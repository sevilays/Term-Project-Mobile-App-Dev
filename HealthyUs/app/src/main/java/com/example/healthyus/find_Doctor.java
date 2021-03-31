package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
//Find Doctor class
public class find_Doctor extends AppCompatActivity {

    String pCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find__doctor);
        // String[] doctorsList = {"Dr.Patrick - 10am - Mon to Wed","Dr.Sam - 11ap- Tue to Fri","Dr.Kim- 12pm - Wed to Sun","Dr.Joe - 1am - Sun to Sat","Dr.Pen - 8pm - Thurs to Fri"};

        Button find = (Button) findViewById(R.id.btnFind);
        EditText postalCode =  findViewById(R.id.txtEnterPostalCode);

        //Button click to find the nearest doctor using postal code.
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pCode = postalCode.getText().toString();
                if(pCode.contentEquals("V6Y1YZ")){

                    startActivity(new Intent(find_Doctor.this,doctors_list1.class));
                }
                else if(pCode.contentEquals("V6R6B6")){
                    startActivity(new Intent(find_Doctor.this,doctorsList2.class));

                }
                else{
                    Toast.makeText(find_Doctor.this,"Enter Valid Postal Code",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}