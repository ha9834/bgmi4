package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcfj implements zzdti<zzcfi> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3230a;
    private final zzdtu<String> b;

    private zzcfj(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2) {
        this.f3230a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcfj zzx(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2) {
        return new zzcfj(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcfi(this.f3230a.get(), this.b.get());
    }
}
