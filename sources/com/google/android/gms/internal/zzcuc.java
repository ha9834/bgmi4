package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzcuc implements Parcelable.Creator<zzcub> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcub createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        long j = 0;
        long j2 = 0;
        byte[] bArr = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j = zzbgm.zzi(parcel, readInt);
                    break;
                case 2:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 3:
                    bArr = zzbgm.zzt(parcel, readInt);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) zzbgm.zza(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 6:
                    j2 = zzbgm.zzi(parcel, readInt);
                    break;
                case 7:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zzbgm.zza(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcub(j, i, bArr, parcelFileDescriptor, str, j2, parcelFileDescriptor2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcub[] newArray(int i) {
        return new zzcub[i];
    }
}
