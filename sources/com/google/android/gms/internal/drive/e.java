package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;

/* loaded from: classes2.dex */
final class e extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> f3933a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> resultHolder) {
        this.f3933a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3933a.setResult(new f(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfb zzfbVar) throws RemoteException {
        this.f3933a.setResult(new f(Status.RESULT_SUCCESS, new zzbi(zzfbVar.f3965a)));
    }
}
