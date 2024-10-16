package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctp extends zzbgl {
    public static final Parcelable.Creator<zzctp> CREATOR = new zzctq();

    /* renamed from: a, reason: collision with root package name */
    private String f4693a;
    private zzcub b;
    private boolean c;

    private zzctp() {
    }

    @Hide
    public zzctp(String str, zzcub zzcubVar, boolean z) {
        this.f4693a = str;
        this.b = zzcubVar;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctp) {
            zzctp zzctpVar = (zzctp) obj;
            if (zzbg.equal(this.f4693a, zzctpVar.f4693a) && zzbg.equal(this.b, zzctpVar.b) && zzbg.equal(Boolean.valueOf(this.c), Boolean.valueOf(zzctpVar.c))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4693a, this.b, Boolean.valueOf(this.c)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4693a, false);
        zzbgo.zza(parcel, 2, this.b, i, false);
        zzbgo.zza(parcel, 3, this.c);
        zzbgo.zzai(parcel, zze);
    }

    public final String zzbde() {
        return this.f4693a;
    }

    public final zzcub zzbdk() {
        return this.b;
    }

    public final boolean zzbdl() {
        return this.c;
    }
}
