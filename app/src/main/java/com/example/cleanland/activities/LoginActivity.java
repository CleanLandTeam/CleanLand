package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionBarColor)));


        findViewById(R.id.signUp_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), SignUpActivity.class);

                startActivity(intent);
            }
        });


        Toast failed = Toast.makeText(getApplicationContext(), "Something want wrong try again!", Toast.LENGTH_LONG);
        Toast succeeded = Toast.makeText(getApplicationContext(), "Sign in succeeded!", Toast.LENGTH_LONG);

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

                        result -> succeeded.show(),
                        error -> failed.show()
                );
                    finish();
            }
        });


    }
}