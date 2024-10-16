package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbmu implements zzdti<zzaly> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzalr> f2941a;

    private zzbmu(zzdtu<zzalr> zzdtuVar) {
        this.f2941a = zzdtuVar;
    }

    public static zzbmu zzh(zzdtu<zzalr> zzdtuVar) {
        return new zzbmu(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzaly) zzdto.zza(this.f2941a.get().zzsc(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
