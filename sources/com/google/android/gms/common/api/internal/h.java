package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class h implements BaseGmsClient.ConnectionProgressReportCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<zaak> f1363a;
    private final Api<?> b;
    private final boolean c;

    public h(zaak zaakVar, Api<?> api, boolean z) {
        this.f1363a = new WeakReference<>(zaakVar);
        this.b = api;
        this.c = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        zabe zabeVar;
        Lock lock;
        Lock lock2;
        boolean a2;
        boolean a3;
        zaak zaakVar = this.f1363a.get();
        if (zaakVar == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        zabeVar = zaakVar.f1386a;
        Preconditions.checkState(myLooper == zabeVar.d.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = zaakVar.b;
        lock.lock();
        try {
            a2 = zaakVar.a(0);
            if (a2) {
                if (!connectionResult.isSuccess()) {
                    zaakVar.a(connectionResult, this.b, this.c);
                }
                a3 = zaakVar.a();
                if (a3) {
                    zaakVar.b();
                }
            }
        } finally {
            lock2 = zaakVar.b;
            lock2.unlock();
        }
    }
}
