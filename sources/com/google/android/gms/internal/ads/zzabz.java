package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

@zzard
/* loaded from: classes2.dex */
public final class zzabz extends zzaap {

    /* renamed from: a, reason: collision with root package name */
    private final OnAdMetadataChangedListener f2693a;

    public zzabz(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.f2693a = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaao
    public final void onAdMetadataChanged() throws RemoteException {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.f2693a;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
