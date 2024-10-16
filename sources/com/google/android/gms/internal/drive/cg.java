package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.MetadataBuffer;

/* loaded from: classes2.dex */
final class cg extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> f3925a;

    public cg(BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> resultHolder) {
        this.f3925a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.f3925a.setResult(new zzaq(status, null, false));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfp zzfpVar) throws RemoteException {
        this.f3925a.setResult(new zzaq(Status.RESULT_SUCCESS, new MetadataBuffer(zzfpVar.f3972a), false));
    }
}
