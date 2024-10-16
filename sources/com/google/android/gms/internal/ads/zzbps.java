package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbps implements zzdti<zzcxm> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbpr f2995a;

    private zzbps(zzbpr zzbprVar) {
        this.f2995a = zzbprVar;
    }

    public static zzbps zza(zzbpr zzbprVar) {
        return new zzbps(zzbprVar);
    }

    public static zzcxm zzb(zzbpr zzbprVar) {
        return (zzcxm) zzdto.zza(zzbprVar.zzagb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzb(this.f2995a);
    }
}
