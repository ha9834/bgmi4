package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;

/* loaded from: classes2.dex */
public final class zze implements Achievements {
    @Override // com.google.android.gms.games.achievement.Achievements
    public final Intent getAchievementsIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbc();
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new ct(this, googleApiClient, z));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void reveal(GoogleApiClient googleApiClient, String str) {
        googleApiClient.execute(new cv(this, str, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new cw(this, str, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void unlock(GoogleApiClient googleApiClient, String str) {
        googleApiClient.execute(new cx(this, str, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new cy(this, str, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void increment(GoogleApiClient googleApiClient, String str, int i) {
        googleApiClient.execute(new cz(this, str, googleApiClient, str, i));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient googleApiClient, String str, int i) {
        return googleApiClient.execute(new da(this, str, googleApiClient, str, i));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void setSteps(GoogleApiClient googleApiClient, String str, int i) {
        googleApiClient.execute(new db(this, str, googleApiClient, str, i));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient googleApiClient, String str, int i) {
        return googleApiClient.execute(new cu(this, str, googleApiClient, str, i));
    }
}
