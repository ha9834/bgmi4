package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcty implements zzdti<zzctw> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3436a;
    private final zzdtu<Context> b;
    private final zzdtu<Set<String>> c;

    private zzcty(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<Set<String>> zzdtuVar3) {
        this.f3436a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzcty zzn(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<Set<String>> zzdtuVar3) {
        return new zzcty(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzctw(this.f3436a.get(), this.b.get(), this.c.get());
    }
}
