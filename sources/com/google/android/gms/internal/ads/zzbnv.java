package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbnv implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2960a;
    private final zzdtu<zzbot> b;

    public zzbnv(zzbnk zzbnkVar, zzdtu<zzbot> zzdtuVar) {
        this.f2960a = zzbnkVar;
        this.b = zzdtuVar;
    }

    public static zzbuz<zzbsr> zza(zzbnk zzbnkVar, zzbot zzbotVar) {
        return (zzbuz) zzdto.zza(new zzbuz(zzbotVar, zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f2960a, this.b.get());
    }
}
