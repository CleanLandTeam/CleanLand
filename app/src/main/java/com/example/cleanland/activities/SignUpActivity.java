package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.example.cleanland.R;

public class SignUpActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());

            Amplify.configure(getApplicationContext());

            Log.i("Tutorial", "Initialized Amplify");
        } catch (AmplifyException e) {
            Log.e("Tutorial", "Could not initialize Amplify", e);
        }



        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText user = findViewById(R.id.userName_signup);
                String userName = user.getText().toString();
                EditText userPass = findViewById(R.id.password_signup);
                String passWord = userPass.getText().toString();

                EditText userEmail = findViewById(R.id.email_signup);
                String email = userEmail.getText().toString();
                Log.i("email", "onClick: "+email);
                AuthSignUpOptions options = AuthSignUpOptions.builder()
                        .userAttribute(AuthUserAttributeKey.email(), email)
                        .userAttribute(AuthUserAttributeKey.familyName(),"sabnagh")
                        .userAttribute(AuthUserAttributeKey.middleName(),"sameer")
                        .userAttribute(AuthUserAttributeKey.picture(),"src/main/res/drawable/login_bk.png")
                        .userAttribute(AuthUserAttributeKey.gender(),"m")
                        .userAttribute(AuthUserAttributeKey.birthdate(),"11/11/1999")
                        .userAttribute(AuthUserAttributeKey.locale(),"amman")
                        .userAttribute(AuthUserAttributeKey.phoneNumber(),"0000000000")
                        .userAttribute(AuthUserAttributeKey.address(),"amman")
                        .build();
                Amplify.Auth.signUp(userName, passWord, options,
                        result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
                        error -> Log.e("AuthQuickStart", "Sign up failed", error)
                );


                Intent intent = new Intent(v.getContext(), confirmSignUpPage.class);
                intent.putExtra("userName2",userName);

                startActivity(intent);
            }
        });

    }
}
