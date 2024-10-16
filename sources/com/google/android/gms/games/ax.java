package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ax extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Snapshot f1631a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(SnapshotsClient snapshotsClient, Snapshot snapshot) {
        this.f1631a = snapshot;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzeVar.zza(this.f1631a);
        taskCompletionSource.setResult(null);
    }
}
