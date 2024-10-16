package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
final class q extends zzav {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DriveId f3941a;
    private final /* synthetic */ int b = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(zzaw zzawVar, GoogleApiClient googleApiClient, DriveId driveId, int i) {
        super(googleApiClient);
        this.f3941a = driveId;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgm(this.f3941a, this.b), (zzes) null, (String) null, new zzgs(this));
    }
}
