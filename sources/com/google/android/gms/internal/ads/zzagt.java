package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* loaded from: classes2.dex */
public final class zzagt extends zzage {

    /* renamed from: a, reason: collision with root package name */
    private final UnifiedNativeAd.UnconfirmedClickListener f2728a;

    public zzagt(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.f2728a = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final void onUnconfirmedClickReceived(String str) {
        this.f2728a.onUnconfirmedClickReceived(str);
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final void onUnconfirmedClickCancelled() {
        this.f2728a.onUnconfirmedClickCancelled();
    }
}
