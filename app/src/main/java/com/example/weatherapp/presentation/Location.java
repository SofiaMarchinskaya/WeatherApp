package com.example.weatherapp.presentation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class Location {
    private final LocationManager mLocationManager;
    private final LocationListener mLocationListener;

    public Location(LocationManager locationManager, Context context, OnLocationGet onLocationGet) {
        this.mLocationManager = locationManager;
        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull android.location.Location location) {
                onLocationGet.onLocationGet(String.valueOf(location.getLatitude()),
                        String.valueOf(location.getLongitude()));
                mLocationManager.removeUpdates(mLocationListener);
            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                onLocationGet.onLocationGet(String.valueOf(mLocationManager.getLastKnownLocation(provider).getLatitude()),
                        String.valueOf(mLocationManager.getLastKnownLocation(provider).getLongitude())  );
                mLocationManager.removeUpdates(mLocationListener);
            }
        };
        mLocationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER, 1000 * 10, 10,
                mLocationListener);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000 * 10, 10, mLocationListener);
    }
}

interface OnLocationGet {
    void onLocationGet(String lat, String lon);
}