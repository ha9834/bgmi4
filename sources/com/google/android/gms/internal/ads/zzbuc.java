package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbuc implements zzdti<Set<zzbuz<zzxr>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3051a;

    private zzbuc(zzbtv zzbtvVar) {
        this.f3051a = zzbtvVar;
    }

    public static zzbuc zzj(zzbtv zzbtvVar) {
        return new zzbuc(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.f3051a.zzagr(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
