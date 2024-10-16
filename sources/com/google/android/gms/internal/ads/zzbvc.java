package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbvc implements zzdti<zzbva> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3068a;
    private final zzdtu<Set<zzbuz<zzue>>> b;
    private final zzdtu<zzcxm> c;

    private zzbvc(zzdtu<Context> zzdtuVar, zzdtu<Set<zzbuz<zzue>>> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3) {
        this.f3068a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzbvc zzh(zzdtu<Context> zzdtuVar, zzdtu<Set<zzbuz<zzue>>> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3) {
        return new zzbvc(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbva(this.f3068a.get(), this.b.get(), this.c.get());
    }
}
