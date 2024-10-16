package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DriveServiceResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzec extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzec> CREATOR = new zzed();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    final IBinder f3957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzec(@SafeParcelable.Param(id = 2) IBinder iBinder) {
        this.f3957a = iBinder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.f3957a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
