package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzczj {

    /* renamed from: a, reason: collision with root package name */
    private final E f3518a;
    private final /* synthetic */ zzczf b;

    private zzczj(zzczf zzczfVar, E e) {
        this.b = zzczfVar;
        this.f3518a = e;
    }

    public final <O> zzczl<O> zzb(zzbbh<O> zzbbhVar) {
        zzbbh zzbbhVar2;
        zzczf zzczfVar = this.b;
        E e = this.f3518a;
        zzbbhVar2 = zzczf.f3516a;
        return new zzczl<>(zzczfVar, e, zzbbhVar2, Collections.emptyList(), zzbbhVar);
    }

    public final <O> zzczl<O> zzd(Callable<O> callable) {
        zzbbl zzbblVar;
        zzbblVar = this.b.b;
        return a(callable, zzbblVar);
    }

    private final <O> zzczl<O> a(Callable<O> callable, zzbbl zzbblVar) {
        zzbbh zzbbhVar;
        zzczf zzczfVar = this.b;
        E e = this.f3518a;
        zzbbhVar = zzczf.f3516a;
        return new zzczl<>(zzczfVar, e, zzbbhVar, Collections.emptyList(), zzbblVar.submit(callable));
    }

    public final zzczl<?> zza(final zzczd zzczdVar, zzbbl zzbblVar) {
        return a(new Callable(zzczdVar) { // from class: com.google.android.gms.internal.ads.aao

            /* renamed from: a, reason: collision with root package name */
            private final zzczd f1763a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1763a = zzczdVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f1763a.run();
                return null;
            }
        }, zzbblVar);
    }
}
