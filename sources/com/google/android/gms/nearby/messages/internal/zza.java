package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zza extends zzbgl implements BleSignal {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private int f5023a;
    private int b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(int i, int i2, int i3) {
        this.f5023a = i;
        this.b = i2;
        this.c = (-169 >= i3 || i3 >= 87) ? BleSignal.UNKNOWN_TX_POWER : i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSignal)) {
            return false;
        }
        BleSignal bleSignal = (BleSignal) obj;
        return this.b == bleSignal.getRssi() && this.c == bleSignal.getTxPower();
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getRssi() {
        return this.b;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getTxPower() {
        return this.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public final String toString() {
        int i = this.b;
        int i2 = this.c;
        StringBuilder sb = new StringBuilder(48);
        sb.append("BleSignal{rssi=");
        sb.append(i);
        sb.append(", txPower=");
        sb.append(i2);
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f5023a);
        zzbgo.zzc(parcel, 2, this.b);
        zzbgo.zzc(parcel, 3, this.c);
        zzbgo.zzai(parcel, zze);
    }
}
