package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cleanland.R;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        final View propLayout = findViewById(R.id.constraintLayout2);
        final View jacketLayout = findViewById(R.id.constraintLayout3jacket);
        final View pantiesLayout = findViewById(R.id.constraintLayout3panties);
        final View suitesLayout = findViewById(R.id.constraintLayout3Suites);
        final View othersLayout = findViewById(R.id.constraintLayout3Others);

        if (intent.getExtras().getString("shirt").equals("0"))
            propLayout.setVisibility(View.INVISIBLE);

        if (intent.getExtras().getString("jacket").equals("0"))
            jacketLayout.setVisibility(View.INVISIBLE);

        if (intent.getExtras().getString("panties").equals("0"))
            pantiesLayout.setVisibility(View.INVISIBLE);

        if (intent.getExtras().getString("suites").equals("0"))
            suitesLayout.setVisibility(View.INVISIBLE);

        if (intent.getExtras().getString("underWare").equals("0"))
            othersLayout.setVisibility(View.INVISIBLE);

        TextView shirtsQuantity = findViewById(R.id.shirtsQuantityDetails);
        TextView jacketsQuantity = findViewById(R.id.jacketQuantityDetails);
        TextView pantsQuantity = findViewById(R.id.pantiesQuantityDetails);
        TextView suitesQuantity = findViewById(R.id.suitesQuantityDetails);
        TextView underWare = findViewById(R.id.underWareQuantityDetails);

        shirtsQuantity.setText(intent.getExtras().getString("shirt"));
        jacketsQuantity.setText(intent.getExtras().getString("jacket"));
        pantsQuantity.setText(intent.getExtras().getString("panties"));
        suitesQuantity.setText(intent.getExtras().getString("suites"));
        underWare.setText(intent.getExtras().getString("underWare"));


    }


}