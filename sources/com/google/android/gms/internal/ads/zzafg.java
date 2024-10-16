package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzafg extends zzfm implements zzafe {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final String zzcj(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        Parcel a3 = a(1, a2);
        String readString = a3.readString();
        a3.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final zzaei zzck(String str) throws RemoteException {
        zzaei zzaekVar;
        Parcel a2 = a();
        a2.writeString(str);
        Parcel a3 = a(2, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        if (readStrongBinder == null) {
            zzaekVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzaei) {
                zzaekVar = (zzaei) queryLocalInterface;
            } else {
                zzaekVar = new zzaek(readStrongBinder);
            }
        }
        a3.recycle();
        return zzaekVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final List<String> getAvailableAssetNames() throws RemoteException {
        Parcel a2 = a(3, a());
        ArrayList<String> createStringArrayList = a2.createStringArrayList();
        a2.recycle();
        return createStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final String getCustomTemplateId() throws RemoteException {
        Parcel a2 = a(4, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void performClick(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void recordImpression() throws RemoteException {
        b(6, a());
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final zzaar getVideoController() throws RemoteException {
        Parcel a2 = a(7, a());
        zzaar zzh = zzaas.zzh(a2.readStrongBinder());
        a2.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void destroy() throws RemoteException {
        b(8, a());
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final IObjectWrapper zzrm() throws RemoteException {
        Parcel a2 = a(9, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final boolean zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        Parcel a3 = a(10, a2);
        boolean zza = zzfo.zza(a3);
        a3.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final IObjectWrapper zzrh() throws RemoteException {
        Parcel a2 = a(11, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }
}
