package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class o implements Result {

    /* renamed from: a, reason: collision with root package name */
    private final Status f3825a;

    public o(Status status) {
        this.f3825a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f3825a;
    }
}
