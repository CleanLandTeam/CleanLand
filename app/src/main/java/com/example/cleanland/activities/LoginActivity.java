package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);


        findViewById(R.id.signUp_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), SignUpActivity.class);

                startActivity(intent);
            }
        });


        findViewById(R.id.signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText user = findViewById(R.id.username_signIn);
                EditText userPass = findViewById(R.id.password_signIn);

                String userName = user.getText().toString();

                String passWord = userPass.getText().toString();


                Amplify.Auth.signIn(
                        userName,
                        passWord,
                        result -> Log.i("AuthQuickstart", result.isSignInComplete() ? "Sign in succeeded" : "Sign in not complete"),
                        error -> Log.e("AuthQuickstart", error.toString())
                );


                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("userName1", userName);
                startActivity(intent);


            }
        });


    }
}