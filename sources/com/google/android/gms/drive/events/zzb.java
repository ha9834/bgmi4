package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

@SafeParcelable.Class(creator = "ChangesAvailableEventCreator")
@SafeParcelable.Reserved({1, 2})
/* loaded from: classes.dex */
public final class zzb extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 3)
    private final zze f1543a;

    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param(id = 3) zze zzeVar) {
        this.f1543a = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Objects.equal(this.f1543a, ((zzb) obj).f1543a);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 4;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f1543a);
    }

    public final String toString() {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", this.f1543a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f1543a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
