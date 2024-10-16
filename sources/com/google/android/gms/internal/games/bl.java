package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;

/* loaded from: classes2.dex */
final class bl implements Stats.LoadPlayerStatsResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar, Status status) {
        this.f4225a = status;
    }

    @Override // com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult
    public final PlayerStats getPlayerStats() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4225a;
    }
}
