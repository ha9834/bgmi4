package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

/* loaded from: classes2.dex */
final class v implements Leaderboards.SubmitScoreResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4277a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(zzaz zzazVar, Status status) {
        this.f4277a = status;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4277a;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
    public final ScoreSubmissionData getScoreData() {
        return new ScoreSubmissionData(DataHolder.empty(14));
    }
}
