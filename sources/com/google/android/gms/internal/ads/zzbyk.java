package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbyk implements zzdti<zzbuz<zzbrw>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbyc f3124a;
    private final zzdtu<zzcac> b;

    public zzbyk(zzbyc zzbycVar, zzdtu<zzcac> zzdtuVar) {
        this.f3124a = zzbycVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
