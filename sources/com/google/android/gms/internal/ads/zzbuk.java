package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbuk implements zzdti<zzbtv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3059a;

    private zzbuk(zzbtv zzbtvVar) {
        this.f3059a = zzbtvVar;
    }

    public static zzbuk zzr(zzbtv zzbtvVar) {
        return new zzbuk(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbtv zzbtvVar = this.f3059a;
        if (zzbtvVar == null) {
            throw null;
        }
        return (zzbtv) zzdto.zza(zzbtvVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
