package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcyp implements zzdti<zzaxb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcyo f3503a;
    private final zzdtu<zzcym> b;

    private zzcyp(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        this.f3503a = zzcyoVar;
        this.b = zzdtuVar;
    }

    public static zzcyp zza(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        return new zzcyp(zzcyoVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzaxb) zzdto.zza(this.b.get().zzduk, "Cannot return null from a non-@Nullable @Provides method");
    }
}
