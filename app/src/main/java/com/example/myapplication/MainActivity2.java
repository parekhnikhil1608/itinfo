package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class MainActivity2<onCurrentAccessTokenChanged> extends AppCompatActivity {
    Button btn_regi;
    EditText txt_uname ,txt_password, txt_vpassword,txt_phone;
    TextView btn_signin;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private FirebaseAuth.AuthStateListener mAuthListener;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();





        setContentView(R.layout.activity_main2);
        btn_regi = findViewById(R.id.btn_reg);
        txt_uname = findViewById(R.id.txtuname);
        txt_password = findViewById(R.id.txtpassword);
        txt_vpassword = findViewById(R.id.txtvpassword);
        btn_signin = findViewById(R.id.btn_signin);
        txt_phone = findViewById(R.id.txtphone);




        btn_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validateUname() | !validatePhone() | !validatePassword() | !validateVPassword()){
                    return;
                }
//                else if(!isConnected(MainActivity2.this)){
//                    showCustomDialog();
//                }



                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("SignUp");

                //get all the value from text view
                String uname = txt_uname.getText().toString();
                String phone = txt_phone.getText().toString();
                String password = txt_password.getText().toString();
                String vpassword = txt_vpassword.getText().toString();

                //user already exist..
                Query checkuser = FirebaseDatabase.getInstance().getReference("SignUp").orderByChild("uname").equalTo(uname);
                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            txt_uname.setError("Username already token");
                        }else{
                            UserHelperClass helperClass = new UserHelperClass(uname,phone,password,vpassword);
                            reference.child(uname).setValue(helperClass);
                            Intent i = new Intent(MainActivity2.this,MainActivity.class);
                            Toast.makeText(MainActivity2.this, "Your Account create Successfully...", Toast.LENGTH_LONG).show();
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity2.this, "Error on database", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }



    private Boolean validateUname(){
        String uname = txt_uname.getText().toString();
        String upattern ="\\A\\w{4,20}\\z";
        if (uname.equals("")){
            txt_uname.setError("Field cannot be empty");
            return false;
        }
        else if(uname.length()>=15){
            txt_uname.setError("uname to long");
            return false;
        }
        else if(!uname.matches(upattern)){
            txt_uname.setError("white spaces are not allowed");
            return false;
        }
        else{
            txt_uname.setError(null);
            return true;
        }
    }

    private Boolean validatePhone(){
        String phone = txt_phone.getText().toString();
        String ppattern = "[6-9]{1}[0-9]{9}";
        if (phone.equals("")){
            txt_phone.setError("Field cannot be empty");
            return false;
        }
        else if(!phone.matches(ppattern)){
            txt_phone.setError(("Please Enter valid phone number"));
            return false;
        }
        else{
            txt_uname.setError(null);
            return true;
        }
    }

    private Boolean validatePassword(){
        String password = txt_password.getText().toString();
        String pas_pattern = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
        if (password.equals("")){
            txt_password.setError("Field cannot be empty");
            return false;
        }
        else if(!password.matches(pas_pattern)){
            txt_password.setError("Please Enter Strong password");
            return false;
        }
        else{
            txt_uname.setError(null);
            return true;
        }
    }

    private Boolean validateVPassword() {
        String password = txt_password.getText().toString();
        String vpassword = txt_vpassword.getText().toString();
        if (password.equals("")) {
            txt_vpassword.setError("Field cannot be empty");
            return false;
        }
        else if(vpassword.equals(password)) {
            txt_vpassword.setError(null);
            return true;
        }else{
            txt_vpassword.setError("Please check Your re-enter password");
            return false;
         }

    }

//    private boolean isConnected(MainActivity2 mainActivity2) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity2.getSystemService(Context.CONNECTIVITY_SERVICE);
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
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
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
//                        startActivity(new Intent(MainActivity2.this,MainActivity.class));
//                        finish();
//                    }
//                });
//    }




}
