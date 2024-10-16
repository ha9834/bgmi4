package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.nearby.messages.Strategy;

@Hide
/* loaded from: classes2.dex */
public final class zzca implements Parcelable.Creator<zzbz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbz createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        zzaf zzafVar = null;
        Strategy strategy = null;
        IBinder iBinder = null;
        String str = null;
        String str2 = null;
        IBinder iBinder2 = null;
        ClientAppContext clientAppContext = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
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
                    strategy = (Strategy) zzbgm.zza(parcel, readInt, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder = zzbgm.zzr(parcel, readInt);
                    break;
                case 5:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 6:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 7:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 8:
                    iBinder2 = zzbgm.zzr(parcel, readInt);
                    break;
                case 9:
                    z2 = zzbgm.zzc(parcel, readInt);
                    break;
                case 10:
                    clientAppContext = (ClientAppContext) zzbgm.zza(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                case 11:
                    i2 = zzbgm.zzg(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzbz(i, zzafVar, strategy, iBinder, str, str2, z, iBinder2, z2, clientAppContext, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbz[] newArray(int i) {
        return new zzbz[i];
    }
}
