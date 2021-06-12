package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;

public class ProfileActivity extends AppCompatActivity {
    Button button = (Button) findViewById(R.id.edit_profile);
    EditText firstName = findViewById(R.id.name_profile);
    EditText middleName =findViewById(R.id.middleName_profile);
    EditText familyName = findViewById(R.id.familyName_profile);
    EditText phoneNumber = findViewById(R.id.phone_number_profile);
    EditText birthday = findViewById(R.id.birthdate_profile);
    EditText address = findViewById(R.id.address_profile);
    EditText gender = findViewById(R.id.gender_profile);
    EditText password = findViewById(R.id.password_profile);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AuthUserAttribute editFirstName = new AuthUserAttribute(AuthUserAttributeKey.name(), firstName.getText().toString());
                AuthUserAttribute editMiddleName = new AuthUserAttribute(AuthUserAttributeKey.name(), middleName.getText().toString());
                AuthUserAttribute editFamilyName = new AuthUserAttribute(AuthUserAttributeKey.name(), familyName.getText().toString());
                AuthUserAttribute editPhoneNumber = new AuthUserAttribute(AuthUserAttributeKey.name(), phoneNumber.getText().toString());
                AuthUserAttribute editBirthday = new AuthUserAttribute(AuthUserAttributeKey.name(), birthday.getText().toString());
                AuthUserAttribute editAddress = new AuthUserAttribute(AuthUserAttributeKey.name(), address.getText().toString());
                AuthUserAttribute editGender = new AuthUserAttribute(AuthUserAttributeKey.name(), gender.getText().toString());
                AuthUserAttribute editPassword = new AuthUserAttribute(AuthUserAttributeKey.name(), password.getText().toString());

                Amplify.Auth.updateUserAttribute(editFirstName,
                        result -> Log.i("AuthDemo", "Updated user attribute = " + result.toString()),
                        error -> Log.e("AuthDemo", "Failed to update user attribute.", error)
                );
                finish();
            }
        });

    }
}