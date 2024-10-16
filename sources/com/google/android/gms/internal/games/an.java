package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes2.dex */
abstract class an extends Games.zza<Quests.LoadQuestsResult> {
    private an(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new ao(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ an(GoogleApiClient googleApiClient, af afVar) {
        this(googleApiClient);
    }
}
