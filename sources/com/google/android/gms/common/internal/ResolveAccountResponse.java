package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountResponseCreator")
/* loaded from: classes.dex */
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zan();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f1460a;

    @SafeParcelable.Field(id = 2)
    private IBinder b;

    @SafeParcelable.Field(getter = "getConnectionResult", id = 3)
    private ConnectionResult c;

    @SafeParcelable.Field(getter = "getSaveDefaultAccount", id = 4)
    private boolean d;

    @SafeParcelable.Field(getter = "isFromCrossClientAuth", id = 5)
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ResolveAccountResponse(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) ConnectionResult connectionResult, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2) {
        this.f1460a = i;
        this.b = iBinder;
        this.c = connectionResult;
        this.d = z;
        this.e = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, null));
    }

    public IAccountAccessor getAccountAccessor() {
        return IAccountAccessor.Stub.asInterface(this.b);
    }

    public ResolveAccountResponse setAccountAccessor(IAccountAccessor iAccountAccessor) {
        this.b = iAccountAccessor == null ? null : iAccountAccessor.asBinder();
        return this;
    }

    public ConnectionResult getConnectionResult() {
        return this.c;
    }

    public boolean getSaveDefaultAccount() {
        return this.d;
    }

    public ResolveAccountResponse setSaveDefaultAccount(boolean z) {
        this.d = z;
        return this;
    }

    public boolean isFromCrossClientAuth() {
        return this.e;
    }

    public ResolveAccountResponse setIsFromCrossClientAuth(boolean z) {
        this.e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f1460a);
        SafeParcelWriter.writeIBinder(parcel, 2, this.b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getConnectionResult(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, getSaveDefaultAccount());
        SafeParcelWriter.writeBoolean(parcel, 5, isFromCrossClientAuth());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.c.equals(resolveAccountResponse.c) && getAccountAccessor().equals(resolveAccountResponse.getAccountAccessor());
    }
}
