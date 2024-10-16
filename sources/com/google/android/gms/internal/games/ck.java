package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class ck extends cl {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f4243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck(zzdw zzdwVar, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient, null);
        this.f4243a = i;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zzb(this, this.f4243a);
    }
}
