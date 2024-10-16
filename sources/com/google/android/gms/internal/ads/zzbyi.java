package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class zzbyi implements zzdti<zzbva> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3122a;
    private final zzdtu<zzcxm> b;

    public zzbyi(zzdtu<Context> zzdtuVar, zzdtu<zzcxm> zzdtuVar2) {
        this.f3122a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbva) zzdto.zza(new zzbva(this.f3122a.get(), new HashSet(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
