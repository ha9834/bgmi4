package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public abstract class zzczf<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzbbh<?> f3516a = zzbar.zzm(null);
    private final zzbbl b;
    private final ScheduledExecutorService c;
    private final zzczr<E> d;

    public zzczf(zzbbl zzbblVar, ScheduledExecutorService scheduledExecutorService, zzczr<E> zzczrVar) {
        this.b = zzbblVar;
        this.c = scheduledExecutorService;
        this.d = zzczrVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String a(E e);

    public final zzczj zzv(E e) {
        return new zzczj(this, e);
    }

    public final <I> zzczl<I> zza(E e, zzbbh<I> zzbbhVar) {
        return new zzczl<>(this, e, zzbbhVar, Collections.singletonList(zzbbhVar), zzbbhVar);
    }

    public final zzczh zza(E e, zzbbh<?>... zzbbhVarArr) {
        return new zzczh(this, e, Arrays.asList(zzbbhVarArr));
    }
}
