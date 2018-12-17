package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomUsers implements Parcelable {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Parcelable.Creator<RandomUsers> CREATOR = new Creator<RandomUsers>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RandomUsers createFromParcel(Parcel in) {
            return new RandomUsers(in);
        }

        public RandomUsers[] newArray(int size) {
            return (new RandomUsers[size]);
        }

    };

    protected RandomUsers(Parcel in) {
        in.readList(this.results, (com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.model.Result.class.getClassLoader()));
        this.info = ((Info) in.readValue((Info.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public RandomUsers() {
    }

    /**
     * @param results
     * @param info
     */
    public RandomUsers(List<Result> results, Info info) {
        super();
        this.results = results;
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return 0;
    }

}