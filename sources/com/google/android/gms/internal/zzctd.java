package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctd extends zzbgl {
    public static final Parcelable.Creator<zzctd> CREATOR = new zzcte();

    /* renamed from: a, reason: collision with root package name */
    private String f4687a;
    private String b;
    private byte[] c;

    private zzctd() {
    }

    @Hide
    public zzctd(String str, String str2, byte[] bArr) {
        this.f4687a = str;
        this.b = str2;
        this.c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctd) {
            zzctd zzctdVar = (zzctd) obj;
            if (zzbg.equal(this.f4687a, zzctdVar.f4687a) && zzbg.equal(this.b, zzctdVar.b) && Arrays.equals(this.c, zzctdVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4687a, this.b, Integer.valueOf(Arrays.hashCode(this.c))});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4687a, false);
        zzbgo.zza(parcel, 2, this.b, false);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zzai(parcel, zze);
    }

    public final String zzbde() {
        return this.f4687a;
    }

    public final String zzbdf() {
        return this.b;
    }

    public final byte[] zzbdh() {
        return this.c;
    }
}
