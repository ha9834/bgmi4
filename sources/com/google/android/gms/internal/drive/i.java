package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
final class i implements DriveApi.DriveIdResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f3936a;
    private final DriveId b;

    public i(Status status, DriveId driveId) {
        this.f3936a = status;
        this.b = driveId;
    }

    @Override // com.google.android.gms.drive.DriveApi.DriveIdResult
    public final DriveId getDriveId() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f3936a;
    }
}
