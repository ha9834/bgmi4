package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbyg implements zzdti<zzbzb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbyc f3120a;
    private final zzdtu<zzbxx> b;

    public zzbyg(zzbyc zzbycVar, zzdtu<zzbxx> zzdtuVar) {
        this.f3120a = zzbycVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbzb) zzdto.zza(this.b.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
