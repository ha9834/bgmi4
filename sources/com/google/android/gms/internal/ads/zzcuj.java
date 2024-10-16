package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcuj implements zzdti<zzcuh> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3444a;
    private final zzdtu<String> b;

    private zzcuj(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2) {
        this.f3444a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcuj zzar(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2) {
        return new zzcuj(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcuh(this.f3444a.get(), this.b.get());
    }
}
