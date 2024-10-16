package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcwn implements zzcva<zzcwm> {

    /* renamed from: a, reason: collision with root package name */
    zzaci f3477a;
    List<String> b;
    private zzbbl c;

    public zzcwn(zzaci zzaciVar, zzbbl zzbblVar, List<String> list) {
        this.f3477a = zzaciVar;
        this.c = zzbblVar;
        this.b = list;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwm> zzalm() {
        return this.c.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zy

            /* renamed from: a, reason: collision with root package name */
            private final zzcwn f2678a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2678a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcwn zzcwnVar = this.f2678a;
                return new zzcwm(zzcwnVar.f3477a.zzb(zzcwnVar.b));
            }
        });
    }
}
