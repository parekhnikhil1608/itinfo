package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Animation_Page extends AppCompatActivity {

    private ImageView img;
    private TextView logo_txt;

    Animation logo_animation_i ,logo_txt_animation_i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_animation_page);

        img = findViewById(R.id.logo);
        logo_txt = findViewById(R.id.logo_txt);

        logo_animation_i  = AnimationUtils.loadAnimation(this,R.anim.logo_anim);
        logo_txt_animation_i = AnimationUtils.loadAnimation(this,R.anim.logo_text_anim);

        img.setAnimation(logo_animation_i);
        logo_txt.setAnimation(logo_txt_animation_i);

        int SPLASH_SCREEN =4300;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Animation_Page.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}