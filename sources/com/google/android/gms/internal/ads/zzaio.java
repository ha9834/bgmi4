package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "AdapterStatusParcelCreator")
/* loaded from: classes2.dex */
public final class zzaio extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaio> CREATOR = new zzaip();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final String f2739a;

    @SafeParcelable.Field(id = 4)
    public final String description;

    @SafeParcelable.Field(id = 2)
    public final boolean zzdbb;

    @SafeParcelable.Field(id = 3)
    public final int zzdbc;

    @SafeParcelable.Constructor
    public zzaio(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) String str2) {
        this.f2739a = str;
        this.zzdbb = z;
        this.zzdbc = i;
        this.description = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f2739a, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdbb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdbc);
        SafeParcelWriter.writeString(parcel, 4, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
