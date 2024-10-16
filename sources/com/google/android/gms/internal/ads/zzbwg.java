package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbwg implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbvz f3080a;
    private final zzdtu<zzbxa> b;

    private zzbwg(zzbvz zzbvzVar, zzdtu<zzbxa> zzdtuVar) {
        this.f3080a = zzbvzVar;
        this.b = zzdtuVar;
    }

    public static zzbwg zzb(zzbvz zzbvzVar, zzdtu<zzbxa> zzdtuVar) {
        return new zzbwg(zzbvzVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
