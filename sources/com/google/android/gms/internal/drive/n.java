package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n extends zzav {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzj f3938a;
    private final /* synthetic */ zzee b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(zzaw zzawVar, GoogleApiClient googleApiClient, zzj zzjVar, zzee zzeeVar) {
        super(googleApiClient);
        this.f3938a = zzjVar;
        this.b = zzeeVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(this.f3938a, this.b, (String) null, new zzgs(this));
    }
}
