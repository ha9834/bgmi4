package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzfd extends zzfk {
    public zzfd(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2) {
        super(zzdyVar, str, str2, c0092zza, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.b) {
            zzdx zzdxVar = new zzdx((String) this.c.invoke(null, new Object[0]));
            this.b.zzbj(zzdxVar.zzxd.longValue());
            this.b.zzbk(zzdxVar.zzxe.longValue());
        }
    }
}
