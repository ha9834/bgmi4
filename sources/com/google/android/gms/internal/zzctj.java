package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctj extends zzbgl {
    public static final Parcelable.Creator<zzctj> CREATOR = new zzctk();

    /* renamed from: a, reason: collision with root package name */
    private String f4690a;

    private zzctj() {
    }

    @Hide
    public zzctj(String str) {
        this.f4690a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctj) {
            return zzbg.equal(this.f4690a, ((zzctj) obj).f4690a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4690a});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4690a, false);
        zzbgo.zzai(parcel, zze);
    }

    public final String zzbde() {
        return this.f4690a;
    }
}
