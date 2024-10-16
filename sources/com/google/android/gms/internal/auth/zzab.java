package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NotifyCompletionRequestCreator")
/* loaded from: classes2.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new zzac();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f3828a;

    @SafeParcelable.Field(id = 2)
    private final String b;

    @SafeParcelable.Field(id = 3)
    private final int c;

    public zzab(String str, int i) {
        this(1, str, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzab(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2) {
        this.f3828a = 1;
        this.b = (String) Preconditions.checkNotNull(str);
        this.c = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f3828a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
