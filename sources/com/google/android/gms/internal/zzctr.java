package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctr extends zzbgl {
    public static final Parcelable.Creator<zzctr> CREATOR = new zzcts();

    /* renamed from: a, reason: collision with root package name */
    private String f4694a;
    private PayloadTransferUpdate b;

    private zzctr() {
    }

    @Hide
    public zzctr(String str, PayloadTransferUpdate payloadTransferUpdate) {
        this.f4694a = str;
        this.b = payloadTransferUpdate;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctr) {
            zzctr zzctrVar = (zzctr) obj;
            if (zzbg.equal(this.f4694a, zzctrVar.f4694a) && zzbg.equal(this.b, zzctrVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4694a, this.b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4694a, false);
        zzbgo.zza(parcel, 2, this.b, i, false);
        zzbgo.zzai(parcel, zze);
    }

    public final String zzbde() {
        return this.f4694a;
    }

    public final PayloadTransferUpdate zzbdm() {
        return this.b;
    }
}
