package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class zzcza implements zzdti<ScheduledExecutorService> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<ThreadFactory> f3513a;

    public zzcza(zzdtu<ThreadFactory> zzdtuVar) {
        this.f3513a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) zzdto.zza(new ScheduledThreadPoolExecutor(1, this.f3513a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
