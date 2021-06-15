package com.example.cleanland.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Donate;
import com.amplifyframework.datastore.generated.model.Orders;
import com.example.cleanland.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DonationActivity extends AppCompatActivity {
    int minteger = 0;
    int mintegerOne = 0;
    int mintegerThree = 0;
    int mintegerFour = 0;
    EditText edittext;
    final Calendar myCalendar = Calendar.getInstance();

    TextView locationViewDonation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);


        edittext = (EditText) findViewById(R.id.donation_date);
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
                new DatePickerDialog(DonationActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        locationViewDonation = (TextView) findViewById(R.id.locationViewDonation);

        Button locationDonation = (Button) findViewById(R.id.locationDonation);
        locationDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(DonationActivity.this, MapsActivity.class);
                startActivityForResult(intent, 1000);// Activity is started with requestCode 2
            }
        });


        Button addDonation = DonationActivity.this.findViewById(R.id.Donate);
        addDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonationActivity.this, userDonations.class);
                TextView shirtsQuantity = (TextView) findViewById(R.id.donation_integer_number);
                TextView jacketsQuantity = (TextView) findViewById(R.id.donation_integer_number_one);
                TextView suitsQuantity = (TextView) findViewById(R.id.donation_integer_number_Three);
                TextView pantiesQuantity = (TextView) findViewById(R.id.donation_integer_number_Four);
                TextView pickUpDate = findViewById(R.id.donation_date);
                TextView location = findViewById(R.id.locationViewDonation);
                boolean shirtsNum = shirtsQuantity.getText().toString().equals("0");
                boolean jacketsNum = jacketsQuantity.getText().toString().equals("0");
                boolean suitsNum = suitsQuantity.getText().toString().equals("0");
                boolean pantiesNum = pantiesQuantity.getText().toString().equals("0");
                boolean date = pickUpDate.getText().toString().equals("");
                boolean cityName = location.getText().toString().equals("");
                boolean checkOne= true;
                boolean checkTwo = true;
                boolean checkThree = true;




                if (shirtsNum && jacketsNum && suitsNum && pantiesNum) {
                    Toast error = Toast.makeText(getApplicationContext(), "please fill the quantity for one section al least ", Toast.LENGTH_LONG);
                    error.show();
                    checkOne = false;
                } else if (date ) {
                    Toast errorOne = Toast.makeText(getApplicationContext(), "please select pickup date ", Toast.LENGTH_LONG);
                    errorOne.show();
                    checkTwo = false;
                }else if (cityName){
                    Toast errorTwo = Toast.makeText(getApplicationContext(), "please select pickup Location ", Toast.LENGTH_LONG);
                    errorTwo.show();
                    checkThree = false;
                }


                    if (checkOne&&checkTwo&&checkThree) {

                        Donate item = Donate.builder()
                                .pickupDate(pickUpDate.getText().toString())
                                .longitude(5.2).latitude(4.1)
                                .shirtsQuantity(Integer.valueOf(shirtsQuantity.getText().toString()))
                                .jacketsQuantity(Integer.valueOf(jacketsQuantity.getText().toString()))
                                .pantiesQuantity(Integer.valueOf(pantiesQuantity.getText().toString()))
                                .suitesQuantity(Integer.valueOf(suitsQuantity.getText().toString()))
                                .build();
                        Amplify.DataStore.save(item,
                                success -> Log.i("Tutorial", "Saved item: " + success.item().getPickupDate()),
                                error -> Log.e("Tutorial", "Could not save item to DataStore", error)
                        );
                        Log.i("Tutorial", "Initialized Amplify");


                        startActivity(intent);
                    }



            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Double latitude = data.getExtras().getDouble("latitude");
        Double longitude = data.getExtras().getDouble("longitude");
        String address = data.getExtras().getString("address");


        locationViewDonation.setText(address);

    }


    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }


    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);


    }
    public void decreaseInteger(View view) {
        if (minteger > 0) {
            minteger = minteger - 1;
            display(minteger);
        } else {
            display(0);
        }
    }

    public void increaseIntegerOne(View view) {
        mintegerOne = mintegerOne + 1;
        displayOne(mintegerOne);


    }public void decreaseIntegerOne(View view) {
        if(mintegerOne>0)
        mintegerOne = mintegerOne - 1;
        displayOne(mintegerOne);
    }public void increaseIntegerThree(View view) {
        mintegerThree = mintegerThree + 1;
        displayThree(mintegerThree);

    }public void decreaseIntegerThree(View view) {
        if(mintegerThree>0)
        mintegerThree = mintegerThree - 1;
        displayThree(mintegerThree);
    }public void increaseIntegerFour(View view) {
        mintegerFour = mintegerFour + 1;
        displayFour(mintegerFour);

    }public void decreaseIntegerFour(View view) {
        if(mintegerFour>0)
        mintegerFour = mintegerFour - 1;
        displayFour(mintegerFour);

    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.donation_integer_number);
        displayInteger.setText("" + number);
    }

    private void displayOne(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.donation_integer_number_one);
        displayInteger.setText("" + number);
    }

    private void displayThree(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.donation_integer_number_Three);
        displayInteger.setText("" + number);
    }

    private void displayFour(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.donation_integer_number_Four);
        displayInteger.setText("" + number);
    }
}
