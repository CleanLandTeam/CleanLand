  package com.example.cleanland.activities;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.DialogFragment;

        import android.content.Intent;
        import android.graphics.drawable.ColorDrawable;
        import android.os.Bundle;
        import android.text.Editable;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.TextView;

        import com.amplifyframework.AmplifyException;
        import com.amplifyframework.core.Amplify;
        import com.amplifyframework.datastore.AWSDataStorePlugin;
        import com.amplifyframework.datastore.generated.model.Orders;
        import com.amplifyframework.datastore.generated.model.State;
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

        try {
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(getApplicationContext());

            Log.i("Tutorial", "Initialized Amplify");
        } catch (AmplifyException e) {
            Log.e("Tutorial", "Could not initialize Amplify", e);
        }
        
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
                EditText pickUpDate = (EditText) findViewById(R.id.pickUpDate);

                    try {
                        Orders item = Orders.builder()
                .pickupDate("abd")
                .deliveryDate("deliveryDate").longitude(5.2).latitude(4.1)
                                .shirtsQuantity(Integer.valueOf(shirtsQuantity.getText().toString()))
                                .jacketsQuantity(Integer.valueOf(jacketsQuantity.getText().toString()))
                                .underWaresQuantity(Integer.valueOf(underWareQuantity.getText().toString()))
                                .pantiesQuantity(Integer.valueOf(pantiesQuantity.getText().toString()))
                                .suitesQuantity(Integer.valueOf(suitsQuantity.getText().toString()))
                .build();
                        Amplify.DataStore.save(item,
                                success -> Log.i("Tutorial", "Saved item: " + success.item().getShirtsQuantity()),
                                error -> Log.e("Tutorial", "Could not save item to DataStore", error)
                        );
                        Log.i("Tutorial", "Initialized Amplify");
                    } catch (Exception e) {
                        Log.e("Tutorial", "Could not initialize Amplify", e);
                    }

                    startActivity(intent);

            }
        });



//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionBarColor)));



    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
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
