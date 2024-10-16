package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class an extends zzav {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzei f3882a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(zzcb zzcbVar, GoogleApiClient googleApiClient, zzei zzeiVar) {
        super(googleApiClient);
        this.f3882a = zzeiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgo(this.f3882a), new zzgs(this));
    }
}
