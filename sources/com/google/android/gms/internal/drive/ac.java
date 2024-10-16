package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes2.dex */
final class ac implements DriveFile.DownloadProgressListener {

    /* renamed from: a, reason: collision with root package name */
    private final ListenerHolder<DriveFile.DownloadProgressListener> f3873a;

    public ac(ListenerHolder<DriveFile.DownloadProgressListener> listenerHolder) {
        this.f3873a = listenerHolder;
    }

    @Override // com.google.android.gms.drive.DriveFile.DownloadProgressListener
    public final void onProgress(long j, long j2) {
        this.f3873a.notifyListener(new ad(this, j, j2));
    }
}
