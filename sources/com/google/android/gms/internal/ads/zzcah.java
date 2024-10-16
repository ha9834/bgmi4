package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcah implements zzdti<zzbzb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcag f3151a;
    private final zzdtu<zzcae> b;

    public zzcah(zzcag zzcagVar, zzdtu<zzcae> zzdtuVar) {
        this.f3151a = zzcagVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbzb) zzdto.zza(this.b.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
