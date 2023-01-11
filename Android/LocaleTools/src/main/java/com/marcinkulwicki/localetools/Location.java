package com.marcinkulwicki.localetools;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;

public class Location implements LocationListener
{
    public static android.location.Location LastLocation;
    private FusedLocationProviderClient locationManager;

    @SuppressLint("MissingPermission")
    public void init(Context context)
    {
        locationManager = LocationServices.getFusedLocationProviderClient(context);
        LocationRequest.Builder locationRequest = new LocationRequest.Builder(500);
        locationRequest.setWaitForAccurateLocation(true);
        locationRequest.setPriority(Priority.PRIORITY_HIGH_ACCURACY);
        locationManager.requestLocationUpdates(locationRequest.build(), this, context.getMainLooper());
    }

    @Override
    public void onLocationChanged(@NonNull android.location.Location location) {
        LastLocation = location;
    }
}
