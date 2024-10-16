package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqy;

/* loaded from: classes2.dex */
public final class zzcmt implements zzdti<zzcms> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbjm> f3328a;
    private final zzdtu<zzbqy.zza> b;
    private final zzdtu<zzbtv> c;

    public zzcmt(zzdtu<zzbjm> zzdtuVar, zzdtu<zzbqy.zza> zzdtuVar2, zzdtu<zzbtv> zzdtuVar3) {
        this.f3328a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcms(this.f3328a.get(), this.b.get(), this.c.get());
    }
}
