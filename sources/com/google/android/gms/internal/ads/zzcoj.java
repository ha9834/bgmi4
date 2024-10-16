package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zzcoj extends zzamw {

    /* renamed from: a, reason: collision with root package name */
    private final zzbri f3347a;
    private final zzbrt b;
    private final zzbse c;
    private final zzbso d;
    private final zzbtp e;
    private final zzbsv f;
    private final zzbvq g;

    public zzcoj(zzbri zzbriVar, zzbrt zzbrtVar, zzbse zzbseVar, zzbso zzbsoVar, zzbtp zzbtpVar, zzbsv zzbsvVar, zzbvq zzbvqVar) {
        this.f3347a = zzbriVar;
        this.b = zzbrtVar;
        this.c = zzbseVar;
        this.d = zzbsoVar;
        this.e = zzbtpVar;
        this.f = zzbsvVar;
        this.g = zzbvqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdFailedToLoad(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzafe zzafeVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzamy zzamyVar) {
    }

    public void zza(zzatq zzatqVar) throws RemoteException {
    }

    public void zzb(Bundle bundle) throws RemoteException {
    }

    public void zzb(zzato zzatoVar) {
    }

    public void zzcs(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzcz(String str) {
    }

    public void zzsn() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClicked() {
        this.f3347a.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClosed() {
        this.f.zzsz();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLeftApplication() {
        this.c.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdOpened() {
        this.f.zzta();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAppEvent(String str, String str2) {
        this.e.onAppEvent(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLoaded() {
        this.d.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdImpression() {
        this.b.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPause() {
        this.g.onVideoPause();
    }

    public void zzsm() {
        this.g.onVideoStart();
    }

    public void onVideoEnd() {
        this.g.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPlay() throws RemoteException {
        this.g.onVideoPlay();
    }
}
