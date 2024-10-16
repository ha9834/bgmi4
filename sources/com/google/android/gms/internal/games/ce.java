package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes2.dex */
abstract class ce extends Games.zza<TurnBasedMultiplayer.LoadMatchesResult> {
    private ce(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new cf(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ce(GoogleApiClient googleApiClient, bm bmVar) {
        this(googleApiClient);
    }
}
