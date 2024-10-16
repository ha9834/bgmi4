package com.tencent.abase;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.tencent.abase.log.XLog;
import java.util.Locale;

/* loaded from: classes2.dex */
public class NetworkStateChecker {
    private static final String tag = "NetworkStateChecker";

    public int GetDetailNetworkState(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                XLog.w(tag, "NetworkStateChecker connManager is null");
                return DetailNetworkState.NotReachable.ordinal();
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (1 == activeNetworkInfo.getType()) {
                    return DetailNetworkState.ReachableViaWiFi.ordinal();
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return DetailNetworkState.ReachableViaWWAN_2G.ordinal();
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return DetailNetworkState.ReachableViaWWAN_3G.ordinal();
                        case 13:
                            return DetailNetworkState.ReachableViaWWAN_4G.ordinal();
                        default:
                            return DetailNetworkState.ReachableViaWWAN_UNKNOWN.ordinal();
                    }
                }
                return DetailNetworkState.ReachableViaOthers.ordinal();
            }
            XLog.w(tag, "NetworkStateChecker ApolloNetInfo is null");
            return DetailNetworkState.NotReachable.ordinal();
        } catch (Exception e) {
            XLog.w(tag, "check Get exception:" + e.toString());
            return DetailNetworkState.NotReachable.ordinal();
        }
    }

    public String GetSSID(Context context) {
        WifiInfo connectionInfo;
        String ssid;
        try {
            context.enforcePermission("android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid(), "permission.ACCESS_FINE_LOCATION not grant");
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || connectionInfo.getSSID() == null || (ssid = connectionInfo.getSSID()) == null) ? "None" : ssid.replace("\"", "");
        } catch (Exception e) {
            e.printStackTrace();
            return "None";
        }
    }

    public String GetBSSID(Context context) {
        WifiInfo connectionInfo;
        try {
            context.enforcePermission("android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid(), "permission.ACCESS_FINE_LOCATION not grant");
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || connectionInfo.getBSSID() == null) ? "None" : connectionInfo.getBSSID();
        } catch (Exception e) {
            e.printStackTrace();
            return "None";
        }
    }

    public String GetCurrentCarrierCode(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return (telephonyManager == null || 5 != telephonyManager.getSimState()) ? "" : telephonyManager.getSimOperator();
    }

    public int GetCurrentCarrier(String str, String str2) {
        Carrier carrier;
        Carrier carrier2;
        if (str.equals("46000") || str.equals("46002") || str.equals("46007")) {
            carrier = Carrier.ChinaMobile;
        } else if (str.equals("46001") || str.equals("46006")) {
            carrier = Carrier.ChinaUnicom;
        } else if (str.equals("46003") || str.equals("46005")) {
            carrier = Carrier.ChinaTelecom;
        } else if (str.equals("46004")) {
            carrier = Carrier.ChinaSpacecom;
        } else {
            carrier = Carrier.Unknown;
        }
        if (str2.equals("")) {
            carrier2 = Carrier.None;
        } else if (str2.equals("CMWAP") || str2.equals("CMNET")) {
            carrier2 = Carrier.ChinaMobile;
        } else if (str2.equals("UNIWAP") || str2.equals("UNINET") || str2.equals("3GWAP") || str2.equals("3GNET")) {
            carrier2 = Carrier.ChinaUnicom;
        } else if (str2.equals("CTWAP") || str2.equals("CTNET")) {
            carrier2 = Carrier.ChinaTelecom;
        } else {
            carrier2 = Carrier.Unknown;
        }
        if (!carrier2.equals(Carrier.None) && !carrier2.equals(Carrier.Unknown) && !carrier2.equals(carrier)) {
            return carrier2.ordinal();
        }
        return carrier.ordinal();
    }

    public String GetCurrentAPN(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "";
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo != null) {
                return extraInfo;
            }
            XLog.e("getExtraInfo is null");
            return "";
        }
        if (type != 0) {
            return "";
        }
        String extraInfo2 = activeNetworkInfo.getExtraInfo();
        if (extraInfo2 == null) {
            XLog.e("Error", "getExtraInfo is null");
            return "";
        }
        String lowerCase = extraInfo2.toLowerCase(Locale.ENGLISH);
        return lowerCase.startsWith("cmwap") ? "CMWAP" : (lowerCase.startsWith("cmnet") || lowerCase.startsWith("epc.tmobile.com")) ? "CMNET" : lowerCase.startsWith("uniwap") ? "UNIWAP" : lowerCase.startsWith("uninet") ? "UNINET" : lowerCase.startsWith("wap") ? "WAP" : lowerCase.startsWith("net") ? "NET" : lowerCase.startsWith("ctwap") ? "CTWAP" : lowerCase.startsWith("ctnet") ? "CTNET" : lowerCase.startsWith("3gwap") ? "3GWAP" : lowerCase.startsWith("3gnet") ? "3GNET" : lowerCase.toUpperCase(Locale.ENGLISH);
    }

    public int CheckNetworkState(Context context) {
        NetworkState.NotReachable.ordinal();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return NetworkState.NotReachable.ordinal();
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                        return NetworkState.ReachableViaWWAN.ordinal();
                    case 1:
                        return NetworkState.ReachableViaWiFi.ordinal();
                    default:
                        return NetworkState.ReachableViaOthers.ordinal();
                }
            }
            return NetworkState.NotReachable.ordinal();
        } catch (Exception e) {
            XLog.e(tag, "check Get exception:" + e.toString());
            return NetworkState.NotReachable.ordinal();
        }
    }
}
