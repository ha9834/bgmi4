package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes2.dex */
final class cb implements TurnBasedMultiplayer.LeaveMatchResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4239a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar, Status status) {
        this.f4239a = status;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult
    public final TurnBasedMatch getMatch() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4239a;
    }
}
