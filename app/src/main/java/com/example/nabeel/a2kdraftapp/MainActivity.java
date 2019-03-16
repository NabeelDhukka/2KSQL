package com.example.nabeel.a2kdraftapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.RosterContainer);

        List<String> roster = new ArrayList<>();

        roster.add("Steph Curry");
        roster.add("Klay Thompson");
        roster.add("Kawhi Leonard");
        roster.add("Rudy Gay");
        roster.add("Rudy Gobert");
        roster.add("Boban Marjanovic");
        roster.add("Luka Doncic");
        roster.add("Serge Ibaka");
        roster.add("Chris Paul");
        roster.add("Brook Lopez");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, roster);
        listView.setAdapter(arrayAdapter);
    }



}
