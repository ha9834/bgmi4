package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.internal.zzcux;

@Hide
/* loaded from: classes2.dex */
public final class zza implements Parcelable.Creator<Message> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Message createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        byte[] bArr = null;
        String str = null;
        String str2 = null;
        zzcux[] zzcuxVarArr = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 != 1000) {
                switch (i2) {
                    case 1:
                        bArr = zzbgm.zzt(parcel, readInt);
                        break;
                    case 2:
                        str2 = zzbgm.zzq(parcel, readInt);
                        break;
                    case 3:
                        str = zzbgm.zzq(parcel, readInt);
                        break;
                    case 4:
                        zzcuxVarArr = (zzcux[]) zzbgm.zzb(parcel, readInt, zzcux.CREATOR);
                        break;
                    case 5:
                        j = zzbgm.zzi(parcel, readInt);
                        break;
                    default:
                        zzbgm.zzb(parcel, readInt);
                        break;
                }
            } else {
                i = zzbgm.zzg(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new Message(i, bArr, str, str2, zzcuxVarArr, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Message[] newArray(int i) {
        return new Message[i];
    }
}
