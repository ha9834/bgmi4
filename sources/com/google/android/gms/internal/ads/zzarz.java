package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "StringParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzarz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarz> CREATOR = new zzasa();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    String f2789a;

    @SafeParcelable.Constructor
    public zzarz(@SafeParcelable.Param(id = 2) String str) {
        this.f2789a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f2789a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
