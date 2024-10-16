package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbof implements zzdti<zzcjv<zzbnf>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Boolean> f2968a;
    private final zzdtu<zzcmo> b;
    private final zzdtu<zzcoe<zzbnf, zzams, zzcla>> c;

    public zzbof(zzdtu<Boolean> zzdtuVar, zzdtu<zzcmo> zzdtuVar2, zzdtu<zzcoe<zzbnf, zzams, zzcla>> zzdtuVar3) {
        this.f2968a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        boolean booleanValue = this.f2968a.get().booleanValue();
        zzcjv zzcjvVar = (zzcmo) this.b.get();
        zzcjv zzcjvVar2 = (zzcoe) this.c.get();
        if (!booleanValue) {
            zzcjvVar = zzcjvVar2;
        }
        return (zzcjv) zzdto.zza(zzcjvVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
