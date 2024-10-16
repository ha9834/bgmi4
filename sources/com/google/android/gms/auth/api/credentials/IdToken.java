package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "IdTokenCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "getAccountType", id = 1)
    private final String f1244a;

    @SafeParcelable.Field(getter = "getIdToken", id = 2)
    private final String b;

    @SafeParcelable.Constructor
    public IdToken(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        Preconditions.checkArgument(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.f1244a = str;
        this.b = str2;
    }

    public final String getAccountType() {
        return this.f1244a;
    }

    public final String getIdToken() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 2, getIdToken(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return Objects.equal(this.f1244a, idToken.f1244a) && Objects.equal(this.b, idToken.b);
    }
}
