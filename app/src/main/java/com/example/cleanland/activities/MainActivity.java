package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.widget.TextView;
=======
import android.os.Handler;
import android.util.Log;
>>>>>>> b5ddf997d3f5afaf9da81543b0069edfaf8125d1

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.example.cleanland.R;
import com.example.cleanland.utils.AmplifyInitializer;

public class MainActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 12000; //splash screen will be shown for 2 seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        AmplifyInitializer amplifyInitializer= new AmplifyInitializer();
=======


        //        initialize Amplify
        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());

            Amplify.configure(getApplicationContext());

            Log.i("Tutorial", "Initialized Amplify");
        } catch (AmplifyException e) {
            Log.e("Tutorial", "Could not initialize Amplify", e);
        }




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


>>>>>>> b5ddf997d3f5afaf9da81543b0069edfaf8125d1
    }
}