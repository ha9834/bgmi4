package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.stats.Stats;

/* loaded from: classes2.dex */
abstract class bk extends Games.zza<Stats.LoadPlayerStatsResult> {
    private bk(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new bl(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bk(GoogleApiClient googleApiClient, bj bjVar) {
        this(googleApiClient);
    }
}
