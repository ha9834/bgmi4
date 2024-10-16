package com.google.android.gms.internal.plus;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class f extends i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(zzj zzjVar, GoogleApiClient googleApiClient) {
        super(googleApiClient, null);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.plus.internal.zzh zzhVar) throws RemoteException {
        zzhVar.zza(this);
    }
}
