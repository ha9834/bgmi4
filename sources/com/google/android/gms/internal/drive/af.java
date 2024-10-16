package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;

/* loaded from: classes2.dex */
final class af extends al {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ MetadataChangeSet f3876a;
    private final /* synthetic */ zzbs b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(zzbs zzbsVar, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        super(googleApiClient);
        this.b = zzbsVar;
        this.f3876a = metadataChangeSet;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.f3876a.zzp().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzy(this.b.getDriveId(), this.f3876a.zzp()), new ah(this));
    }
}
