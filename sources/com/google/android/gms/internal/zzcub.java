package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcub extends zzbgl {
    public static final Parcelable.Creator<zzcub> CREATOR = new zzcuc();

    /* renamed from: a, reason: collision with root package name */
    private long f4699a;
    private int b;
    private byte[] c;
    private ParcelFileDescriptor d;
    private String e;
    private long f;
    private ParcelFileDescriptor g;

    private zzcub() {
    }

    @Hide
    public zzcub(long j, int i, byte[] bArr, ParcelFileDescriptor parcelFileDescriptor, String str, long j2, ParcelFileDescriptor parcelFileDescriptor2) {
        this.f4699a = j;
        this.b = i;
        this.c = bArr;
        this.d = parcelFileDescriptor;
        this.e = str;
        this.f = j2;
        this.g = parcelFileDescriptor2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcub) {
            zzcub zzcubVar = (zzcub) obj;
            if (zzbg.equal(Long.valueOf(this.f4699a), Long.valueOf(zzcubVar.f4699a)) && zzbg.equal(Integer.valueOf(this.b), Integer.valueOf(zzcubVar.b)) && Arrays.equals(this.c, zzcubVar.c) && zzbg.equal(this.d, zzcubVar.d) && zzbg.equal(this.e, zzcubVar.e) && zzbg.equal(Long.valueOf(this.f), Long.valueOf(zzcubVar.f)) && zzbg.equal(this.g, zzcubVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final byte[] getBytes() {
        return this.c;
    }

    public final long getId() {
        return this.f4699a;
    }

    public final int getType() {
        return this.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f4699a), Integer.valueOf(this.b), Integer.valueOf(Arrays.hashCode(this.c)), this.d, this.e, Long.valueOf(this.f), this.g});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4699a);
        zzbgo.zzc(parcel, 2, this.b);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zza(parcel, 4, this.d, i, false);
        zzbgo.zza(parcel, 5, this.e, false);
        zzbgo.zza(parcel, 6, this.f);
        zzbgo.zza(parcel, 7, this.g, i, false);
        zzbgo.zzai(parcel, zze);
    }

    public final ParcelFileDescriptor zzbdn() {
        return this.d;
    }

    public final String zzbdo() {
        return this.e;
    }

    public final long zzbdp() {
        return this.f;
    }
}
