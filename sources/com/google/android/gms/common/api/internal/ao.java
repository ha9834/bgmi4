package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Add missing generic type declarations: [A, ResultT] */
/* loaded from: classes.dex */
final class ao<A, ResultT> extends TaskApiCall<A, ResultT> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TaskApiCall.Builder f1341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(TaskApiCall.Builder builder, Feature[] featureArr, boolean z) {
        super(featureArr, z);
        this.f1341a = builder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (TA;Lcom/google/android/gms/tasks/TaskCompletionSource<TResultT;>;)V */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final void a(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        RemoteCall remoteCall;
        remoteCall = this.f1341a.f1326a;
        remoteCall.accept(anyClient, taskCompletionSource);
    }
}
