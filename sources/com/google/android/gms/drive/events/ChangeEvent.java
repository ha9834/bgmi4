package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

@SafeParcelable.Class(creator = "ChangeEventCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class ChangeEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final Parcelable.Creator<ChangeEvent> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final DriveId f1537a;

    @SafeParcelable.Field(id = 3)
    private final int b;

    @SafeParcelable.Constructor
    public ChangeEvent(@SafeParcelable.Param(id = 2) DriveId driveId, @SafeParcelable.Param(id = 3) int i) {
        this.f1537a = driveId;
        this.b = i;
    }

    @Override // com.google.android.gms.drive.events.ResourceEvent
    public final DriveId getDriveId() {
        return this.f1537a;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 1;
    }

    public final boolean hasBeenDeleted() {
        return (this.b & 4) != 0;
    }

    public final boolean hasContentChanged() {
        return (this.b & 2) != 0;
    }

    public final boolean hasMetadataChanged() {
        return (this.b & 1) != 0;
    }

    public final String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", this.f1537a, Integer.valueOf(this.b));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f1537a, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
