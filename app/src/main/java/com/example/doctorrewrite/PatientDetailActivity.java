package com.example.doctorrewrite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.doctorrewrite.Adapters.AppointmentRecyclerViewAdapter;
import com.example.doctorrewrite.Classes.Appointment;
import com.example.doctorrewrite.Classes.DBHandler;
import com.example.doctorrewrite.Classes.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppointmentRecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Appointment> appointmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);

        Intent i = getIntent();
        Patient p = i.getParcelableExtra("PATIENT");

        TextView name = findViewById(R.id.patientCardName);
        name.setText(p.getName());

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.setId(-5);
                Intent i = new Intent(PatientDetailActivity.this, normalText.class);
                i.putExtra("PATIENT", p);
                startActivity(i);
            }
        });

        DBHandler db = new DBHandler(this);

        appointmentArrayList = new ArrayList<>();
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList = db.getAllAppointments();

        for(Appointment a: appointmentList){
            if(a.getName().equalsIgnoreCase(p.getName())){
                appointmentArrayList.add(a);
            }
        }

        recyclerView = findViewById(R.id.patientDetailRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new AppointmentRecyclerViewAdapter(PatientDetailActivity.this, appointmentArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}