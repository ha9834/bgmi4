package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzem extends zzfk {
    private static zzfl<String> d = new zzfl<>();
    private final Context e;

    public zzem(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2, Context context) {
        super(zzdyVar, str, str2, c0092zza, i, 29);
        this.e = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.zzaa("E");
        AtomicReference<String> zzar = d.zzar(this.e.getPackageName());
        if (zzar.get() == null) {
            synchronized (zzar) {
                if (zzar.get() == null) {
                    zzar.set((String) this.c.invoke(null, this.e));
                }
            }
        }
        String str = zzar.get();
        synchronized (this.b) {
            this.b.zzaa(zzcg.zza(str.getBytes(), true));
        }
    }
}
