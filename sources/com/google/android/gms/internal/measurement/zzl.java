package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzl extends zzo {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<Bundle> f4616a = new AtomicReference<>();
    private boolean b;

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void zzb(Bundle bundle) {
        synchronized (this.f4616a) {
            try {
                this.f4616a.set(bundle);
                this.b = true;
            } finally {
                this.f4616a.notify();
            }
        }
    }

    public final String zza(long j) {
        return (String) zza(zzb(j), String.class);
    }

    public final Bundle zzb(long j) {
        Bundle bundle;
        synchronized (this.f4616a) {
            if (!this.b) {
                try {
                    this.f4616a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f4616a.get();
        }
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r4 = r4.get(com.helpshift.analytics.AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> T zza(android.os.Bundle r4, java.lang.Class<T> r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L3d
            java.lang.String r1 = "r"
            java.lang.Object r4 = r4.get(r1)
            if (r4 == 0) goto L3c
            java.lang.Object r4 = r5.cast(r4)     // Catch: java.lang.ClassCastException -> L10
            return r4
        L10:
            r0 = move-exception
            java.lang.String r5 = r5.getCanonicalName()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.String r1 = "Unexpected object type. Expected, Received"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = ": %s, %s"
            java.lang.String r1 = r1.concat(r2)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            r2[r5] = r4
            java.lang.String r4 = java.lang.String.format(r1, r2)
            java.lang.String r5 = "AM"
            android.util.Log.w(r5, r4, r0)
            throw r0
        L3c:
            return r0
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzl.zza(android.os.Bundle, java.lang.Class):java.lang.Object");
    }
}
