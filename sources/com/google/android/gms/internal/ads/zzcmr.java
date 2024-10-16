package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqy;

/* loaded from: classes2.dex */
public final class zzcmr implements zzdti<zzcmq> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbjm> f3326a;
    private final zzdtu<zzbqy.zza> b;
    private final zzdtu<zzcow> c;
    private final zzdtu<zzbtv> d;

    public zzcmr(zzdtu<zzbjm> zzdtuVar, zzdtu<zzbqy.zza> zzdtuVar2, zzdtu<zzcow> zzdtuVar3, zzdtu<zzbtv> zzdtuVar4) {
        this.f3326a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcmq(this.f3326a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
