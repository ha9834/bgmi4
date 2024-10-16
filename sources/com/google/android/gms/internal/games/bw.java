package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes2.dex */
abstract class bw extends Games.zza<TurnBasedMultiplayer.CancelMatchResult> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4236a;

    public bw(String str, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f4236a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new bx(this, status);
    }
}
