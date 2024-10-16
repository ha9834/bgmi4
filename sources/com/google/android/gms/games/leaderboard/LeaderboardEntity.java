package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

@UsedByReflection("GamesClientImpl.java")
/* loaded from: classes.dex */
public final class LeaderboardEntity implements Leaderboard {

    /* renamed from: a, reason: collision with root package name */
    private final String f1715a;
    private final String b;
    private final Uri c;
    private final int d;
    private final ArrayList<LeaderboardVariantEntity> e;
    private final Game f;
    private final String g;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.f1715a = leaderboard.getLeaderboardId();
        this.b = leaderboard.getDisplayName();
        this.c = leaderboard.getIconImageUri();
        this.g = leaderboard.getIconImageUrl();
        this.d = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.f = game == null ? null : new GameEntity(game);
        ArrayList<LeaderboardVariant> variants = leaderboard.getVariants();
        int size = variants.size();
        this.e = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.e.add((LeaderboardVariantEntity) variants.get(i).freeze());
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Leaderboard freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getLeaderboardId() {
        return this.f1715a;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getDisplayName() {
        return this.b;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.b, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Uri getIconImageUri() {
        return this.c;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getIconImageUrl() {
        return this.g;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final int getScoreOrder() {
        return this.d;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<>(this.e);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Game getGame() {
        return this.f;
    }

    public final int hashCode() {
        return a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Leaderboard leaderboard) {
        return Objects.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return Objects.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && Objects.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && Objects.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && Objects.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && Objects.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    public final String toString() {
        return b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Leaderboard leaderboard) {
        return Objects.toStringHelper(leaderboard).add("LeaderboardId", leaderboard.getLeaderboardId()).add("DisplayName", leaderboard.getDisplayName()).add("IconImageUri", leaderboard.getIconImageUri()).add("IconImageUrl", leaderboard.getIconImageUrl()).add("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).add("Variants", leaderboard.getVariants()).toString();
    }
}
