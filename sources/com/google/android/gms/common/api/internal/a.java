package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements OnCompleteListener<Map<zai<?>, String>> {

    /* renamed from: a, reason: collision with root package name */
    private SignInConnectionListener f1328a;
    private final /* synthetic */ zax b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zax zaxVar, SignInConnectionListener signInConnectionListener) {
        this.b = zaxVar;
        this.f1328a = signInConnectionListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f1328a.onComplete();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Map<zai<?>, String>> task) {
        Lock lock;
        Lock lock2;
        boolean z;
        boolean z2;
        Map map;
        Map map2;
        boolean a2;
        Map map3;
        Map map4;
        Map map5;
        Map map6;
        ConnectionResult d;
        Condition condition;
        Map map7;
        Map map8;
        Map map9;
        lock = this.b.f;
        lock.lock();
        try {
            z = this.b.n;
            if (!z) {
                this.f1328a.onComplete();
                return;
            }
            if (task.isSuccessful()) {
                zax zaxVar = this.b;
                map7 = this.b.b;
                zaxVar.p = new androidx.b.a(map7.size());
                map8 = this.b.b;
                for (zaw zawVar : map8.values()) {
                    map9 = this.b.p;
                    map9.put(zawVar.zak(), ConnectionResult.RESULT_SUCCESS);
                }
            } else if (task.getException() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.getException();
                z2 = this.b.l;
                if (z2) {
                    zax zaxVar2 = this.b;
                    map = this.b.b;
                    zaxVar2.p = new androidx.b.a(map.size());
                    map2 = this.b.b;
                    for (zaw zawVar2 : map2.values()) {
                        Object zak = zawVar2.zak();
                        ConnectionResult connectionResult = availabilityException.getConnectionResult(zawVar2);
                        a2 = this.b.a((zaw<?>) zawVar2, connectionResult);
                        if (a2) {
                            map3 = this.b.p;
                            map3.put(zak, new ConnectionResult(16));
                        } else {
                            map4 = this.b.p;
                            map4.put(zak, connectionResult);
                        }
                    }
                } else {
                    this.b.p = availabilityException.zaj();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                this.b.p = Collections.emptyMap();
            }
            if (this.b.isConnected()) {
                map5 = this.b.o;
                map6 = this.b.p;
                map5.putAll(map6);
                d = this.b.d();
                if (d == null) {
                    this.b.b();
                    this.b.c();
                    condition = this.b.i;
                    condition.signalAll();
                }
            }
            this.f1328a.onComplete();
        } finally {
            lock2 = this.b.f;
            lock2.unlock();
        }
    }
}
