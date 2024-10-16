package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class aw extends bf {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(zzch zzchVar, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, null);
        this.f4214a = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zzf(this, this.f4214a);
    }
}
