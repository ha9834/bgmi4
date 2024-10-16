package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzfg extends zzfk {
    public zzfg(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2) {
        super(zzdyVar, str, str2, c0092zza, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.zze(zzbz.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.c.invoke(null, this.f3634a.getContext())).booleanValue();
        synchronized (this.b) {
            if (booleanValue) {
                this.b.zze(zzbz.ENUM_TRUE);
            } else {
                this.b.zze(zzbz.ENUM_FALSE);
            }
        }
    }
}
