package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzfh extends zzfk {
    private final View d;

    public zzfh(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2, View view) {
        super(zzdyVar, str, str2, c0092zza, i, 57);
        this.d = view;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.d != null) {
            Boolean bool = (Boolean) zzyt.zzpe().zzd(zzacu.zzcrr);
            zzeg zzegVar = new zzeg((String) this.c.invoke(null, this.d, this.f3634a.getContext().getResources().getDisplayMetrics(), bool));
            zzbp.zza.zzf.C0094zza zzat = zzbp.zza.zzf.zzat();
            zzat.zzdc(zzegVar.zzyn.longValue()).zzdd(zzegVar.zzyo.longValue()).zzde(zzegVar.zzyp.longValue());
            if (bool.booleanValue()) {
                zzat.zzdf(zzegVar.zzyq.longValue());
            }
            this.b.zzb((zzbp.zza.zzf) ((zzdob) zzat.zzaya()));
        }
    }
}
