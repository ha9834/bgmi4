package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class xs implements zzbsr {

    /* renamed from: a, reason: collision with root package name */
    private zzbsr f2620a;
    private final /* synthetic */ zzcqj b;

    public xs(zzcqj zzcqjVar, zzbsr zzbsrVar) {
        this.b = zzcqjVar;
        this.f2620a = zzbsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        this.b.a();
        this.f2620a.onAdLoaded();
        this.b.b();
    }
}
