package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class av<T> extends zac {

    /* renamed from: a, reason: collision with root package name */
    protected final TaskCompletionSource<T> f1346a;

    public av(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.f1346a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public void zaa(zaab zaabVar, boolean z) {
    }

    protected abstract void zad(GoogleApiManager.zaa<?> zaaVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.zab
    public void zaa(Status status) {
        this.f1346a.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public void zaa(RuntimeException runtimeException) {
        this.f1346a.trySetException(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        Status b;
        Status b2;
        try {
            zad(zaaVar);
        } catch (DeadObjectException e) {
            b2 = zab.b(e);
            zaa(b2);
            throw e;
        } catch (RemoteException e2) {
            b = zab.b(e2);
            zaa(b);
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }
}
