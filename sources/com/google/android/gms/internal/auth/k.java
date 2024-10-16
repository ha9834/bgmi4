package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes2.dex */
final class k extends BaseImplementation.ApiMethodImpl<Result, zzr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Account f3822a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(zzh zzhVar, Api api, GoogleApiClient googleApiClient, Account account) {
        super((Api<?>) api, googleApiClient);
        this.f3822a = account;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        return new p(status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzr zzrVar) throws RemoteException {
        ((com.google.android.gms.auth.account.zzc) zzrVar.getService()).zza(new l(this), this.f3822a);
    }
}
