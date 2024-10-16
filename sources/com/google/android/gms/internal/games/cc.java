package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes2.dex */
abstract class cc extends Games.zza<TurnBasedMultiplayer.LoadMatchResult> {
    private cc(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new cd(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cc(GoogleApiClient googleApiClient, bm bmVar) {
        this(googleApiClient);
    }
}
