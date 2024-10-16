package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RetrieveDataRequestCreator")
/* loaded from: classes2.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f3829a;

    @SafeParcelable.Field(id = 2)
    private final String b;

    public zzad(String str) {
        this(1, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzad(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
        this.f3829a = 1;
        this.b = (String) Preconditions.checkNotNull(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f3829a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
