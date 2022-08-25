package com.example.doctorrewrite.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context context) {
        super(context, "DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_patients = "CREATE TABLE IF NOT EXISTS patients ( " +
                "ID INTEGER PRIMARY KEY," +
                "NAME TEXT, " +
                "NUMBER TEXT, " +
                "HISTORY TEXT, " +
                "MEDICAL_HISTORY TEXT, " +
                "COMPLAINS TEXT, "+
                "PAST_HISTORY TEXT, " +
                "DIAGNOSIS TEXT, " +
                "PROCEDURE TEXT, " +
                "DATE TEXT)";
        db.execSQL(create_patients);

        String create_appointments = "CREATE TABLE IF NOT EXISTS appointments ( " +
                "ID INTEGER PRIMARY KEY, " +
                "NAME TEXT, " +
                "NUMBER TEXT, " +
                "PROCEDURE TEXT, " +
                "DATE TEXT, " +
                "TO_PAY INTEGER ," +
                "PAID INTEGER)";
        db.execSQL(create_appointments);

        String create_visit = "CREATE TABLE IF NOT EXISTS visits (" +
                "ID INTEGER PRIMARY KEY, " +
                "NAME TEXT, " +
                "DATE TEXT, " +
                "PLACE TEXT, " +
                "TO_PAY INTEGER, " +
                "PAID INTEGER ) ";
        db.execSQL(create_visit);
    }

    public void addPatient(Patient p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();

        v.put("NAME", p.getName());
        v.put("NUMBER", p.getNumber());
        v.put("HISTORY", p.getHistory());
        v.put("MEDICAL_HISTORY", p.getMedical_history());
        v.put("COMPLAINS", p.getComplains());
        v.put("PAST_HISTORY", p.getPast_history());
        v.put("DIAGNOSIS", p.getDiagnosis());
        v.put("PROCEDURE", p.getProcedure());
        v.put("DATE", p.getFirst_date());

        db.insert("patients", null, v);
    }

    public List<Patient> getAllPatients(){
        List<Patient> patient_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM patients", null);

        if(c.moveToFirst()){
            do{
                Patient pt = new Patient();
                pt.setId(Integer.parseInt(c.getString(0)));
                pt.setName(c.getString(1));
                pt.setNumber(c.getString(2));
                pt.setHistory(c.getString(3));
                pt.setMedical_history(c.getString(4));
                pt.setComplains(c.getString(5));
                pt.setPast_history(c.getString(6));
                pt.setDiagnosis(c.getString(7));
                pt.setProcedure(c.getString(8));
                pt.setFirst_date(c.getString(9));

                patient_list.add(pt);

            }while(c.moveToNext());
        }
        return patient_list;
    }

    public void updatePatient(Patient p){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues v = new ContentValues();

        v.put("NAME", p.getName());
        v.put("NUMBER", p.getNumber());
        v.put("HISTORY", p.getHistory());
        v.put("MEDICAL_HISTORY", p.getMedical_history());
        v.put("COMPLAINS", p.getComplains());
        v.put("PAST_HISTORY", p.getPast_history());
        v.put("DIAGNOSIS", p.getDiagnosis());
        v.put("PROCEDURE", p.getProcedure());
        v.put("DATE", p.getFirst_date());

        db.update("patients", v, "NAME =? ",
                new String[]{p.getName()});

    }

    public void addAppointment(Appointment a){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();

        v.put("NAME", a.getName());
        v.put("NUMBER", a.getNumber());
        v.put("PROCEDURE", a.getProcedure());
        v.put("DATE", a.getDate());
        v.put("TO_PAY", a.getTo_pay());
        v.put("PAID", a.getPaid());

        db.insert("appointments", null, v);
    }

    public List<Appointment> getAllAppointments(){
        List<Appointment> appointmentList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM appointments", null);

        if(c.moveToFirst()){
            do{
                Appointment a = new Appointment();
                a.setId(Integer.parseInt(c.getString(0)));
                a.setName(c.getString(1));
                a.setNumber(c.getString(2));
                a.setDate(c.getString(3));
                a.setProcedure(c.getString(4));
                a.setTo_pay(Integer.parseInt(c.getString(5)));
                a.setPaid(Integer.parseInt(c.getString(6)));
                appointmentList.add(a);
            }while(c.moveToNext());
        }
        return appointmentList;
    }

    public List<Appointment> getAppointmentbyName(String number){
        List<Appointment> appointmentList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM appointments WHERE NUMBER = ?", new String[]{number}, null);

        if(c.moveToFirst()){
            do{
                Appointment pt = new Appointment();
                pt.setId(Integer.parseInt(c.getString(0)));
                pt.setName(c.getString(1));
                pt.setNumber(c.getString(2));
                pt.setDate(c.getString(3));
                pt.setProcedure(c.getString(4));
                pt.setTo_pay(Integer.parseInt(c.getString(5)));
                pt.setPaid(Integer.parseInt(c.getString(6)));
                appointmentList.add(pt);

            }while(c.moveToNext());
        }
        return appointmentList;
    }

    public void addVisit(Visit a){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();

        v.put("NAME", a.getName());
        v.put("DATE", a.getDate());
        v.put("PLACE", a.getPlace());
        v.put("TO_PAY", a.getTo_pay());
        v.put("PAID", a.getPaid());

        db.insert("visits", null, v);
    }

    public List<Visit> getAllVisits(){
        List<Visit> visitList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM visits", null);

        if(c.moveToFirst()){
            do{
                Visit a = new Visit();
                a.setId(Integer.parseInt(c.getString(0)));
                a.setName(c.getString(1));
                a.setDate(c.getString(2));
                a.setPlace(c.getString(3));
                a.setTo_pay(Integer.parseInt(c.getString(4)));
                a.setPaid(Integer.parseInt(c.getString(5)));
                visitList.add(a);
            }while(c.moveToNext());
        }
        return visitList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
