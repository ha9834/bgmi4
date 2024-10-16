package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcuf implements Parcelable.Creator<zzcue> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcue createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = zzbgm.zzr(parcel, readInt);
                    break;
                case 2:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcue(iBinder, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcue[] newArray(int i) {
        return new zzcue[i];
    }
}
