package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcuj implements Parcelable.Creator<zzcui> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcui createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        String[] strArr = null;
        zzcub zzcubVar = null;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = zzbgm.zzr(parcel, readInt);
                    break;
                case 2:
                    strArr = zzbgm.zzaa(parcel, readInt);
                    break;
                case 3:
                    zzcubVar = (zzcub) zzbgm.zza(parcel, readInt, zzcub.CREATOR);
                    break;
                case 4:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcui(iBinder, strArr, zzcubVar, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcui[] newArray(int i) {
        return new zzcui[i];
    }
}
