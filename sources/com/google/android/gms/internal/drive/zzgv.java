package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;

@SafeParcelable.Class(creator = "TrashResourceRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzgv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgv> CREATOR = new zzgw();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final DriveId f3989a;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzgv(@SafeParcelable.Param(id = 2) DriveId driveId) {
        this.f3989a = driveId;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f3989a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
