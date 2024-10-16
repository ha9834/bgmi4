package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcth extends zzbgl {
    public static final Parcelable.Creator<zzcth> CREATOR = new zzcti();

    /* renamed from: a, reason: collision with root package name */
    private String f4689a;
    private int b;
    private byte[] c;

    private zzcth() {
    }

    @Hide
    public zzcth(String str, int i, byte[] bArr) {
        this.f4689a = str;
        this.b = i;
        this.c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcth) {
            zzcth zzcthVar = (zzcth) obj;
            if (zzbg.equal(this.f4689a, zzcthVar.f4689a) && zzbg.equal(Integer.valueOf(this.b), Integer.valueOf(zzcthVar.b)) && Arrays.equals(this.c, zzcthVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int getStatusCode() {
        return this.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4689a, Integer.valueOf(this.b), Integer.valueOf(Arrays.hashCode(this.c))});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4689a, false);
        zzbgo.zzc(parcel, 2, this.b);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zzai(parcel, zze);
    }

    public final String zzbde() {
        return this.f4689a;
    }
}
