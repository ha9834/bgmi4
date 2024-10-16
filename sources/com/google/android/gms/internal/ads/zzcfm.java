package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcfm implements zzdti<zzcfk> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcfi> f3232a;
    private final zzdtu<Set<sr>> b;
    private final zzdtu<Clock> c;

    private zzcfm(zzdtu<zzcfi> zzdtuVar, zzdtu<Set<sr>> zzdtuVar2, zzdtu<Clock> zzdtuVar3) {
        this.f3232a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzcfm zzl(zzdtu<zzcfi> zzdtuVar, zzdtu<Set<sr>> zzdtuVar2, zzdtu<Clock> zzdtuVar3) {
        return new zzcfm(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcfk(this.f3232a.get(), this.b.get(), this.c.get());
    }
}
