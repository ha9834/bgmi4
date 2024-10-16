package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;

/* loaded from: classes2.dex */
final class ci implements DriveResource.MetadataResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f3927a;
    private final Metadata b;

    public ci(Status status, Metadata metadata) {
        this.f3927a = status;
        this.b = metadata;
    }

    @Override // com.google.android.gms.drive.DriveResource.MetadataResult
    public final Metadata getMetadata() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f3927a;
    }
}
