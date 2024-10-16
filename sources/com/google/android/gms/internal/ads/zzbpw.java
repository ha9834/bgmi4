package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbpw implements zzdti<zzbpv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbse> f2999a;

    private zzbpw(zzdtu<zzbse> zzdtuVar) {
        this.f2999a = zzdtuVar;
    }

    public static zzbpw zzk(zzdtu<zzbse> zzdtuVar) {
        return new zzbpw(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbpv(this.f2999a.get());
    }
}
