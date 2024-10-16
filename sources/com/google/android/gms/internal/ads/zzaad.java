package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzaad extends zzfm implements zzaab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zza() throws RemoteException {
        b(1, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void setAppVolume(float f) throws RemoteException {
        Parcel a2 = a();
        a2.writeFloat(f);
        b(2, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzbu(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void setAppMuted(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzfo.writeBoolean(a2, z);
        b(4, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzc(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeString(str);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        zzfo.zza(a2, iObjectWrapper);
        b(6, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final float zzpq() throws RemoteException {
        Parcel a2 = a(7, a());
        float readFloat = a2.readFloat();
        a2.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final boolean zzpr() throws RemoteException {
        Parcel a2 = a(8, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final String getVersionString() throws RemoteException {
        Parcel a2 = a(9, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzbv(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zza(zzamp zzampVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzampVar);
        b(11, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zza(zzait zzaitVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaitVar);
        b(12, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final List<zzaio> zzps() throws RemoteException {
        Parcel a2 = a(13, a());
        ArrayList createTypedArrayList = a2.createTypedArrayList(zzaio.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }
}
