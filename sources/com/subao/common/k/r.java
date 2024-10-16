package com.subao.common.k;

import android.annotation.TargetApi;
import android.net.Network;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.subao.common.k.m;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.DatagramSocket;

/* loaded from: classes2.dex */
public final class r {
    public static boolean a() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (!z && com.subao.common.d.a("SubaoParallel")) {
            Log.d("SubaoParallel", "WiFi-Accel not supported on Android version " + Build.VERSION.SDK_INT);
        }
        return z;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT == 23;
    }

    public static void a(DatagramSocket datagramSocket, Network network) {
        a(Build.VERSION.SDK_INT, datagramSocket, network);
    }

    static void a(int i, DatagramSocket datagramSocket, Network network) {
        if (i < 21) {
            throw new m.d(2000);
        }
        if (i > 21) {
            c(datagramSocket, network);
        } else {
            b(datagramSocket, network);
        }
    }

    @TargetApi(21)
    private static void b(DatagramSocket datagramSocket, Network network) {
        ParcelFileDescriptor parcelFileDescriptor;
        int a2 = a(network);
        try {
            parcelFileDescriptor = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        } catch (Error | RuntimeException unused) {
            parcelFileDescriptor = null;
        }
        if (parcelFileDescriptor == null) {
            throw new m.d(2011);
        }
        try {
            a(datagramSocket, parcelFileDescriptor.getFd(), a2);
        } catch (RuntimeException unused2) {
            throw new m.d(2012);
        }
    }

    @TargetApi(22)
    private static void c(DatagramSocket datagramSocket, Network network) {
        try {
            network.bindSocket(datagramSocket);
        } catch (Error e) {
            e.printStackTrace();
            throw new m.d(2017);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new m.d(2009);
        }
    }

    static int a(Network network) {
        try {
            Field declaredField = network.getClass().getDeclaredField("netId");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                Object obj = declaredField.get(network);
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
            }
        } catch (Exception unused) {
        }
        throw new m.d(2010);
    }

    static void a(DatagramSocket datagramSocket, int i, int i2) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("android.net.NetworkUtils");
            if (cls != null && (declaredMethod = cls.getDeclaredMethod("bindSocketToNetwork", Integer.TYPE, Integer.TYPE)) != null) {
                datagramSocket.getReuseAddress();
                Integer num = (Integer) declaredMethod.invoke(null, Integer.valueOf(i), Integer.valueOf(i2));
                if (num != null) {
                    if (num.intValue() == 0) {
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
        throw new m.d(2013);
    }
}
