package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbnu implements zzdti<zzbuz<zzbrw>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2959a;
    private final zzdtu<zzbot> b;

    public zzbnu(zzbnk zzbnkVar, zzdtu<zzbot> zzdtuVar) {
        this.f2959a = zzbnkVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
