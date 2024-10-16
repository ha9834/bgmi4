package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* loaded from: classes2.dex */
public final class zzcyf implements zzdti<Clock> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcye f3497a;

    public zzcyf(zzcye zzcyeVar) {
        this.f3497a = zzcyeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Clock) zzdto.zza(DefaultClock.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
