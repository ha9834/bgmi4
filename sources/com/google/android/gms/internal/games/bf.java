package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshots;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class bf extends Games.zza<Snapshots.LoadSnapshotsResult> {
    private bf(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new bg(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bf(GoogleApiClient googleApiClient, aw awVar) {
        this(googleApiClient);
    }
}
