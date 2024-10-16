package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcvm implements zzdti<zzcvk> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3460a;
    private final zzdtu<Context> b;

    private zzcvm(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        this.f3460a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcvm zzat(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        return new zzcvm(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcvk(this.f3460a.get(), this.b.get());
    }
}
