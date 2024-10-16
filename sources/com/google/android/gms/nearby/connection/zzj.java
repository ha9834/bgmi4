package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
/* loaded from: classes2.dex */
public final class zzj implements Parcelable.Creator<Strategy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Strategy createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 3:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbgm.zzg(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new Strategy(i, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
