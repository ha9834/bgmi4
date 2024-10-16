package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes2.dex */
public final class zzgs extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<Status> f3987a;

    public zzgs(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f3987a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void onSuccess() throws RemoteException {
        this.f3987a.setResult(Status.RESULT_SUCCESS);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3987a.setResult(status);
    }
}
