package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View;
import android.widget.Button;


import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.example.cleanland.R;
import com.example.cleanland.utils.AmplifyInitializer;
import com.example.cleanland.utils.UserAuthentication;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AmplifyInitializer amplifyInitializer;
    UserAuthentication userAuthentication ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Welcome To Clean Land");
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionBarColor)));
       this.amplifyInitializer= new AmplifyInitializer(getApplicationContext());



        Amplify.Auth.fetchAuthSession(
                result -> {
                    if (!result.isSignedIn()) {
                      //  Log.d("ActivityContextlog", "inside userauth check"+ ActivityContext);
                        Intent loginIntent = new Intent(this, LoginActivity.class);
                       startActivity(loginIntent);
                    }else{

                       TextView welcoming_user= findViewById(R.id.welcoming_user);

                        Amplify.Auth.fetchUserAttributes(
                                attributes ->{
                                    if (attributes.get(9).getValue()!= "null")
                                        ContextCompat.getMainExecutor(getApplicationContext()).execute(() -> {
                                            welcoming_user.setText(welcoming_user.getText()+ " " + attributes.get(9).getValue() );
                                        });
                                    },
                                error -> Log.e("AuthDemo", "Failed to fetch user attributes.", error)
                        );

                    }



                },
                error -> Log.e("failed user login", error.toString())
        );







        RelativeLayout goToOrderActivity =  MainActivity.this.findViewById(R.id.orders);
        goToOrderActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderPage.class);
                startActivity(intent);
            }
        });

        RelativeLayout goToOffersActivity =  MainActivity.this.findViewById(R.id.offers);
        goToOffersActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OffersActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout goToCharityActivity =  MainActivity.this.findViewById(R.id.addDonation);
        goToCharityActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DonationActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Amplify.Auth.fetchAuthSession(
                result -> {
                    if (!result.isSignedIn()) {
                       // Log.d("ActivityContextlog", "inside userauth check"+ ActivityContext);
                        Intent loginIntent = new Intent(this, LoginActivity.class);
                        startActivity(loginIntent);
                    }
                },
                error -> Log.e("failed user login", error.toString())
        );


        RelativeLayout goToOrderActivity =  MainActivity.this.findViewById(R.id.orders);
        goToOrderActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderPage.class);
                startActivity(intent);
            }
        });

        RelativeLayout goToOffersActivity =  MainActivity.this.findViewById(R.id.offers);
        goToOffersActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OffersActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout goToCharityActivity =  MainActivity.this.findViewById(R.id.addDonation);
        goToCharityActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DonationActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_user_profile) {
            //Menu item pressed
            Intent profileIntent = new Intent(this,ProfileActivity.class);
            startActivity(profileIntent);
//            Toast.makeText(this,"user profile pressed .", Toast.LENGTH_SHORT).show();
            return true; //Indicated menu press was handled
        }
        if (id == R.id.action_user_donations) {
            //Menu item pressed
            Intent intent = new Intent(this,userDonations.class);
            startActivity(intent);
//            Toast.makeText(this,"user donations pressed .", Toast.LENGTH_SHORT).show();
            return true; //Indicated menu press was handled
        }
        if (id == R.id.action_user_orders) {
            //Menu item pressed
            Intent intent = new Intent(this,MyOrders.class);
            startActivity(intent);
//            Toast.makeText(this,"user order  pressed .", Toast.LENGTH_SHORT).show();
            return true; //Indicated menu press was handled
        }
        if (id == R.id.action_user_logout) {
            //Menu item pressed
            Amplify.Auth.signOut(

                    () -> {Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent)
                    ;} ,
                    error -> Log.e("AuthQuickstart", error.toString())
            );
//            Toast.makeText(this,"Signed out succeeded!", Toast.LENGTH_SHORT).show();

            return true; //Indicated menu press was handled
        }

        return super.onOptionsItemSelected(item);
    }


}