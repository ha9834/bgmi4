package com.tencent.hawk.bridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class NetworkUtil {
    public static final int NETWORN_2G = 2;
    public static final int NETWORN_3G = 3;
    public static final int NETWORN_4G = 4;
    public static final int NETWORN_MOBILE = 5;
    public static final int NETWORN_NONE = 0;
    public static final int NETWORN_WIFI = 1;

    @SuppressLint({"NewApi"})
    public static int getNetworkState(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                return 1;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                NetworkInfo.State state2 = networkInfo2.getState();
                String subtypeName = networkInfo2.getSubtypeName();
                if (subtypeName != null && state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return 3;
                        case 13:
                        case 18:
                            return 4;
                        default:
                            return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : 5;
                    }
                }
            }
        } else {
            Network[] allNetworks = connectivityManager.getAllNetworks();
            if (allNetworks == null) {
                return 0;
            }
            for (Network network : allNetworks) {
                NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(network);
                if (networkInfo3 == null) {
                    return 0;
                }
                NetworkInfo.State state3 = networkInfo3.getState();
                if (state3 != null && (state3 == NetworkInfo.State.CONNECTED || state3 == NetworkInfo.State.CONNECTING)) {
                    if (networkInfo3.getType() == 1) {
                        return 1;
                    }
                    String subtypeName2 = networkInfo3.getSubtypeName();
                    if (subtypeName2 == null) {
                        return 0;
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return 3;
                        case 13:
                        case 18:
                            return 4;
                        default:
                            return (subtypeName2.equalsIgnoreCase("TD-SCDMA") || subtypeName2.equalsIgnoreCase("WCDMA") || subtypeName2.equalsIgnoreCase("CDMA2000")) ? 3 : 5;
                    }
                }
            }
        }
        return 0;
    }

    public static String getIPAddress(boolean z) {
        ArrayList list;
        ArrayList<InetAddress> list2;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null || (list = Collections.list(networkInterfaces)) == null) {
                return null;
            }
            Iterator it = list.iterator();
            while (it.hasNext() && (list2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses())) != null) {
                for (InetAddress inetAddress : list2) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress == null) {
                            return null;
                        }
                        boolean z2 = hostAddress.indexOf(58) < 0;
                        if (z) {
                            if (z2) {
                                return hostAddress;
                            }
                        } else if (!z2) {
                            int indexOf = hostAddress.indexOf(37);
                            return indexOf < 0 ? hostAddress.toUpperCase(Locale.getDefault()) : hostAddress.substring(0, indexOf).toUpperCase();
                        }
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long hton(String str) {
        String[] split = str.split("\\.");
        if (split == null || split.length != 4) {
            return -1L;
        }
        return ((Integer.parseInt(split[1].trim()) & 255) << 16) | ((Integer.parseInt(split[0].trim()) & 255) << 24) | ((Integer.parseInt(split[2].trim()) & 255) << 8) | (Integer.parseInt(split[3].trim()) & 255);
    }

    public static long getIpAddr() {
        String iPAddress = getIPAddress(true);
        if (iPAddress == null) {
            return -1L;
        }
        return hton(iPAddress);
    }
}
