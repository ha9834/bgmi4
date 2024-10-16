package com.google.android.gms.internal.plus;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class d extends i {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f4652a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(zzj zzjVar, GoogleApiClient googleApiClient, int i, String str) {
        super(googleApiClient, null);
        this.f4652a = i;
        this.b = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.plus.internal.zzh zzhVar) throws RemoteException {
        a(zzhVar.zza(this, this.f4652a, this.b));
    }
}
