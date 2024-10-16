package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class lf implements com.google.android.gms.ads.internal.overlay.zzo {

    /* renamed from: a, reason: collision with root package name */
    private zzbgz f2313a;
    private com.google.android.gms.ads.internal.overlay.zzo b;

    public lf(zzbgz zzbgzVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar) {
        this.f2313a = zzbgzVar;
        this.b = zzoVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        this.b.zzta();
        this.f2313a.zztl();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.b.zzsz();
        this.f2313a.zzaab();
    }
}
