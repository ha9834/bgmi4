package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzer extends zzfk {
    private long d;

    public zzer(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, long j, int i, int i2) {
        super(zzdyVar, str, str2, c0092zza, i, 25);
        this.d = j;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.c.invoke(null, new Object[0])).longValue();
        synchronized (this.b) {
            this.b.zzbr(longValue);
            if (this.d != 0) {
                this.b.zzat(longValue - this.d);
                this.b.zzaw(this.d);
            }
        }
    }
}
