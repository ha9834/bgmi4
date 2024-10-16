package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassEventParcelCreator")
/* loaded from: classes2.dex */
public final class zzday extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzday> CREATOR = new zzdaz();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f3531a;

    @SafeParcelable.Field(id = 2)
    private final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzday(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.f3531a = i;
        this.b = bArr;
    }

    public zzday(byte[] bArr) {
        this(1, bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f3531a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
