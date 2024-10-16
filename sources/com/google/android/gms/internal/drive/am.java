package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class am extends aq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcb f3881a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(zzcb zzcbVar, GoogleApiClient googleApiClient) {
        super(zzcbVar, googleApiClient);
        this.f3881a = zzcbVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zzb(new ao(this.f3881a, this, null));
    }
}
