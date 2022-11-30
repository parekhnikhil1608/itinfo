package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.ui.dashboard.DashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityHomeBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    private ActivityHomeBinding binding;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());



        //add Sharedpreferences ......

        sharedPreferences  = getSharedPreferences("myfile", Context.MODE_PRIVATE);
        String suname = sharedPreferences.getString("uname",null);
        String spassword = sharedPreferences.getString("password",null);

        if(suname.equals("")){
            Intent i = new Intent(Home.this,MainActivity.class);
            startActivity(i);
        }

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_home);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      if(item.getItemId()==R.id.id3){
            sharedPreferences =getSharedPreferences("myfile",Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            Intent intent = new Intent(Home.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            Toast.makeText(Home.this, "Logout success", Toast.LENGTH_SHORT).show();
        }
//      else if(item.getItemId()==R.id.id1){
//          Intent i = new Intent(Home.this,Google_map.class);
//          startActivity(i);
//      }
        return super.onOptionsItemSelected(item);
    }
}