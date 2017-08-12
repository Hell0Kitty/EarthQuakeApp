package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import static com.example.android.quakereport.EarthquakeActivity.LOG_TAG;

/**
 * Created by Thinkpad on 5/4/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {

    private String mURL;
    public EarthquakeLoader(Context context,String url) {
        super(context);
        mURL = url;
        Log.w(LOG_TAG,"LoaderConstructor okay");
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        if (mURL == null) {
            return null;
        }
        ArrayList<Earthquake> earthquakesData = QueryUtils.fetchEarthquakeData(mURL);
        Log.w(LOG_TAG,"loadInBackground okay");
        return earthquakesData;
    }

    @Override
    protected void onStartLoading() {
        Log.w(LOG_TAG,"OnStartLoading okay");
        forceLoad();
    }
}
