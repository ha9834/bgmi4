package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.video.Videos;

/* loaded from: classes2.dex */
abstract class cp extends Games.zza<Videos.CaptureStateResult> {
    private cp(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new cq(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cp(GoogleApiClient googleApiClient, ci ciVar) {
        this(googleApiClient);
    }
}
