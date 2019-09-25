package com.km.eparkinguser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userEmail, userPassword;
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setIds();
        setListeners();
    }

    private void setIds() {
        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
    }

    private void setListeners() {
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    private boolean validateFields() {
        if (userEmail.getText().toString().trim().isEmpty()) {
            userEmail.setError("Enter email");
            return false;
        }
        if (userPassword.getText().toString().trim().isEmpty()) {
            userPassword.setError("Enter password");
            return false;
        }
        return true;
    }

    private void performUserLogin() {
        String name = userEmail.getText().toString();
        String password = userPassword.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                if (validateFields()) {
                    performUserLogin();
                }
                break;
            case R.id.register_button:
                startActivity(new Intent(this, RegistrationActivity.class));
                finish();
                break;

        }
    }
}
