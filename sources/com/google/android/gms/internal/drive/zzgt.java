package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "StringListResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzgt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgt> CREATOR = new zzgu();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "getList", id = 2)
    private final List<String> f3988a;

    @SafeParcelable.Constructor
    public zzgt(@SafeParcelable.Param(id = 2) List<String> list) {
        this.f3988a = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 2, this.f3988a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
