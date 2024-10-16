package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class cq extends zzag<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(GamesClient gamesClient) {
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<String> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzeVar.zzbr());
    }
}
