package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcuy implements Parcelable.Creator<zzcux> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcux createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 3) {
                str = zzbgm.zzq(parcel, readInt);
            } else if (i2 == 6) {
                str2 = zzbgm.zzq(parcel, readInt);
            } else if (i2 != 1000) {
                zzbgm.zzb(parcel, readInt);
            } else {
                i = zzbgm.zzg(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcux(i, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcux[] newArray(int i) {
        return new zzcux[i];
    }
}
