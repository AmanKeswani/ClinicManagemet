package com.example.doctorrewrite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doctorrewrite.Classes.DBHandler;
import com.example.doctorrewrite.Classes.Patient;

public class PatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        Intent i = getIntent();
        Patient ab = i.getParcelableExtra("PATIENT");

        if(ab.getId() != -1){
            TextView name = findViewById(R.id.appointmentName);
            TextView number = findViewById(R.id.appointmentNumber);
            TextView history = findViewById(R.id.patientHistory);
            TextView medical_history = findViewById(R.id.patientMedicalHistory);
            TextView complains = findViewById(R.id.patientComplains);
            TextView past_history = findViewById(R.id.patientPastHistory);
            TextView diagnosis = findViewById(R.id.patientDiagnosis);
            TextView procedure = findViewById(R.id.appointmentProcedure);
            TextView date = findViewById(R.id.appointmenttopay);

            name.setText(ab.getName());
            number.setText("" + ab.getNumber());
            history.setText(ab.getHistory());
            medical_history.setText(ab.getMedical_history());
            complains.setText(ab.getComplains());
            past_history.setText(ab.getPast_history());
            diagnosis.setText(ab.getDiagnosis());
            procedure.setText(ab.getProcedure());
            date.setText(ab.getFirst_date());

        }

        Button b = findViewById(R.id.appointmentSubmit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name = findViewById(R.id.appointmentName);
                TextView number = findViewById(R.id.appointmentNumber);
                TextView history = findViewById(R.id.patientHistory);
                TextView medical_history = findViewById(R.id.patientMedicalHistory);
                TextView complains = findViewById(R.id.patientComplains);
                TextView past_history = findViewById(R.id.patientPastHistory);
                TextView diagnosis = findViewById(R.id.patientDiagnosis);
                TextView procedure = findViewById(R.id.appointmentProcedure);
                TextView date = findViewById(R.id.appointmenttopay);

                Patient pt = new Patient();
                pt.setName(name.getText().toString());
                pt.setNumber(number.getText().toString());
                pt.setHistory(history.getText().toString());
                pt.setMedical_history(medical_history.getText().toString());
                pt.setComplains(complains.getText().toString());
                pt.setPast_history(past_history.getText().toString());
                pt.setDiagnosis(diagnosis.getText().toString());
                pt.setProcedure(procedure.getText().toString());
                pt.setFirst_date(date.getText().toString());

                DBHandler db = new DBHandler(PatientActivity.this);
                if (ab.getId() == -1) {
                    db.addPatient(pt);
                    Toast.makeText(PatientActivity.this, "Added Patient Successfully.", Toast.LENGTH_SHORT).show();
                } else if(ab.getId() >= 0){
                    db.updatePatient(pt);
                    Toast.makeText(PatientActivity.this, "Updated Patient.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}