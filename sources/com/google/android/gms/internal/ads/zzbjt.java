package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbjt implements zzdti<zzcjz<zzams, zzclb>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjn f2890a;
    private final zzdtu<zzclc> b;

    public zzbjt(zzbjn zzbjnVar, zzdtu<zzclc> zzdtuVar) {
        this.f2890a = zzbjnVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcjz) zzdto.zza(new zzcnk(this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
