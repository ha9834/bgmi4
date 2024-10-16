package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzez extends zzfk {
    public zzez(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2) {
        super(zzdyVar, str, str2, c0092zza, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        try {
            this.b.zzh(((Boolean) this.c.invoke(null, this.f3634a.getContext())).booleanValue() ? zzbz.ENUM_TRUE : zzbz.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.b.zzh(zzbz.ENUM_FAILURE);
        }
    }
}
