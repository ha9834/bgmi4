package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes2.dex */
abstract class bb extends Games.zza<Snapshots.CommitSnapshotResult> {
    private bb(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new bc(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bb(GoogleApiClient googleApiClient, aw awVar) {
        this(googleApiClient);
    }
}
