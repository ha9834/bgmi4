package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DrivePreferencesApi;

/* loaded from: classes2.dex */
final class ao extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<DrivePreferencesApi.FileUploadPreferencesResult> f3883a;
    private final /* synthetic */ zzcb b;

    private ao(zzcb zzcbVar, BaseImplementation.ResultHolder<DrivePreferencesApi.FileUploadPreferencesResult> resultHolder) {
        this.b = zzcbVar;
        this.f3883a = resultHolder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ao(zzcb zzcbVar, BaseImplementation.ResultHolder resultHolder, am amVar) {
        this(zzcbVar, resultHolder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3883a.setResult(new ap(this.b, status, null, 0 == true ? 1 : 0));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfd zzfdVar) throws RemoteException {
        this.f3883a.setResult(new ap(this.b, Status.RESULT_SUCCESS, zzfdVar.f3966a, null));
    }
}
