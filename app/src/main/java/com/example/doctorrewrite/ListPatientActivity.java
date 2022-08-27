package com.example.doctorrewrite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.doctorrewrite.Adapters.AppointmentRecyclerViewAdapter;
import com.example.doctorrewrite.Adapters.PatientRecyclerViewAdapter;
import com.example.doctorrewrite.Classes.Appointment;
import com.example.doctorrewrite.Classes.DBHandler;
import com.example.doctorrewrite.Classes.Patient;

import java.util.ArrayList;
import java.util.List;

public class ListPatientActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PatientRecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Patient> appointmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_patient);

        DBHandler db = new DBHandler(this);

        appointmentArrayList = new ArrayList<>();
        List<Patient> appointmentList = new ArrayList<>();
        appointmentList = db.getAllPatients();

        for(Patient a: appointmentList){
                appointmentArrayList.add(a);
        }

        recyclerView = findViewById(R.id.listPatientRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerViewAdapter = new PatientRecyclerViewAdapter(ListPatientActivity.this, appointmentArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);


    }
}