package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* loaded from: classes2.dex */
final class de implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AdRequest.ErrorCode f2117a;
    private final /* synthetic */ zzanu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(zzanu zzanuVar, AdRequest.ErrorCode errorCode) {
        this.b = zzanuVar;
        this.f2117a = errorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzamv zzamvVar;
        try {
            zzamvVar = this.b.f2770a;
            zzamvVar.onAdFailedToLoad(zzaog.zza(this.f2117a));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
