package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cleanland.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OrderPage extends AppCompatActivity {
    int minteger = 0;
    int mintegerOne = 0;
    int mintegerTwo = 0;
    int mintegerThree = 0;
    int mintegerFour = 0;
    EditText edittext;
    final Calendar myCalendar = Calendar.getInstance();
    EditText editDeliveryDate;
    TextView locationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);


//
//        Button popupButton = findViewById(R.id.add);
//        popupButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                PopUpClass popUpClass = new PopUpClass();
//                popUpClass.showPopupWindow(v);
//            }
//        });


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionBarColor)));


        edittext = (EditText) findViewById(R.id.in_date);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(OrderPage.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        editDeliveryDate = (EditText) findViewById(R.id.in_delivery_date);
        DatePickerDialog.OnDateSetListener delivery_date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDeliveryDate();
            }

        };

        editDeliveryDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(OrderPage.this, delivery_date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });




         locationView=(TextView)findViewById(R.id.locationView);

        Button location=(Button)findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(OrderPage.this,MapsActivity.class);
                startActivityForResult(intent, 1000);// Activity is started with requestCode 2
            }
        });
    }

    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
//        if(requestCode==1000)
//        {
        Double latitude=data.getExtras().getDouble("latitude");
        Double longitude=data.getExtras().getDouble("longitude");
        String address=data.getExtras().getString("address");


        locationView.setText(address);
    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateDeliveryDate() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editDeliveryDate.setText(sdf.format(myCalendar.getTime()));
    }


    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }

    public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    public void increaseIntegerOne(View view) {
        mintegerOne = mintegerOne + 1;
        displayOne(mintegerOne);

    }

    public void decreaseIntegerOne(View view) {
        mintegerOne = mintegerOne - 1;
        displayOne(mintegerOne);
    }

    public void increaseIntegerTwo(View view) {
        mintegerTwo = mintegerTwo + 1;
        displayTwo(mintegerTwo);

    }

    public void decreaseIntegerTwo(View view) {
        mintegerTwo = mintegerTwo - 1;
        displayTwo(mintegerTwo);
    }

    public void increaseIntegerThree(View view) {
        mintegerThree = mintegerThree + 1;
        displayThree(mintegerThree);

    }

    public void decreaseIntegerThree(View view) {
        mintegerThree = mintegerThree - 1;
        displayThree(mintegerThree);
    }

    public void increaseIntegerFour(View view) {
        mintegerFour = mintegerFour + 1;
        displayFour(mintegerFour);

    }

    public void decreaseIntegerFour(View view) {
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