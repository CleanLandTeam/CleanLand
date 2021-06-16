package com.example.cleanland.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.cleanland.R;
import com.example.cleanland.utils.AmplifyInitializer;

public class SplashActivity extends AppCompatActivity {
    AmplifyInitializer amplifyInitializer;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.amplifyInitializer= new AmplifyInitializer(getApplicationContext());

        //setTitle("Welcome To Clean Land");



        handler=new Handler();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);



    }
}