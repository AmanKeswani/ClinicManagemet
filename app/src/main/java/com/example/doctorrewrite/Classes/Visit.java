package com.example.doctorrewrite.Classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Visit implements Parcelable {
    private int id;
    private String name;
    private String date;
    private String place;
    private int to_pay;
    private int paid;

    public Visit(int id, String name, String date, String place, int to_pay, int paid) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
        this.to_pay = to_pay;
        this.paid = paid;
    }

    public Visit(String name, String date, String place, int to_pay, int paid) {
        this.name = name;
        this.date = date;
        this.place = place;
        this.to_pay = to_pay;
        this.paid = paid;
    }

    public Visit() {
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    protected Visit(Parcel in) {
        id = in.readInt();
        name = in.readString();
        date = in.readString();
        place = in.readString();
        to_pay = in.readInt();
        paid = in.readInt();
    }

    public static final Creator<Visit> CREATOR = new Creator<Visit>() {
        @Override
        public Visit createFromParcel(Parcel in) {
            return new Visit(in);
        }

        @Override
        public Visit[] newArray(int size) {
            return new Visit[size];
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
        parcel.writeString(date);
        parcel.writeString(place);
        parcel.writeInt(to_pay);
        parcel.writeInt(paid);
    }
}
