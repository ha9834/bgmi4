package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbjs implements zzdti<zzcjz<zzams, zzcla>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjn f2889a;
    private final zzdtu<zzclc> b;

    public zzbjs(zzbjn zzbjnVar, zzdtu<zzclc> zzdtuVar) {
        this.f2889a = zzbjnVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcjz) zzdto.zza(new zzclv(this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
