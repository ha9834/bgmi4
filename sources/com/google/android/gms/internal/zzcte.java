package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcte implements Parcelable.Creator<zzctd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctd createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 2:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 3:
                    bArr = zzbgm.zzt(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzctd(str, str2, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctd[] newArray(int i) {
        return new zzctd[i];
    }
}
