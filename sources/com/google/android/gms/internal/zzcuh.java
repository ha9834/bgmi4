package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcuh implements Parcelable.Creator<zzcug> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcug createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        IBinder iBinder4 = null;
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
                    iBinder3 = zzbgm.zzr(parcel, readInt);
                    break;
                case 4:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 5:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 6:
                    bArr = zzbgm.zzt(parcel, readInt);
                    break;
                case 7:
                    iBinder4 = zzbgm.zzr(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcug(iBinder, iBinder2, iBinder3, str, str2, bArr, iBinder4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcug[] newArray(int i) {
        return new zzcug[i];
    }
}
