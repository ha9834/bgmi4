package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzaav extends zzfn implements zzaau {
    public zzaav() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                onVideoStart();
                break;
            case 2:
                onVideoPlay();
                break;
            case 3:
                onVideoPause();
                break;
            case 4:
                onVideoEnd();
                break;
            case 5:
                onVideoMute(zzfo.zza(parcel));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
