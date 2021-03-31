package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Login page
public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Button buttonSignIn = (Button) findViewById(R.id.btnSignIn) ;
        Button buttonSignUp = (Button) findViewById(R.id.btnSignUp);
        //9TextView doctorSignUp = findViewById(R.id.txtLoginPage);

        /*doctorSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this,doctor_signup.class));
            }
        });*/

        //Button click to navigate user to sign in page if they are already registered.
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this, SignInPage.class));
            }
        });

        //Button click to navigate user to sign up if they are new to the app
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this, SignUpPage.class));
            }
        });
    }


}