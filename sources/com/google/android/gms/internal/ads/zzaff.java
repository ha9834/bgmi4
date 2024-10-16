package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzaff extends zzfn implements zzafe {
    public zzaff() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzafe zzn(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (queryLocalInterface instanceof zzafe) {
            return (zzafe) queryLocalInterface;
        }
        return new zzafg(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String zzcj = zzcj(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zzcj);
                return true;
            case 2:
                zzaei zzck = zzck(parcel.readString());
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzck);
                return true;
            case 3:
                List<String> availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                return true;
            case 4:
                String customTemplateId = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(customTemplateId);
                return true;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 7:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.zza(parcel2, videoController);
                return true;
            case 8:
                destroy();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper zzrm = zzrm();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzrm);
                return true;
            case 10:
                boolean zzp = zzp(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, zzp);
                return true;
            case 11:
                IObjectWrapper zzrh = zzrh();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzrh);
                return true;
            default:
                return false;
        }
    }
}
