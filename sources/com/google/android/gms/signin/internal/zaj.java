package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInResponseCreator")
/* loaded from: classes2.dex */
public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new zak();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f5056a;

    @SafeParcelable.Field(getter = "getConnectionResult", id = 2)
    private final ConnectionResult b;

    @SafeParcelable.Field(getter = "getResolveAccountResponse", id = 3)
    private final ResolveAccountResponse c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zaj(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(id = 3) ResolveAccountResponse resolveAccountResponse) {
        this.f5056a = i;
        this.b = connectionResult;
        this.c = resolveAccountResponse;
    }

    public zaj(int i) {
        this(new ConnectionResult(8, null), null);
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }

    public final ConnectionResult getConnectionResult() {
        return this.b;
    }

    public final ResolveAccountResponse zacx() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f5056a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.c, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
