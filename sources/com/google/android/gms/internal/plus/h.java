package com.google.android.gms.internal.plus;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class h extends i {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String[] f4655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(zzj zzjVar, GoogleApiClient googleApiClient, String[] strArr) {
        super(googleApiClient, null);
        this.f4655a = strArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.plus.internal.zzh zzhVar) throws RemoteException {
        zzhVar.zza(this, this.f4655a);
    }
}
