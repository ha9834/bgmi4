package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;

/* loaded from: classes2.dex */
abstract class a extends Games.zza<Result> {
    private a(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public Result createFailedResult(Status status) {
        return new b(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(GoogleApiClient googleApiClient, dg dgVar) {
        this(googleApiClient);
    }
}
