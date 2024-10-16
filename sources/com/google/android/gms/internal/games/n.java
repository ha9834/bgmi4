package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;

/* loaded from: classes2.dex */
final class n extends t {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ LeaderboardScoreBuffer f4272a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(zzal zzalVar, GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        super(googleApiClient, null);
        this.f4272a = leaderboardScoreBuffer;
        this.b = i;
        this.d = i2;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4272a, this.b, this.d);
    }
}
