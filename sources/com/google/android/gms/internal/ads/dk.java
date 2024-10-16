package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* loaded from: classes2.dex */
final class dk implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaos f2123a;
    private final /* synthetic */ zzamv b;
    private final /* synthetic */ zzapc c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(zzapc zzapcVar, zzaos zzaosVar, zzamv zzamvVar) {
        this.c = zzapcVar;
        this.f2123a = zzaosVar;
        this.b = zzamvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.c.c = mediationRewardedAd;
            this.f2123a.zzsw();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new dn(this.b);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.f2123a.zzdb(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
