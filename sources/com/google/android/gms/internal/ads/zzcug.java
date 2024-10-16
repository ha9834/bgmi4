package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcug implements zzdti<zzcue> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3442a;
    private final zzdtu<Bundle> b;

    private zzcug(zzdtu<zzbbl> zzdtuVar, zzdtu<Bundle> zzdtuVar2) {
        this.f3442a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcug zzaq(zzdtu<zzbbl> zzdtuVar, zzdtu<Bundle> zzdtuVar2) {
        return new zzcug(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcue(this.f3442a.get(), this.b.get());
    }
}
