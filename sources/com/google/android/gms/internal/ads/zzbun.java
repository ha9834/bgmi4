package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class zzbun implements zzdti<zzcmu> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3062a;
    private final zzdtu<Clock> b;

    private zzbun(zzbtv zzbtvVar, zzdtu<Clock> zzdtuVar) {
        this.f3062a = zzbtvVar;
        this.b = zzdtuVar;
    }

    public static zzbun zzb(zzbtv zzbtvVar, zzdtu<Clock> zzdtuVar) {
        return new zzbun(zzbtvVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcmu) zzdto.zza(this.f3062a.zza(this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
