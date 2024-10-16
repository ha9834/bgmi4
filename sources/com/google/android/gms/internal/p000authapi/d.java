package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class d extends g<Status> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Credential f3807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(zzi zziVar, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.f3807a = credential;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    @Override // com.google.android.gms.internal.p000authapi.g
    protected final void a(Context context, zzw zzwVar) throws RemoteException {
        zzwVar.zzc(new f(this), new zzs(this.f3807a));
    }
}
