package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzaas extends zzfn implements zzaar {
    public zzaas() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzaar zzh(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (queryLocalInterface instanceof zzaar) {
            return (zzaar) queryLocalInterface;
        }
        return new zzaat(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaau zzaawVar;
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                return true;
            case 2:
                pause();
                parcel2.writeNoException();
                return true;
            case 3:
                mute(zzfo.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean isMuted = isMuted();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, isMuted);
                return true;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                return true;
            case 6:
                float zzpv = zzpv();
                parcel2.writeNoException();
                parcel2.writeFloat(zzpv);
                return true;
            case 7:
                float zzpw = zzpw();
                parcel2.writeNoException();
                parcel2.writeFloat(zzpw);
                return true;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaawVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    if (queryLocalInterface instanceof zzaau) {
                        zzaawVar = (zzaau) queryLocalInterface;
                    } else {
                        zzaawVar = new zzaaw(readStrongBinder);
                    }
                }
                zza(zzaawVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                return true;
            case 10:
                boolean isCustomControlsEnabled = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, isCustomControlsEnabled);
                return true;
            case 11:
                zzaau zzpx = zzpx();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzpx);
                return true;
            case 12:
                boolean isClickToExpandEnabled = isClickToExpandEnabled();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, isClickToExpandEnabled);
                return true;
            default:
                return false;
        }
    }
}
