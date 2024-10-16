package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* loaded from: classes2.dex */
final class dl implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaop f2124a;
    private final /* synthetic */ zzamv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(zzapc zzapcVar, zzaop zzaopVar, zzamv zzamvVar) {
        this.f2124a = zzaopVar;
        this.b = zzamvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        try {
            this.f2124a.zza(new zzaoi(unifiedNativeAdMapper));
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new dn(this.b);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.f2124a.zzdb(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
