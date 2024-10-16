package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzcjw<DelegateT, AdapterT> implements zzcjv<AdapterT> {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private final zzcjv<DelegateT> f3290a;
    private final zzbam<DelegateT, AdapterT> b;

    public zzcjw(zzcjv<DelegateT> zzcjvVar, zzbam<DelegateT, AdapterT> zzbamVar) {
        this.f3290a = zzcjvVar;
        this.b = zzbamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return this.f3290a.zza(zzcxuVar, zzcxmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<AdapterT> zzb(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return zzbar.zza(this.f3290a.zzb(zzcxuVar, zzcxmVar), this.b, zzaxg.zzdvp);
    }
}
