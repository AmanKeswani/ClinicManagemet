package com.example.doctorrewrite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.doctorrewrite.Adapters.VisitRecyclerViewAdapter;
import com.example.doctorrewrite.Classes.DBHandler;
import com.example.doctorrewrite.Classes.Visit;

import java.util.ArrayList;
import java.util.List;

public class ListVisitActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VisitRecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Visit> appointmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_visit);

        DBHandler db = new DBHandler(this);

        appointmentArrayList = new ArrayList<>();
        List<Visit> appointmentList = new ArrayList<>();
        appointmentList = db.getAllVisits();

        for(Visit a: appointmentList){
            appointmentArrayList.add(a);
        }

        recyclerView = findViewById(R.id.listVisitRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new VisitRecyclerViewAdapter(ListVisitActivity.this, appointmentArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}