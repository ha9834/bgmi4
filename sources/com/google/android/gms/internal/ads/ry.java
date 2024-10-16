package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ry implements com.google.android.gms.ads.internal.overlay.zzo, com.google.android.gms.ads.internal.overlay.zzu, zzagv, zzagx, zzxr {

    /* renamed from: a, reason: collision with root package name */
    private zzxr f2479a;
    private zzagv b;
    private com.google.android.gms.ads.internal.overlay.zzo c;
    private zzagx d;
    private com.google.android.gms.ads.internal.overlay.zzu e;

    private ry() {
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final synchronized void onAdClicked() {
        if (this.f2479a != null) {
            this.f2479a.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzsz() {
        if (this.c != null) {
            this.c.zzsz();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        if (this.c != null) {
            this.c.onPause();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        if (this.c != null) {
            this.c.onResume();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzta() {
        if (this.c != null) {
            this.c.zzta();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzu
    public final synchronized void zztq() {
        if (this.e != null) {
            this.e.zztq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagv
    public final synchronized void zza(String str, Bundle bundle) {
        if (this.b != null) {
            this.b.zza(str, bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagx
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.d != null) {
            this.d.onAppEvent(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void a(zzxr zzxrVar, zzagv zzagvVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzagx zzagxVar, com.google.android.gms.ads.internal.overlay.zzu zzuVar) {
        this.f2479a = zzxrVar;
        this.b = zzagvVar;
        this.c = zzoVar;
        this.d = zzagxVar;
        this.e = zzuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ry(ru ruVar) {
        this();
    }
}
