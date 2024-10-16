package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbp;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class am extends zzbp<com.google.android.gms.games.multiplayer.realtime.zzh> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public am(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    @Override // com.google.android.gms.games.internal.zzbp
    protected final void a(zze zzeVar, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        taskCompletionSource.setResult(true);
    }
}
