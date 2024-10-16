package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcuv implements Parcelable.Creator<zzcuu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuu createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = null;
        ParcelUuid parcelUuid3 = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 != 1) {
                switch (i3) {
                    case 4:
                        parcelUuid = (ParcelUuid) zzbgm.zza(parcel, readInt, ParcelUuid.CREATOR);
                        break;
                    case 5:
                        parcelUuid2 = (ParcelUuid) zzbgm.zza(parcel, readInt, ParcelUuid.CREATOR);
                        break;
                    case 6:
                        parcelUuid3 = (ParcelUuid) zzbgm.zza(parcel, readInt, ParcelUuid.CREATOR);
                        break;
                    case 7:
                        bArr = zzbgm.zzt(parcel, readInt);
                        break;
                    case 8:
                        bArr2 = zzbgm.zzt(parcel, readInt);
                        break;
                    case 9:
                        i2 = zzbgm.zzg(parcel, readInt);
                        break;
                    case 10:
                        bArr3 = zzbgm.zzt(parcel, readInt);
                        break;
                    case 11:
                        bArr4 = zzbgm.zzt(parcel, readInt);
                        break;
                    default:
                        zzbgm.zzb(parcel, readInt);
                        break;
                }
            } else {
                i = zzbgm.zzg(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcuu(i, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i2, bArr3, bArr4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuu[] newArray(int i) {
        return new zzcuu[i];
    }
}
