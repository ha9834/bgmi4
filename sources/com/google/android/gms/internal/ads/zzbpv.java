package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class zzbpv implements com.google.android.gms.ads.internal.overlay.zzo {

    /* renamed from: a, reason: collision with root package name */
    private final zzbse f2998a;
    private AtomicBoolean b = new AtomicBoolean(false);

    public zzbpv(zzbse zzbseVar) {
        this.f2998a = zzbseVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.b.set(true);
        this.f2998a.onAdClosed();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        this.f2998a.onAdOpened();
    }

    public final boolean isClosed() {
        return this.b.get();
    }
}
