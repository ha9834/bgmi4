package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbud implements zzdti<Set<zzbuz<zzbro>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3052a;

    private zzbud(zzbtv zzbtvVar) {
        this.f3052a = zzbtvVar;
    }

    public static zzbud zzk(zzbtv zzbtvVar) {
        return new zzbud(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.f3052a.zzagn(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
