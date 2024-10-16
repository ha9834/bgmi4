package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcuz;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzcsk<S extends zzcuz> implements zzcva<S> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<yj<S>> f3411a = new AtomicReference<>();
    private final Clock b;
    private final zzcva<S> c;
    private final long d;

    public zzcsk(zzcva<S> zzcvaVar, long j, Clock clock) {
        this.b = clock;
        this.c = zzcvaVar;
        this.d = j;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<S> zzalm() {
        yj<S> yjVar = this.f3411a.get();
        if (yjVar == null || yjVar.a()) {
            yjVar = new yj<>(this.c.zzalm(), this.d, this.b);
            this.f3411a.set(yjVar);
        }
        return yjVar.f2637a;
    }
}
