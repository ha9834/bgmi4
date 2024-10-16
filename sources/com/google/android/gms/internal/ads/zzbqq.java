package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzbqq {
    public static <T> zzbbh<T> zza(zzczt zzcztVar, zzbbh<zzcxu> zzbbhVar, zzblq zzblqVar, zzcmx<T> zzcmxVar) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvm)).booleanValue()) {
            return zzcztVar.zza((zzczt) zzczs.RENDERER, (zzbbh) zzbbhVar).zza(zzblqVar).zza(zzcmxVar).zzane();
        }
        return zzcztVar.zza((zzczt) zzczs.RENDERER, (zzbbh) zzbbhVar).zza(zzblqVar).zza(zzcmxVar).zza(((Integer) zzyt.zzpe().zzd(zzacu.zzcvn)).intValue(), TimeUnit.SECONDS).zzane();
    }
}
