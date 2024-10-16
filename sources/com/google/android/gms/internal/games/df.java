package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;

/* loaded from: classes2.dex */
final class df implements Achievements.UpdateAchievementResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4259a;
    private final /* synthetic */ de b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar, Status status) {
        this.b = deVar;
        this.f4259a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4259a;
    }

    @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
    public final String getAchievementId() {
        String str;
        str = this.b.f4258a;
        return str;
    }
}
