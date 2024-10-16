package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class bt extends ca {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4233a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(zzcz zzczVar, GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient, null);
        this.f4233a = str;
        this.b = str2;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4233a, this.b);
    }
}
