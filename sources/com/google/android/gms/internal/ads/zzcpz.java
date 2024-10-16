package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcpz extends AdMetadataListener {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzaao f3372a;

    public final synchronized void zzb(zzaao zzaaoVar) {
        this.f3372a = zzaaoVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final synchronized void onAdMetadataChanged() {
        if (this.f3372a != null) {
            try {
                this.f3372a.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
