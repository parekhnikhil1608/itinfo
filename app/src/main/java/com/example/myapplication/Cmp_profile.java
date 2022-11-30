package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Cmp_profile extends AppCompatActivity {

    CircleImageView image;
    TextView name,phone,address,industry,website,hr,contect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmp_profile);

        image = findViewById(R.id.cmp_image);
        name = findViewById(R.id.cmp_name);
        address = findViewById(R.id.cmp_address);
        industry = findViewById(R.id.cmp_industry);
        website = findViewById(R.id.cmp_website);
        hr = findViewById(R.id.cmp_hr_name);
        contect = findViewById(R.id.cmp_contect);
        phone = findViewById(R.id.cmp_phone);

        Intent intent = this.getIntent();
        String cmp_namei = intent.getStringExtra("name");
        String cmp_addressi = intent.getStringExtra("address");
        String cmp_industryi = intent.getStringExtra("industry");
        String cmp_websitei = intent.getStringExtra("website");
        String cmp_hri = intent.getStringExtra("hr");
        String cmp_contecti = intent.getStringExtra("contect");
        String cmp_phonei = intent.getStringExtra("phone");

        int imgi = intent.getIntExtra("img",R.drawable.logo1);

        name.setText(cmp_namei);
        address.setText(cmp_addressi);
        industry.setText(cmp_industryi);
        website.setText(cmp_websitei);
        hr.setText(cmp_hri);
        contect.setText(cmp_contecti);
        phone.setText(cmp_phonei);

        image.setImageResource(imgi);
    }
}