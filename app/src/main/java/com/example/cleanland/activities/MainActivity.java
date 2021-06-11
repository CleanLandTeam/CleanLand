package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cleanland.R;
import com.example.cleanland.utils.AmplifyInitializer;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AmplifyInitializer amplifyInitializer= new AmplifyInitializer();
    }
}