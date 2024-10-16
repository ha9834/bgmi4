package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* loaded from: classes.dex */
public final class LeaderboardScoreRef extends DataBufferRef implements LeaderboardScore {
    private final PlayerRef c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeaderboardScoreRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.c = new PlayerRef(dataHolder, i);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRank() {
        return a("rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayRank() {
        return d("display_rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        a("display_rank", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayScore() {
        return d("display_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        a("display_score", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRawScore() {
        return a("raw_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getTimestampMillis() {
        return a("achieved_timestamp");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderDisplayName() {
        if (h("external_player_id")) {
            return d("default_display_name");
        }
        return this.c.getDisplayName();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (h("external_player_id")) {
            a("default_display_name", charArrayBuffer);
        } else {
            this.c.getDisplayName(charArrayBuffer);
        }
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderIconImageUri() {
        if (h("external_player_id")) {
            return g("default_display_image_uri");
        }
        return this.c.getIconImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderIconImageUrl() {
        if (h("external_player_id")) {
            return d("default_display_image_url");
        }
        return this.c.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderHiResImageUri() {
        if (h("external_player_id")) {
            return null;
        }
        return this.c.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderHiResImageUrl() {
        if (h("external_player_id")) {
            return null;
        }
        return this.c.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Player getScoreHolder() {
        if (h("external_player_id")) {
            return null;
        }
        return this.c;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreTag() {
        return d("score_tag");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return LeaderboardScoreEntity.a(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return LeaderboardScoreEntity.a(this, obj);
    }

    public final String toString() {
        return LeaderboardScoreEntity.b(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ LeaderboardScore freeze() {
        return new LeaderboardScoreEntity(this);
    }
}
