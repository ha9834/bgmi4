package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;

/* loaded from: classes2.dex */
abstract class de extends Games.zza<Achievements.UpdateAchievementResult> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4258a;

    public de(String str, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f4258a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new df(this, status);
    }
}
