package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzath extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzath> CREATOR = new zzati();

    @SafeParcelable.Field(id = 3)
    public final String zzchk;

    @SafeParcelable.Field(id = 2)
    public final zzxz zzdlk;

    @SafeParcelable.Constructor
    public zzath(@SafeParcelable.Param(id = 2) zzxz zzxzVar, @SafeParcelable.Param(id = 3) String str) {
        this.zzdlk = zzxzVar;
        this.zzchk = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdlk, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzchk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
