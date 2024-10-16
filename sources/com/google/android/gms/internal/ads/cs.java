package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cs implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzamv f2105a;
    private final /* synthetic */ Adapter b;
    private final /* synthetic */ zzanl c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(zzanl zzanlVar, zzamv zzamvVar, Adapter adapter) {
        this.c = zzanlVar;
        this.f2105a = zzamvVar;
        this.b = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.c.e = mediationRewardedAd;
            this.f2105a.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new zzauo(this.f2105a);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            String canonicalName = this.b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 30 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded medation ad: ");
            sb.append(str);
            zzbad.zzdp(sb.toString());
            this.f2105a.onAdFailedToLoad(0);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
