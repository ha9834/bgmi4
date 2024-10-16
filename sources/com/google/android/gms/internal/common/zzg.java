package com.google.android.gms.internal.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

/* loaded from: classes2.dex */
public final class zzg {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f3868a = !zzam();

    public static boolean zzam() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @TargetApi(24)
    public static Context getDeviceProtectedStorageContext(Context context) {
        return context.isDeviceProtectedStorage() ? context : context.createDeviceProtectedStorageContext();
    }
}
