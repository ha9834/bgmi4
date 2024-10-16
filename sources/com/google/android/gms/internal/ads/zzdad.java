package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzdad implements zzdti<zzalr> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdac f3525a;
    private final zzdtu<Context> b;
    private final zzdtu<zzbai> c;

    public zzdad(zzdac zzdacVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2) {
        this.f3525a = zzdacVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzalr) zzdto.zza(new zzalk().zzb(this.b.get(), this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
