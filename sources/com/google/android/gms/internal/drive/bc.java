package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class bc extends TaskApiCall<zzaw, DriveContents> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveFile f3896a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(zzch zzchVar, DriveFile driveFile, int i) {
        this.f3896a = driveFile;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveContents> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgd(this.f3896a.getDriveId(), this.b, 0), new zzhc(taskCompletionSource));
    }
}
