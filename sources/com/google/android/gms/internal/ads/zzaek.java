package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaek extends zzfm implements zzaei {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaek(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final IObjectWrapper zzrf() throws RemoteException {
        Parcel a2 = a(1, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final Uri getUri() throws RemoteException {
        Parcel a2 = a(2, a());
        Uri uri = (Uri) zzfo.zza(a2, Uri.CREATOR);
        a2.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final double getScale() throws RemoteException {
        Parcel a2 = a(3, a());
        double readDouble = a2.readDouble();
        a2.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getWidth() throws RemoteException {
        Parcel a2 = a(4, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getHeight() throws RemoteException {
        Parcel a2 = a(5, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
