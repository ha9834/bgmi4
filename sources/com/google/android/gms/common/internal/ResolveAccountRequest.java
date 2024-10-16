package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountRequestCreator")
/* loaded from: classes.dex */
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zam();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f1459a;

    @SafeParcelable.Field(getter = "getAccount", id = 2)
    private final Account b;

    @SafeParcelable.Field(getter = "getSessionId", id = 3)
    private final int c;

    @SafeParcelable.Field(getter = "getSignInAccountHint", id = 4)
    private final GoogleSignInAccount d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ResolveAccountRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Account account, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.f1459a = i;
        this.b = account;
        this.c = i2;
        this.d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account getAccount() {
        return this.b;
    }

    public int getSessionId() {
        return this.c;
    }

    public GoogleSignInAccount getSignInAccountHint() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f1459a);
        SafeParcelWriter.writeParcelable(parcel, 2, getAccount(), i, false);
        SafeParcelWriter.writeInt(parcel, 3, getSessionId());
        SafeParcelWriter.writeParcelable(parcel, 4, getSignInAccountHint(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
