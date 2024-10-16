package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes2.dex */
final class ag extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<DriveFolder.DriveFileResult> f3877a;

    public ag(BaseImplementation.ResultHolder<DriveFolder.DriveFileResult> resultHolder) {
        this.f3877a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3877a.setResult(new ai(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfh zzfhVar) throws RemoteException {
        this.f3877a.setResult(new ai(Status.RESULT_SUCCESS, new zzbn(zzfhVar.f3968a)));
    }
}
