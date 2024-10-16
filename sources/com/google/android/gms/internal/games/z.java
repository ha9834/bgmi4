package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.Players;

/* loaded from: classes2.dex */
final class z extends ad {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f4281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(zzbd zzbdVar, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient);
        this.f4281a = i;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza((BaseImplementation.ResultHolder<Players.LoadPlayersResult>) this, this.f4281a, true, false);
    }
}
