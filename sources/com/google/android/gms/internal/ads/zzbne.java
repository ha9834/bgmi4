package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzbne implements zzdti<zzbtb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f2949a;
    private final zzdtu<Clock> b;

    public zzbne(zzdtu<ScheduledExecutorService> zzdtuVar, zzdtu<Clock> zzdtuVar2) {
        this.f2949a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbtb zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbtb) zzdto.zza(new zzbtb(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f2949a.get(), this.b.get());
    }
}
