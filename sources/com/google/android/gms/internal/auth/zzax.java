package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzax implements ProxyApi.SpatulaHeaderResult {

    /* renamed from: a, reason: collision with root package name */
    private Status f3832a;
    private String b;

    public zzax(@Nonnull String str) {
        this.b = (String) Preconditions.checkNotNull(str);
        this.f3832a = Status.RESULT_SUCCESS;
    }

    public zzax(@Nonnull Status status) {
        this.f3832a = (Status) Preconditions.checkNotNull(status);
    }

    @Override // com.google.android.gms.common.api.Result
    @Nullable
    public final Status getStatus() {
        return this.f3832a;
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult
    @Nullable
    public final String getSpatulaHeader() {
        return this.b;
    }
}
