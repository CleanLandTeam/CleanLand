package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import android.view.View;
import android.widget.Button;


import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
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

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AmplifyInitializer amplifyInitializer;
    UserAuthentication userAuthentication =new UserAuthentication();

    ////
    private static final String TAG = "MapsActivity";
    ListView lstPlaces;
    private PlacesClient mPlacesClient;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Location mLastKnownLocation;
    private static final int M_MAX_ENTRIES = 5;
    private String[] mLikelyPlaceNames;
    private String[] mLikelyPlaceAddresses;
    private String[] mLikelyPlaceAttributions;
    private LatLng[] mLikelyPlaceLatLngs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Welcome To Clean Land");

       this.amplifyInitializer= new AmplifyInitializer(getApplicationContext());







        Amplify.Auth.fetchAuthSession(
                result -> {
                    if (!result.isSignedIn()) {
                      //  Log.d("ActivityContextlog", "inside userauth check"+ ActivityContext);
                        Intent loginIntent = new Intent(this, LoginActivity.class);
                       startActivity(loginIntent);
                    }
                },
                error -> Log.e("failed user login", error.toString())
        );
        //this.userAuthentication.checkForUserAuth(getBaseContext());

        RelativeLayout goToProfile =  MainActivity.this.findViewById(R.id.addDonation);
        goToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, userDonations.class);
                startActivity(intent);
            }
        });



        RelativeLayout goToLogin = MainActivity.this.findViewById(R.id.login);
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
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
       // this.userAuthentication.checkForUserAuth(this);

        RelativeLayout goToOrderBtn = MainActivity.this.findViewById(R.id.orders);
        goToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, OrderPage.class);
                startActivity(i);
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
            Toast.makeText(this,"user profile pressed .", Toast.LENGTH_SHORT).show();
            return true; //Indicated menu press was handled
        }
        if (id == R.id.action_user_donations) {
            //Menu item pressed
            Intent intent = new Intent(this,userDonations.class);
            startActivity(intent);
            Toast.makeText(this,"user donations pressed .", Toast.LENGTH_SHORT).show();
            return true; //Indicated menu press was handled
        }
        if (id == R.id.action_user_orders) {
            //Menu item pressed
            Intent intent = new Intent(this,OrderPage.class);
            startActivity(intent);
            Toast.makeText(this,"user order  pressed .", Toast.LENGTH_SHORT).show();
            return true; //Indicated menu press was handled
        }
        if (id == R.id.action_user_logout) {
            //Menu item pressed
            Toast.makeText(this,"user logout pressed .", Toast.LENGTH_SHORT).show();
            return true; //Indicated menu press was handled
        }

        return super.onOptionsItemSelected(item);
    }


}