package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
/* loaded from: classes2.dex */
public final class zzi implements Parcelable.Creator<PayloadTransferUpdate> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PayloadTransferUpdate createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j = zzbgm.zzi(parcel, readInt);
                    break;
                case 2:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 3:
                    j2 = zzbgm.zzi(parcel, readInt);
                    break;
                case 4:
                    j3 = zzbgm.zzi(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new PayloadTransferUpdate(j, i, j2, j3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PayloadTransferUpdate[] newArray(int i) {
        return new PayloadTransferUpdate[i];
    }
}
