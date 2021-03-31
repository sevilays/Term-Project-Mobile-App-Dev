package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

//Splash activity to display the app logo for few secondsS
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                finish();
                startActivity(new Intent(SplashActivity.this,LoginPage.class));
            }
        };

        Timer opening = new Timer();
        opening.schedule(task, 4000);
    }
}