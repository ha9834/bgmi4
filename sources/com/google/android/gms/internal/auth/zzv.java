package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DeviceMetaDataRequestCreator")
/* loaded from: classes2.dex */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f3838a;

    @SafeParcelable.Field(id = 2)
    private final String b;

    public zzv(String str) {
        this(1, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzv(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
        this.f3838a = 1;
        this.b = (String) Preconditions.checkNotNull(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f3838a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
