package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzanj extends zzaas {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2761a = new Object();
    private volatile zzaau b;

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float zzpv() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float zzpw() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void zza(zzaau zzaauVar) throws RemoteException {
        synchronized (this.f2761a) {
            this.b = zzaauVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final zzaau zzpx() throws RemoteException {
        zzaau zzaauVar;
        synchronized (this.f2761a) {
            zzaauVar = this.b;
        }
        return zzaauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }
}
