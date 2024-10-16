package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbtx implements zzdti<zzbrm> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3046a;
    private final zzdtu<Set<zzbuz<zzbro>>> b;

    private zzbtx(zzbtv zzbtvVar, zzdtu<Set<zzbuz<zzbro>>> zzdtuVar) {
        this.f3046a = zzbtvVar;
        this.b = zzdtuVar;
    }

    public static zzbtx zza(zzbtv zzbtvVar, zzdtu<Set<zzbuz<zzbro>>> zzdtuVar) {
        return new zzbtx(zzbtvVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbrm) zzdto.zza(this.f3046a.zzc(this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
