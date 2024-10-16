package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public abstract class zzag<TResult> extends TaskApiCall<com.google.android.gms.games.internal.zze, TResult> {
    /* JADX WARN: Can't rename method to resolve collision */
    protected abstract void a(com.google.android.gms.games.internal.zze zzeVar, TaskCompletionSource<TResult> taskCompletionSource) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            a(zzeVar, taskCompletionSource);
        } catch (RemoteException | SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}
