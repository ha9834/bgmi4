package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzctq implements Parcelable.Creator<zzctp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctp createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        zzcub zzcubVar = null;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 2:
                    zzcubVar = (zzcub) zzbgm.zza(parcel, readInt, zzcub.CREATOR);
                    break;
                case 3:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzctp(str, zzcubVar, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctp[] newArray(int i) {
        return new zzctp[i];
    }
}
