package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* loaded from: classes2.dex */
final class bp extends TaskApiCall<zzaw, Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveResource f3908a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(zzch zzchVar, DriveResource driveResource, List list) {
        this.f3908a = driveResource;
        this.b = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgq(this.f3908a.getDriveId(), this.b), new zzhl(taskCompletionSource));
    }
}
