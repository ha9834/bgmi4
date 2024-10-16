package com.helpshift.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes2.dex */
public final class HelpshiftConnectionUtil {
    private static final String TAG = "Helpshift_ConnectUtil";

    public static boolean isOnline(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            HSLogger.e(TAG, "Exception while getting system connectivity service", e);
            return false;
        }
    }

    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : "Unknown";
        } catch (Exception e) {
            HSLogger.e(TAG, "Exception while getting system connectivity service", e);
            return "Unknown";
        }
    }
}
