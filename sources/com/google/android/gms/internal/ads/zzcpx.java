package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcpx extends AdMetadataListener {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzzp f3370a;

    public final synchronized void zzb(zzzp zzzpVar) {
        this.f3370a = zzzpVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final synchronized void onAdMetadataChanged() {
        if (this.f3370a != null) {
            try {
                this.f3370a.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdMetadataChanged.", e);
            }
        }
    }
}
