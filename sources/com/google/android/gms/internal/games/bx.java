package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes2.dex */
final class bx implements TurnBasedMultiplayer.CancelMatchResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4237a;
    private final /* synthetic */ bw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar, Status status) {
        this.b = bwVar;
        this.f4237a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4237a;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
    public final String getMatchId() {
        String str;
        str = this.b.f4236a;
        return str;
    }
}
