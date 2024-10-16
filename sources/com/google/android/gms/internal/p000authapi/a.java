package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a extends g<CredentialRequestResult> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CredentialRequest f3804a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(zzi zziVar, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        super(googleApiClient);
        this.f3804a = credentialRequest;
    }

    @Override // com.google.android.gms.internal.p000authapi.g
    protected final void a(Context context, zzw zzwVar) throws RemoteException {
        zzwVar.zzc(new b(this), this.f3804a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return zzh.zzd(status);
    }
}
