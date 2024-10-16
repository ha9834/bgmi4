package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes.dex */
public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final zza b;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.b = new zza(dataHolder.getMetadata());
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.f1413a, i);
    }

    public final zza zzdi() {
        return this.b;
    }
}
