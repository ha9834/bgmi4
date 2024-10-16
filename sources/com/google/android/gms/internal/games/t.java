package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes2.dex */
abstract class t extends Games.zza<Leaderboards.LoadScoresResult> {
    private t(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new u(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(GoogleApiClient googleApiClient, i iVar) {
        this(googleApiClient);
    }
}
