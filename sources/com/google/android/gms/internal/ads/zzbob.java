package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzbob implements zzdti<zzcva<zzcrd>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcre> f2966a;
    private final zzdtu<ScheduledExecutorService> b;

    public zzbob(zzdtu<zzcre> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2) {
        this.f2966a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcva) zzdto.zza(new zzctz(this.f2966a.get(), 0L, this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
