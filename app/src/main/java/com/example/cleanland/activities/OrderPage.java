package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cleanland.R;

public class OrderPage extends AppCompatActivity {
    int minteger = 0;
    int mintegerOne = 0;
    int mintegerTwo = 0;
    int mintegerThree = 0;
    int mintegerFour = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);



        Button popupButton = findViewById(R.id.add);
        popupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                PopUpClass popUpClass = new PopUpClass();
                popUpClass.showPopupWindow(v);
            }
        });

    }



    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }
    public void increaseIntegerOne(View view) {
        mintegerOne = mintegerOne + 1;
        displayOne(mintegerOne);

    }public void decreaseIntegerOne(View view) {
        mintegerOne = mintegerOne - 1;
        displayOne(mintegerOne);
    }public void increaseIntegerTwo(View view) {
        mintegerTwo = mintegerTwo + 1;
        displayTwo(mintegerTwo);

    }public void decreaseIntegerTwo(View view) {
        mintegerTwo = mintegerTwo - 1;
        displayTwo(mintegerTwo);
    }public void increaseIntegerThree(View view) {
        mintegerThree = mintegerThree + 1;
        displayThree(mintegerThree);

    }public void decreaseIntegerThree(View view) {
        mintegerThree = mintegerThree - 1;
        displayThree(mintegerThree);
    }public void increaseIntegerFour(View view) {
        mintegerFour = mintegerFour + 1;
        displayFour(mintegerFour);

    }public void decreaseIntegerFour(View view) {
        mintegerFour = mintegerFour - 1;
        displayFour(mintegerFour);
    }
    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number);
    }
    private void displayOne(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number_one);
        displayInteger.setText("" + number);
    }
    private void displayTwo(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number_Two);
        displayInteger.setText("" + number);
    }
    private void displayThree(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number_Three);
        displayInteger.setText("" + number);
    }
    private void displayFour(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number_Four);
        displayInteger.setText("" + number);
    }
}