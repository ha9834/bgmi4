package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class n implements WorkAccountApi.AddAccountResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f3824a;
    private final Account b;

    public n(Status status, Account account) {
        this.f3824a = status;
        this.b = account;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f3824a;
    }

    @Override // com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult
    public final Account getAccount() {
        return this.b;
    }
}
