package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class g implements ProxyApi.ProxyResult {

    /* renamed from: a, reason: collision with root package name */
    private Status f3818a;
    private ProxyResponse b;

    public g(ProxyResponse proxyResponse) {
        this.b = proxyResponse;
        this.f3818a = Status.RESULT_SUCCESS;
    }

    public g(Status status) {
        this.f3818a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f3818a;
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult
    public final ProxyResponse getResponse() {
        return this.b;
    }
}
