package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "SignInAccountCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(defaultValue = "", id = 4)
    @Deprecated
    private String f1253a;

    @SafeParcelable.Field(getter = "getGoogleSignInAccount", id = 7)
    private GoogleSignInAccount b;

    @SafeParcelable.Field(defaultValue = "", id = 8)
    @Deprecated
    private String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public SignInAccount(@SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 7) GoogleSignInAccount googleSignInAccount, @SafeParcelable.Param(id = 8) String str2) {
        this.b = googleSignInAccount;
        this.f1253a = Preconditions.checkNotEmpty(str, "8.3 and 8.4 SDKs require non-null email");
        this.c = Preconditions.checkNotEmpty(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    @Nullable
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 4, this.f1253a, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.b, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
