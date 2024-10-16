package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepName
@SafeParcelable.Class(creator = "PlusCommonExtrasCreator")
/* loaded from: classes2.dex */
public class PlusCommonExtras extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PlusCommonExtras> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1000)
    private final int f5045a;

    @SafeParcelable.Field(getter = "getGpsrc", id = 1)
    private String b;

    @SafeParcelable.Field(getter = "getClientCallingPackage", id = 2)
    private String c;

    public PlusCommonExtras() {
        this.f5045a = 1;
        this.b = "";
        this.c = "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PlusCommonExtras(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.f5045a = i;
        this.b = str;
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.f5045a == plusCommonExtras.f5045a && Objects.equal(this.b, plusCommonExtras.b) && Objects.equal(this.c, plusCommonExtras.c);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f5045a), this.b, this.c);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.f5045a)).add("Gpsrc", this.b).add("ClientCallingPackage", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.b, false);
        SafeParcelWriter.writeString(parcel, 2, this.c, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f5045a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
