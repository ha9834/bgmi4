package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* loaded from: classes2.dex */
final class ct implements InitializationCompleteCallback {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaiq f2106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(zzanl zzanlVar, zzaiq zzaiqVar) {
        this.f2106a = zzaiqVar;
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationSucceeded() {
        try {
            this.f2106a.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationFailed(String str) {
        try {
            this.f2106a.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
