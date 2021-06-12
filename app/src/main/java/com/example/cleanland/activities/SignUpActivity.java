package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;
import com.example.cleanland.utils.AmplifyInitializer;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText user = findViewById(R.id.userName_signup);
                String username = user.getText().toString();

                EditText userPass = findViewById(R.id.password_signup);
                String password = userPass.getText().toString();

                EditText userEmail = findViewById(R.id.email_signup);
                String email = userEmail.getText().toString();
                Log.i("email", "onClick: " + email);

                Toast succeeded = Toast.makeText(getApplicationContext(), " signUp succeeded!", Toast.LENGTH_LONG);
                Toast failed = Toast.makeText(getApplicationContext(), "please check the user name and email", Toast.LENGTH_LONG);

                ArrayList<AuthUserAttribute> attributes = new ArrayList<>();
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.name(), "null"));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.familyName(), "null"));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.middleName(), "null"));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.picture(), "null"));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.gender(), "null"));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.birthdate(), "02/01/1996"));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.locale(), "null"));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.phoneNumber(), "+96279923821"));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.address(), "null"));

                Amplify.Auth.signUp(
                        email,
                        password,
                        AuthSignUpOptions.builder().userAttributes(attributes).build(),
                        result -> succeeded.show(),
                        error -> failed.show()
                );

                    Intent intent = new Intent(v.getContext(), confirmSignUpActivity.class);
                    intent.putExtra("confirmEmail", email);

                    startActivity(intent);


            }
        });

    }
}
