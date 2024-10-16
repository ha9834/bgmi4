package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes2.dex */
final class be implements Snapshots.DeleteSnapshotResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, Status status) {
        this.f4221a = status;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
    public final String getSnapshotId() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4221a;
    }
}
