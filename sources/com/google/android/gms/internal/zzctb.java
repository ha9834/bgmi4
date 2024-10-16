package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctb extends zzbgl {
    public static final Parcelable.Creator<zzctb> CREATOR = new zzctc();

    /* renamed from: a, reason: collision with root package name */
    private String f4686a;
    private String b;
    private String c;
    private boolean d;
    private byte[] e;

    private zzctb() {
    }

    @Hide
    public zzctb(String str, String str2, String str3, boolean z, byte[] bArr) {
        this.f4686a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctb) {
            zzctb zzctbVar = (zzctb) obj;
            if (zzbg.equal(this.f4686a, zzctbVar.f4686a) && zzbg.equal(this.b, zzctbVar.b) && zzbg.equal(this.c, zzctbVar.c) && zzbg.equal(Boolean.valueOf(this.d), Boolean.valueOf(zzctbVar.d)) && Arrays.equals(this.e, zzctbVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final String getAuthenticationToken() {
        return this.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4686a, this.b, this.c, Boolean.valueOf(this.d), Integer.valueOf(Arrays.hashCode(this.e))});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4686a, false);
        zzbgo.zza(parcel, 2, this.b, false);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zza(parcel, 4, this.d);
        zzbgo.zza(parcel, 5, this.e, false);
        zzbgo.zzai(parcel, zze);
    }

    public final String zzbde() {
        return this.f4686a;
    }

    public final String zzbdf() {
        return this.b;
    }

    public final boolean zzbdg() {
        return this.d;
    }
}
