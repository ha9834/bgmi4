package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcoy implements zzdti<zzcow> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcow f3355a;

    private zzcoy(zzcow zzcowVar) {
        this.f3355a = zzcowVar;
    }

    public static zzcoy zzd(zzcow zzcowVar) {
        return new zzcoy(zzcowVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzcow zzcowVar = this.f3355a;
        if (zzcowVar == null) {
            throw null;
        }
        return (zzcow) zzdto.zza(zzcowVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
