package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class wn implements zzbvo {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcnw f2590a;
    private final /* synthetic */ zzcxu b;
    private final /* synthetic */ zzcxm c;
    private final /* synthetic */ zzcjy d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public wn(zzcnw zzcnwVar, zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy zzcjyVar) {
        this.f2590a = zzcnwVar;
        this.b = zzcxuVar;
        this.c = zzcxmVar;
        this.d = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvo
    public final void onInitializationSucceeded() {
        Executor executor;
        executor = this.f2590a.b;
        final zzcxu zzcxuVar = this.b;
        final zzcxm zzcxmVar = this.c;
        final zzcjy zzcjyVar = this.d;
        executor.execute(new Runnable(this, zzcxuVar, zzcxmVar, zzcjyVar) { // from class: com.google.android.gms.internal.ads.wo

            /* renamed from: a, reason: collision with root package name */
            private final wn f2591a;
            private final zzcxu b;
            private final zzcxm c;
            private final zzcjy d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2591a = this;
                this.b = zzcxuVar;
                this.c = zzcxmVar;
                this.d = zzcjyVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                wn wnVar = this.f2591a;
                zzcxu zzcxuVar2 = this.b;
                zzcxm zzcxmVar2 = this.c;
                zzcjy zzcjyVar2 = this.d;
                zzcnw zzcnwVar = wnVar.f2590a;
                zzcnw.a(zzcxuVar2, zzcxmVar2, zzcjyVar2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbvo
    public final void zzdl(int i) {
        String valueOf = String.valueOf(this.d.zzfis);
        zzawz.zzep(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
