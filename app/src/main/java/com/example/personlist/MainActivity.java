
//https://codeshare.io/dwgyVM

package com.example.personlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView = null;
    public DataAdapter adapter = null;
    public PeopleFromXML people = null;

   //public People [] names = {"Sabin T", "Sabin Tab", "Sabin Tabir", "Sabin Tabirca", "Sabin Ttt", "Sabin Tttttt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup recyclerView
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        people = new PeopleFromXML(this);


        // make adapter for it
        String [] names = people.getNames();
        adapter = new DataAdapter(this, R.layout.row_layout, names);
        recyclerView.setAdapter(adapter);
    }
}