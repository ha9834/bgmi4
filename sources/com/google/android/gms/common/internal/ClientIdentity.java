package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new zab();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(defaultValueUnchecked = "0", id = 1)
    private final int f1444a;

    @SafeParcelable.Field(defaultValueUnchecked = com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID, id = 2)
    private final String b;

    @SafeParcelable.Constructor
    public ClientIdentity(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
        this.f1444a = i;
        this.b = str;
    }

    public int hashCode() {
        return this.f1444a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f1444a == this.f1444a && Objects.equal(clientIdentity.b, this.b);
    }

    public String toString() {
        int i = this.f1444a;
        String str = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f1444a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
