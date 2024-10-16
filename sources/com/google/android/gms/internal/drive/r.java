package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class r extends TaskApiCall<zzaw, DriveId> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3942a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(zzbb zzbbVar, String str) {
        this.f3942a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveId> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzek(DriveId.zza(this.f3942a), false), new zzhf(taskCompletionSource));
    }
}
