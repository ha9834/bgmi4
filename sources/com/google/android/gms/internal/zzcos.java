package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcos implements Parcelable.Creator<zzcor> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcor createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        long j = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = zzbgm.zzr(parcel, readInt);
                    break;
                case 2:
                    j = zzbgm.zzi(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcor(iBinder, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcor[] newArray(int i) {
        return new zzcor[i];
    }
}
