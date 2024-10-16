package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.GmsLogger;

/* loaded from: classes2.dex */
final class z implements ResultCallback<Status> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public z(zzbi zzbiVar) {
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void onResult(Status status) {
        GmsLogger gmsLogger;
        Status status2 = status;
        if (status2.isSuccess()) {
            return;
        }
        gmsLogger = zzbi.f3953a;
        gmsLogger.efmt("DriveContentsImpl", "Error discarding contents, status: %s", status2);
    }
}
