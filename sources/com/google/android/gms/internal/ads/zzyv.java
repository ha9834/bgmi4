package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

@zzard
/* loaded from: classes2.dex */
public class zzyv extends AdListener {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3785a = new Object();
    private AdListener b;

    public final void zza(AdListener adListener) {
        synchronized (this.f3785a) {
            this.b = adListener;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        synchronized (this.f3785a) {
            if (this.b != null) {
                this.b.onAdClosed();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i) {
        synchronized (this.f3785a) {
            if (this.b != null) {
                this.b.onAdFailedToLoad(i);
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLeftApplication() {
        synchronized (this.f3785a) {
            if (this.b != null) {
                this.b.onAdLeftApplication();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
        synchronized (this.f3785a) {
            if (this.b != null) {
                this.b.onAdOpened();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        synchronized (this.f3785a) {
            if (this.b != null) {
                this.b.onAdLoaded();
            }
        }
    }
}
