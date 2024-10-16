package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SendDataRequestCreator")
/* loaded from: classes2.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f3830a;

    @SafeParcelable.Field(id = 2)
    private final String b;

    @SafeParcelable.Field(id = 3)
    private final byte[] c;

    public zzaf(String str, byte[] bArr) {
        this(1, str, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzaf(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) byte[] bArr) {
        this.f3830a = 1;
        this.b = (String) Preconditions.checkNotNull(str);
        this.c = (byte[]) Preconditions.checkNotNull(bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f3830a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
