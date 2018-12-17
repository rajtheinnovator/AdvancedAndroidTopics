package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timezone implements Parcelable {

    public final static Parcelable.Creator<Timezone> CREATOR = new Creator<Timezone>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Timezone createFromParcel(Parcel in) {
            return new Timezone(in);
        }

        public Timezone[] newArray(int size) {
            return (new Timezone[size]);
        }

    };
    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("description")
    @Expose
    private String description;

    protected Timezone(Parcel in) {
        this.offset = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public Timezone() {
    }

    /**
     * @param description
     * @param offset
     */
    public Timezone(String offset, String description) {
        super();
        this.offset = offset;
        this.description = description;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(offset);
        dest.writeValue(description);
    }

    public int describeContents() {
        return 0;
    }

}