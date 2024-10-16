package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzp {

    /* renamed from: a, reason: collision with root package name */
    private static Object f1479a = new Object();

    @GuardedBy("sLock")
    private static boolean b;
    private static String c;
    private static int d;

    public static String zzc(Context context) {
        a(context);
        return c;
    }

    public static int zzd(Context context) {
        a(context);
        return d;
    }

    private static void a(Context context) {
        Bundle bundle;
        synchronized (f1479a) {
            if (b) {
                return;
            }
            b = true;
            try {
                bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            c = bundle.getString("com.google.app.id");
            d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
