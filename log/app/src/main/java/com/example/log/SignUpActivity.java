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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
TextView register,textview4;
EditText username,Password,confirmpassword,city,state,address,emailaddress;
RadioButton radioButton,radioButton2;
Button btnregister;
    boolean isEmailValid, isPasswordValid,isconfirmpasswordValid,isNameValid;

private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        Password = findViewById(R.id.Password);
        confirmpassword= findViewById(R.id.confirmpassword);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        address = findViewById(R.id.address);
        emailaddress = findViewById(R.id.emailaddress);
        btnregister = findViewById(R.id.btnregister);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);

        btnregister.setOnClickListener(new View.OnClickListener() {
            private boolean isPasswordValid;
            private boolean isNameValid;
            private boolean isEmailaddressValid;
            private boolean isconfirmpasswordvalidValid;


            @Override
            public void onClick(View view) {
                SetValidation();
            }

            private void SetValidation() {
                // Check for a valid name.
                if (username.getText().toString().isEmpty()) {
                    username.setError(getResources().getString(R.string.app_name));
                    isNameValid = false;
                } else {
                    isNameValid = true;
                }

                // Check for a valid email address.
                if (emailaddress.getText().toString().isEmpty()) {
                    emailaddress.setError(getResources().getString(R.string.email_error));
                    isEmailValid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailaddress.getText().toString()).matches()) {
                    emailaddress.setError(getResources().getString(R.string.error_invalid_email));
                    isEmailaddressValid = false;
                } else {
                    isEmailaddressValid = true;
                }


                // Check for a valid password.
                if (Password.getText().toString().isEmpty()) {
                    Password.setError(getResources().getString(R.string.password_error));
                    isPasswordValid = false;
                } else if (Password.getText().length() < 6) {
                    Password.setError(getResources().getString(R.string.error_invalid_password));
                    isPasswordValid = false;
                } else {
                    isPasswordValid = true;
                }

                // Check for a valid password.
                if (confirmpassword.getText().toString().isEmpty()) {
                    confirmpassword.setError(getResources().getString(R.string.confirm_password));
                    isconfirmpasswordvalidValid = false;
                } else if (confirmpassword.getText().length() < 6) {
                    confirmpassword.setError(getResources().getString(R.string.error_invalid_password));
                    isPasswordValid = false;
                } else {
                    isconfirmpasswordvalidValid = true;
                }


                if (isNameValid && isEmailaddressValid && isconfirmpasswordvalidValid && isPasswordValid) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
            });

    }
}
