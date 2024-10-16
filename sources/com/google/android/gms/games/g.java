package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes.dex */
final class g implements PendingResultUtil.ResultConverter<Leaderboards.LoadScoresResult, LeaderboardsClient.LeaderboardScores> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ LeaderboardsClient.LeaderboardScores convert(Leaderboards.LoadScoresResult loadScoresResult) {
        Leaderboards.LoadScoresResult loadScoresResult2 = loadScoresResult;
        if (loadScoresResult2 != null) {
            return new LeaderboardsClient.LeaderboardScores(loadScoresResult2.getLeaderboard() != null ? loadScoresResult2.getLeaderboard().freeze() : null, loadScoresResult2.getScores());
        }
        return null;
    }
}
