package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcjb implements zzdti<zzcja> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3278a;

    private zzcjb(zzdtu<Context> zzdtuVar) {
        this.f3278a = zzdtuVar;
    }

    public static zzcjb zzaf(zzdtu<Context> zzdtuVar) {
        return new zzcjb(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcja(this.f3278a.get());
    }
}
