package com.helpshift.util;

import android.location.Location;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
public class LocationUtil {
    private static final float LOCATION_MIN_DISTANCE = 10.0f;
    private static final int TWO_MINUTES = 120000;

    private static double limitLongitude(double d) {
        double d2 = d % 360.0d;
        return d2 > 180.0d ? d2 - 360.0d : d2 <= -180.0d ? d2 + 360.0d : d2;
    }

    public static boolean isBetterLocation(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean isSameProvider = isSameProvider(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && isSameProvider;
        }
        return true;
    }

    public static Location sanitizeLocation(Location location) {
        Location limitLatitude = limitLatitude(location.getLatitude(), location.getLongitude());
        location.setLatitude(limitLatitude.getLatitude());
        location.setLongitude(limitLatitude.getLongitude());
        return location;
    }

    private static Location limitLatitude(double d, double d2) {
        double limitLongitude = limitLongitude(d);
        boolean z = true;
        if (limitLongitude > 90.0d) {
            limitLongitude = 180.0d - limitLongitude;
        } else if (limitLongitude < -90.0d) {
            limitLongitude = (-180.0d) - limitLongitude;
        } else {
            z = false;
        }
        if (z) {
            d2 += d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 180.0d : -180.0d;
        }
        double limitLongitude2 = limitLongitude(d2);
        Location location = new Location("");
        location.setLatitude(limitLongitude);
        location.setLongitude(limitLongitude2);
        return location;
    }

    public static boolean isSameLocation(Location location, Location location2) {
        return (location == null || location2 == null) ? location == null && location2 == null : location.distanceTo(location2) <= LOCATION_MIN_DISTANCE;
    }

    private static boolean isSameProvider(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }
}
