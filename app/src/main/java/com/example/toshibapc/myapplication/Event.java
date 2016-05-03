package com.example.toshibapc.myapplication;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Toshiba PC on 29/12/14.
 */
public class Event implements Parcelable{
    private String title;
    private String timing;
    private String details;
    public Event(String title, String timing, String details) {
        this.title = title;
        this.timing = timing;
        this.details = details;
    }
    public Event(String title, String timing) {
        this.title = title;
        this.timing = timing;
    }

    public String getTitle() {
        return title;
    }
    public String getTiming() {
        return timing;
    }
    public String getDetails() {
        return details;
    }

    protected Event(Parcel in) {
        title = in.readString();
        timing = in.readString();
        details = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(timing);
        dest.writeString(details);
    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
