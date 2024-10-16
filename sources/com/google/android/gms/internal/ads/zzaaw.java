package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaaw extends zzfm implements zzaau {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaaw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoStart() throws RemoteException {
        b(1, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoPlay() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoPause() throws RemoteException {
        b(3, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoEnd() throws RemoteException {
        b(4, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoMute(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzfo.writeBoolean(a2, z);
        b(5, a2);
    }
}
