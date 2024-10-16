package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
final class di implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaoj f2121a;
    private final /* synthetic */ zzamv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(zzapc zzapcVar, zzaoj zzaojVar, zzamv zzamvVar) {
        this.f2121a = zzaojVar;
        this.b = zzamvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        try {
            this.f2121a.zzw(ObjectWrapper.wrap(mediationBannerAd.getView()));
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new dn(this.b);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.f2121a.zzdb(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
