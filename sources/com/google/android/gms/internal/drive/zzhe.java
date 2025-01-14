package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public final class zzhe extends zzhb<DriveFolder> {
    public zzhe(TaskCompletionSource<DriveFolder> taskCompletionSource) {
        super(taskCompletionSource);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfh zzfhVar) throws RemoteException {
        zzap().setResult(zzfhVar.getDriveId().asDriveFolder());
    }
}
