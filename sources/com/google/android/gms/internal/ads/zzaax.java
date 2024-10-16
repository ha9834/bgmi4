package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "IconAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzaax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaax> CREATOR = new zzaay();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final int f2682a;

    @SafeParcelable.Constructor
    public zzaax(@SafeParcelable.Param(id = 2) int i) {
        this.f2682a = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f2682a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
