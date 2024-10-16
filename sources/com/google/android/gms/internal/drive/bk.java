package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class bk extends TaskApiCall<zzaw, Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveContents f3903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(zzch zzchVar, DriveContents driveContents) {
        this.f3903a = driveContents;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzo(this.f3903a.zzh().getRequestId(), false), new zzhl(taskCompletionSource));
    }
}
