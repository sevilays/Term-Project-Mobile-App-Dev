package com.example.healthyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Doctors list 2 class

public class doctorsList2 extends AppCompatActivity {

    String[] doctors2 = {"Dr.Joe, 5pm- 1am, Sun to Sat, Ph: 2365121272","Dr.Pen, 11am- 8pm, Thurs to Fri,Ph: 6045876899","Dr.Alex, 7am-3pm, Mon to Sun,Ph: 7786834756"};

    int[] images2 = {R.drawable.doctor4,R.drawable.doctor5,R.drawable.doctor6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list2);

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();

        for(int i=0;i<3;i++){
            HashMap<String,String> hashMap = new HashMap<String, String>();
            hashMap.put("txt",doctors2[i]);
            hashMap.put("images",Integer.toString(images2[i]));

            aList.add(hashMap);
        }
        String[] from = {"images","txt"};
        int[] to = {R.id.image1,R.id.listDoctor2};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(),aList,R.layout.doctors_list2,from,to);

        ListView listView = findViewById(R.id.listDoctor2);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Switch cases to navigate to appointments page once after checking the doctor availability day and time.
                switch (position){
                    case 0:
                    case 1:
                    case 2:
                        startActivity(new Intent(doctorsList2.this, appointment_page.class));
                        break;
                }
            }
        });
    }
}