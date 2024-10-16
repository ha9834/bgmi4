package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "CreateContentsRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.drive.DriveFile.MODE_WRITE_ONLY", id = 2)
    private final int f4004a;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(id = 2) int i) {
        Preconditions.checkArgument(i == 536870912 || i == 805306368, "Cannot create a new read-only contents!");
        this.f4004a = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f4004a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
