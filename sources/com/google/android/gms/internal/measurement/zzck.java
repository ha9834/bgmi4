package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;

/* loaded from: classes2.dex */
public final class zzck {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzcw<Boolean> f4544a = zzcw.zzrp();
    private static final Object b = new Object();

    private static boolean a(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean zza(Context context, Uri uri) {
        boolean z;
        String authority = uri.getAuthority();
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (f4544a.isPresent()) {
            return f4544a.get().booleanValue();
        }
        synchronized (b) {
            if (f4544a.isPresent()) {
                return f4544a.get().booleanValue();
            }
            boolean z2 = false;
            if ("com.google.android.gms".equals(context.getPackageName())) {
                z = true;
            } else {
                ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
                z = resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName);
            }
            if (z && a(context)) {
                z2 = true;
            }
            f4544a = zzcw.zzf(Boolean.valueOf(z2));
            return f4544a.get().booleanValue();
        }
    }
}
