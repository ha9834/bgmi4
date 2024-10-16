package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcyn implements zzdti<zzcyk> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3502a;
    private final zzdtu<zzbai> b;
    private final zzdtu<zzawm> c;

    public zzcyn(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzawm> zzdtuVar3) {
        this.f3502a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcyk(this.f3502a.get(), this.b.get(), this.c.get());
    }
}
