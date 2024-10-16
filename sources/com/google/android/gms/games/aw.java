package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class aw extends zzag<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1630a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(SnapshotsClient snapshotsClient, String str, boolean z, boolean z2, int i) {
        this.f1630a = str;
        this.b = z;
        this.c = z2;
        this.d = i;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzeVar.zza(this.f1630a, this.b, this.c, this.d));
    }
}
