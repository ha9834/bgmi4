package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctv extends zzbgl {
    public static final Parcelable.Creator<zzctv> CREATOR = new zzctw();

    /* renamed from: a, reason: collision with root package name */
    private int f4696a;

    private zzctv() {
    }

    @Hide
    public zzctv(int i) {
        this.f4696a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctv) {
            return zzbg.equal(Integer.valueOf(this.f4696a), Integer.valueOf(((zzctv) obj).f4696a));
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4696a)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f4696a);
        zzbgo.zzai(parcel, zze);
    }
}
