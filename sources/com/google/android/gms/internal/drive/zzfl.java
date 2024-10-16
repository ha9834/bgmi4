package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnFetchThumbnailResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzfl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfl> CREATOR = new zzfm();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final ParcelFileDescriptor f3970a;

    @SafeParcelable.Constructor
    public zzfl(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.f3970a = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f3970a, i | 1, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
