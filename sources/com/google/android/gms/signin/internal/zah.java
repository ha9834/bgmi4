package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInRequestCreator")
/* loaded from: classes2.dex */
public final class zah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zah> CREATOR = new zai();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f5055a;

    @SafeParcelable.Field(getter = "getResolveAccountRequest", id = 2)
    private final ResolveAccountRequest b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zah(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ResolveAccountRequest resolveAccountRequest) {
        this.f5055a = i;
        this.b = resolveAccountRequest;
    }

    public zah(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f5055a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
