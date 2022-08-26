package com.example.doctorrewrite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doctorrewrite.Classes.Appointment;
import com.example.doctorrewrite.Classes.DBHandler;
import com.example.doctorrewrite.Classes.Patient;

public class AddAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        Intent i = getIntent();
        Patient p = i.getParcelableExtra("PATIENT");
        Toast.makeText(this, "1" + p.getName(), Toast.LENGTH_SHORT).show();
        TextView name = findViewById(R.id.appointmentName);
        TextView number = findViewById(R.id.appointmentNumber);
        name.setText(p.getName());
        number.setText(p.getNumber());

        Button b = findViewById(R.id.appointmentSubmit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name = findViewById(R.id.appointmentName);
                TextView number = findViewById(R.id.appointmentNumber);
                TextView procedure = findViewById(R.id.appointmentProcedure);
                TextView to_pay = findViewById(R.id.appointmenttopay);
                TextView paid = findViewById(R.id.appointmentpaid);
                TextView date = findViewById(R.id.appointmentdate);

                DBHandler db = new DBHandler(AddAppointmentActivity.this);
                Appointment a = new Appointment();

                a.setName(name.getText().toString());
                a.setNumber(number.getText().toString());
                a.setProcedure(procedure.getText().toString());
                a.setTo_pay(Integer.parseInt(to_pay.getText().toString()));
                a.setPaid(Integer.parseInt(paid.getText().toString()));
                a.setDate(date.getText().toString());
                db.addAppointment(a);
                Toast.makeText(AddAppointmentActivity.this, "Added Appointment.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}