package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctx extends zzbgl {
    public static final Parcelable.Creator<zzctx> CREATOR = new zzcty();

    /* renamed from: a, reason: collision with root package name */
    private int f4697a;

    private zzctx() {
    }

    @Hide
    public zzctx(int i) {
        this.f4697a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctx) {
            return zzbg.equal(Integer.valueOf(this.f4697a), Integer.valueOf(((zzctx) obj).f4697a));
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4697a)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f4697a);
        zzbgo.zzai(parcel, zze);
    }
}
