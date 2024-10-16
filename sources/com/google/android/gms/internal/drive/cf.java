package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class cf extends zzav {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzdp f3924a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf(zzdp zzdpVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f3924a = zzdpVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgx(this.f3924a.f3955a), new zzgs(this));
    }
}
