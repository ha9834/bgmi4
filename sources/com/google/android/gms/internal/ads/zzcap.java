package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcap implements zzdti<zzcan> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzayu> f3158a;
    private final zzdtu<Clock> b;
    private final zzdtu<Executor> c;

    public zzcap(zzdtu<zzayu> zzdtuVar, zzdtu<Clock> zzdtuVar2, zzdtu<Executor> zzdtuVar3) {
        this.f3158a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcan(this.f3158a.get(), this.b.get(), this.c.get());
    }
}
