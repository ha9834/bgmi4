package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbwr implements zzdti<zzbwq> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbsv> f3089a;
    private final zzdtu<zzbuv> b;

    private zzbwr(zzdtu<zzbsv> zzdtuVar, zzdtu<zzbuv> zzdtuVar2) {
        this.f3089a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbwr zzi(zzdtu<zzbsv> zzdtuVar, zzdtu<zzbuv> zzdtuVar2) {
        return new zzbwr(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbwq(this.f3089a.get(), this.b.get());
    }
}
