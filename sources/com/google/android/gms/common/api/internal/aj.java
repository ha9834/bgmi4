package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Add missing generic type declarations: [A, L] */
/* loaded from: classes.dex */
final class aj<A, L> extends UnregisterListenerMethod<A, L> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ RegistrationMethods.Builder f1337a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(RegistrationMethods.Builder builder, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
        this.f1337a = builder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (TA;Lcom/google/android/gms/tasks/TaskCompletionSource<Ljava/lang/Boolean;>;)V */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final void a(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        RemoteCall remoteCall;
        remoteCall = this.f1337a.b;
        remoteCall.accept(anyClient, taskCompletionSource);
    }
}
