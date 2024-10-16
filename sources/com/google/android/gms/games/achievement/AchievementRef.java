package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* loaded from: classes.dex */
public final class AchievementRef extends DataBufferRef implements Achievement {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AchievementRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getAchievementId() {
        return d("external_achievement_id");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getApplicationId() {
        return d("external_game_id");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getType() {
        return b("type");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getName() {
        return d("name");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getName(CharArrayBuffer charArrayBuffer) {
        a("name", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getDescription() {
        return d("description");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        a("description", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getUnlockedImageUri() {
        return g("unlocked_icon_image_uri");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getUnlockedImageUrl() {
        return d("unlocked_icon_image_url");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getRevealedImageUri() {
        return g("revealed_icon_image_uri");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getRevealedImageUrl() {
        return d("revealed_icon_image_url");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getTotalSteps() {
        Asserts.checkState(getType() == 1);
        return b("total_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedTotalSteps() {
        Asserts.checkState(getType() == 1);
        return d("formatted_total_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getType() == 1);
        a("formatted_total_steps", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player getPlayer() {
        return (Player) Preconditions.checkNotNull(zzw());
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player zzw() {
        if (h("external_player_id")) {
            return null;
        }
        return new PlayerRef(this.f1417a, this.b);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getState() {
        return b("state");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getCurrentSteps() {
        Asserts.checkState(getType() == 1);
        return b("current_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedCurrentSteps() {
        Asserts.checkState(getType() == 1);
        return d("formatted_current_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getType() == 1);
        a("formatted_current_steps", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getLastUpdatedTimestamp() {
        return a("last_updated_timestamp");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getXpValue() {
        if (!hasColumn("instance_xp_value") || h("instance_xp_value")) {
            return a("definition_xp_value");
        }
        return a("instance_xp_value");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final float zzx() {
        if (!hasColumn("rarity_percent") || h("rarity_percent")) {
            return -1.0f;
        }
        return e("rarity_percent");
    }

    public final String toString() {
        return AchievementEntity.a(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((AchievementEntity) ((Achievement) freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Achievement freeze() {
        return new AchievementEntity(this);
    }
}
