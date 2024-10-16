package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* loaded from: classes2.dex */
final class dj implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaom f2122a;
    private final /* synthetic */ zzamv b;
    private final /* synthetic */ zzapc c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(zzapc zzapcVar, zzaom zzaomVar, zzamv zzamvVar) {
        this.c = zzapcVar;
        this.f2122a = zzaomVar;
        this.b = zzamvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        try {
            this.c.b = mediationInterstitialAd;
            this.f2122a.zzsw();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new dn(this.b);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.f2122a.zzdb(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
