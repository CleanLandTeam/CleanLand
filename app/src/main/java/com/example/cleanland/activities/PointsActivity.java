package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Donate;
import com.amplifyframework.datastore.generated.model.Orders;
import com.example.cleanland.R;

import java.util.ArrayList;
import java.util.List;

public class PointsActivity extends AppCompatActivity {

    TextView ordersPoint;
    TextView donationsPoint;
    TextView ordersAndDonationsPoint;
    int ordersShirtsPointsCounter =0;
    int ordersJacketsPointsCounter=0;
    int ordersPantsPointsCounter=0;
    int ordersSuitesPointsCounter=0;
    int ordersUnderwearPointsCounter=0;

    int donationShirtsPointsCounter=0;
    int donationJacketsPointsCounter=0;
    int donationPantsPointsCounter=0;
    int donationSuitesPointsCounter=0;

    int summationOfAllOrderPoints = 0;
    int summationOfAllDonationPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        setTitle("Point System");

        ordersPoint = (TextView) findViewById(R.id.ordersPoint);
        donationsPoint = (TextView) findViewById(R.id.donationPoint);
        ordersAndDonationsPoint = (TextView) findViewById(R.id.ordersAndDonationsPoint);

//        ordersPoint.setText(10*ordersShirtsPointsCounter + );
        List<Orders> ordersToView = new ArrayList<>();
        Amplify.DataStore.query(Orders.class,
                AllOrders -> {
                    while (AllOrders.hasNext()) {
                        Orders orders = AllOrders.next();
                        SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        String UserEmail=spref.getString("userLoggedInEmail","");
                        Log.d("email is", "onClick:+ " +UserEmail);
                        if (orders.getUserId().equals(UserEmail)){
                            ordersToView.add(orders);
                            ordersShirtsPointsCounter+=orders.getShirtsQuantity();
                            ordersJacketsPointsCounter+=orders.getJacketsQuantity();
                            ordersPantsPointsCounter+=orders.getPantiesQuantity();
                            ordersSuitesPointsCounter+=orders.getSuitesQuantity();
                            ordersUnderwearPointsCounter+=orders.getUnderWaresQuantity();

                        }


                    }
                    summationOfAllOrderPoints = ordersShirtsPointsCounter* 10 + ordersJacketsPointsCounter * 15 + ordersPantsPointsCounter *10 + ordersSuitesPointsCounter*20 + ordersUnderwearPointsCounter* 5;
                    ordersPoint.setText(Integer.toString(summationOfAllOrderPoints));
                },
                failure -> Log.e("Tutorial", "Could not query DataStore", failure)
        );
        List<Donate> donatesToView = new ArrayList<>();
        Amplify.DataStore.query(Donate.class,
                AllDonations -> {
                    while (AllDonations.hasNext()) {
                        Donate donates = AllDonations.next();
                        SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        String UserEmail=spref.getString("userLoggedInEmail","");
                        Log.d("email is", "onClick:+ " +UserEmail);
                        if (donates.getUserId().equals(UserEmail)){
                            donatesToView.add(donates);
                            donationShirtsPointsCounter+=donates.getShirtsQuantity();
                            donationJacketsPointsCounter+=donates.getJacketsQuantity();
                            donationPantsPointsCounter+=donates.getPantiesQuantity();
                            donationSuitesPointsCounter+=donates.getSuitesQuantity();
                        }


                    }
                    summationOfAllDonationPoints = donationShirtsPointsCounter* 15 +donationJacketsPointsCounter * 20 + donationPantsPointsCounter* 15 +donationSuitesPointsCounter* 25;


                    donationsPoint.setText( Integer.toString(summationOfAllDonationPoints));
                    ordersAndDonationsPoint.setText(Integer.toString(summationOfAllOrderPoints+summationOfAllDonationPoints));
                },
                failure -> Log.e("Tutorial", "Could not query DataStore", failure)
        );

    }
}