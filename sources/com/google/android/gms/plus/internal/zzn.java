package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PlusSessionCreator")
/* loaded from: classes2.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1000)
    private final int f5050a;

    @SafeParcelable.Field(getter = "getAccountName", id = 1)
    private final String b;

    @SafeParcelable.Field(getter = "getRequestedScopes", id = 2)
    private final String[] c;

    @SafeParcelable.Field(getter = "getVisibleActions", id = 3)
    private final String[] d;

    @SafeParcelable.Field(getter = "getRequiredFeatures", id = 4)
    private final String[] e;

    @SafeParcelable.Field(getter = "getPackageNameForAuth", id = 5)
    private final String f;

    @SafeParcelable.Field(getter = "getCallingPackageName", id = 6)
    private final String g;

    @SafeParcelable.Field(getter = "getApplicationName", id = 7)
    private final String h;

    @SafeParcelable.Field(getter = "getClientId_DEPRECATED", id = 8)
    private final String i;

    @SafeParcelable.Field(getter = "getExtras", id = 9)
    private final PlusCommonExtras j;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzn(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) String[] strArr2, @SafeParcelable.Param(id = 4) String[] strArr3, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) String str4, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) PlusCommonExtras plusCommonExtras) {
        this.f5050a = i;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = plusCommonExtras;
    }

    public zzn(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.f5050a = 1;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str2;
        this.g = str3;
        this.h = null;
        this.i = null;
        this.j = plusCommonExtras;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        return this.f5050a == zznVar.f5050a && Objects.equal(this.b, zznVar.b) && Arrays.equals(this.c, zznVar.c) && Arrays.equals(this.d, zznVar.d) && Arrays.equals(this.e, zznVar.e) && Objects.equal(this.f, zznVar.f) && Objects.equal(this.g, zznVar.g) && Objects.equal(this.h, zznVar.h) && Objects.equal(this.i, zznVar.i) && Objects.equal(this.j, zznVar.j);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f5050a), this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.f5050a)).add("accountName", this.b).add("requestedScopes", this.c).add("visibleActivities", this.d).add("requiredFeatures", this.e).add("packageNameForAuth", this.f).add("callingPackageName", this.g).add("applicationName", this.h).add("extra", this.j.toString()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.b, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.c, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.d, false);
        SafeParcelWriter.writeStringArray(parcel, 4, this.e, false);
        SafeParcelWriter.writeString(parcel, 5, this.f, false);
        SafeParcelWriter.writeString(parcel, 6, this.g, false);
        SafeParcelWriter.writeString(parcel, 7, this.h, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f5050a);
        SafeParcelWriter.writeString(parcel, 8, this.i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.j, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String[] zzc() {
        return this.d;
    }

    public final String zzd() {
        return this.f;
    }

    public final Bundle zze() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", SafeParcelableSerializer.serializeToBytes(this.j));
        return bundle;
    }
}
