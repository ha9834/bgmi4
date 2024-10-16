package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes2.dex */
final class bc implements Snapshots.CommitSnapshotResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, Status status) {
        this.f4220a = status;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
    public final SnapshotMetadata getSnapshotMetadata() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4220a;
    }
}
