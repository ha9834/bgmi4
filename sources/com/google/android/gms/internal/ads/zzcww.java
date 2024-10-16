package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzcww implements zzdti<zzcwu> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzaqm> f3483a;
    private final zzdtu<ScheduledExecutorService> b;
    private final zzdtu<Context> c;

    public zzcww(zzdtu<zzaqm> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        this.f3483a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcwu(this.f3483a.get(), this.b.get(), this.c.get());
    }
}
