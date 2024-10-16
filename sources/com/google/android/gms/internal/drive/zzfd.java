package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnDeviceUsagePreferenceResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzfd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfd> CREATOR = new zzfe();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    final zzei f3966a;

    @SafeParcelable.Constructor
    public zzfd(@SafeParcelable.Param(id = 2) zzei zzeiVar) {
        this.f3966a = zzeiVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f3966a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzei zzaj() {
        return this.f3966a;
    }
}
