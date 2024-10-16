package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes2.dex */
final class ak implements DriveFolder.DriveFolderResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f3880a;
    private final DriveFolder b;

    public ak(Status status, DriveFolder driveFolder) {
        this.f3880a = status;
        this.b = driveFolder;
    }

    @Override // com.google.android.gms.drive.DriveFolder.DriveFolderResult
    public final DriveFolder getDriveFolder() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f3880a;
    }
}
