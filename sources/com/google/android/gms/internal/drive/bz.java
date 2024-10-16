package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class bz extends cj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f3917a = false;
    private final /* synthetic */ zzdp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(zzdp zzdpVar, GoogleApiClient googleApiClient, boolean z) {
        super(zzdpVar, googleApiClient, null);
        this.b = zzdpVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzek(this.b.f3955a, this.f3917a), new ch(this));
    }
}
