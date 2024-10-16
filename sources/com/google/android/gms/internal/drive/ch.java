package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveResource;

/* loaded from: classes2.dex */
final class ch extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<DriveResource.MetadataResult> f3926a;

    public ch(BaseImplementation.ResultHolder<DriveResource.MetadataResult> resultHolder) {
        this.f3926a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3926a.setResult(new ci(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfs zzfsVar) throws RemoteException {
        this.f3926a.setResult(new ci(Status.RESULT_SUCCESS, new zzaa(zzfsVar.f3974a)));
    }
}
