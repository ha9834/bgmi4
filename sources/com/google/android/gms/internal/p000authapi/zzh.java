package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public final class zzh implements CredentialRequestResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f3812a;
    private final Credential b;

    public zzh(Status status, Credential credential) {
        this.f3812a = status;
        this.b = credential;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f3812a;
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialRequestResult
    public final Credential getCredential() {
        return this.b;
    }

    public static zzh zzd(Status status) {
        return new zzh(status, null);
    }
}
