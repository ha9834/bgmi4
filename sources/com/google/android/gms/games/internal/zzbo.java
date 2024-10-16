package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class zzbo<L> extends RegisterListenerMethod<zze, L> {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbo(ListenerHolder<L> listenerHolder) {
        super(listenerHolder);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    protected abstract void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public /* synthetic */ void a(zze zzeVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            a(zzeVar, (TaskCompletionSource<Void>) taskCompletionSource);
        } catch (SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}
