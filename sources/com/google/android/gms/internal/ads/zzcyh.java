package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcyh implements zzdti<zzbuz<zzbro>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcyg f3498a;
    private final zzdtu<zzcyi> b;

    private zzcyh(zzcyg zzcygVar, zzdtu<zzcyi> zzdtuVar) {
        this.f3498a = zzcygVar;
        this.b = zzdtuVar;
    }

    public static zzcyh zza(zzcyg zzcygVar, zzdtu<zzcyi> zzdtuVar) {
        return new zzcyh(zzcygVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
