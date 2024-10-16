package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserChallengeRequestCreator")
/* loaded from: classes2.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f3831a;

    @SafeParcelable.Field(id = 2)
    private final String b;

    @SafeParcelable.Field(id = 3)
    private final PendingIntent c;

    public zzah(String str, PendingIntent pendingIntent) {
        this(1, str, pendingIntent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzah(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent) {
        this.f3831a = 1;
        this.b = (String) Preconditions.checkNotNull(str);
        this.c = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f3831a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.c, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
