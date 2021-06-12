package com.example.cleanland.activities;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.cognitoauth.Auth;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Button button = (Button) findViewById(R.id.edit_profile);

        EditText firstName = findViewById(R.id.name_profile);
        EditText middleName = findViewById(R.id.middleName_profile);
        EditText familyName = findViewById(R.id.familyName_profile);
        EditText phoneNumber = findViewById(R.id.phone_number_profile);
        EditText birthday = findViewById(R.id.birthdate_profile);
        EditText address = findViewById(R.id.address_profile);
        EditText gender = findViewById(R.id.gender_profile);
        Amplify.Auth.fetchUserAttributes(

                attributes -> {

                    ContextCompat.getMainExecutor(getApplicationContext()).execute(() -> {



                        address.setText(attributes.get(1).getValue());
                        birthday.setText(attributes.get(2).getValue().toString());
                        gender.setText(attributes.get(4).getValue().toString());
                        middleName.setText(attributes.get(7).getValue().toString());
                        firstName.setText(attributes.get(9).getValue().toString());
                        phoneNumber.setText(attributes.get(10).getValue().toString());
                        familyName.setText(attributes.get(11).getValue().toString());

                        Log.i("AuthDemo", "User attributes = " + attributes.toString());
                    });


                },
                error -> Log.e("AuthDemo", "Failed to fetch user attributes.", error)
        );


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                List<AuthUserAttribute> attributes = new ArrayList<>();
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.name(), firstName.getText().toString()));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.middleName(), middleName.getText().toString()));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.familyName(), familyName.getText().toString()));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.phoneNumber(), phoneNumber.getText().toString()));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.birthdate(), birthday.getText().toString()));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.address(), address.getText().toString()));
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.gender(), gender.getText().toString()));

                Amplify.Auth.updateUserAttributes(attributes,
                        result -> Log.i("AuthDemo", "Updated user attribute = " + result.toString()),
                        error -> Log.e("AuthDemo", "Failed to update user attribute.", error)
                );
                finish();
            }
        });

    }
}
