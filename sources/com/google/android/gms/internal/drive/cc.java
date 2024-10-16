package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;

/* loaded from: classes2.dex */
final class cc extends cj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ MetadataChangeSet f3921a;
    private final /* synthetic */ zzdp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc(zzdp zzdpVar, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        super(zzdpVar, googleApiClient, null);
        this.b = zzdpVar;
        this.f3921a = metadataChangeSet;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.f3921a.zzp().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzgz(this.b.f3955a, this.f3921a.zzp()), new ch(this));
    }
}
