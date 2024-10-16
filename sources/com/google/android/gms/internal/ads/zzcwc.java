package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcwc implements zzcva<zzcwb> {

    /* renamed from: a, reason: collision with root package name */
    zzvx f3470a;
    Context b;
    private zzbbl c;

    public zzcwc(zzvx zzvxVar, zzbbl zzbblVar, Context context) {
        this.f3470a = zzvxVar;
        this.c = zzbblVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwb> zzalm() {
        return this.c.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zu

            /* renamed from: a, reason: collision with root package name */
            private final zzcwc f2674a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2674a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcwc zzcwcVar = this.f2674a;
                return new zzcwb(zzcwcVar.f3470a.zzf(zzcwcVar.b));
            }
        });
    }
}
