package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class zzbov implements zzbsr, zzue {

    /* renamed from: a, reason: collision with root package name */
    private final zzcxm f2980a;
    private final zzbrt b;
    private final AtomicBoolean c = new AtomicBoolean();

    public zzbov(zzcxm zzcxmVar, zzbrt zzbrtVar) {
        this.f2980a = zzcxmVar;
        this.b = zzbrtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        if (this.f2980a.zzgjz != 1) {
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void zza(zzud zzudVar) {
        if (this.f2980a.zzgjz == 1 && zzudVar.zzbtk) {
            a();
        }
    }

    private final void a() {
        if (this.c.compareAndSet(false, true)) {
            this.b.onAdImpression();
        }
    }
}
