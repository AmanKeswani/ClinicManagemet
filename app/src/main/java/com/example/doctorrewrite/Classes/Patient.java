package com.example.doctorrewrite.Classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Patient implements Parcelable {
    private int id;
    private String name;
    private String number;
    private String history;
    private String medical_history;
    private String complains;
    private String past_history;
    private String diagnosis;
    private String procedure;
    private String first_date;

    public Patient(int id,
                   String name,
                   String number,
                   String history,
                   String medical_history,
                   String complains,
                   String past_history,
                   String diagnosis,
                   String procedure,
                   String first_date) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.history = history;
        this.medical_history = medical_history;
        this.complains = complains;
        this.past_history = past_history;
        this.diagnosis = diagnosis;
        this.procedure = procedure;
        this.first_date = first_date;
    }

    public Patient(String name,
                   String number,
                   String history,
                   String medical_history,
                   String complains,
                   String past_history,
                   String diagnosis,
                   String procedure,
                   String first_date) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.history = history;
        this.medical_history = medical_history;
        this.complains = complains;
        this.past_history = past_history;
        this.diagnosis = diagnosis;
        this.procedure = procedure;
        this.first_date = first_date;
    }

    public Patient() {
    }

    protected Patient(Parcel in) {
        id = in.readInt();
        name = in.readString();
        number = in.readString();
        history = in.readString();
        medical_history = in.readString();
        complains = in.readString();
        past_history = in.readString();
        diagnosis = in.readString();
        procedure = in.readString();
        first_date = in.readString();
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getMedical_history() {
        return medical_history;
    }

    public void setMedical_history(String medical_history) {
        this.medical_history = medical_history;
    }

    public String getComplains() {
        return complains;
    }

    public void setComplains(String complains) {
        this.complains = complains;
    }

    public String getPast_history() {
        return past_history;
    }

    public void setPast_history(String past_history) {
        this.past_history = past_history;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getFirst_date() {
        return first_date;
    }

    public void setFirst_date(String first_date) {
        this.first_date = first_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(number);
        parcel.writeString(history);
        parcel.writeString(medical_history);
        parcel.writeString(complains);
        parcel.writeString(past_history);
        parcel.writeString(diagnosis);
        parcel.writeString(procedure);
        parcel.writeString(first_date);
    }
}

