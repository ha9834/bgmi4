package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bt implements zzbbt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzala f2084a;
    private final /* synthetic */ zzakh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(zzakh zzakhVar, zzala zzalaVar) {
        this.b = zzakhVar;
        this.f2084a = zzalaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final void run() {
        Object obj;
        obj = this.b.f2745a;
        synchronized (obj) {
            this.b.h = 1;
            zzawz.zzds("Failed loading new engine. Marking new engine destroyable.");
            this.f2084a.zzrz();
        }
    }
}
