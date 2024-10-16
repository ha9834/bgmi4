package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ca implements zzbbv<zzajw> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzala f2091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(zzala zzalaVar) {
        this.f2091a = zzalaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbv
    public final /* synthetic */ void zzh(zzajw zzajwVar) {
        final zzajw zzajwVar2 = zzajwVar;
        zzbbm.zzeae.execute(new Runnable(this, zzajwVar2) { // from class: com.google.android.gms.internal.ads.cb

            /* renamed from: a, reason: collision with root package name */
            private final ca f2092a;
            private final zzajw b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2092a = this;
                this.b = zzajwVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzayp zzaypVar;
                ca caVar = this.f2092a;
                zzajw zzajwVar3 = this.b;
                zzaypVar = caVar.f2091a.b;
                zzaypVar.zzh(zzajwVar3);
                zzajwVar3.destroy();
            }
        });
    }
}
