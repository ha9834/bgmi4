package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ba extends bh {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4219a;
    private final /* synthetic */ String b;
    private final /* synthetic */ SnapshotMetadataChange d;
    private final /* synthetic */ SnapshotContents e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(zzch zzchVar, GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        super(googleApiClient, null);
        this.f4219a = str;
        this.b = str2;
        this.d = snapshotMetadataChange;
        this.e = snapshotContents;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) throws RemoteException {
        zzeVar.zza(this, this.f4219a, this.b, this.d, this.e);
    }
}
