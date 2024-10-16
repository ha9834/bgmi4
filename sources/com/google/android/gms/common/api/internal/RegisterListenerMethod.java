package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a, reason: collision with root package name */
    private final ListenerHolder<L> f1322a;
    private final Feature[] b;
    private final boolean c;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public RegisterListenerMethod(ListenerHolder<L> listenerHolder) {
        this.f1322a = listenerHolder;
        this.b = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public abstract void a(A a2, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z) {
        this.f1322a = listenerHolder;
        this.b = featureArr;
        this.c = z;
    }

    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.f1322a.getListenerKey();
    }

    @KeepForSdk
    public void clearListener() {
        this.f1322a.clear();
    }

    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return this.b;
    }

    public final boolean shouldAutoResolveMissingFeatures() {
        return this.c;
    }
}
