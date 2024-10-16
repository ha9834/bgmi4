package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzep extends zzfk {
    public zzep(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2) {
        super(zzdyVar, str, str2, c0092zza, i, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.zzam(-1L);
        this.b.zzan(-1L);
        int[] iArr = (int[]) this.c.invoke(null, this.f3634a.getContext());
        synchronized (this.b) {
            this.b.zzam(iArr[0]);
            this.b.zzan(iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.b.zzbm(iArr[2]);
            }
        }
    }
}
