package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {
    Button btn_logini;
    EditText txt_login_unamei,txt_login_passwordi;
    TextView btn_create;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        btn_logini = findViewById(R.id.btn_login);
        txt_login_unamei = findViewById(R.id.txt_login_uname);
        txt_login_passwordi = findViewById(R.id.txt_login_password);
        btn_create = findViewById(R.id.btn_create);


//        Intent i = getIntent();
//        String u = i.getStringExtra("key1");
//        String p = i.getStringExtra("key2");


        btn_logini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//              if(!isConnected(MainActivity.this)){
//                  showCustomDialog();
//              }
              String _uname = txt_login_unamei.getText().toString();
              String _password = txt_login_passwordi.getText().toString();
               // Database
                Query checkuser = FirebaseDatabase.getInstance().getReference("SignUp").orderByChild("uname").equalTo(_uname);
                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            txt_login_unamei.setError(null);
                            txt_login_unamei.setEnabled(false);
                            String systempassword = snapshot.child(_uname).child("password").getValue(String.class);
                            if (systempassword.equals(_password)){
                                txt_login_passwordi.setError(null);
                                txt_login_passwordi.setEnabled(false);

                                String _phone = snapshot.child(_uname).child("phone").getValue(String.class);


                                //add Sharedpreferences ......

                                sharedPreferences =getSharedPreferences("myfile",Context.MODE_PRIVATE);
                                editor = sharedPreferences.edit();
                                editor.putString("uname",_uname);
                                editor.putString("password",_password);
                                editor.putString("key1","true");
                                editor.apply();
                                Intent intent = new Intent(MainActivity.this,Home.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                                //end sharedpreferences ........
                                Toast.makeText(MainActivity.this, "Login Success...", Toast.LENGTH_SHORT).show();
                                
                            }else {
                                Toast.makeText(MainActivity.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                            }
                        }else{

                            Toast.makeText(MainActivity.this, "No such user exist!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity.this, "Error on database", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }


//    private boolean isConnected(MainActivity mainActivity) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo wificonn = connectivityManager.getNetworkInfo(connectivityManager.TYPE_WIFI);
//        NetworkInfo mobileconn = connectivityManager.getNetworkInfo(connectivityManager.TYPE_MOBILE);
//
//        if ((wificonn != null && wificonn.isConnected() )|| (mobileconn != null && mobileconn.isConnected())){
//            return true;
//        }else {
//            return false;
//        }
//
//
//
//    }
//
//    private void showCustomDialog(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setMessage("please connect to the internet to proceed further")
//                .setCancelable(false)
//                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        startActivity(new Intent(MainActivity.this,MainActivity.class));
//                        finish();
//                    }
//                });
//    }


}