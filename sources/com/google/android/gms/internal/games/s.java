package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes2.dex */
final class s implements Leaderboards.LoadPlayerScoreResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4275a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, Status status) {
        this.f4275a = status;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
    public final LeaderboardScore getScore() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4275a;
    }
}
