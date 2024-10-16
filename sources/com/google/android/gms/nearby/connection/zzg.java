package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
/* loaded from: classes2.dex */
public final class zzg implements Parcelable.Creator<DiscoveryOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DiscoveryOptions createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        boolean z = true;
        Strategy strategy = null;
        boolean z2 = false;
        boolean z3 = true;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    strategy = (Strategy) zzbgm.zza(parcel, readInt, Strategy.CREATOR);
                    break;
                case 2:
                    z2 = zzbgm.zzc(parcel, readInt);
                    break;
                case 3:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 4:
                    z3 = zzbgm.zzc(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new DiscoveryOptions(strategy, z2, z, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DiscoveryOptions[] newArray(int i) {
        return new DiscoveryOptions[i];
    }
}
