package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

@UsedByReflection("GamesClientImpl.java")
/* loaded from: classes.dex */
public final class LeaderboardScoreEntity implements LeaderboardScore {

    /* renamed from: a, reason: collision with root package name */
    private final long f1716a;
    private final String b;
    private final String c;
    private final long d;
    private final long e;
    private final String f;
    private final Uri g;
    private final Uri h;
    private final PlayerEntity i;
    private final String j;
    private final String k;
    private final String l;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        this.f1716a = leaderboardScore.getRank();
        this.b = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayRank());
        this.c = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayScore());
        this.d = leaderboardScore.getRawScore();
        this.e = leaderboardScore.getTimestampMillis();
        this.f = leaderboardScore.getScoreHolderDisplayName();
        this.g = leaderboardScore.getScoreHolderIconImageUri();
        this.h = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.i = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.j = leaderboardScore.getScoreTag();
        this.k = leaderboardScore.getScoreHolderIconImageUrl();
        this.l = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ LeaderboardScore freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRank() {
        return this.f1716a;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayRank() {
        return this.b;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.b, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayScore() {
        return this.c;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.c, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRawScore() {
        return this.d;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getTimestampMillis() {
        return this.e;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderDisplayName() {
        PlayerEntity playerEntity = this.i;
        if (playerEntity == null) {
            return this.f;
        }
        return playerEntity.getDisplayName();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.i;
        if (playerEntity == null) {
            DataUtils.copyStringToBuffer(this.f, charArrayBuffer);
        } else {
            playerEntity.getDisplayName(charArrayBuffer);
        }
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderIconImageUri() {
        PlayerEntity playerEntity = this.i;
        if (playerEntity == null) {
            return this.g;
        }
        return playerEntity.getIconImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderIconImageUrl() {
        PlayerEntity playerEntity = this.i;
        if (playerEntity == null) {
            return this.k;
        }
        return playerEntity.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderHiResImageUri() {
        PlayerEntity playerEntity = this.i;
        if (playerEntity == null) {
            return this.h;
        }
        return playerEntity.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderHiResImageUrl() {
        PlayerEntity playerEntity = this.i;
        if (playerEntity == null) {
            return this.l;
        }
        return playerEntity.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Player getScoreHolder() {
        return this.i;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreTag() {
        return this.j;
    }

    public final int hashCode() {
        return a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(LeaderboardScore leaderboardScore) {
        return Objects.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return Objects.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && Objects.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && Objects.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && Objects.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && Objects.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && Objects.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && Objects.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && Objects.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && Objects.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && Objects.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    public final String toString() {
        return b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(LeaderboardScore leaderboardScore) {
        return Objects.toStringHelper(leaderboardScore).add("Rank", Long.valueOf(leaderboardScore.getRank())).add("DisplayRank", leaderboardScore.getDisplayRank()).add("Score", Long.valueOf(leaderboardScore.getRawScore())).add("DisplayScore", leaderboardScore.getDisplayScore()).add("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).add("DisplayName", leaderboardScore.getScoreHolderDisplayName()).add("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).add("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).add("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).add("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).add("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).add("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }
}
