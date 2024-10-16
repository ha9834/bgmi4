package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzeu extends zzfk {
    private static volatile Long d;
    private static final Object e = new Object();

    public zzeu(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2) {
        super(zzdyVar, str, str2, c0092zza, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.zzav(d.longValue());
        }
    }
}
