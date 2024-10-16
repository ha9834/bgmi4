package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInConfigurationCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzx();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "getConsumerPkgName", id = 2)
    private final String f1258a;

    @SafeParcelable.Field(getter = "getGoogleConfig", id = 5)
    private GoogleSignInOptions b;

    @SafeParcelable.Constructor
    public SignInConfiguration(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 5) GoogleSignInOptions googleSignInOptions) {
        this.f1258a = Preconditions.checkNotEmpty(str);
        this.b = googleSignInOptions;
    }

    public final GoogleSignInOptions zzm() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f1258a, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.b, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f1258a.equals(signInConfiguration.f1258a)) {
            GoogleSignInOptions googleSignInOptions = this.b;
            if (googleSignInOptions == null) {
                if (signInConfiguration.b == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new HashAccumulator().addObject(this.f1258a).addObject(this.b).hash();
    }
}
