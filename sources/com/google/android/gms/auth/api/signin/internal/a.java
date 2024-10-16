package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends g<GoogleSignInResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1262a;
    final /* synthetic */ GoogleSignInOptions b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        super(googleApiClient);
        this.f1262a = context;
        this.b = googleSignInOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzg zzgVar) throws RemoteException {
        ((zzu) zzgVar.getService()).zzc(new b(this), this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new GoogleSignInResult(null, status);
    }
}
