package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes2.dex */
final class ch implements TurnBasedMultiplayer.UpdateMatchResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4242a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar, Status status) {
        this.f4242a = status;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult
    public final TurnBasedMatch getMatch() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4242a;
    }
}
