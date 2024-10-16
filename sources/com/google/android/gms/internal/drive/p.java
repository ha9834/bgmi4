package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class p extends zzav {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzj f3940a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(zzaw zzawVar, GoogleApiClient googleApiClient, zzj zzjVar) {
        super(googleApiClient);
        this.f3940a = zzjVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(this.f3940a, (zzes) null, (String) null, new zzgs(this));
    }
}
