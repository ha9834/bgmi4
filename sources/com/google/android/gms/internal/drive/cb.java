package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

/* loaded from: classes2.dex */
final class cb extends zzav {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ List f3920a;
    private final /* synthetic */ zzdp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(zzdp zzdpVar, GoogleApiClient googleApiClient, List list) {
        super(googleApiClient);
        this.b = zzdpVar;
        this.f3920a = list;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgq(this.b.f3955a, this.f3920a), new zzgs(this));
    }
}
