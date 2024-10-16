package com.google.android.gms.internal;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctl extends zzbgl {
    public static final Parcelable.Creator<zzctl> CREATOR = new zzctm();

    /* renamed from: a, reason: collision with root package name */
    private String f4691a;
    private String b;
    private String c;
    private BluetoothDevice d;

    private zzctl() {
    }

    @Hide
    public zzctl(String str, String str2, String str3, BluetoothDevice bluetoothDevice) {
        this.f4691a = str;
        this.b = str2;
        this.c = str3;
        this.d = bluetoothDevice;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctl) {
            zzctl zzctlVar = (zzctl) obj;
            if (zzbg.equal(this.f4691a, zzctlVar.f4691a) && zzbg.equal(this.b, zzctlVar.b) && zzbg.equal(this.c, zzctlVar.c) && zzbg.equal(this.d, zzctlVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final String getEndpointName() {
        return this.c;
    }

    public final String getServiceId() {
        return this.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4691a, this.b, this.c, this.d});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4691a, false);
        zzbgo.zza(parcel, 2, this.b, false);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zza(parcel, 4, this.d, i, false);
        zzbgo.zzai(parcel, zze);
    }

    public final String zzbdi() {
        return this.f4691a;
    }

    public final BluetoothDevice zzbdj() {
        return this.d;
    }
}
