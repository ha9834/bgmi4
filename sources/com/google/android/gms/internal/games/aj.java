package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes2.dex */
abstract class aj extends Games.zza<Quests.AcceptQuestResult> {
    private aj(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new ak(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(GoogleApiClient googleApiClient, af afVar) {
        this(googleApiClient);
    }
}
