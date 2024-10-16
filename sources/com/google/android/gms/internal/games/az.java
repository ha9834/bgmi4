package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

/* loaded from: classes2.dex */
final class az extends bd {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ SnapshotMetadata f4217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(zzch zzchVar, GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        super(googleApiClient, null);
        this.f4217a = snapshotMetadata;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zzi(this, this.f4217a.getSnapshotId());
    }
}
