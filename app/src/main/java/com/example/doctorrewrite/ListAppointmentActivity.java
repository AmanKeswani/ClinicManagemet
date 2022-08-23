package com.example.doctorrewrite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.doctorrewrite.Adapters.AppointmentRecyclerViewAdapter;
import com.example.doctorrewrite.Classes.Appointment;
import com.example.doctorrewrite.Classes.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class ListAppointmentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppointmentRecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Appointment> appointmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_appointment);

        DBHandler db = new DBHandler(this);

        appointmentArrayList = new ArrayList<>();
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList = db.getAllAppointments();

        for(Appointment a: appointmentList){
            appointmentArrayList.add(a);
        }

        recyclerView = findViewById(R.id.listAppRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new AppointmentRecyclerViewAdapter(ListAppointmentActivity.this, appointmentArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}