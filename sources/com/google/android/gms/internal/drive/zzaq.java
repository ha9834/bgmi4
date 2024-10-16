package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.MetadataBuffer;

/* loaded from: classes2.dex */
public final class zzaq implements DriveApi.MetadataBufferResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f3951a;
    private final MetadataBuffer b;
    private final boolean c;

    public zzaq(Status status, MetadataBuffer metadataBuffer, boolean z) {
        this.f3951a = status;
        this.b = metadataBuffer;
        this.c = z;
    }

    @Override // com.google.android.gms.drive.DriveApi.MetadataBufferResult
    public final MetadataBuffer getMetadataBuffer() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f3951a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        MetadataBuffer metadataBuffer = this.b;
        if (metadataBuffer != null) {
            metadataBuffer.release();
        }
    }
}
