package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;

/* loaded from: classes2.dex */
final class h extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<DriveApi.DriveIdResult> f3935a;

    public h(BaseImplementation.ResultHolder<DriveApi.DriveIdResult> resultHolder) {
        this.f3935a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3935a.setResult(new i(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfh zzfhVar) throws RemoteException {
        this.f3935a.setResult(new i(Status.RESULT_SUCCESS, zzfhVar.f3968a));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfs zzfsVar) throws RemoteException {
        this.f3935a.setResult(new i(Status.RESULT_SUCCESS, new zzaa(zzfsVar.f3974a).getDriveId()));
    }
}
