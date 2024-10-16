package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes2.dex */
final class ad implements ListenerHolder.Notifier<DriveFile.DownloadProgressListener> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f3874a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, long j, long j2) {
        this.f3874a = j;
        this.b = j2;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(DriveFile.DownloadProgressListener downloadProgressListener) {
        downloadProgressListener.onProgress(this.f3874a, this.b);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
