package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;

/* loaded from: classes2.dex */
final class dd implements Achievements.LoadAchievementsResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar, Status status) {
        this.f4257a = status;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4257a;
    }

    @Override // com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
    public final AchievementBuffer getAchievements() {
        return new AchievementBuffer(DataHolder.empty(14));
    }
}
