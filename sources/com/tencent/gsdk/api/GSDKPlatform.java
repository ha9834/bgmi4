package com.tencent.gsdk.api;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class GSDKPlatform {
    private static c info = null;
    public static String mRoomIp = null;
    public static String mTag = "-1";
    public static String mZoneId;

    public static void GSDKSetControlAddressUrl(String str) {
        GSDKSystem.getInstance().a(str);
    }

    public static void GSDKInit(Context context, String str, boolean z, int i) {
        GSDKSystem.getInstance().a(context, str, z, i);
    }

    public static void GSDKInitWithBeacon(Context context, String str, boolean z, int i) {
        GSDKSystem.getInstance().a(context, str);
        GSDKSystem.getInstance().a(context, str, z, i);
    }

    public static void GSDKSetUserName(int i, String str) {
        GSDKSystem.getInstance().a(i, str);
    }

    public static void GSDKStart(String str, String str2, String str3) {
        mZoneId = str;
        mTag = str2;
        mRoomIp = str3;
        GSDKSystem.getInstance().b(str);
    }

    public static void GSDKEnd() {
        GSDKSystem.getInstance().a(info);
    }

    public static void GSDKSaveFps(float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str) {
        info = new c(f, i, i2, i3, i4, i5, i6, i7, i8, i9, str);
    }

    public static void GSDKSaveGpuInfo(String str) {
        GSDKSystem.getInstance().c(str);
    }

    public static void GSDKSetEvent(int i, boolean z, String str, boolean z2, boolean z3) {
        GSDKSystem.getInstance().a(i, z, str, z2, z3);
    }

    public static void GSDKSetPayEvent(int i, int i2, boolean z, String str) {
        GSDKSystem.getInstance().a(i, i2, z, str);
    }

    public static void GSDKTimeOutDetect() {
        GSDKSystem.getInstance().c();
    }

    public static String getCpuList() {
        String str = "";
        List<Long> list = GSDKSystem.f;
        if (list == null) {
            return "";
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            str = str + String.valueOf(it.next().longValue()) + ",";
        }
        return str;
    }

    public static String getMemList() {
        String str = "";
        List<Long> list = GSDKSystem.d;
        if (list == null) {
            return "";
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            str = str + String.valueOf(it.next().longValue()) + ",";
        }
        return str;
    }

    public static String getUdpList() {
        String str = "";
        List<Long> list = GSDKSystem.c;
        if (list == null) {
            return "";
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            str = str + String.valueOf(it.next().longValue()) + ",";
        }
        return str;
    }

    public static String getSignalList() {
        String str = "";
        List<Long> list = GSDKSystem.m;
        if (list == null) {
            return "";
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            str = str + String.valueOf(it.next().longValue()) + ",";
        }
        return str;
    }

    public static int getBatteryLevel(Context context) {
        return a.a();
    }

    public static void GSDKReportEvent(String str, Map<String, String> map) {
        com.tencent.gsdk.utils.a.c.a(str, map);
    }
}
