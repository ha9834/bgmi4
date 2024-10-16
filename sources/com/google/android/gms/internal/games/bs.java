package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class bs extends ca {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4232a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(zzcz zzczVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, null);
        this.f4232a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zze(this, this.f4232a);
    }
}
