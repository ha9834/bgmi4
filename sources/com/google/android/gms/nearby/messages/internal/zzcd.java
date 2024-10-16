package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

@Hide
/* loaded from: classes2.dex */
public final class zzcd implements Parcelable.Creator<SubscribeRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SubscribeRequest createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        Strategy strategy = null;
        IBinder iBinder2 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        IBinder iBinder3 = null;
        ClientAppContext clientAppContext = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        int i4 = 0;
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
                    strategy = (Strategy) zzbgm.zza(parcel, readInt, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder2 = zzbgm.zzr(parcel, readInt);
                    break;
                case 5:
                    messageFilter = (MessageFilter) zzbgm.zza(parcel, readInt, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) zzbgm.zza(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 7:
                    i2 = zzbgm.zzg(parcel, readInt);
                    break;
                case 8:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 9:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 10:
                    bArr = zzbgm.zzt(parcel, readInt);
                    break;
                case 11:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 12:
                    iBinder3 = zzbgm.zzr(parcel, readInt);
                    break;
                case 13:
                    z2 = zzbgm.zzc(parcel, readInt);
                    break;
                case 14:
                    clientAppContext = (ClientAppContext) zzbgm.zza(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                case 15:
                    z3 = zzbgm.zzc(parcel, readInt);
                    break;
                case 16:
                    i3 = zzbgm.zzg(parcel, readInt);
                    break;
                case 17:
                    i4 = zzbgm.zzg(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new SubscribeRequest(i, iBinder, strategy, iBinder2, messageFilter, pendingIntent, i2, str, str2, bArr, z, iBinder3, z2, clientAppContext, z3, i3, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
