package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbyf implements zzdti<zzbyx> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbyc f3119a;
    private final zzdtu<zzbyy> b;

    public zzbyf(zzbyc zzbycVar, zzdtu<zzbyy> zzdtuVar) {
        this.f3119a = zzbycVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbyx) zzdto.zza(this.b.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
