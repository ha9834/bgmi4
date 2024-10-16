package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import java.util.Arrays;

@Hide
/* loaded from: classes.dex */
public final class zzcux extends zzbgl {
    public static final Parcelable.Creator<zzcux> CREATOR = new zzcuy();

    /* renamed from: a, reason: collision with root package name */
    private static final String f4707a = null;
    public static final zzcux zzkck = new zzcux("", null);
    private int b;
    private final String c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcux(int i, String str, String str2) {
        this.b = ((Integer) zzbq.checkNotNull(Integer.valueOf(i))).intValue();
        this.c = str == null ? "" : str;
        this.d = str2;
    }

    @Hide
    private zzcux(String str, String str2) {
        this(1, str, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcux)) {
            return false;
        }
        zzcux zzcuxVar = (zzcux) obj;
        return zzbg.equal(this.c, zzcuxVar.c) && zzbg.equal(this.d, zzcuxVar.d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.d});
    }

    public final String toString() {
        String str = this.c;
        String str2 = this.d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(str2).length());
        sb.append("NearbyDevice{handle=");
        sb.append(str);
        sb.append(", bluetoothAddress=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zza(parcel, 6, this.d, false);
        zzbgo.zzc(parcel, 1000, this.b);
        zzbgo.zzai(parcel, zze);
    }
}
