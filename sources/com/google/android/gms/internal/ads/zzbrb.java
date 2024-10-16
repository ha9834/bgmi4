package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbrb implements zzdti<Context> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqy f3023a;
    private final zzdtu<Context> b;

    private zzbrb(zzbqy zzbqyVar, zzdtu<Context> zzdtuVar) {
        this.f3023a = zzbqyVar;
        this.b = zzdtuVar;
    }

    public static zzbrb zza(zzbqy zzbqyVar, zzdtu<Context> zzdtuVar) {
        return new zzbrb(zzbqyVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Context) zzdto.zza(this.f3023a.a(this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
