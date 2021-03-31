package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//Sign In Page
public class SignInPage extends AppCompatActivity {

    String email;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
         EditText emailId =  findViewById(R.id.txtEmailAddress);
         EditText passwordEntry =  findViewById(R.id.txtPassword);

        Button login = (Button) findViewById(R.id.btnLogin);

        //Button click to enable user to login with their credentials
        login.setOnClickListener(new View.OnClickListener() {
            //final TextView warningDisplay = (TextView) findViewById(R.id.txtWarning);
            @Override

            public void onClick(View v) {
                email = emailId.getText().toString();
                password = passwordEntry.getText().toString();
                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(SignInPage.this,"Enter Valid Email and Password",Toast.LENGTH_LONG).show();
                }
                //If entered details are valid user will be navigated to home page
                else{
                    startActivity(new Intent(SignInPage.this, HomePage.class));

                }

            }
        });
    }
}