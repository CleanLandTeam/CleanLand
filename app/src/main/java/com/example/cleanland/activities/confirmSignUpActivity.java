package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;

public class confirmSignUpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_sign_up_page);



        Toast succeeded = Toast.makeText(getApplicationContext(), "Your Account is Activated", Toast.LENGTH_LONG);
        Toast failed = Toast.makeText(getApplicationContext(), "Something Went Wrong!", Toast.LENGTH_LONG);
        Toast succeededResend = Toast.makeText(getApplicationContext(), "Confirmation Code Sent", Toast.LENGTH_LONG);
        Intent getIntent = getIntent();
        String emailRecived = getIntent.getStringExtra("confirmEmail");
        EditText userCode = findViewById(R.id.code_confirm);
        String code = userCode.getText().toString();

        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Amplify.Auth.confirmSignUp(
                        emailRecived,
                        code,
                        result -> {succeeded.show();
                        finish();},
                        error ->  failed.show()
                );


            }
        });

        findViewById(R.id.resend_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUserAttribute email=  new AuthUserAttribute(AuthUserAttributeKey.email(),emailRecived);
                Amplify.Auth.resendUserAttributeConfirmationCode(AuthUserAttributeKey.email(),
                        result -> {succeededResend.show();
                            },
                        error -> {failed.show();Log.d("whats worng", ""+error); }
                );

            }
        });



    }
}