package com.tencent.gsdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f6242a = -1;
    private static a b;

    public static int a(int i) {
        switch (i) {
            case 2412:
                return 1;
            case 2417:
                return 2;
            case 2422:
                return 3;
            case 2427:
                return 4;
            case 2432:
                return 5;
            case 2437:
                return 6;
            case 2442:
                return 7;
            case 2447:
                return 8;
            case 2452:
                return 9;
            case 2457:
                return 10;
            case 2462:
                return 11;
            case 2467:
                return 12;
            case 2472:
                return 13;
            case 2484:
                return 14;
            case 5180:
                return 36;
            case 5190:
                return 38;
            case 5200:
                return 40;
            case 5210:
                return 42;
            case 5220:
                return 44;
            case 5230:
                return 46;
            case 5240:
                return 48;
            case 5745:
                return TbsListener.ErrorCode.NEEDDOWNLOAD_10;
            case 5765:
                return 153;
            case 5785:
                return 157;
            case 5805:
                return TbsListener.ErrorCode.STARTDOWNLOAD_2;
            case 5825:
                return TbsListener.ErrorCode.STARTDOWNLOAD_6;
            default:
                return -1;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception e) {
            g.d("Check isNetworkConnected error:" + e.getMessage());
            return false;
        }
    }

    public static String b(Context context) {
        switch (c(context)) {
            case 0:
                return "unknown或无网络";
            case 1:
                return "2G";
            case 2:
                return "3G";
            case 3:
                return "4G";
            case 4:
                return "wifi";
            default:
                return "unknown";
        }
    }

    public static int c(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 4;
        }
        if (activeNetworkInfo.getType() == 0) {
            return a(activeNetworkInfo);
        }
        return 0;
    }

    private static int a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return 0;
        }
        switch (networkInfo.getSubtype()) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 0;
        }
    }

    public static int d(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo.getBSSID() != null) {
                return WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 5);
            }
            return -1;
        } catch (Exception e) {
            g.c("getWifiRssi error:" + e.getMessage());
            return -1;
        }
    }

    public static int e(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo.getBSSID() != null) {
                return connectionInfo.getLinkSpeed();
            }
            return -1;
        } catch (Exception e) {
            g.c("getWifiLinkSpeed error:" + e.getMessage());
            return -1;
        }
    }

    @SuppressLint({"UseSparseArrays"})
    public static int f(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            HashMap hashMap = new HashMap();
            try {
                int i = 0;
                int i2 = 0;
                for (ScanResult scanResult : wifiManager.getScanResults()) {
                    int a2 = a(scanResult.frequency);
                    if (scanResult.BSSID.equalsIgnoreCase(connectionInfo.getBSSID())) {
                        i2 = a2;
                    }
                    if (hashMap.containsKey(Integer.valueOf(a2))) {
                        hashMap.put(Integer.valueOf(a2), Integer.valueOf(((Integer) hashMap.get(Integer.valueOf(a2))).intValue() + 1));
                    } else {
                        hashMap.put(Integer.valueOf(a2), 1);
                    }
                }
                int i3 = 0;
                int i4 = 0;
                for (Map.Entry entry : hashMap.entrySet()) {
                    int intValue = ((Integer) entry.getKey()).intValue();
                    int intValue2 = ((Integer) entry.getValue()).intValue();
                    i3 += intValue2;
                    if (i2 == intValue) {
                        i = intValue2;
                    } else if (intValue >= i2 - 2 && intValue <= i2 + 2) {
                        i4 += intValue2;
                    }
                }
                g.a("信道：" + i2 + "，信道wifi数：" + i + "，附近的wifi数:" + i4 + ",扫描到的wifi总数：" + i3);
                return i;
            } catch (Exception e) {
                g.c("getWifiSignal error:" + e.getMessage());
                return -1;
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void b(int i) {
        f6242a = i;
    }

    public static int a() {
        return f6242a;
    }

    public static void g(final Context context) {
        g.b("startMobileSignalListener");
        try {
            if (b == null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.gsdk.utils.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a unused = c.b = new a();
                        if (context != null) {
                            g.b("startMobileSignalListener 2");
                            ((TelephonyManager) context.getSystemService("phone")).listen(c.b, 256);
                        }
                    }
                });
            }
        } catch (Exception e) {
            g.d("startMobileSignal:" + e.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    static class a extends PhoneStateListener {
        a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            int intValue;
            super.onSignalStrengthsChanged(signalStrength);
            g.b("startMobileSignalListener onSignalStrengthsChanged");
            if (signalStrength == null) {
                return;
            }
            try {
                if (signalStrength.isGsm()) {
                    Method method = SignalStrength.class.getMethod("getLevel", new Class[0]);
                    method.setAccessible(true);
                    intValue = ((Integer) method.invoke(signalStrength, new Object[0])).intValue();
                } else {
                    Method method2 = SignalStrength.class.getMethod("getEvdoLevel", new Class[0]);
                    method2.setAccessible(true);
                    intValue = ((Integer) method2.invoke(signalStrength, new Object[0])).intValue();
                }
                if (intValue == 5) {
                    intValue = 4;
                }
                g.b("onSignalStrengthsChanged level is " + intValue);
                c.b(intValue);
            } catch (Exception e) {
                g.c("MobileSignalState:" + e.getMessage());
            }
        }
    }
}
