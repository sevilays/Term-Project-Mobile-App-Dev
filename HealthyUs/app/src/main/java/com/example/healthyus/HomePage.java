package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
//Homepage class
public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        final RadioButton foodTracker = (RadioButton) findViewById(R.id.radFoodTracker);
        final RadioButton findDoctor = (RadioButton) findViewById(R.id.radFindADoctor);
        Button go = (Button) findViewById(R.id.btnGo);

        //Button click to navigate to food tracker and find doctor page.
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If food tracker is selected user will be navigated to food tracker page
                if(foodTracker.isChecked()) {
                    startActivity(new Intent(HomePage.this, FoodTracker.class));
                }
                //else user will be navigated to find doctor page
                else if(findDoctor.isChecked()) {
                    startActivity(new Intent(HomePage.this, find_Doctor.class));
                }
                else {
                    Toast.makeText(HomePage.this, "Select one of the options", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}