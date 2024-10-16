package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* loaded from: classes.dex */
public class InstantApps {

    /* renamed from: a, reason: collision with root package name */
    private static Context f1516a;
    private static Boolean b;

    @KeepForSdk
    public static synchronized boolean isInstantApp(Context context) {
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (f1516a != null && b != null && f1516a == applicationContext) {
                return b.booleanValue();
            }
            b = null;
            if (PlatformVersion.isAtLeastO()) {
                b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    b = true;
                } catch (ClassNotFoundException unused) {
                    b = false;
                }
            }
            f1516a = applicationContext;
            return b.booleanValue();
        }
    }
}
