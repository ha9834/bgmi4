package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcoq implements Parcelable.Creator<zzcop> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcop createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        byte[] bArr = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = zzbgm.zzr(parcel, readInt);
                    break;
                case 2:
                    iBinder2 = zzbgm.zzr(parcel, readInt);
                    break;
                case 3:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 4:
                    bArr = zzbgm.zzt(parcel, readInt);
                    break;
                case 5:
                    iBinder3 = zzbgm.zzr(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcop(iBinder, iBinder2, str, bArr, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcop[] newArray(int i) {
        return new zzcop[i];
    }
}
