package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbzh implements zzdti<zzbyt> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbzf f3137a;

    private zzbzh(zzbzf zzbzfVar) {
        this.f3137a = zzbzfVar;
    }

    public static zzbzh zza(zzbzf zzbzfVar) {
        return new zzbzh(zzbzfVar);
    }

    public static zzbyt zzb(zzbzf zzbzfVar) {
        return (zzbyt) zzdto.zza(zzbzfVar.zzaiq(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzb(this.f3137a);
    }
}
