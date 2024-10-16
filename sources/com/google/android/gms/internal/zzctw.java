package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzctw implements Parcelable.Creator<zzctv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctv createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                zzbgm.zzb(parcel, readInt);
            } else {
                i = zzbgm.zzg(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzctv(i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctv[] newArray(int i) {
        return new zzctv[i];
    }
}
