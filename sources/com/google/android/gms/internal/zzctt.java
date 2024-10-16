package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctt extends zzbgl {
    public static final Parcelable.Creator<zzctt> CREATOR = new zzctu();

    /* renamed from: a, reason: collision with root package name */
    private int f4695a;
    private String b;

    private zzctt() {
    }

    @Hide
    public zzctt(int i, String str) {
        this.f4695a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctt) {
            zzctt zzcttVar = (zzctt) obj;
            if (zzbg.equal(Integer.valueOf(this.f4695a), Integer.valueOf(zzcttVar.f4695a)) && zzbg.equal(this.b, zzcttVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final String getLocalEndpointName() {
        return this.b;
    }

    public final int getStatusCode() {
        return this.f4695a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4695a), this.b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f4695a);
        zzbgo.zza(parcel, 2, this.b, false);
        zzbgo.zzai(parcel, zze);
    }
}
