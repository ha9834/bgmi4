package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzfc extends zzfk {
    private final StackTraceElement[] d;

    public zzfc(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzdyVar, str, str2, c0092zza, i, 45);
        this.d = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        zzbz zzbzVar;
        if (this.d != null) {
            zzdw zzdwVar = new zzdw((String) this.c.invoke(null, this.d));
            synchronized (this.b) {
                this.b.zzbi(zzdwVar.zzxa.longValue());
                if (zzdwVar.zzxb.booleanValue()) {
                    zzbp.zza.C0092zza c0092zza = this.b;
                    if (zzdwVar.zzxc.booleanValue()) {
                        zzbzVar = zzbz.ENUM_FALSE;
                    } else {
                        zzbzVar = zzbz.ENUM_TRUE;
                    }
                    c0092zza.zzg(zzbzVar);
                } else {
                    this.b.zzg(zzbz.ENUM_FAILURE);
                }
            }
        }
    }
}
