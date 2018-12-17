package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dob implements Parcelable {

    public final static Parcelable.Creator<Dob> CREATOR = new Creator<Dob>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Dob createFromParcel(Parcel in) {
            return new Dob(in);
        }

        public Dob[] newArray(int size) {
            return (new Dob[size]);
        }

    };
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private long age;

    protected Dob(Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.age = ((long) in.readValue((long.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public Dob() {
    }

    /**
     * @param age
     * @param date
     */
    public Dob(String date, long age) {
        super();
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(age);
    }

    public int describeContents() {
        return 0;
    }

}