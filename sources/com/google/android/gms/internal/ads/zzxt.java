package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "AdDataParcelCreator")
/* loaded from: classes2.dex */
public final class zzxt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxt> CREATOR = new zzxu();

    @SafeParcelable.Field(id = 1)
    public final String zzcgj;

    @SafeParcelable.Field(id = 2)
    public final String zzcgk;

    @SafeParcelable.Constructor
    public zzxt(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zzcgj = str;
        this.zzcgk = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcgj, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
