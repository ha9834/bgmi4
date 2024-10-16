package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

@Hide
/* loaded from: classes.dex */
public final class zzcts implements Parcelable.Creator<zzctr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctr createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        PayloadTransferUpdate payloadTransferUpdate = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 2:
                    payloadTransferUpdate = (PayloadTransferUpdate) zzbgm.zza(parcel, readInt, PayloadTransferUpdate.CREATOR);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzctr(str, payloadTransferUpdate);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctr[] newArray(int i) {
        return new zzctr[i];
    }
}
