package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public final class zza {
    private static long b;

    /* renamed from: a, reason: collision with root package name */
    private static final IntentFilter f1513a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static float c = Float.NaN;

    @TargetApi(20)
    public static int zzg(Context context) {
        boolean isScreenOn;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f1513a);
        int i = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (PlatformVersion.isAtLeastKitKatWatch()) {
            isScreenOn = powerManager.isInteractive();
        } else {
            isScreenOn = powerManager.isScreenOn();
        }
        return (isScreenOn ? 2 : 0) | i;
    }

    public static synchronized float zzh(Context context) {
        synchronized (zza.class) {
            if (SystemClock.elapsedRealtime() - b < 60000 && !Float.isNaN(c)) {
                return c;
            }
            if (context.getApplicationContext().registerReceiver(null, f1513a) != null) {
                c = r6.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) / r6.getIntExtra("scale", -1);
            }
            b = SystemClock.elapsedRealtime();
            return c;
        }
    }
}
