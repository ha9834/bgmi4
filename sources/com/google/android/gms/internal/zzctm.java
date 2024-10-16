package com.google.android.gms.internal;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: classes.dex */
public final class zzctm implements Parcelable.Creator<zzctl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctl createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        BluetoothDevice bluetoothDevice = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 2:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 3:
                    str3 = zzbgm.zzq(parcel, readInt);
                    break;
                case 4:
                    bluetoothDevice = (BluetoothDevice) zzbgm.zza(parcel, readInt, BluetoothDevice.CREATOR);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzctl(str, str2, str3, bluetoothDevice);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctl[] newArray(int i) {
        return new zzctl[i];
    }
}
