package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

/* loaded from: classes2.dex */
final class ay extends bb {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Snapshot f4216a;
    private final /* synthetic */ SnapshotMetadataChange b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(zzch zzchVar, GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        super(googleApiClient, null);
        this.f4216a = snapshot;
        this.b = snapshotMetadataChange;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4216a, this.b);
    }
}
