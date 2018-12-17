package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info implements Parcelable {

    @SerializedName("seed")
    @Expose
    private String seed;
    public final static Parcelable.Creator<Info> CREATOR = new Creator<Info>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        public Info[] newArray(int size) {
            return (new Info[size]);
        }

    };
    @SerializedName("results")
    @Expose
    private long results;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("page")
    @Expose
    private long page;

    protected Info(Parcel in) {
        this.seed = ((String) in.readValue((String.class.getClassLoader())));
        this.results = ((long) in.readValue((long.class.getClassLoader())));
        this.page = ((long) in.readValue((long.class.getClassLoader())));
        this.version = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public Info() {
    }

    /**
     * @param results
     * @param page
     * @param seed
     * @param version
     */
    public Info(String seed, long results, long page, String version) {
        super();
        this.seed = seed;
        this.results = results;
        this.page = page;
        this.version = version;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public long getResults() {
        return results;
    }

    public void setResults(long results) {
        this.results = results;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(seed);
        dest.writeValue(results);
        dest.writeValue(page);
        dest.writeValue(version);
    }

    public int describeContents() {
        return 0;
    }

}