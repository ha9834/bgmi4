package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SafeParcelable.Class(creator = "CredentialRequestCreator")
/* loaded from: classes.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1000)
    private final int f1240a;

    @SafeParcelable.Field(getter = "isPasswordLoginSupported", id = 1)
    private final boolean b;

    @SafeParcelable.Field(getter = "getAccountTypes", id = 2)
    private final String[] c;

    @SafeParcelable.Field(getter = "getCredentialPickerConfig", id = 3)
    private final CredentialPickerConfig d;

    @SafeParcelable.Field(getter = "getCredentialHintPickerConfig", id = 4)
    private final CredentialPickerConfig e;

    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 5)
    private final boolean f;

    @SafeParcelable.Field(getter = "getServerClientId", id = 6)
    private final String g;

    @SafeParcelable.Field(getter = "getIdTokenNonce", id = 7)
    private final String h;

    @SafeParcelable.Field(getter = "getRequireUserMediation", id = 8)
    private final boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public CredentialRequest(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 4) CredentialPickerConfig credentialPickerConfig2, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z3) {
        this.f1240a = i;
        this.b = z;
        this.c = (String[]) Preconditions.checkNotNull(strArr);
        this.d = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.e = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig2;
        if (i < 3) {
            this.f = true;
            this.g = null;
            this.h = null;
        } else {
            this.f = z2;
            this.g = str;
            this.h = str2;
        }
        this.i = z3;
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1241a;
        private String[] b;
        private CredentialPickerConfig c;
        private CredentialPickerConfig d;
        private boolean e = false;
        private boolean f = false;
        private String g = null;
        private String h;

        @Deprecated
        public final Builder setSupportsPasswordLogin(boolean z) {
            return setPasswordLoginSupported(z);
        }

        public final Builder setPasswordLoginSupported(boolean z) {
            this.f1241a = z;
            return this;
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.b = strArr;
            return this;
        }

        public final Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.c = credentialPickerConfig;
            return this;
        }

        public final Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.d = credentialPickerConfig;
            return this;
        }

        public final Builder setIdTokenRequested(boolean z) {
            this.e = z;
            return this;
        }

        public final Builder setServerClientId(String str) {
            this.g = str;
            return this;
        }

        public final Builder setIdTokenNonce(String str) {
            this.h = str;
            return this;
        }

        public final CredentialRequest build() {
            if (this.b == null) {
                this.b = new String[0];
            }
            if (!this.f1241a && this.b.length == 0) {
                throw new IllegalStateException("At least one authentication method must be specified");
            }
            return new CredentialRequest(this);
        }
    }

    private CredentialRequest(Builder builder) {
        this(4, builder.f1241a, builder.b, builder.c, builder.d, builder.e, builder.g, builder.h, false);
    }

    @Deprecated
    public final boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public final boolean isPasswordLoginSupported() {
        return this.b;
    }

    public final String[] getAccountTypes() {
        return this.c;
    }

    public final Set<String> getAccountTypesSet() {
        return new HashSet(Arrays.asList(this.c));
    }

    public final CredentialPickerConfig getCredentialPickerConfig() {
        return this.d;
    }

    public final CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.e;
    }

    public final boolean isIdTokenRequested() {
        return this.f;
    }

    public final String getServerClientId() {
        return this.g;
    }

    public final String getIdTokenNonce() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isPasswordLoginSupported());
        SafeParcelWriter.writeStringArray(parcel, 2, getAccountTypes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getCredentialPickerConfig(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getCredentialHintPickerConfig(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f1240a);
        SafeParcelWriter.writeBoolean(parcel, 8, this.i);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
