package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnSyncMoreResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzgb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgb> CREATOR = new zzgc();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final boolean f3979a;

    @SafeParcelable.Constructor
    public zzgb(@SafeParcelable.Param(id = 2) boolean z) {
        this.f3979a = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f3979a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
