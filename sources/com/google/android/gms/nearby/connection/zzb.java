package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
/* loaded from: classes2.dex */
public final class zzb implements Parcelable.Creator<AdvertisingOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdvertisingOptions createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Strategy strategy = null;
        byte[] bArr = null;
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    strategy = (Strategy) zzbgm.zza(parcel, readInt, Strategy.CREATOR);
                    break;
                case 2:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 3:
                    z2 = zzbgm.zzc(parcel, readInt);
                    break;
                case 4:
                    z3 = zzbgm.zzc(parcel, readInt);
                    break;
                case 5:
                    z4 = zzbgm.zzc(parcel, readInt);
                    break;
                case 6:
                    bArr = zzbgm.zzt(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new AdvertisingOptions(strategy, z, z2, z3, z4, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdvertisingOptions[] newArray(int i) {
        return new AdvertisingOptions[i];
    }
}
