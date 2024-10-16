package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcut implements Parcelable.Creator<zzcus> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcus createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        while (parcel.dataPosition() < zzd) {
            zzbgm.zzb(parcel, parcel.readInt());
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcus();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcus[] newArray(int i) {
        return new zzcus[i];
    }
}
