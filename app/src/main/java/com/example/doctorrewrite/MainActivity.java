package com.example.doctorrewrite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doctorrewrite.Classes.AddVisitDialog;
import com.example.doctorrewrite.Classes.DBHandler;
import com.example.doctorrewrite.Classes.Visit;

public class MainActivity extends AppCompatActivity implements AddVisitDialog.DialogListener {

    private Button addpatient;
    private Button getpatient;
    private Button addappointment;
    private Button getappointments;
    private Button addvisit;
    private Button getvisits;
    private Button editpatient;
    private Button deletepatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addpatient = findViewById(R.id.addNewPatient);
        getpatient = findViewById(R.id.GetPatient);
        addappointment = findViewById(R.id.addAppointment);
        getappointments = findViewById(R.id.getAppointments);
        addvisit = findViewById(R.id.addVisit);
        getvisits = findViewById(R.id.getVisits);
        editpatient = findViewById(R.id.editPatient);
        deletepatient = findViewById(R.id.deletePatient);

        addpatient.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PatientActivity.class);
                startActivity(i);
            }
        });

        getpatient.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PatientActivity.class);
                startActivity(i);
            }
        });
        addappointment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddAppointmentActivity.class);
                startActivity(i);
            }
        });
        getappointments.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListAppointmentActivity.class);
                startActivity(i);
            }
        });
        addvisit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AddVisitDialog addVisitDialog = new AddVisitDialog();
                addVisitDialog.show(getSupportFragmentManager(), "Add Visit");



            }
        });
        getvisits.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListVisitActivity.class);
                startActivity(i);
            }
        });
        editpatient.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PatientActivity.class);
                startActivity(i);
            }
        });
        deletepatient.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PatientActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void pass_visit(Visit v) {
        DBHandler db = new DBHandler(this);
        db.addVisit(v);

        Toast.makeText(this, "Added Visit", Toast.LENGTH_SHORT).show();
    }
}