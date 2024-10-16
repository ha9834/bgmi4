package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
/* loaded from: classes2.dex */
public final class zzcf implements Parcelable.Creator<zzce> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzce createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        zzaf zzafVar = null;
        IBinder iBinder = null;
        String str = null;
        String str2 = null;
        ClientAppContext clientAppContext = null;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 2:
                    zzafVar = (zzaf) zzbgm.zza(parcel, readInt, zzaf.CREATOR);
                    break;
                case 3:
                    iBinder = zzbgm.zzr(parcel, readInt);
                    break;
                case 4:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 5:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 6:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 7:
                    clientAppContext = (ClientAppContext) zzbgm.zza(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzce(i, zzafVar, iBinder, str, str2, z, clientAppContext);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzce[] newArray(int i) {
        return new zzce[i];
    }
}
