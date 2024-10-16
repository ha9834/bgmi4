package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcpv implements zzxr {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzyw f3368a;

    public final synchronized void zzb(zzyw zzywVar) {
        this.f3368a = zzywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final synchronized void onAdClicked() {
        if (this.f3368a != null) {
            try {
                this.f3368a.onAdClicked();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }
}
