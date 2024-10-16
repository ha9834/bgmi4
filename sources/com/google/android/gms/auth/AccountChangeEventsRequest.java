package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AccountChangeEventsRequestCreator")
/* loaded from: classes.dex */
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f1212a;

    @SafeParcelable.Field(id = 2)
    private int b;

    @SafeParcelable.Field(id = 3)
    @Deprecated
    private String c;

    @SafeParcelable.Field(id = 4)
    private Account d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AccountChangeEventsRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) Account account) {
        this.f1212a = i;
        this.b = i2;
        this.c = str;
        if (account == null && !TextUtils.isEmpty(str)) {
            this.d = new Account(str, "com.google");
        } else {
            this.d = account;
        }
    }

    public AccountChangeEventsRequest() {
        this.f1212a = 1;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.b = i;
        return this;
    }

    @Deprecated
    public AccountChangeEventsRequest setAccountName(String str) {
        this.c = str;
        return this;
    }

    @Deprecated
    public String getAccountName() {
        return this.c;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.d = account;
        return this;
    }

    public Account getAccount() {
        return this.d;
    }

    public int getEventIndex() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f1212a);
        SafeParcelWriter.writeInt(parcel, 2, this.b);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.d, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
