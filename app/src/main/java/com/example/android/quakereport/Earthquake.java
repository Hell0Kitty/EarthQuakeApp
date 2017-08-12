package com.example.android.quakereport;

/**
 * Created by Thinkpad on 5/1/2017.
 */

public class Earthquake {
    /**
     * data members to describe details of the earthquake
     */
    private double mMagnitude;
    private String mOffsetLocation;
    private String mPrimaryLocation;
    private long mTime;
    private String mUrl;
    private static final String LOCATION_SEPARATOR = "of";

    //constructor takes magnitude, place and time information
    public Earthquake(double magnitude, String place,  long time, String url){

        mMagnitude = magnitude;

        //split up the location information into offset and primary locations
        int offsetPosition = place.indexOf(LOCATION_SEPARATOR);
        if(offsetPosition == -1) {
            mOffsetLocation = "Near the";
            mPrimaryLocation = place;
        }
        else {
            mOffsetLocation = place.substring(0,offsetPosition + 3);
            mPrimaryLocation = place.substring(offsetPosition + 3, place.length());
        }
        mTime = time;
        mUrl = url;
    }

    //return the magnitude of the earthquake
    public double getMagnitude(){
        return mMagnitude;
    }

    //return the offset location of the earthquake
    public String getOffsetLocation(){
        return mOffsetLocation;
    }

    //return the primary location of the earthquake
    public String getPrimaryLocation(){
        return mPrimaryLocation;
    }

    //return the time of the earthquake
    public long getTime(){
        return mTime;
    }

    public String getUrl() {
        return mUrl;
    }

    //set the magnitude of the earthquake
    public void setMagnitude(double magnitude){
        mMagnitude = magnitude;
    }

    //set the offset location of the earthquake
    public void setOffsetLocation(String place){
        mOffsetLocation = place;
    }

    //set the primary location of the earthquake
    public void setPrimaryLocation(String place){
        mPrimaryLocation = place;
    }

    //set the time of the earthquake
    public void getTime(long time){
        mTime = time;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
