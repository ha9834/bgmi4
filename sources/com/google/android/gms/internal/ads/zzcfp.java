package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcfp {
    public static Set<zzbuz<zzbrx>> zza(zzcfz zzcfzVar, Executor executor) {
        return a(zzcfzVar, executor);
    }

    public static Set<zzbuz<AppEventListener>> zzb(zzcfz zzcfzVar, Executor executor) {
        return a(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzbsr>> zzc(zzcfz zzcfzVar, Executor executor) {
        return a(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzbro>> zzd(zzcfz zzcfzVar, Executor executor) {
        return a(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzbrl>> zze(zzcfz zzcfzVar, Executor executor) {
        return a(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzbrw>> zzf(zzcfz zzcfzVar, Executor executor) {
        return a(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzxr>> zzg(zzcfz zzcfzVar, Executor executor) {
        return a(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzczz>> zzh(zzcfz zzcfzVar, Executor executor) {
        return a(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzbtk>> zzi(zzcfz zzcfzVar, Executor executor) {
        return a(zzcfzVar, executor);
    }

    private static <T> Set<zzbuz<T>> a(T t, Executor executor) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqg)).booleanValue()) {
            return Collections.singleton(new zzbuz(t, executor));
        }
        return Collections.emptySet();
    }
}
