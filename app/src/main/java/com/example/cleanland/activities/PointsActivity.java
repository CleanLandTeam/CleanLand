package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cleanland.R;

public class PointsActivity extends AppCompatActivity {

    TextView ordersPoint;
    TextView donationsPoint;
    TextView ordersAndDonationsPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        setTitle("Points System");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionBarColor)));

        ordersPoint = (TextView) findViewById(R.id.ordersPoint);
        donationsPoint = (TextView) findViewById(R.id.donationPoint);
        ordersAndDonationsPoint = (TextView) findViewById(R.id.ordersAndDonationsPoint);

        ordersPoint.setText(10*minteger + );

    }
}