package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bd implements zabt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ba f1354a;

    private bd(ba baVar) {
        this.f1354a = baVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zab(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.f1354a.m;
        lock.lock();
        try {
            this.f1354a.k = ConnectionResult.RESULT_SUCCESS;
            this.f1354a.a();
        } finally {
            lock2 = this.f1354a.m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zac(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.f1354a.m;
        lock.lock();
        try {
            this.f1354a.k = connectionResult;
            this.f1354a.a();
        } finally {
            lock2 = this.f1354a.m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zab(int i, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        zabe zabeVar;
        lock = this.f1354a.m;
        lock.lock();
        try {
            z2 = this.f1354a.l;
            if (z2) {
                this.f1354a.l = false;
                this.f1354a.a(i, z);
            } else {
                this.f1354a.l = true;
                zabeVar = this.f1354a.d;
                zabeVar.onConnectionSuspended(i);
            }
        } finally {
            lock2 = this.f1354a.m;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bd(ba baVar, bb bbVar) {
        this(baVar);
    }
}
