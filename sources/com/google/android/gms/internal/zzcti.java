package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcti implements Parcelable.Creator<zzcth> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcth createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 2:
                    i = zzbgm.zzg(parcel, readInt);
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
        return new zzcth(str, i, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcth[] newArray(int i) {
        return new zzcth[i];
    }
}
