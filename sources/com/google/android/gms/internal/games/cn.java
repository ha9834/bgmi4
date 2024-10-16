package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.video.Videos;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class cn extends Games.zza<Videos.CaptureCapabilitiesResult> {
    private cn(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new co(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cn(GoogleApiClient googleApiClient, ci ciVar) {
        this(googleApiClient);
    }
}
