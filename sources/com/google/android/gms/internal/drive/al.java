package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes2.dex */
abstract class al extends zzau<DriveFolder.DriveFolderResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public al(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new ak(status, null);
    }
}
