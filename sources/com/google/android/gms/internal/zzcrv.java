package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcrv extends zzbgl {
    public static final Parcelable.Creator<zzcrv> CREATOR = new zzcrw();

    /* renamed from: a, reason: collision with root package name */
    private String f4684a;

    private zzcrv() {
    }

    @Hide
    public zzcrv(String str) {
        this.f4684a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcrv) {
            return zzbg.equal(this.f4684a, ((zzcrv) obj).f4684a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4684a});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4684a, false);
        zzbgo.zzai(parcel, zze);
    }
}
