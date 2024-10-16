package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

@SafeParcelable.Class(creator = "CredentialCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zzc();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";

    /* renamed from: a, reason: collision with root package name */
    @Nonnull
    @SafeParcelable.Field(getter = "getId", id = 1)
    private final String f1236a;

    @SafeParcelable.Field(getter = "getName", id = 2)
    private final String b;

    @SafeParcelable.Field(getter = "getProfilePictureUri", id = 3)
    private final Uri c;

    @Nonnull
    @SafeParcelable.Field(getter = "getIdTokens", id = 4)
    private final List<IdToken> d;

    @SafeParcelable.Field(getter = "getPassword", id = 5)
    private final String e;

    @SafeParcelable.Field(getter = "getAccountType", id = 6)
    private final String f;

    @SafeParcelable.Field(getter = "getGivenName", id = 9)
    private final String g;

    @SafeParcelable.Field(getter = "getFamilyName", id = 10)
    private final String h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Credential(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) Uri uri, @SafeParcelable.Param(id = 4) List<IdToken> list, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 9) String str5, @SafeParcelable.Param(id = 10) String str6) {
        List<IdToken> unmodifiableList;
        String trim = ((String) Preconditions.checkNotNull(str, "credential identifier cannot be null")).trim();
        Preconditions.checkNotEmpty(trim, "credential identifier cannot be empty");
        if (str3 != null && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password must not be empty if set");
        }
        if (str4 != null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(str4);
                if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme()))) {
                    z = true;
                }
            }
            if (!Boolean.valueOf(z).booleanValue()) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.b = str2;
        this.c = uri;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.d = unmodifiableList;
        this.f1236a = trim;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final String f1237a;
        private String b;
        private Uri c;
        private List<IdToken> d;
        private String e;
        private String f;
        private String g;
        private String h;

        public Builder(String str) {
            this.f1237a = str;
        }

        public Builder(Credential credential) {
            this.f1237a = credential.f1236a;
            this.b = credential.b;
            this.c = credential.c;
            this.d = credential.d;
            this.e = credential.e;
            this.f = credential.f;
            this.g = credential.g;
            this.h = credential.h;
        }

        public Builder setName(String str) {
            this.b = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.c = uri;
            return this;
        }

        public Builder setPassword(String str) {
            this.e = str;
            return this;
        }

        public Builder setAccountType(String str) {
            this.f = str;
            return this;
        }

        public Credential build() {
            return new Credential(this.f1237a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    @Nonnull
    public String getId() {
        return this.f1236a;
    }

    public String getName() {
        return this.b;
    }

    public Uri getProfilePictureUri() {
        return this.c;
    }

    @Nonnull
    public List<IdToken> getIdTokens() {
        return this.d;
    }

    public String getPassword() {
        return this.e;
    }

    public String getAccountType() {
        return this.f;
    }

    public String getGivenName() {
        return this.g;
    }

    public String getFamilyName() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getProfilePictureUri(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 4, getIdTokens(), false);
        SafeParcelWriter.writeString(parcel, 5, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 6, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 9, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 10, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f1236a, credential.f1236a) && TextUtils.equals(this.b, credential.b) && Objects.equal(this.c, credential.c) && TextUtils.equals(this.e, credential.e) && TextUtils.equals(this.f, credential.f);
    }

    public int hashCode() {
        return Objects.hashCode(this.f1236a, this.b, this.c, this.e, this.f);
    }
}
