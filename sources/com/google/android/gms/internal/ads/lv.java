package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class lv implements com.google.android.gms.ads.internal.overlay.zzo {

    /* renamed from: a, reason: collision with root package name */
    private zzbgz f2329a;
    private com.google.android.gms.ads.internal.overlay.zzo b;

    public lv(zzbgz zzbgzVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar) {
        this.f2329a = zzbgzVar;
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
        this.f2329a.zztl();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.b.zzsz();
        this.f2329a.zzaab();
    }
}
