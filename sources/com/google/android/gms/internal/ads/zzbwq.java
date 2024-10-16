package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbwq implements com.google.android.gms.ads.internal.overlay.zzo {

    /* renamed from: a, reason: collision with root package name */
    private final zzbsv f3088a;
    private final zzbuv b;

    public zzbwq(zzbsv zzbsvVar, zzbuv zzbuvVar) {
        this.f3088a = zzbsvVar;
        this.b = zzbuvVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.f3088a.zzsz();
        this.b.onHide();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
        this.f3088a.onPause();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
        this.f3088a.onResume();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        this.f3088a.zzta();
        this.b.zzagw();
    }
}
