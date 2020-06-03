package com.book.pay.app.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.book.pay.app.service.LocationService;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class LocationUtil {

    private FusedLocationProviderClient mFusedLocationClient;
    private LocationManager locationManager;
    private LocationRequest locationRequest;
    private AppCompatActivity activity;

    private Coordinate coordinate;
    private Location location;

    public Coordinate getCoordinate() {
        return coordinate;
    }



    public LocationUtil(AppCompatActivity activity) {


        this.locationManager = locationManager;
        this.locationRequest = locationRequest;
        this.activity = activity;

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity);
        locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
    }

    //TODO da completare
    public boolean getLocationTask(final Coordinate coordinate) {


        if (ActivityCompat.checkSelfPermission(this.activity, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this.activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            return false;
        }

        location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
        mFusedLocationClient.getLastLocation().addOnCompleteListener(
                new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {

                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();

                        } else {
                            Log.d("TAG LOCATION UTIL","Coordinate acquisite "+coordinate.getLatitudine() +
                                    " "+coordinate.getLongitudine() );
                            coordinate.setLatitudine(String.valueOf(location.getLatitude()));
                            coordinate.setLongitudine(String.valueOf(location.getLongitude()));
                        }
                    }

                }
        );
        return true;
    }

    public boolean lastLocation(Coordinate coordinate) {
       if(coordinate == null){
           return false;
       }
       Double latitudine = Double.valueOf(coordinate.getLatitudine());
       Double longitudine = Double.valueOf(coordinate.getLongitudine());
       if(latitudine.equals(location.getLatitude()) && longitudine.equals(location.getLongitude())){
           return false;
       }
        return true;
    }


    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(1000L);
        mLocationRequest.setNumUpdates(2);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity);
        mFusedLocationClient.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                Looper.myLooper()
        );

    }

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            if(mLastLocation != null){
                if(coordinate != null){
                    coordinate.setLongitudine(String.valueOf(mLastLocation.getLongitude()));
                    coordinate.setLatitudine(String.valueOf(mLastLocation.getLatitude()));
                }else{
                    coordinate = new Coordinate();
                    coordinate.setLongitudine(String.valueOf(mLastLocation.getLongitude()));
                    coordinate.setLatitudine(String.valueOf(mLastLocation.getLatitude()));
                }
            }
        }
    };


}
