package com.book.pay.app.service;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.google.android.gms.location.LocationListener;


public class LocationService implements LocationListener {

    public static final int MY_PERMISSION_ACCESS_COURSE_LOCATION = 204;
    //The minimum distance to change updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 10 meters

    //The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 0;//1000 * 60 * 1; // 1 minute

    private final static boolean forceNetwork = false;

    private static LocationService instance = null;

    private LocationManager locationManager;
    public Location location;
    public double longitude;
    public double latitude;

    private boolean isGPSEnabled,isNetworkEnabled,locationServiceAvailable;

    /**
     * Singleton implementation
     * @return
     */
    public static LocationService getLocationManager(Context context)     {
        if (instance == null) {
            instance = new LocationService(context);
        }
        return instance;
    }

    /**
     * Local constructor
     */
    private LocationService( Context context )     {



    }


    @Override
    public void onLocationChanged(Location location) {

        int lat = (int) location.getLatitude(); // * 1E6);
        int log = (int) location.getLongitude(); // * 1E6);
        int acc = (int) (location.getAccuracy());



        String info = location.getProvider();
        try {

            // LocatorService.myLatitude=location.getLatitude();

            // LocatorService.myLongitude=location.getLongitude();

            latitude = location.getLatitude();
            longitude = location.getLongitude();

        } catch (Exception e) {
            // progDailog.dismiss();
            // Toast.makeText(getApplicationContext(),"Unable to get Location"
            // , Toast.LENGTH_LONG).show();
        }

    }


}
