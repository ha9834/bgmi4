package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SaveRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes2.dex */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "getCredential", id = 1)
    private final Credential f3814a;

    @SafeParcelable.Constructor
    public zzy(@SafeParcelable.Param(id = 1) Credential credential) {
        this.f3814a = credential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f3814a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
