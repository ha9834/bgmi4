package com.google.android.gms.internal.plus;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class e extends i {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4653a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zzj zzjVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, null);
        this.f4653a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.plus.internal.zzh zzhVar) throws RemoteException {
        a(zzhVar.zza(this, 0, this.f4653a));
    }
}
