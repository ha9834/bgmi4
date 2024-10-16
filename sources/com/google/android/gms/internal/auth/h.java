package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h extends BaseImplementation.ApiMethodImpl<Result, zzr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f3819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(zzh zzhVar, Api api, GoogleApiClient googleApiClient, boolean z) {
        super((Api<?>) api, googleApiClient);
        this.f3819a = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        return new o(status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzr zzrVar) throws RemoteException {
        ((com.google.android.gms.auth.account.zzc) zzrVar.getService()).zzb(this.f3819a);
        setResult((h) new o(Status.RESULT_SUCCESS));
    }
}
