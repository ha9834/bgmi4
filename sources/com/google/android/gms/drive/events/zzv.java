package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.drive.zzh;
import java.util.List;

@SafeParcelable.Class(creator = "TransferStateEventCreator")
@SafeParcelable.Reserved({1, 2})
/* loaded from: classes.dex */
public final class zzv extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 3)
    private final List<zzh> f1548a;

    @SafeParcelable.Constructor
    public zzv(@SafeParcelable.Param(id = 3) List<zzh> list) {
        this.f1548a = list;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Objects.equal(this.f1548a, ((zzv) obj).f1548a);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 7;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f1548a);
    }

    public final String toString() {
        return String.format("TransferStateEvent[%s]", TextUtils.join("','", this.f1548a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 3, this.f1548a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
