package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zag<ResultT> extends zac {

    /* renamed from: a, reason: collision with root package name */
    private final TaskApiCall<Api.AnyClient, ResultT> f1400a;
    private final TaskCompletionSource<ResultT> b;
    private final StatusExceptionMapper c;

    public zag(int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i);
        this.b = taskCompletionSource;
        this.f1400a = taskApiCall;
        this.c = statusExceptionMapper;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        Status b;
        try {
            this.f1400a.a(zaaVar.zaab(), this.b);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            b = zab.b(e2);
            zaa(b);
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(Status status) {
        this.b.trySetException(this.c.getException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(RuntimeException runtimeException) {
        this.b.trySetException(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(zaab zaabVar, boolean z) {
        zaabVar.a(this.b, z);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(GoogleApiManager.zaa<?> zaaVar) {
        return this.f1400a.zabt();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zac(GoogleApiManager.zaa<?> zaaVar) {
        return this.f1400a.shouldAutoResolveMissingFeatures();
    }
}
