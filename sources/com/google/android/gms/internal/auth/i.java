package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes2.dex */
final class i extends BaseImplementation.ApiMethodImpl<WorkAccountApi.AddAccountResult, zzr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3820a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(zzh zzhVar, Api api, GoogleApiClient googleApiClient, String str) {
        super((Api<?>) api, googleApiClient);
        this.f3820a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzr zzrVar) throws RemoteException {
        ((com.google.android.gms.auth.account.zzc) zzrVar.getService()).zza(new j(this), this.f3820a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new n(status, null);
    }
}
