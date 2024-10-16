package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbre implements zzdti<zzcxv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqy f3026a;

    private zzbre(zzbqy zzbqyVar) {
        this.f3026a = zzbqyVar;
    }

    public static zzbre zzh(zzbqy zzbqyVar) {
        return new zzbre(zzbqyVar);
    }

    public static zzcxv zzi(zzbqy zzbqyVar) {
        return (zzcxv) zzdto.zza(zzbqyVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzi(this.f3026a);
    }
}
