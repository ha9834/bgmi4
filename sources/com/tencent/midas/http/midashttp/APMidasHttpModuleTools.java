package com.tencent.midas.http.midashttp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.security.cert.CertificateNotYetValidException;
import javax.security.cert.CertificateExpiredException;

/* loaded from: classes.dex */
class APMidasHttpModuleTools {
    APMidasHttpModuleTools() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isTimeError(Throwable th) {
        String th2 = th.toString();
        if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
            return true;
        }
        if (TextUtils.isEmpty(th2)) {
            return false;
        }
        if (th2.contains("validation time") && th2.contains("current time")) {
            return true;
        }
        if (th2.contains("GMT") && th2.contains("compared to")) {
            return true;
        }
        if (th2.contains("Could not validate certificate")) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis > 0 && 1451577600 > currentTimeMillis) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isWifiProxy(Throwable th, Context context) {
        if (context == null || th == null) {
            return false;
        }
        return getNetWorkType(context) == 1000 && !TextUtils.isEmpty(Proxy.getDefaultHost()) && th.toString().contains("Trust anchor for certification path not found");
    }

    private static boolean isSSLV3Error(Throwable th) {
        String th2 = th.toString();
        return (th2.contains("SSL handshake aborted") && th2.contains("usually a protocol error")) || th2.contains("GET_SERVER_HELLO");
    }

    private static int getNetWorkType(Context context) {
        try {
            if (!isNetworkConnect(context)) {
                return 0;
            }
            if (isNetworkWIFI(context)) {
                return 1000;
            }
            if (isNetwork4G(context)) {
                return 4;
            }
            if (isNetwork3G(context)) {
                return 3;
            }
            return isWAP(context) ? 1 : 2;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static boolean isWAP(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && "MOBILE".equals(activeNetworkInfo.getTypeName())) {
                String defaultHost = Proxy.getDefaultHost();
                if (!TextUtils.isEmpty(defaultHost)) {
                    if (defaultHost.contains("wap")) {
                        return true;
                    }
                    if (defaultHost.contains("WAP")) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isNetwork3G(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && "MOBILE".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
                int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                if (networkType == 3 || networkType == 6) {
                    return true;
                }
                switch (networkType) {
                    case 8:
                        return true;
                    case 9:
                        return true;
                    case 10:
                        return true;
                    default:
                        return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isNetwork4G(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && "MOBILE".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkType() == 13;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isNetworkWIFI(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if ("WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isNetworkConnect(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
