package com.example.myapplication.ui.home;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.List_view;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    AnimationDrawable manimation=new AnimationDrawable();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);



        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ImageView iv = binding.imageView2;
        Button btn1 = binding.button1;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List_view.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "TOP IT COMPANIES", Toast.LENGTH_SHORT).show();
            }
        });

        BitmapDrawable frame1= (BitmapDrawable)
                getResources().getDrawable(R.drawable.tcs);

        BitmapDrawable frame2= (BitmapDrawable)
                getResources().getDrawable(R.drawable.gatway);

        BitmapDrawable frame3= (BitmapDrawable)
                getResources().getDrawable(R.drawable.infosys);

        BitmapDrawable frame4= (BitmapDrawable)
                getResources().getDrawable(R.drawable.amazon_p);

        BitmapDrawable frame5= (BitmapDrawable)
                getResources().getDrawable(R.drawable.tcs_p);

        BitmapDrawable frame6= (BitmapDrawable)
                getResources().getDrawable(R.drawable.reliance_p);

        BitmapDrawable frame7= (BitmapDrawable)
                getResources().getDrawable(R.drawable.oracle_p);

        BitmapDrawable frame8= (BitmapDrawable)
                getResources().getDrawable(R.drawable.capgemini_p);

        BitmapDrawable frame9= (BitmapDrawable)
                getResources().getDrawable(R.drawable.deloitte_p);

        BitmapDrawable frame10= (BitmapDrawable)
                getResources().getDrawable(R.drawable.accenture_p);

        BitmapDrawable frame11= (BitmapDrawable)
                getResources().getDrawable(R.drawable.larsen_p);

        BitmapDrawable frame12= (BitmapDrawable)
                getResources().getDrawable(R.drawable.wipro_p);

        BitmapDrawable frame13= (BitmapDrawable)
                getResources().getDrawable(R.drawable.concentrix_p);

        BitmapDrawable frame14= (BitmapDrawable)
                getResources().getDrawable(R.drawable.nielsen_p);

        BitmapDrawable frame15= (BitmapDrawable)
                getResources().getDrawable(R.drawable.eclinicalworks_p);

        BitmapDrawable frame16= (BitmapDrawable)
                getResources().getDrawable(R.drawable.cybage_p);

        BitmapDrawable frame17= (BitmapDrawable)
                getResources().getDrawable(R.drawable.atos_p);

        BitmapDrawable frame18= (BitmapDrawable)
                getResources().getDrawable(R.drawable.einfochips_p);

        BitmapDrawable frame19= (BitmapDrawable)
                getResources().getDrawable(R.drawable.lti_p);

        BitmapDrawable frame20= (BitmapDrawable)
                getResources().getDrawable(R.drawable.infostretch_p);

        BitmapDrawable frame21= (BitmapDrawable)
                getResources().getDrawable(R.drawable.sophos_p);

        BitmapDrawable frame22= (BitmapDrawable)
                getResources().getDrawable(R.drawable.igate_p);




        manimation.addFrame(frame1,1000);
        manimation.addFrame(frame2,1000);
        manimation.addFrame(frame3,1000);
        manimation.addFrame(frame4,1000);
        manimation.addFrame(frame5,1000);
        manimation.addFrame(frame6,1000);
        manimation.addFrame(frame7,1000);
        manimation.addFrame(frame8,1000);
        manimation.addFrame(frame9,1000);
        manimation.addFrame(frame10,1000);
        manimation.addFrame(frame11,1000);
        manimation.addFrame(frame12,1000);
        manimation.addFrame(frame13,1000);
        manimation.addFrame(frame14,1000);
        manimation.addFrame(frame15,1000);
        manimation.addFrame(frame16,1000);
        manimation.addFrame(frame17,1000);
        manimation.addFrame(frame18,1000);
        manimation.addFrame(frame19,1000);
        manimation.addFrame(frame20,1000);
        manimation.addFrame(frame21,1000);
        manimation.addFrame(frame22,1000);


        iv.setBackgroundDrawable(manimation);
        manimation.setOneShot(false);
        manimation.start();
        return root;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}