package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Sing up class
public class SignUpPage extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    String fName;
    String dis;
    String med;
    String eId;
    String pass;
    String pCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        databaseHelper = new DatabaseHelper(this);

        EditText fullName = findViewById(R.id.txtFullName);
        EditText disease =  findViewById(R.id.txtHealthInfo);
        EditText medications =  findViewById(R.id.txtMedication);
        EditText emailId =  findViewById(R.id.txtEmailIdCreate);
        EditText password =  findViewById(R.id.txtPasswordCreate);
        EditText postalCode = findViewById(R.id.txtAddress);
        Button buttonRegister = findViewById(R.id.btnRegister);
        Button btnSignIn = findViewById(R.id.btnDirectToSignIn);

        //Button click to navigate user to sign in page once after they successfully register
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(new Intent(SignUpPage.this, SignInPage.class));
                }

        });

        //button click to register for new users
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View v) {
                fName = fullName.getText().toString();
                dis = disease.getText().toString();
                med = medications.getText().toString();
                eId = emailId.getText().toString();
                pass = password.getText().toString();
                pCode = postalCode.getText().toString();

                //if user left any fields user will be notified to enter all details
                if(fName.isEmpty() || dis.isEmpty() || med.isEmpty() || eId.isEmpty() || pass.isEmpty() || pCode.isEmpty()){
                    Toast.makeText(SignUpPage.this,"Enter all Fields",Toast.LENGTH_LONG).show();
                }
                else{

                    //If loop for checking for any duplicate entries for all fields
                    if(!databaseHelper.signUpDupeCheck(eId)){
                        isInserted = databaseHelper.signUp(fullName.getText().toString(),
                                disease.getText().toString(),
                                medications.getText().toString(),
                                emailId.getText().toString(),
                                password.getText().toString(),
                                postalCode.getText().toString());

                        //If user enters data in all fields those details will be saved into database
                if(isInserted){
                    Toast.makeText(SignUpPage.this,"You are Now Registered. Please click on SIGN IN to Continue",Toast.LENGTH_LONG).show();
                    fullName.setText("");
                    disease.setText("");
                    medications.setText("");
                    emailId.setText("");
                    password.setText("");
                    postalCode.setText("");
                }
                else{
                    Toast.makeText(SignUpPage.this,"Data Not Added",Toast.LENGTH_LONG).show();

                }
                }
                    else{
                        Toast.makeText(SignUpPage.this,"You are already Registered",Toast.LENGTH_LONG).show();
                    }
            }}
        });
    }
}