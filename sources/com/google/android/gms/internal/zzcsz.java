package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcsz extends zzbgl {
    public static final Parcelable.Creator<zzcsz> CREATOR = new zzcta();

    /* renamed from: a, reason: collision with root package name */
    private String f4685a;
    private int b;

    private zzcsz() {
    }

    @Hide
    public zzcsz(String str, int i) {
        this.f4685a = str;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcsz) {
            zzcsz zzcszVar = (zzcsz) obj;
            if (zzbg.equal(this.f4685a, zzcszVar.f4685a) && zzbg.equal(Integer.valueOf(this.b), Integer.valueOf(zzcszVar.b))) {
                return true;
            }
        }
        return false;
    }

    public final int getQuality() {
        return this.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4685a, Integer.valueOf(this.b)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4685a, false);
        zzbgo.zzc(parcel, 2, this.b);
        zzbgo.zzai(parcel, zze);
    }

    public final String zzbde() {
        return this.f4685a;
    }
}
