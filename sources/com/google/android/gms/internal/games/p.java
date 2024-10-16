package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class p extends Games.zza<Leaderboards.LeaderboardMetadataResult> {
    private p(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new q(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(GoogleApiClient googleApiClient, i iVar) {
        this(googleApiClient);
    }
}
