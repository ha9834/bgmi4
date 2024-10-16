package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbwh implements zzdti<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbvz f3081a;
    private final zzdtu<zzbxa> b;

    private zzbwh(zzbvz zzbvzVar, zzdtu<zzbxa> zzdtuVar) {
        this.f3081a = zzbvzVar;
        this.b = zzdtuVar;
    }

    public static zzbwh zzc(zzbvz zzbvzVar, zzdtu<zzbxa> zzdtuVar) {
        return new zzbwh(zzbvzVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
