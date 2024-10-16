package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzctl implements zzcva<zzctk> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3430a;
    private final zzcxk b;

    public zzctl(zzbbl zzbblVar, zzcxk zzcxkVar) {
        this.f3430a = zzbblVar;
        this.b = zzcxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzctk> zzalm() {
        return this.f3430a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.ys

            /* renamed from: a, reason: collision with root package name */
            private final zzctl f2645a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2645a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2645a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzctk a() throws Exception {
        return new zzctk(this.b);
    }
}
