package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;

/* loaded from: classes2.dex */
final class ae implements Players.LoadPlayersResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4201a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, Status status) {
        this.f4201a = status;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4201a;
    }

    @Override // com.google.android.gms.games.Players.LoadPlayersResult
    public final PlayerBuffer getPlayers() {
        return new PlayerBuffer(DataHolder.empty(14));
    }
}
