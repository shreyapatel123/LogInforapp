package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView, textView2, textView3;
    private EditText username, password, number,email;
    private Button button, button2;
    boolean isEmailValid, isPasswordValid,isPhoneValid,isNameValid;



    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.ed_username);
        password = findViewById(R.id.password);
        number = findViewById(R.id.ed_number);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);



        button.setOnClickListener(new View.OnClickListener() {

            private boolean isPasswordValid;
            private boolean isNameValid;
            private boolean isEmailValid;
            private boolean isPhoneValid;


            @Override
            public void onClick(View view) {
                SetValidation();
            }


            SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
            String Username = credentials.getString("username", null);
            String edpassword = credentials.getString("password", null);

            String Name = username.getText().toString();
            String Password = password.getText().toString();


            private void SetValidation() {

                if (username.getText().toString().isEmpty()) {
                    username.setError(getResources().getString(R.string.username_error));
                    isNameValid = false;
                } else {
                    isNameValid = true;
                }

                // Check for a valid email address.
                if (email.getText().toString().isEmpty()) {
                    email.setError(getResources().getString(R.string.email_error));
                    isEmailValid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    email.setError(getResources().getString(R.string.error_invalid_email));
                    isEmailValid = false;
                } else {
                    isEmailValid = true;
                }


                // Check for a valid password.
                if (password.getText().toString().isEmpty()) {
                    password.setError(getResources().getString(R.string.password_error));
                    isPasswordValid = false;
                } else if (password.getText().length() < 6) {
                    password.setError(getResources().getString(R.string.error_invalid_password));
                    isPasswordValid = false;
                } else {
                    isPasswordValid = true;
                }

                // Check for a valid phone number.

                if (number.getText().toString().isEmpty()) {
                    number.setError(getResources().getString(R.string.phone_error));
                    isPhoneValid = false;
                } else {
                    isPhoneValid = true;
                }


                if (isNameValid && isEmailValid && isPasswordValid) {
                    Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                    startActivity(i);
                    finish();
                }
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}

