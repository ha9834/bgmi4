package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzcws implements zzdti<zzcwq> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzamg> f3480a;
    private final zzdtu<ScheduledExecutorService> b;
    private final zzdtu<Boolean> c;
    private final zzdtu<ApplicationInfo> d;

    public zzcws(zzdtu<zzamg> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<Boolean> zzdtuVar3, zzdtu<ApplicationInfo> zzdtuVar4) {
        this.f3480a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcwq(this.f3480a.get(), this.b.get(), this.c.get().booleanValue(), this.d.get());
    }
}
