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

        TextView shirtsQuantity = findViewById(R.id.shirtsQuantityDetails);
        TextView jacketsQuantity = findViewById(R.id.jacketQuantityDetails);
        TextView pantsQuantity = findViewById(R.id.pantiesQuantityDetails);
        TextView suitesQuantity = findViewById(R.id.suitesQuantityDetails);
        TextView underWare = findViewById(R.id.underWareQuantityDetails);
        TextView pickUpDate = findViewById(R.id.pickUpDateDetails);
        TextView deliveryDate = findViewById(R.id.quantityDileveryDetail);
        TextView stateItem = findViewById(R.id.stateItemDetails);
        TextView totalText = findViewById(R.id.totalPriceDetails);


        shirtsQuantity.setText(intent.getExtras().getString("shirt"));
        jacketsQuantity.setText(intent.getExtras().getString("jacket"));
        pantsQuantity.setText(intent.getExtras().getString("panties"));
        suitesQuantity.setText(intent.getExtras().getString("suites"));
        underWare.setText(intent.getExtras().getString("underWare"));
        pickUpDate.setText(intent.getExtras().getString("pickupDate"));
        deliveryDate.setText(intent.getExtras().getString("DeliveryDate"));
        stateItem.setText(intent.getExtras().getString("state"));
        Integer shirtPrice=Integer.valueOf(intent.getExtras().getString("shirt"));
        Integer jacketPrice=Integer.valueOf(intent.getExtras().getString("jacket"));
        Integer pantiesPrice=Integer.valueOf(intent.getExtras().getString("panties"));
        Integer underWarePrice=Integer.valueOf(intent.getExtras().getString("underWare"));
        Integer suitesPrice=Integer.valueOf(intent.getExtras().getString("suites"));
        double total =(shirtPrice*.5)+(jacketPrice)+(pantiesPrice*.75)+(underWarePrice*.25)+(suitesPrice*2);
        totalText.setText(total+"");
    }


}