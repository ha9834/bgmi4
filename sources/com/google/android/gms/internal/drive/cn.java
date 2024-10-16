package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes2.dex */
final class cn extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> f3930a;
    private final DriveFile.DownloadProgressListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> resultHolder, DriveFile.DownloadProgressListener downloadProgressListener) {
        this.f3930a = resultHolder;
        this.b = downloadProgressListener;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3930a.setResult(new f(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfb zzfbVar) throws RemoteException {
        this.f3930a.setResult(new f(zzfbVar.b ? new Status(-1) : Status.RESULT_SUCCESS, new zzbi(zzfbVar.f3965a)));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzff zzffVar) throws RemoteException {
        DriveFile.DownloadProgressListener downloadProgressListener = this.b;
        if (downloadProgressListener != null) {
            downloadProgressListener.onProgress(zzffVar.f3967a, zzffVar.b);
        }
    }
}
