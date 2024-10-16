package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;

/* loaded from: classes2.dex */
abstract class g extends zzau<DriveApi.DriveContentsResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new f(status, null);
    }
}
