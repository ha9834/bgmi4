package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class zzbp<L> extends UnregisterListenerMethod<zze, L> {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbp(ListenerHolder.ListenerKey<L> listenerKey) {
        super(listenerKey);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    protected abstract void a(zze zzeVar, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public /* synthetic */ void a(zze zzeVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            a(zzeVar, (TaskCompletionSource<Boolean>) taskCompletionSource);
        } catch (SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}
