package com.example.doctorrewrite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.doctorrewrite.Classes.Patient;

public class normalText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_text);

        Intent i = getIntent();
        Patient p = i.getParcelableExtra("PATIENT");

        String main = "ID: " + p.getId() +
                "\nName:\n " + p.getName() +
                "\nNumber:\n " + p.getNumber() +
                "\nHistory:\n " + p.getHistory() +
                "\nMedical History:\n " + p.getMedical_history() +
                "\nComplains:\n " + p.getComplains() +
                "\nPast History:\n " + p.getPast_history() +
                "\nDiagnosis:\n " + p.getDiagnosis() +
                "\nProcedure:\n " + p.getProcedure() +
                "\nFirst Visit:\n " + p.getFirst_date();

        TextView text = findViewById(R.id.textView);
        text.setMovementMethod(new ScrollingMovementMethod());
        text.setText(main);
    }
}