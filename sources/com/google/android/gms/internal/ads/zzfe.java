package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzfe extends zzfk {
    private final zzeh d;
    private long e;

    public zzfe(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2, zzeh zzehVar) {
        super(zzdyVar, str, str2, c0092zza, i, 53);
        this.d = zzehVar;
        if (zzehVar != null) {
            this.e = zzehVar.zzcv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.d != null) {
            this.b.zzbl(((Long) this.c.invoke(null, Long.valueOf(this.e))).longValue());
        }
    }
}
