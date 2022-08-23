package com.example.doctorrewrite.Classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Appointment implements Parcelable {
    private int id;
    private String name;
    private String number;
    private String date;
    private String procedure;
    private int to_pay;
    private int paid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public int getTo_pay() {
        return to_pay;
    }

    public void setTo_pay(int to_pay) {
        this.to_pay = to_pay;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public Appointment(String name, String number, String date, String procedure, int to_pay, int paid) {
        this.name = name;
        this.number = number;
        this.date = date;
        this.procedure = procedure;
        this.to_pay = to_pay;
        this.paid = paid;
    }

    public Appointment(int id, String name, String number, String date, String procedure, int to_pay, int paid) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.date = date;
        this.procedure = procedure;
        this.to_pay = to_pay;
        this.paid = paid;
    }

    public Appointment() {
    }


    protected Appointment(Parcel in) {
        id = in.readInt();
        name = in.readString();
        number = in.readString();
        date = in.readString();
        procedure = in.readString();
        to_pay = in.readInt();
        paid = in.readInt();
    }

    public static final Creator<Appointment> CREATOR = new Creator<Appointment>() {
        @Override
        public Appointment createFromParcel(Parcel in) {
            return new Appointment(in);
        }

        @Override
        public Appointment[] newArray(int size) {
            return new Appointment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(number);
        parcel.writeString(date);
        parcel.writeString(procedure);
        parcel.writeInt(to_pay);
        parcel.writeInt(paid);
    }
}

