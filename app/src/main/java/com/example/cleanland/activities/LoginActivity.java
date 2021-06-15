package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);



        findViewById(R.id.signUp_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);

                startActivity(intent);
            }
        });


        Toast failed = Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_LONG);
        Toast succeeded = Toast.makeText(getApplicationContext(), "Sign in succeeded", Toast.LENGTH_LONG);

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
                        result -> {succeeded.show();




                        finish();



//                            SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//
//                            welcome_msg.setText("{"+ spref.getString("Username","username")+"}'s Tasks");
                        },
                        error -> {

                            if(error.getCause().getLocalizedMessage().contains("UserNotConfirmedException") ){

                                Intent intent = new Intent(getApplicationContext(), confirmSignUpActivity.class);
                                intent.putExtra("confirmEmail",  user.getText().toString());
                                startActivity(intent);
                            }
                            else {
                                failed.show();

                            }

                          //  Log.d("check error type: ", " "+error.get);
                          //  Log.d(" error  cause: ", " "+ error.getCause().getLocalizedMessage().contains("UserNotConfirmedException"));
//
//                            Log.d("check error type: ", " "+error);
//
//                            Log.d(" error  fillInStack", " "+error.fillInStackTrace());
                        }
                );

            }
        });


    }
}