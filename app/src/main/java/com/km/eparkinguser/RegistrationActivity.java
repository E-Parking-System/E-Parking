package com.km.eparkinguser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userName, userEmail, userPassword, bikeName, bikeNumber;
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setIds();
        setListeners();
    }

    private void setIds() {
        userName = findViewById(R.id.user_name);
        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        bikeName = findViewById(R.id.bike_name);
        bikeNumber = findViewById(R.id.bike_number);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
    }

    private void setListeners() {
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    private boolean validateFields() {
        if (userName.getText().toString().trim().isEmpty()) {
            userName.requestFocus();
            userName.setError("Enter user name");
            return false;
        }
        if (userEmail.getText().toString().trim().isEmpty()) {
            userEmail.requestFocus();
            userEmail.setError("Enter email");
            return false;
        }
        if (userPassword.getText().toString().trim().isEmpty()) {
            userPassword.requestFocus();
            userPassword.setError("Enter password");
            return false;
        }
        if (bikeName.getText().toString().trim().isEmpty()) {
            bikeName.requestFocus();
            bikeName.setError("Enter bike name");
            return false;
        }
        if (bikeNumber.getText().toString().trim().isEmpty()) {
            bikeNumber.requestFocus();
            bikeNumber.setError("Enter licence plate number");
            return false;
        }
        return true;
    }

    private void performRegistration() {
        String userDetailsString = userName.toString() + userEmail.toString() + bikeName.toString() + bikeNumber;
        AppPreferences appPreferences = new AppPreferences(this);
        appPreferences.setUserDetails(userDetailsString);
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.register_button:
                if (validateFields()) {
                    performRegistration();
                }
                break;
        }
    }
}
