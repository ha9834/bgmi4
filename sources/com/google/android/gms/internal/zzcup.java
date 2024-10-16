package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcup implements Parcelable.Creator<zzcuo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuo createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        while (parcel.dataPosition() < zzd) {
            zzbgm.zzb(parcel, parcel.readInt());
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcuo();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcuo[] newArray(int i) {
        return new zzcuo[i];
    }
}
