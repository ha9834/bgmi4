package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzblg implements zzdti<zzbah> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<String> f2907a;

    private zzblg(zzdtu<String> zzdtuVar) {
        this.f2907a = zzdtuVar;
    }

    public static zzblg zza(zzdtu<String> zzdtuVar) {
        return new zzblg(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbah) zzdto.zza(new zzbah(this.f2907a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
