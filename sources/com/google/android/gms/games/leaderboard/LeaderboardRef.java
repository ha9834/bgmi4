package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class LeaderboardRef extends DataBufferRef implements Leaderboard {
    private final int c;
    private final Game d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeaderboardRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = i2;
        this.d = new GameRef(dataHolder, i);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getLeaderboardId() {
        return d("external_leaderboard_id");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getDisplayName() {
        return d("name");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        a("name", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Uri getIconImageUri() {
        return g("board_icon_image_uri");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getIconImageUrl() {
        return d("board_icon_image_url");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final int getScoreOrder() {
        return b("score_order");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(this.c);
        for (int i = 0; i < this.c; i++) {
            arrayList.add(new zzb(this.f1417a, this.b + i));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Game getGame() {
        return this.d;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return LeaderboardEntity.a(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return LeaderboardEntity.a(this, obj);
    }

    public final String toString() {
        return LeaderboardEntity.b(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Leaderboard freeze() {
        return new LeaderboardEntity(this);
    }
}
