package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class bm extends TaskApiCall<zzaw, Metadata> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveResource f3905a;
    private final /* synthetic */ boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(zzch zzchVar, DriveResource driveResource, boolean z) {
        this.f3905a = driveResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Metadata> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzek(this.f3905a.getDriveId(), this.b), new zzhj(taskCompletionSource));
    }
}
