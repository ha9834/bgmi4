package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes2.dex */
abstract class by extends Games.zza<TurnBasedMultiplayer.InitiateMatchResult> {
    private by(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new bz(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ by(GoogleApiClient googleApiClient, bm bmVar) {
        this(googleApiClient);
    }
}
