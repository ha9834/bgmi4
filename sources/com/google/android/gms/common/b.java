package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzm f1409a;
    private static final Object b = new Object();
    private static Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                c = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(String str, d dVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return b(str, dVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static j b(final String str, final d dVar, final boolean z, boolean z2) {
        try {
            if (f1409a == null) {
                Preconditions.checkNotNull(c);
                synchronized (b) {
                    if (f1409a == null) {
                        f1409a = zzn.zzc(DynamiteModule.load(c, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            Preconditions.checkNotNull(c);
            try {
                if (f1409a.zza(new zzk(str, dVar, z, z2), ObjectWrapper.wrap(c.getPackageManager()))) {
                    return j.a();
                }
                return j.a((Callable<String>) new Callable(z, str, dVar) { // from class: com.google.android.gms.common.c

                    /* renamed from: a, reason: collision with root package name */
                    private final boolean f1410a;
                    private final String b;
                    private final d c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f1410a = z;
                        this.b = str;
                        this.c = dVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        String a2;
                        a2 = j.a(this.b, this.c, this.f1410a, !r3 && b.b(r4, r5, true, false).f1481a);
                        return a2;
                    }
                });
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return j.a("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String valueOf = String.valueOf(e2.getMessage());
            return j.a(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e2);
        }
    }
}
