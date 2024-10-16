package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class xo implements zzbsr {

    /* renamed from: a, reason: collision with root package name */
    private zzbsr f2616a;
    private final /* synthetic */ zzcqf b;

    public xo(zzcqf zzcqfVar, zzbsr zzbsrVar) {
        this.b = zzcqfVar;
        this.f2616a = zzbsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        this.b.a();
        this.f2616a.onAdLoaded();
        this.b.b();
    }
}
