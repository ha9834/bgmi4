package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class bf extends TaskApiCall<zzaw, DriveContents> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f3899a = DriveFile.MODE_WRITE_ONLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(zzch zzchVar, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveContents> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzr(this.f3899a), new zzhc(taskCompletionSource));
    }
}
