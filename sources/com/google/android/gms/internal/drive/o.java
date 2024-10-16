package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o extends zzav {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzgm f3939a;
    private final /* synthetic */ zzee b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(zzaw zzawVar, GoogleApiClient googleApiClient, zzgm zzgmVar, zzee zzeeVar) {
        super(googleApiClient);
        this.f3939a = zzgmVar;
        this.b = zzeeVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(this.f3939a, this.b, (String) null, new zzgs(this));
    }
}
