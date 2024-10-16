package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcys implements zzdti<zzdh> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcyo f3506a;
    private final zzdtu<zzcym> b;

    private zzcys(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        this.f3506a = zzcyoVar;
        this.b = zzdtuVar;
    }

    public static zzcys zzc(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        return new zzcys(zzcyoVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzdh) zzdto.zza(this.b.get().zzglt, "Cannot return null from a non-@Nullable @Provides method");
    }
}
