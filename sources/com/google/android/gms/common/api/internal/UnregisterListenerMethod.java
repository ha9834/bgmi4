package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a, reason: collision with root package name */
    private final ListenerHolder.ListenerKey<L> f1327a;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public UnregisterListenerMethod(ListenerHolder.ListenerKey<L> listenerKey) {
        this.f1327a = listenerKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public abstract void a(A a2, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.f1327a;
    }
}
