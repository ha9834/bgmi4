package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;

/* loaded from: classes.dex */
public final class zzcuq extends zzbgl {
    public static final Parcelable.Creator<zzcuq> CREATOR = new zzcur();

    @Hide
    public zzcuq() {
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof zzcuq);
    }

    public final int hashCode() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzbgo.zzai(parcel, zzbgo.zze(parcel));
    }
}
