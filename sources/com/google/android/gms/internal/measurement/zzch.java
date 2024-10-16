package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* loaded from: classes2.dex */
public final /* synthetic */ class zzch {
    public static <V> V zza(zzcg<V> zzcgVar) {
        try {
            return zzcgVar.zzrj();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzcgVar.zzrj();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }
}
