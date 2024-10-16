package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class DeviceProperties {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f1502a;
    private static Boolean b;
    private static Boolean c;
    private static Boolean d;
    private static Boolean e;
    private static Boolean f;
    private static Boolean g;
    private static Boolean h;

    private DeviceProperties() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (com.google.android.gms.common.util.DeviceProperties.b.booleanValue() != false) goto L23;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isTablet(android.content.res.Resources r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.Boolean r1 = com.google.android.gms.common.util.DeviceProperties.f1502a
            if (r1 != 0) goto L45
            android.content.res.Configuration r1 = r4.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 15
            r2 = 3
            r3 = 1
            if (r1 <= r2) goto L16
            r1 = 1
            goto L17
        L16:
            r1 = 0
        L17:
            if (r1 != 0) goto L3e
            java.lang.Boolean r1 = com.google.android.gms.common.util.DeviceProperties.b
            if (r1 != 0) goto L36
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.screenLayout
            r1 = r1 & 15
            if (r1 > r2) goto L2f
            int r4 = r4.smallestScreenWidthDp
            r1 = 600(0x258, float:8.41E-43)
            if (r4 < r1) goto L2f
            r4 = 1
            goto L30
        L2f:
            r4 = 0
        L30:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            com.google.android.gms.common.util.DeviceProperties.b = r4
        L36:
            java.lang.Boolean r4 = com.google.android.gms.common.util.DeviceProperties.b
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L3f
        L3e:
            r0 = 1
        L3f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.f1502a = r4
        L45:
            java.lang.Boolean r4 = com.google.android.gms.common.util.DeviceProperties.f1502a
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isTablet(android.content.res.Resources):boolean");
    }

    @KeepForSdk
    @TargetApi(20)
    public static boolean isWearable(Context context) {
        if (c == null) {
            c = Boolean.valueOf(PlatformVersion.isAtLeastKitKatWatch() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return c.booleanValue();
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean isWearableWithoutPlayStore(Context context) {
        if (!isWearable(context)) {
            return false;
        }
        if (PlatformVersion.isAtLeastN()) {
            return isSidewinder(context) && !PlatformVersion.isAtLeastO();
        }
        return true;
    }

    @KeepForSdk
    @TargetApi(21)
    public static boolean isSidewinder(Context context) {
        if (d == null) {
            d = Boolean.valueOf(PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return d.booleanValue();
    }

    @KeepForSdk
    public static boolean isLatchsky(Context context) {
        if (e == null) {
            PackageManager packageManager = context.getPackageManager();
            e = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return e.booleanValue();
    }

    public static boolean zzf(Context context) {
        if (f == null) {
            f = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f.booleanValue();
    }

    @KeepForSdk
    public static boolean isAuto(Context context) {
        if (g == null) {
            g = Boolean.valueOf(PlatformVersion.isAtLeastO() && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"));
        }
        return g.booleanValue();
    }

    @KeepForSdk
    public static boolean isTv(Context context) {
        if (h == null) {
            PackageManager packageManager = context.getPackageManager();
            h = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return h.booleanValue();
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        return "user".equals(Build.TYPE);
    }
}
