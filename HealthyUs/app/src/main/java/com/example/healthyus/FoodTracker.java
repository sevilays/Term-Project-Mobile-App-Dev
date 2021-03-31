package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;
//Food tracker class
public class FoodTracker extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    String foodItemsEntered;
    double caloriesEntered;
    double idealCaloriesPerDay = 500;
    String userEmail;
    double caloriesRequired;
    String dateEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tracker);

        databaseHelper = new DatabaseHelper(this);

         EditText foodItems = findViewById(R.id.txtFoodEntries);
         EditText calories = findViewById(R.id.numCalories);
        EditText userEmail = findViewById(R.id.txtUserEmail);
        EditText date = findViewById(R.id.txtDate);
        Button submit = (Button) findViewById(R.id.btnCalorieDisplay);
        Button healthyRecipe = findViewById(R.id.btnHealthyRecipe);

        //TextView click to logout
        TextView logout = findViewById(R.id.txtLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodTracker.this, LoginPage.class));
            }
        });

        //Button click to navigate to web page for healthy recipes.
        healthyRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.foodnetwork.com/healthyeats/recipes/2013/01/500-calorie-or-less-comfort-foods")));
            }
        });

        //Button click for submitting the user details and getting the results for their calorie intake
        submit.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            final TextView result = (TextView) findViewById(R.id.txtResult);
            @Override
            public void onClick(View v) {
                foodItemsEntered = foodItems.getText().toString();
                caloriesEntered = Double.parseDouble(calories.getText().toString());
                dateEntered = date.getText().toString();

                //If loop to display whether the intake calorie is higher or below the standard calorie intake
                if(caloriesEntered < idealCaloriesPerDay) {
                    caloriesRequired = idealCaloriesPerDay - caloriesEntered;
                    result.setText("You need " + caloriesRequired + " more calories today.");
                }

                else if(caloriesEntered > idealCaloriesPerDay){
                    caloriesRequired = caloriesEntered - idealCaloriesPerDay;
                    result.setText("You exceeded the limit, consumed " + caloriesRequired + " extra calories");
                }

                else {
                    result.setText("You consumed the ideal amount of calories today");
                }

                //method to save the user entry into database.
                isInserted = databaseHelper.caloriecount(foodItems.getText().toString(),
                        calories.getText().toString(),
                        userEmail.getText().toString(),
                        date.getText().toString());
            }
        });
    }
}