package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

@SafeParcelable.Class(creator = "OnDriveIdResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzfh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfh> CREATOR = new zzfi();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    DriveId f3968a;

    @SafeParcelable.Constructor
    public zzfh(@SafeParcelable.Param(id = 2) DriveId driveId) {
        this.f3968a = driveId;
    }

    public final DriveId getDriveId() {
        return this.f3968a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f3968a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
