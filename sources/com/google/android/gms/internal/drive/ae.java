package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ae extends aj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ MetadataChangeSet f3875a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int d;
    private final /* synthetic */ ExecutionOptions e;
    private final /* synthetic */ zzbs f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(zzbs zzbsVar, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        super(googleApiClient);
        this.f = zzbsVar;
        this.f3875a = metadataChangeSet;
        this.b = i;
        this.d = i2;
        this.e = executionOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.f3875a.zzp().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzw(this.f.getDriveId(), this.f3875a.zzp(), this.b, this.d, this.e), new ag(this));
    }
}
