package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;

public class confirmSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_sign_up_page);




        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = getIntent();
                String userName = getIntent.getStringExtra("userName2");
                EditText userCode = findViewById(R.id.code_confirm);
                String code = userCode.getText().toString();


                Amplify.Auth.confirmSignUp(
                        userName,
                        code,
                        result -> Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete"),
                        error -> Log.e("AuthQuickstart", error.toString())
                );

                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}