package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbug implements zzdti<Set<zzbuz<zzbrl>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3055a;

    private zzbug(zzbtv zzbtvVar) {
        this.f3055a = zzbtvVar;
    }

    public static zzbug zzm(zzbtv zzbtvVar) {
        return new zzbug(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.f3055a.zzagl(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
