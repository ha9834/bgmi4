package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.request.Requests;

/* loaded from: classes2.dex */
abstract class au extends Games.zza<Requests.UpdateRequestsResult> {
    private au(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new av(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ au(GoogleApiClient googleApiClient, ap apVar) {
        this(googleApiClient);
    }
}
