package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc implements zabt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ba f1353a;

    private bc(ba baVar) {
        this.f1353a = baVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zab(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.f1353a.m;
        lock.lock();
        try {
            this.f1353a.a(bundle);
            this.f1353a.j = ConnectionResult.RESULT_SUCCESS;
            this.f1353a.a();
        } finally {
            lock2 = this.f1353a.m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zac(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.f1353a.m;
        lock.lock();
        try {
            this.f1353a.j = connectionResult;
            this.f1353a.a();
        } finally {
            lock2 = this.f1353a.m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zab(int i, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        zabe zabeVar;
        lock = this.f1353a.m;
        lock.lock();
        try {
            z2 = this.f1353a.l;
            if (!z2) {
                connectionResult = this.f1353a.k;
                if (connectionResult != null) {
                    connectionResult2 = this.f1353a.k;
                    if (connectionResult2.isSuccess()) {
                        this.f1353a.l = true;
                        zabeVar = this.f1353a.e;
                        zabeVar.onConnectionSuspended(i);
                        return;
                    }
                }
            }
            this.f1353a.l = false;
            this.f1353a.a(i, z);
        } finally {
            lock2 = this.f1353a.m;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bc(ba baVar, bb bbVar) {
        this(baVar);
    }
}
