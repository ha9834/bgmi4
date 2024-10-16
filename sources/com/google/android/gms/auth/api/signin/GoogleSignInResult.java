package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class GoogleSignInResult implements Result {

    /* renamed from: a, reason: collision with root package name */
    private Status f1252a;
    private GoogleSignInAccount b;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.b = googleSignInAccount;
        this.f1252a = status;
    }

    public GoogleSignInAccount getSignInAccount() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f1252a;
    }

    public boolean isSuccess() {
        return this.f1252a.isSuccess();
    }
}
