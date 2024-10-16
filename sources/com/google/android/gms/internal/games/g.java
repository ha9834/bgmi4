package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.Invitations;

/* loaded from: classes2.dex */
abstract class g extends Games.zza<Invitations.LoadInvitationsResult> {
    private g(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new h(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(GoogleApiClient googleApiClient, f fVar) {
        this(googleApiClient);
    }
}
