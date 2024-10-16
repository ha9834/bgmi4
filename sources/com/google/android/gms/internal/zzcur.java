package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcur implements Parcelable.Creator<zzcuq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuq createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        while (parcel.dataPosition() < zzd) {
            zzbgm.zzb(parcel, parcel.readInt());
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcuq();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuq[] newArray(int i) {
        return new zzcuq[i];
    }
}
