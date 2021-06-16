package com.example.cleanland.activities;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.cognitoauth.Auth;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity {
    EditText edittext;
    EditText edittextOne;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("My Profile");


        Button button = (Button) findViewById(R.id.edit_profile);

        EditText firstName = findViewById(R.id.name_profile);
        EditText middleName = findViewById(R.id.middleName_profile);
        EditText familyName = findViewById(R.id.familyName_profile);
        EditText phoneNumber = findViewById(R.id.phone_number_profile);
        EditText birthday = findViewById(R.id.birthdate_profile);
        EditText address = findViewById(R.id.address_profile);
        Spinner gender = findViewById(R.id.gender_profile);

        Toast failed = Toast.makeText(getApplicationContext(), "Please fill all the field", Toast.LENGTH_LONG);
        Toast succeeded = Toast.makeText(getApplicationContext(), "Updated successfully ", Toast.LENGTH_LONG);


        Amplify.Auth.fetchUserAttributes(

                attributes -> {

                    ContextCompat.getMainExecutor(getApplicationContext()).execute(() -> {
                        if (attributes.get(1).getValue().equals("null")) {
                            address.setText("");
                        } else {
                            address.setText(attributes.get(1).getValue());
                        }
                        if (attributes.get(2).getValue().equals("01/01/1950"))
                            birthday.setText("");
                        else
                            birthday.setText(attributes.get(2).getValue().toString());


                        gender.setSelection(gen(attributes.get(4).getValue()));

                        if (attributes.get(7).getValue().equals("null")) {
                            middleName.setText("");
                        } else {
                            middleName.setText(attributes.get(7).getValue().toString());
                        }

                        if (attributes.get(9).getValue().equals("null")) {
                            firstName.setText("");
                        } else {
                            firstName.setText(attributes.get(9).getValue().toString());
                        }

                        if (attributes.get(10).getValue().equals("+96270000000"))
                            phoneNumber.setText("");
                        else if (attributes.get(10).getValue().equals("null")) {
                            phoneNumber.setText("");
                        } else {
                            phoneNumber.setText(attributes.get(10).getValue().toString());
                        }
                        if (attributes.get(11).getValue().equals("null")) {
                            familyName.setText("");
                        } else {
                            familyName.setText(attributes.get(11).getValue().toString());
                        }
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
                attributes.add(new AuthUserAttribute(AuthUserAttributeKey.gender(), gender.getSelectedItem().toString()));

                Amplify.Auth.updateUserAttributes(attributes,
                        result -> succeeded.show(),
                        error -> failed.show()
                );
                finish();
            }
        });


        edittextOne = findViewById(R.id.birthdate_profile);
        edittext = findViewById(R.id.birthdate_profile);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ProfileActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));

    }

    public int gen(String str) {
        if (str.equals("Male"))
            return 0;

        return 1;
    }
}
