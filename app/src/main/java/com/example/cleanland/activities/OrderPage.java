

  package com.example.cleanland.activities;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.DialogFragment;

        import android.app.DatePickerDialog;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.graphics.drawable.ColorDrawable;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.text.Editable;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.amplifyframework.AmplifyException;
        import com.amplifyframework.core.Amplify;
        import com.amplifyframework.datastore.AWSDataStorePlugin;
        import com.amplifyframework.datastore.generated.model.Orders;
        import com.amplifyframework.datastore.generated.model.State;
        import com.example.cleanland.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
        import java.util.Date;
        import java.util.Locale;

public class OrderPage extends AppCompatActivity {
    int minteger = 0;
    int mintegerOne = 0;
    int mintegerTwo = 0;
    int mintegerThree = 0;
    int mintegerFour = 0;
    EditText edittext;

    double longitude=0;
    double latitude=0;
    final Calendar myCalendar = Calendar.getInstance();
    EditText editDeliveryDate;
    TextView locationView;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        
        Button addOrder = OrderPage.this.findViewById(R.id.add);
        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderPage.this,MyOrders.class);
                TextView shirtsQuantity = (TextView) findViewById(R.id.integer_number);
                TextView jacketsQuantity = (TextView) findViewById(R.id.integer_number_one);
                TextView underWareQuantity = (TextView) findViewById(R.id.integer_number_Two);
                TextView suitsQuantity = (TextView) findViewById(R.id.integer_number_Three);
                TextView pantiesQuantity = (TextView) findViewById(R.id.integer_number_Four);
                TextView pickUpDate =  findViewById(R.id.in_date);
                TextView deliveryDate =  findViewById(R.id.in_delivery_date);

                SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//
//                            welcome_msg.setText("{"+ spref.getString("Username","username")+"}'s Tasks");

                String UserEmail=spref.getString("userLoggedInEmail","");

                Log.d("email is", "onClick:+ " +UserEmail);

                if ((minteger !=0 || mintegerOne!=0 || mintegerTwo!=0 || mintegerThree!=0 || mintegerFour!=0) &&(longitude!=0 && latitude!=0) && (pickUpDate.getText().length()==8 && pickUpDate.getText().length()==8) ){
                    try {
                        Orders item = Orders.builder()
                                .pickupDate(pickUpDate.getText().toString())
                                .deliveryDate(deliveryDate.getText().toString())
                                .longitude(getLongitude()).latitude(getLatitude())
                                .shirtsQuantity(Integer.valueOf(shirtsQuantity.getText().toString()))
                                .jacketsQuantity(Integer.valueOf(jacketsQuantity.getText().toString()))
                                .underWaresQuantity(Integer.valueOf(underWareQuantity.getText().toString()))
                                .pantiesQuantity(Integer.valueOf(pantiesQuantity.getText().toString()))
                                .suitesQuantity(Integer.valueOf(suitsQuantity.getText().toString()))
                                .othersQuantity(0)
                                .state(State.New)
                                .userId(UserEmail)
                                .build();
                        Amplify.DataStore.save(item,
                                success -> Log.i("Tutorial", "Saved item: " + success.item().getPickupDate()),
                                error -> Log.e("Tutorial", "Could not save item to DataStore", error)
                        );
                        Log.i("Tutorial", "Initialized Amplify");
                    } catch (Exception e) {
                        Log.e("Tutorial", "Could not initialize Amplify", e);
                    }

                    startActivity(intent);

                }
            }
        });



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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        Double latitude=data.getExtras().getDouble("latitude");
        Double longitude=data.getExtras().getDouble("longitude");
        String address=data.getExtras().getString("address");

        setLatitude(latitude);
        setLongitude(longitude);

        locationView.setText(address);
    }

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


    }public void decreaseInteger(View view) {
        if(minteger>0)
            minteger = minteger - 1;
        display(minteger);

    }


    public void increaseIntegerOne(View view) {
        mintegerOne = mintegerOne + 1;
        displayOne(mintegerOne);


    }public void decreaseIntegerOne(View view) {
        if(mintegerOne>0)
            mintegerOne = mintegerOne - 1;
        displayOne(mintegerOne);
    }
    public void increaseIntegerTwo(View view) {
        mintegerTwo = mintegerTwo + 1;
        displayTwo(mintegerTwo);

    }public void decreaseIntegerTwo(View view) {
        if(mintegerTwo>0)
            mintegerTwo = mintegerTwo - 1;
        displayTwo(mintegerTwo);
    }

    public void increaseIntegerThree(View view) {
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
