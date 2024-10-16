package com.google.android.gms.internal.games;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes2.dex */
final class cf implements TurnBasedMultiplayer.LoadMatchesResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar, Status status) {
        this.f4241a = status;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4241a;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
    public final LoadMatchesResponse getMatches() {
        return new LoadMatchesResponse(new Bundle());
    }
}
