package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class ba extends TaskApiCall<zzaw, Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveResource f3894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(zzch zzchVar, DriveResource driveResource) {
        this.f3894a = driveResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        if (!zzawVar2.d) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
        }
        ((zzeo) zzawVar2.getService()).zza(new zzj(1, this.f3894a.getDriveId()), (zzes) null, (String) null, new zzhl(taskCompletionSource));
    }
}
