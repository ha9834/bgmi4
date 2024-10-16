package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@zzard
@Deprecated
/* loaded from: classes2.dex */
public class zzbbw<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbr<T> f2853a = new zzbbr<>();
    private final AtomicInteger b = new AtomicInteger(0);

    public zzbbw() {
        zzbar.zza(this.f2853a, new hr(this), zzbbm.zzeaf);
    }

    @Deprecated
    public final void zza(zzbbv<T> zzbbvVar, zzbbt zzbbtVar) {
        zzbar.zza(this.f2853a, new hs(this, zzbbvVar, zzbbtVar), zzbbm.zzeaf);
    }

    @Deprecated
    public final void zzo(T t) {
        this.f2853a.set(t);
    }

    @Deprecated
    public final void reject() {
        this.f2853a.setException(new Exception());
    }

    @Deprecated
    public final int getStatus() {
        return this.b.get();
    }
}
