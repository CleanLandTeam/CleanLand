package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.example.cleanland.R;
import com.example.cleanland.utils.AmplifyInitializer;
import com.example.cleanland.utils.UserAuthentication;

public class MainActivity extends AppCompatActivity {


    UserAuthentication userAuthentication =new UserAuthentication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AmplifyInitializer amplifyInitializer= new AmplifyInitializer();

        this.userAuthentication.checkForUserAuth();




    }

    @Override
    protected void onResume() {
        super.onResume();

        this.userAuthentication.checkForUserAuth();

    }
}