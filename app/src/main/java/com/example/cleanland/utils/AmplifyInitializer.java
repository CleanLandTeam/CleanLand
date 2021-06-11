package com.example.cleanland.utils;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;

public class AmplifyInitializer extends AppCompatActivity {


    public AmplifyInitializer(){
        try {
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSS3StoragePlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());

            Amplify.configure(getApplicationContext());

            Log.i("AmplifyInitializer", "Initialized Amplify");
        } catch (AmplifyException e) {
            Log.e("AmplifyInitializer", "Could not initialize Amplify", e);
        }
    }
}
