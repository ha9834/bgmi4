package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes2.dex */
final class b extends g {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f3893a = DriveFile.MODE_WRITE_ONLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzaf zzafVar, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzr(this.f3893a), new e(this));
    }
}
