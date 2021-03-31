package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
//Online help class
public class online_help extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    String uEmail;
    String dName;
    String com;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_help);
        databaseHelper = new DatabaseHelper(this);

        EditText userEmail = findViewById(R.id.txtOnlineHelpUserEmail);
        EditText doctorName = findViewById(R.id.txtOnlineHelpDoctorName);
        EditText complaints = findViewById(R.id.txtOnlineHelpComplaints);

        TextView bill= findViewById(R.id.txtOnlineHelpBill);

        RadioButton withMSP = findViewById(R.id.rdOnlineHelpWithMsp);
        RadioButton withoutMSP = findViewById(R.id.rdOnlineHelpWithNoMsp);

        Button submit = findViewById(R.id.btnOnlineHelpSubmit);

        //Logout to enable user to logout from the app
        TextView logout = findViewById(R.id.txtLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(online_help.this, LoginPage.class));
            }
        });
        //Button click to submit the details for online help from doctors
        submit.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View v) {
                uEmail = userEmail.getText().toString();
                dName = doctorName.getText().toString();
                com = complaints.getText().toString();

                if(uEmail.isEmpty() || dName.isEmpty() || com.isEmpty() ){
                    Toast.makeText(online_help.this,"Enter all Fields",Toast.LENGTH_LONG).show();
                }
                else{
                    isInserted = databaseHelper.onlineHelp(userEmail.getText().toString(),
                            doctorName.getText().toString(),
                            complaints.getText().toString());
                    if(isInserted){
                        Toast.makeText(online_help.this,"Your Request is submitted",Toast.LENGTH_LONG).show();
                        userEmail.setText("");
                        doctorName.setText("");
                        complaints.setText("");

                    }
                    else{
                        Toast.makeText(online_help.this,"Request Not Submitted",Toast.LENGTH_LONG).show();

                    }
                }
                //if loop for asking user to verify if they are having MSP coverage to get discounts on the total bill
                if(withMSP.isChecked()){
                    bill.setText("Your Total Bill is 100$");
                }
                else if(withoutMSP.isChecked()){
                    bill.setText("Your Total bill is 200$");
                }
                else{
                    bill.setText("Please select one option for MSP");
                }
            }


        });
    }
}