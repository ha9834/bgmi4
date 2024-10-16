package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

/* loaded from: classes.dex */
public final class zzbph {
    public final List<? extends zzbbh<? extends zzbpc>> zzfiv;

    public zzbph(List<? extends zzbbh<? extends zzbpc>> list) {
        this.zzfiv = list;
    }

    public zzbph(zzbpc zzbpcVar) {
        this.zzfiv = Collections.singletonList(zzbar.zzm(zzbpcVar));
    }

    public static zzcjv<zzbph> zza(@Nonnull zzclw<? extends zzbpc> zzclwVar) {
        return new zzcjw(zzclwVar, no.f2374a);
    }

    public static zzcjv<zzbph> zza(@Nonnull zzcjv<? extends zzbpc> zzcjvVar) {
        return new zzcjw(zzcjvVar, np.f2375a);
    }
}
