package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;

/* loaded from: classes2.dex */
final class bm extends by {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TurnBasedMatchConfig f4226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(zzcz zzczVar, GoogleApiClient googleApiClient, TurnBasedMatchConfig turnBasedMatchConfig) {
        super(googleApiClient, null);
        this.f4226a = turnBasedMatchConfig;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4226a);
    }
}
