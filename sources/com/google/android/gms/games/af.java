package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class af extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1613a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(RealTimeMultiplayerClient realTimeMultiplayerClient, String str) {
        this.f1613a = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzeVar.zzb(this.f1613a, 0);
        taskCompletionSource.setResult(null);
    }
}
