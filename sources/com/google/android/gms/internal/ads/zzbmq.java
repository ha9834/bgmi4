package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbmq implements zzdti<zzbmn> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzaly> f2937a;
    private final zzdtu<zzbml> b;
    private final zzdtu<Executor> c;
    private final zzdtu<zzbmg> d;
    private final zzdtu<Clock> e;

    private zzbmq(zzdtu<zzaly> zzdtuVar, zzdtu<zzbml> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzbmg> zzdtuVar4, zzdtu<Clock> zzdtuVar5) {
        this.f2937a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    public static zzbmq zza(zzdtu<zzaly> zzdtuVar, zzdtu<zzbml> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzbmg> zzdtuVar4, zzdtu<Clock> zzdtuVar5) {
        return new zzbmq(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbmn(this.f2937a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
