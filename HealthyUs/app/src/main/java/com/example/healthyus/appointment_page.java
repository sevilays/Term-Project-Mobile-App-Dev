package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//Appointment Page class
public class appointment_page extends AppCompatActivity {
    //Calling databseHelper class
    DatabaseHelper databaseHelper;

    String uName;
    String uEmail;
    String dName;
    String dTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_page);

        //Constructor for databaseHelper class
        databaseHelper = new DatabaseHelper(this);


        EditText userName = findViewById(R.id.txtAppoinmentName);
        EditText userEmail = findViewById(R.id.txtAppointmentEmail);
        EditText doctorName = findViewById(R.id.txtAppointmentDoctorName);
        EditText dateTime = findViewById(R.id.txtAppointmentDateTime);

        Button bookAppointment = findViewById(R.id.btnAppointmentSubmit);
        Button onlineHelp = findViewById(R.id.btnAppointmentGetOnlineHelp);

        //Text view click to navigate to doctor availability page
        TextView backToAvailability = findViewById(R.id.txtCheckAvailability);
        backToAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(appointment_page.this, find_Doctor.class));
            }
        });

        //Text View to logout from the screen
        TextView logout = findViewById(R.id.txtLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(appointment_page.this, LoginPage.class));
            }
        });

        //Button click To navigate to online help page to get online help from doctors
        onlineHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(appointment_page.this, online_help.class));
            }
        });

        //Button click to book appointment
        bookAppointment.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View v) {
                uName = userName.getText().toString();
                uEmail = userEmail.getText().toString();
                dName = doctorName.getText().toString();
                dTime = dateTime.getText().toString();

                //Condition for checking whether user enters data in all fields
                if(uName.isEmpty() || uEmail.isEmpty() || dName.isEmpty() || dTime.isEmpty()){
                    Toast.makeText(appointment_page.this,"Enter all Fields",Toast.LENGTH_LONG).show();
                }
                else{
                    // If user entered the data in all fields those details will be saving into Appointments page
                    isInserted = databaseHelper.bookAppointment(userName.getText().toString(),
                            userEmail.getText().toString(),
                            doctorName.getText().toString(),
                            dateTime.getText().toString());

                    //Condition to reset the user entry values once after a successful entry
                    if(isInserted){
                        //Toast message to notify user that the appointment is booked
                        Toast.makeText(appointment_page.this,"Your appointment is booked. Click on Online Help to post your complaint online",Toast.LENGTH_LONG).show();
                        userName.setText("");
                        userEmail.setText("");
                        doctorName.setText("");
                        dateTime.setText("");

                    }
                    else{
                        //Toast message to notify user if the appointment is not booked.
                        Toast.makeText(appointment_page.this,"Appointment not booked",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });


    }
}