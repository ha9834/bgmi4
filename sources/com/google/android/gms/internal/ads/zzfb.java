package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzfb extends zzfk {
    private final boolean d;

    public zzfb(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2) {
        super(zzdyVar, str, str2, c0092zza, i, 61);
        this.d = zzdyVar.zzco();
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.c.invoke(null, this.f3634a.getContext(), Boolean.valueOf(this.d))).longValue();
        synchronized (this.b) {
            this.b.zzbo(longValue);
        }
    }
}
