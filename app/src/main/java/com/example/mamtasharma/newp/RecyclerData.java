package com.example.mamtasharma.newp;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

/**
 * Created by Mamta Sharma on 11/3/2016.
 */

public class RecyclerData implements Parcelable{
    String title;
    String description;
    RecyclerView data;
    public RecyclerData(){}
    public RecyclerData(Parcel item){

        title = item.readString();
        description = item.readString();
    }

    public static final Parcelable.Creator<RecyclerData> CREATOR = new Parcelable.Creator<RecyclerData>() {
        @Override
        public RecyclerData createFromParcel(Parcel in) {
            return new RecyclerData(in);
        }

        @Override
        public RecyclerData[] newArray(int size) {
            return new RecyclerData[size];
        }
    };

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCrossImage(ImageView crossImage){
        setCrossImage(crossImage);
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(title);
        parcel.writeString(description);
    }
}