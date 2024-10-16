package com.google.android.gms.internal.p001authapiphone;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class d extends TaskApiCall<zzi, Void> {

    /* renamed from: a, reason: collision with root package name */
    private TaskCompletionSource<Void> f3800a;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(b bVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public /* synthetic */ void a(zzi zziVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.f3800a = taskCompletionSource;
        a((zze) zziVar.getService());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Status status) {
        TaskUtil.setResultOrApiException(status, this.f3800a);
    }

    protected abstract void a(zze zzeVar) throws RemoteException;
}
