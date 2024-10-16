package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class bg extends TaskApiCall<zzaw, DriveContents> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveContents f3900a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(zzch zzchVar, DriveContents driveContents) {
        this.f3900a = driveContents;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveContents> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgd(this.f3900a.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.f3900a.zzh().getRequestId()), new zzhc(taskCompletionSource));
    }
}
