package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaat extends zzfm implements zzaar {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaat(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void play() throws RemoteException {
        b(1, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void pause() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void mute(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzfo.writeBoolean(a2, z);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean isMuted() throws RemoteException {
        Parcel a2 = a(4, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final int getPlaybackState() throws RemoteException {
        Parcel a2 = a(5, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float zzpv() throws RemoteException {
        Parcel a2 = a(6, a());
        float readFloat = a2.readFloat();
        a2.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float zzpw() throws RemoteException {
        Parcel a2 = a(7, a());
        float readFloat = a2.readFloat();
        a2.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void zza(zzaau zzaauVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaauVar);
        b(8, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float getAspectRatio() throws RemoteException {
        Parcel a2 = a(9, a());
        float readFloat = a2.readFloat();
        a2.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean isCustomControlsEnabled() throws RemoteException {
        Parcel a2 = a(10, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final zzaau zzpx() throws RemoteException {
        zzaau zzaawVar;
        Parcel a2 = a(11, a());
        IBinder readStrongBinder = a2.readStrongBinder();
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
        a2.recycle();
        return zzaawVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean isClickToExpandEnabled() throws RemoteException {
        Parcel a2 = a(12, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }
}
