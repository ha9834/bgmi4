package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* loaded from: classes2.dex */
final class dm implements SignalCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaoy f2125a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(zzapc zzapcVar, zzaoy zzaoyVar) {
        this.f2125a = zzaoyVar;
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onSuccess(String str) {
        try {
            this.f2125a.zzdc(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onFailure(String str) {
        try {
            this.f2125a.onFailure(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
