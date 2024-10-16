package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcva implements Parcelable.Creator<zzcuz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuz createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        int i = 0;
        byte[] bArr = null;
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 != 1000) {
                switch (i3) {
                    case 1:
                        i2 = zzbgm.zzg(parcel, readInt);
                        break;
                    case 2:
                        bArr = zzbgm.zzt(parcel, readInt);
                        break;
                    case 3:
                        z = zzbgm.zzc(parcel, readInt);
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
        return new zzcuz(i, i2, bArr, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuz[] newArray(int i) {
        return new zzcuz[i];
    }
}
