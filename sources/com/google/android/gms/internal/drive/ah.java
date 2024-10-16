package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes2.dex */
final class ah extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<DriveFolder.DriveFolderResult> f3878a;

    public ah(BaseImplementation.ResultHolder<DriveFolder.DriveFolderResult> resultHolder) {
        this.f3878a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3878a.setResult(new ak(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfh zzfhVar) throws RemoteException {
        this.f3878a.setResult(new ak(Status.RESULT_SUCCESS, new zzbs(zzfhVar.f3968a)));
    }
}
