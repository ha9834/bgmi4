package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbju implements zzdti<zzblp> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjn f2891a;
    private final zzdtu<zzbjm> b;

    public zzbju(zzbjn zzbjnVar, zzdtu<zzbjm> zzdtuVar) {
        this.f2891a = zzbjnVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzblp) zzdto.zza(this.b.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
