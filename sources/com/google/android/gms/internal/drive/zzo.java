package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;

@SafeParcelable.Class(creator = "CloseContentsRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private final Contents f4003a;

    @SafeParcelable.Field(id = 3)
    private final Boolean b;

    @SafeParcelable.Field(id = 4)
    private final int c;

    @VisibleForTesting
    public zzo(int i, boolean z) {
        this(null, false, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 2) Contents contents, @SafeParcelable.Param(id = 3) Boolean bool, @SafeParcelable.Param(id = 4) int i) {
        this.f4003a = contents;
        this.b = bool;
        this.c = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f4003a, i, false);
        SafeParcelWriter.writeBooleanObject(parcel, 3, this.b, false);
        SafeParcelWriter.writeInt(parcel, 4, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
