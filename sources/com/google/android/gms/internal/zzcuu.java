package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

@Hide
/* loaded from: classes.dex */
public final class zzcuu extends zzbgl {
    public static final Parcelable.Creator<zzcuu> CREATOR = new zzcuv();

    /* renamed from: a, reason: collision with root package name */
    private final int f4705a;
    private final ParcelUuid b;
    private final ParcelUuid c;
    private final ParcelUuid d;
    private final byte[] e;
    private final byte[] f;
    private final int g;
    private final byte[] h;
    private final byte[] i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcuu(int i, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4) {
        this.f4705a = i;
        this.b = parcelUuid;
        this.c = parcelUuid2;
        this.d = parcelUuid3;
        this.e = bArr;
        this.f = bArr2;
        this.g = i2;
        this.h = bArr3;
        this.i = bArr4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzcuu zzcuuVar = (zzcuu) obj;
            if (this.g == zzcuuVar.g && Arrays.equals(this.h, zzcuuVar.h) && Arrays.equals(this.i, zzcuuVar.i) && zzbg.equal(this.d, zzcuuVar.d) && Arrays.equals(this.e, zzcuuVar.e) && Arrays.equals(this.f, zzcuuVar.f) && zzbg.equal(this.b, zzcuuVar.b) && zzbg.equal(this.c, zzcuuVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.g), Integer.valueOf(Arrays.hashCode(this.h)), Integer.valueOf(Arrays.hashCode(this.i)), this.d, Integer.valueOf(Arrays.hashCode(this.e)), Integer.valueOf(Arrays.hashCode(this.f)), this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f4705a);
        zzbgo.zza(parcel, 4, this.b, i, false);
        zzbgo.zza(parcel, 5, this.c, i, false);
        zzbgo.zza(parcel, 6, this.d, i, false);
        zzbgo.zza(parcel, 7, this.e, false);
        zzbgo.zza(parcel, 8, this.f, false);
        zzbgo.zzc(parcel, 9, this.g);
        zzbgo.zza(parcel, 10, this.h, false);
        zzbgo.zza(parcel, 11, this.i, false);
        zzbgo.zzai(parcel, zze);
    }
}
