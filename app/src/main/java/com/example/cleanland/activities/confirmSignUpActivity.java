package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.example.cleanland.R;

public class confirmSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_sign_up_page);



        Toast succeeded = Toast.makeText(getApplicationContext(), "Confirm signUp succeeded!", Toast.LENGTH_LONG);
        Toast failed = Toast.makeText(getApplicationContext(), "Confirmation code is wrong!", Toast.LENGTH_LONG);

        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = getIntent();
                String email = getIntent.getStringExtra("confirmEmail");
                EditText userCode = findViewById(R.id.code_confirm);
                String code = userCode.getText().toString();


                Amplify.Auth.confirmSignUp(
                        email,
                        code,
                        result -> {succeeded.show(); finish();},
                        error ->  failed.show()
                );

//                Intent intent = new Intent(v.getContext(), MainActivity.class);
//                startActivity(intent);
            }
        });

    }
}