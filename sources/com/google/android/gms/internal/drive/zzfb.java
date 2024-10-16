package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

@SafeParcelable.Class(creator = "OnContentsResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzfb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfb> CREATOR = new zzfc();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    final Contents f3965a;

    @SafeParcelable.Field(id = 3)
    final boolean b;

    @SafeParcelable.Constructor
    public zzfb(@SafeParcelable.Param(id = 2) Contents contents, @SafeParcelable.Param(id = 3) boolean z) {
        this.f3965a = contents;
        this.b = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f3965a, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Contents zzai() {
        return this.f3965a;
    }
}
