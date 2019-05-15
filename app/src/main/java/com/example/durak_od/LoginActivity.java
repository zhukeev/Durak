package com.example.durak_od;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button loginButton,haveAnAccountButton;
    EditText login,password,repeatPassword,phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        loginButton = findViewById(R.id.btn_login);
        haveAnAccountButton = findViewById(R.id.btn_create_an_account);

        login = findViewById(R.id.ET_login);
        password = findViewById(R.id.ET_password);
        repeatPassword = findViewById(R.id.ET_password_repeat);
        phoneNumber = findViewById(R.id.ET_number);

        //BUTTON CLICK

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,BoardActivity.class);
                startActivity(intent);
            }
        });
        haveAnAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SigninAcitvity.class);
                startActivity(intent);
            }
        });

    }


}
