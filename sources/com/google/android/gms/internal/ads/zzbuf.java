package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbuf implements zzdti<Set<zzbuz<zzbrw>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3054a;

    private zzbuf(zzbtv zzbtvVar) {
        this.f3054a = zzbtvVar;
    }

    public static zzbuf zzl(zzbtv zzbtvVar) {
        return new zzbuf(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.f3054a.zzags(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
