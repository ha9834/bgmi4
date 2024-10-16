package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class av extends TaskApiCall<zzaw, Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveResource f3889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(zzch zzchVar, DriveResource driveResource) {
        this.f3889a = driveResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgv(this.f3889a.getDriveId()), new zzhl(taskCompletionSource));
    }
}
