package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;

/* loaded from: classes2.dex */
abstract class dc extends Games.zza<Achievements.LoadAchievementsResult> {
    private dc(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new dd(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dc(GoogleApiClient googleApiClient, ct ctVar) {
        this(googleApiClient);
    }
}
