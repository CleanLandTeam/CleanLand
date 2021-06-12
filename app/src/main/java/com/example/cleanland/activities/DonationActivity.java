package com.example.cleanland.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cleanland.R;

public class DonationActivity extends AppCompatActivity {
    LinearLayout shirtsLayout,jacketsLayout,pantiesLayout,suitesLayout,othersLayout ;
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation_items_fragment);




    }
}
