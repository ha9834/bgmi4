package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes2.dex */
abstract class bh extends Games.zza<Snapshots.OpenSnapshotResult> {
    private bh(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new bi(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bh(GoogleApiClient googleApiClient, aw awVar) {
        this(googleApiClient);
    }
}
