package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bs implements zzbbv<zzajw> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzala f2083a;
    private final /* synthetic */ zzakh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(zzakh zzakhVar, zzala zzalaVar) {
        this.b = zzakhVar;
        this.f2083a = zzalaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbv
    public final /* synthetic */ void zzh(zzajw zzajwVar) {
        Object obj;
        zzala zzalaVar;
        zzala zzalaVar2;
        zzala zzalaVar3;
        obj = this.b.f2745a;
        synchronized (obj) {
            this.b.h = 0;
            zzalaVar = this.b.g;
            if (zzalaVar != null) {
                zzala zzalaVar4 = this.f2083a;
                zzalaVar2 = this.b.g;
                if (zzalaVar4 != zzalaVar2) {
                    zzawz.zzds("New JS engine is loaded, marking previous one as destroyable.");
                    zzalaVar3 = this.b.g;
                    zzalaVar3.zzrz();
                }
            }
            this.b.g = this.f2083a;
        }
    }
}
