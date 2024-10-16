package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnRealtimeLoadedResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzfr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfr> CREATOR = new zzfw();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final boolean f3973a;

    @SafeParcelable.Constructor
    public zzfr(@SafeParcelable.Param(id = 2) boolean z) {
        this.f3973a = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f3973a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
