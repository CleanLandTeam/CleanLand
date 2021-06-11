package com.example.cleanland.utils;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amplifyframework.core.Amplify;
import com.example.cleanland.activities.LoginActivity;
import com.example.cleanland.activities.MainActivity;
import com.example.cleanland.activities.SplashActivity;

import java.util.Map;

public class UserAuthentication extends AppCompatActivity {
    public UserAuthentication() {

    }

    public void checkForUserAuth() {

        Amplify.Auth.fetchAuthSession(
                result -> {
                    if (!result.isSignedIn()) {
                                    Intent loginIntent = new Intent(this, LoginActivity.class);
                                    startActivity(loginIntent);
                                }
                    },
                error -> Log.e("failed user login", error.toString())
        );

    }




}
