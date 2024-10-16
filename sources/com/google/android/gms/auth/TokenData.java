package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "TokenDataCreator")
/* loaded from: classes.dex */
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f1215a;

    @SafeParcelable.Field(getter = "getToken", id = 2)
    private final String b;

    @SafeParcelable.Field(getter = "getExpirationTimeSecs", id = 3)
    private final Long c;

    @SafeParcelable.Field(getter = "isCached", id = 4)
    private final boolean d;

    @SafeParcelable.Field(getter = "isSnowballed", id = 5)
    private final boolean e;

    @SafeParcelable.Field(getter = "getGrantedScopes", id = 6)
    private final List<String> f;

    @SafeParcelable.Field(getter = "getScopeData", id = 7)
    private final String g;

    public static TokenData zza(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public TokenData(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) Long l, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) String str2) {
        this.f1215a = i;
        this.b = Preconditions.checkNotEmpty(str);
        this.c = l;
        this.d = z;
        this.e = z2;
        this.f = list;
        this.g = str2;
    }

    public final String zzb() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.b, tokenData.b) && Objects.equal(this.c, tokenData.c) && this.d == tokenData.d && this.e == tokenData.e && Objects.equal(this.f, tokenData.f) && Objects.equal(this.g, tokenData.g);
    }

    public int hashCode() {
        return Objects.hashCode(this.b, this.c, Boolean.valueOf(this.d), Boolean.valueOf(this.e), this.f, this.g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f1215a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeLongObject(parcel, 3, this.c, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.e);
        SafeParcelWriter.writeStringList(parcel, 6, this.f, false);
        SafeParcelWriter.writeString(parcel, 7, this.g, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
