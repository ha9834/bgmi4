package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator = "CredentialPickerConfigCreator")
/* loaded from: classes.dex */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1000)
    private final int f1238a;

    @SafeParcelable.Field(getter = "shouldShowAddAccountButton", id = 1)
    private final boolean b;

    @SafeParcelable.Field(getter = "shouldShowCancelButton", id = 2)
    private final boolean c;

    @SafeParcelable.Field(getter = "isForNewAccount", id = 3)
    @Deprecated
    private final boolean d;

    @SafeParcelable.Field(getter = "getPromptInternalId", id = 4)
    private final int e;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public CredentialPickerConfig(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) int i2) {
        this.f1238a = i;
        this.b = z;
        this.c = z2;
        if (i < 2) {
            this.d = z3;
            this.e = z3 ? 3 : 1;
        } else {
            this.d = i2 == 3;
            this.e = i2;
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1239a = false;
        private boolean b = true;
        private int c = 1;

        public Builder setShowAddAccountButton(boolean z) {
            this.f1239a = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setPrompt(int i) {
            this.c = i;
            return this;
        }

        @Deprecated
        public Builder setForNewAccount(boolean z) {
            this.c = z ? 3 : 1;
            return this;
        }

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.f1239a, builder.b, false, builder.c);
    }

    public final boolean shouldShowAddAccountButton() {
        return this.b;
    }

    public final boolean shouldShowCancelButton() {
        return this.c;
    }

    @Deprecated
    public final boolean isForNewAccount() {
        return this.e == 3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, shouldShowAddAccountButton());
        SafeParcelWriter.writeBoolean(parcel, 2, shouldShowCancelButton());
        SafeParcelWriter.writeBoolean(parcel, 3, isForNewAccount());
        SafeParcelWriter.writeInt(parcel, 4, this.e);
        SafeParcelWriter.writeInt(parcel, 1000, this.f1238a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
