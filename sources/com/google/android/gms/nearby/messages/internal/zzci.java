package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.internal.zzcux;
import com.google.android.gms.nearby.messages.Message;

@Hide
/* loaded from: classes2.dex */
public final class zzci implements Parcelable.Creator<Update> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Update createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Message message = null;
        zze zzeVar = null;
        zza zzaVar = null;
        zzcux zzcuxVar = null;
        byte[] bArr = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbgm.zzg(parcel, readInt);
                    break;
                case 3:
                    message = (Message) zzbgm.zza(parcel, readInt, Message.CREATOR);
                    break;
                case 4:
                    zzeVar = (zze) zzbgm.zza(parcel, readInt, zze.CREATOR);
                    break;
                case 5:
                    zzaVar = (zza) zzbgm.zza(parcel, readInt, zza.CREATOR);
                    break;
                case 6:
                    zzcuxVar = (zzcux) zzbgm.zza(parcel, readInt, zzcux.CREATOR);
                    break;
                case 7:
                    bArr = zzbgm.zzt(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new Update(i, i2, message, zzeVar, zzaVar, zzcuxVar, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Update[] newArray(int i) {
        return new Update[i];
    }
}
