package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzfa extends zzfk {
    private List<Long> d;

    public zzfa(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2) {
        super(zzdyVar, str, str2, c0092zza, i, 31);
        this.d = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.zzax(-1L);
        this.b.zzay(-1L);
        if (this.d == null) {
            this.d = (List) this.c.invoke(null, this.f3634a.getContext());
        }
        List<Long> list = this.d;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.b) {
            this.b.zzax(this.d.get(0).longValue());
            this.b.zzay(this.d.get(1).longValue());
        }
    }
}
