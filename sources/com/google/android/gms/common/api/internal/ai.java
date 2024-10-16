package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Add missing generic type declarations: [A, L] */
/* loaded from: classes.dex */
final class ai<A, L> extends RegisterListenerMethod<A, L> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ RegistrationMethods.Builder f1336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(RegistrationMethods.Builder builder, ListenerHolder listenerHolder, Feature[] featureArr, boolean z) {
        super(listenerHolder, featureArr, z);
        this.f1336a = builder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (TA;Lcom/google/android/gms/tasks/TaskCompletionSource<Ljava/lang/Void;>;)V */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final void a(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        RemoteCall remoteCall;
        remoteCall = this.f1336a.f1323a;
        remoteCall.accept(anyClient, taskCompletionSource);
    }
}
