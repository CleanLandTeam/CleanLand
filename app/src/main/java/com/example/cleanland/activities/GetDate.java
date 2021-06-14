package com.example.cleanland.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cleanland.R;

public class GetDate extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender);




    }
    public void getPickUpDate ( int year, int month, int day){
        Log.i("TAG", "onDateSet: " + year + month + day);

//        Intent intent = new Intent(this, OrderPage.class);
//        intent.putExtra("date", year + "/" + month + "/" + day);
//        startActivity(intent);


        EditText pickUpDate = findViewById(R.id.in_date);
        pickUpDate.setText(year + "/" + month + "/" + day);
    }

}
