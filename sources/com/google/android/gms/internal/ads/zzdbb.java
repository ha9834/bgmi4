package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassRequestParcelCreator")
/* loaded from: classes2.dex */
public final class zzdbb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdbb> CREATOR = new zzdbc();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f3532a;

    @SafeParcelable.Field(id = 2)
    private final String b;

    @SafeParcelable.Field(id = 3)
    private final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzdbb(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
        this.f3532a = i;
        this.b = str;
        this.c = str2;
    }

    public zzdbb(String str, String str2) {
        this(1, str, str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f3532a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
