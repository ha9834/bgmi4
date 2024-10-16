package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
/* loaded from: classes2.dex */
public final class zzc implements Parcelable.Creator<AppIdentifier> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppIdentifier createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                zzbgm.zzb(parcel, readInt);
            } else {
                str = zzbgm.zzq(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new AppIdentifier(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppIdentifier[] newArray(int i) {
        return new AppIdentifier[i];
    }
}
