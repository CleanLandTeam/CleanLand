package com.example.cleanland.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.core.Amplify;
import com.example.cleanland.activities.LoginActivity;
import com.example.cleanland.activities.MainActivity;

public class UserAuthentication  {
    public UserAuthentication() {

    }

    public void checkForUserAuth(Context ActivityContext) {
        Log.d("testlog", "inside userauth check");
        Amplify.Auth.fetchAuthSession(
                result -> {
                    if (!result.isSignedIn()) {
                        Log.d("ActivityContextlog", "inside userauth check"+ ActivityContext);
                                    Intent loginIntent = new Intent(ActivityContext, LoginActivity.class);
                                    ActivityContext.getApplicationContext().startActivity(loginIntent);
                                }
                    },
                error -> Log.e("failed user login", error.toString())
        );

    }




}
