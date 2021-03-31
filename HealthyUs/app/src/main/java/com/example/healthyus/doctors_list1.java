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

//Doctor's list1 class
public class doctors_list1 extends AppCompatActivity {

    String[] doctors1 = {"Dr.Patrick, 10am-4pm, Mon to Wed, Ph: 6567483243","Dr.Sam, 11am-3pm, Tue to Fri,Ph: 6784561234","Dr.Kim, 12pm-6pm, Wed to Sun,Ph: 7789987898"};

    int[] images = {R.drawable.doctor1,R.drawable.doctor2,R.drawable.doctor3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list1);


        List<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();

        for(int i=0;i<3;i++){
            HashMap<String,String> hashMap = new HashMap<String, String>();
            hashMap.put("txt",doctors1[i]);
            hashMap.put("image",Integer.toString(images[i]));

            aList.add(hashMap);

        }
        String[] from = {"image","txt"};
        int[] to = {R.id.image,R.id.listDoctor1};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(),aList,R.layout.doctors_list1,from,to);

        ListView listView = findViewById(R.id.listDoctor1);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Switch cases to navigate to appointments page once after checking the doctor availability day and time.
                switch (position){
                    case 0:
                    case 1:
                    case 2:
                        startActivity(new Intent(doctors_list1.this, appointment_page.class));
                        break;
                }
            }
        });
    }
}