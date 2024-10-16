package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzctn implements zzdti<zzctl> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3431a;
    private final zzdtu<zzcxk> b;

    private zzctn(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcxk> zzdtuVar2) {
        this.f3431a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzctn zzao(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcxk> zzdtuVar2) {
        return new zzctn(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzctl(this.f3431a.get(), this.b.get());
    }
}
