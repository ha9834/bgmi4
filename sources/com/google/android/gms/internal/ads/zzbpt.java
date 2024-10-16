package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbpt implements zzdti<String> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbpr f2996a;

    private zzbpt(zzbpr zzbprVar) {
        this.f2996a = zzbprVar;
    }

    public static zzbpt zzc(zzbpr zzbprVar) {
        return new zzbpt(zzbprVar);
    }

    public static String zzd(zzbpr zzbprVar) {
        return (String) zzdto.zza(zzbprVar.zzagc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzd(this.f2996a);
    }
}
