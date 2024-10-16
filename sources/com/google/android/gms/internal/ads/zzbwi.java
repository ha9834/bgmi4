package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbwi implements zzdti<zzbuz<zzahy>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbvz f3082a;
    private final zzdtu<zzccz> b;

    public zzbwi(zzbvz zzbvzVar, zzdtu<zzccz> zzdtuVar) {
        this.f3082a = zzbvzVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
