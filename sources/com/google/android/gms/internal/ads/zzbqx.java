package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbqx implements zzdti<zzbtb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbtb> f3019a;

    private zzbqx(zzdtu<zzbtb> zzdtuVar) {
        this.f3019a = zzdtuVar;
    }

    public static zzbqx zzl(zzdtu<zzbtb> zzdtuVar) {
        return new zzbqx(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbtb) zzdto.zza(this.f3019a.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
