package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.android.quakereport.R.id.magnitude;

/**
 * Created by Thinkpad on 5/1/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter <Earthquake> {

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    //using the ArrayAdapter's constructor
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> EarthquakeList){
        super(context, 0, EarthquakeList);
    }
    //format the magnitude to 2 decimal places
    private String formatMagnitude(double magnitude){
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }


    //inflate the list_item_view
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View listItemView = convertView;

        // handle the non reusable situation
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_view, parent, false);
        }

        Earthquake thisEarthquake = getItem(position);

        // infalte the list item view
        TextView magnitudeView = (TextView) listItemView.findViewById(magnitude);
        double magnitude = thisEarthquake.getMagnitude();
        magnitudeView.setText(formatMagnitude(magnitude));

        //set background color of the magnitude view
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(thisEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        TextView offsetLocationView = (TextView) listItemView.findViewById(R.id.location_offset);
        offsetLocationView.setText(thisEarthquake.getOffsetLocation());

        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(thisEarthquake.getPrimaryLocation());

        long timeInMilliSeconds = thisEarthquake.getTime();
        Date dateObject = new Date(timeInMilliSeconds);

        String dateString = formatDate(dateObject);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(dateString);

        String timeString = formatTime(dateObject);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(timeString);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude){
        int intMagnitude = (int) Math.floor(magnitude);
        switch(intMagnitude){
            case 0:
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return  ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default:
                return  ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
    }
}
