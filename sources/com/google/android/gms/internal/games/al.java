package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes2.dex */
abstract class al extends Games.zza<Quests.ClaimMilestoneResult> {
    private al(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new am(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(GoogleApiClient googleApiClient, af afVar) {
        this(googleApiClient);
    }
}
