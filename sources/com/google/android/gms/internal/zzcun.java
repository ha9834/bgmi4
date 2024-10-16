package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

@Hide
/* loaded from: classes.dex */
public final class zzcun implements Parcelable.Creator<zzcum> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcum createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        DiscoveryOptions discoveryOptions = null;
        IBinder iBinder3 = null;
        long j = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = zzbgm.zzr(parcel, readInt);
                    break;
                case 2:
                    iBinder2 = zzbgm.zzr(parcel, readInt);
                    break;
                case 3:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 4:
                    j = zzbgm.zzi(parcel, readInt);
                    break;
                case 5:
                    discoveryOptions = (DiscoveryOptions) zzbgm.zza(parcel, readInt, DiscoveryOptions.CREATOR);
                    break;
                case 6:
                    iBinder3 = zzbgm.zzr(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcum(iBinder, iBinder2, str, j, discoveryOptions, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcum[] newArray(int i) {
        return new zzcum[i];
    }
}
