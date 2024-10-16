package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzczh {

    /* renamed from: a, reason: collision with root package name */
    private final E f3517a;
    private final List<zzbbh<?>> b;
    private final /* synthetic */ zzczf c;

    private zzczh(zzczf zzczfVar, E e, List<zzbbh<?>> list) {
        this.c = zzczfVar;
        this.f3517a = e;
        this.b = list;
    }

    public final <O> zzczl<O> zzc(Callable<O> callable) {
        zzbbl zzbblVar;
        zzbbc zzf = zzbar.zzf(this.b);
        zzbbh zza = zzf.zza(aan.f1762a, zzbbm.zzeaf);
        zzczf zzczfVar = this.c;
        E e = this.f3517a;
        List<zzbbh<?>> list = this.b;
        zzbblVar = zzczfVar.b;
        return new zzczl<>(zzczfVar, e, zza, list, zzf.zza(callable, zzbblVar));
    }
}
