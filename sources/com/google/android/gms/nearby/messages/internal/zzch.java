package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
/* loaded from: classes2.dex */
public final class zzch implements Parcelable.Creator<zzcg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcg createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        String str = null;
        String str2 = null;
        ClientAppContext clientAppContext = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 2:
                    iBinder = zzbgm.zzr(parcel, readInt);
                    break;
                case 3:
                    iBinder2 = zzbgm.zzr(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zzbgm.zza(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    i2 = zzbgm.zzg(parcel, readInt);
                    break;
                case 6:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 7:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 8:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 9:
                    clientAppContext = (ClientAppContext) zzbgm.zza(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcg(i, iBinder, iBinder2, pendingIntent, i2, str, str2, z, clientAppContext);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcg[] newArray(int i) {
        return new zzcg[i];
    }
}
