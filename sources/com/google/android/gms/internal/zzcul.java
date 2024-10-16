package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

@Hide
/* loaded from: classes.dex */
public final class zzcul implements Parcelable.Creator<zzcuk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuk createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        String str2 = null;
        AdvertisingOptions advertisingOptions = null;
        IBinder iBinder3 = null;
        long j = 0;
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
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 5:
                    j = zzbgm.zzi(parcel, readInt);
                    break;
                case 6:
                    advertisingOptions = (AdvertisingOptions) zzbgm.zza(parcel, readInt, AdvertisingOptions.CREATOR);
                    break;
                case 7:
                    iBinder3 = zzbgm.zzr(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcuk(iBinder, iBinder2, str, str2, j, advertisingOptions, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuk[] newArray(int i) {
        return new zzcuk[i];
    }
}
