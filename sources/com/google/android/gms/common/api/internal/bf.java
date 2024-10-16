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
public final class bf implements OnCompleteListener<Map<zai<?>, String>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zax f1355a;

    private bf(zax zaxVar) {
        this.f1355a = zaxVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Map<zai<?>, String>> task) {
        Lock lock;
        Lock lock2;
        boolean z;
        boolean z2;
        ConnectionResult d;
        Map map;
        Map map2;
        boolean a2;
        Map map3;
        Map map4;
        Map map5;
        ConnectionResult connectionResult;
        zaaw zaawVar;
        ConnectionResult connectionResult2;
        Condition condition;
        Map map6;
        Map map7;
        ConnectionResult d2;
        Map map8;
        Map map9;
        Map map10;
        lock = this.f1355a.f;
        lock.lock();
        try {
            z = this.f1355a.n;
            if (z) {
                if (task.isSuccessful()) {
                    zax zaxVar = this.f1355a;
                    map8 = this.f1355a.f1405a;
                    zaxVar.o = new androidx.b.a(map8.size());
                    map9 = this.f1355a.f1405a;
                    for (zaw zawVar : map9.values()) {
                        map10 = this.f1355a.o;
                        map10.put(zawVar.zak(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    z2 = this.f1355a.l;
                    if (z2) {
                        zax zaxVar2 = this.f1355a;
                        map = this.f1355a.f1405a;
                        zaxVar2.o = new androidx.b.a(map.size());
                        map2 = this.f1355a.f1405a;
                        for (zaw zawVar2 : map2.values()) {
                            Object zak = zawVar2.zak();
                            ConnectionResult connectionResult3 = availabilityException.getConnectionResult(zawVar2);
                            a2 = this.f1355a.a((zaw<?>) zawVar2, connectionResult3);
                            if (a2) {
                                map3 = this.f1355a.o;
                                map3.put(zak, new ConnectionResult(16));
                            } else {
                                map4 = this.f1355a.o;
                                map4.put(zak, connectionResult3);
                            }
                        }
                    } else {
                        this.f1355a.o = availabilityException.zaj();
                    }
                    zax zaxVar3 = this.f1355a;
                    d = this.f1355a.d();
                    zaxVar3.r = d;
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                    this.f1355a.o = Collections.emptyMap();
                    this.f1355a.r = new ConnectionResult(8);
                }
                map5 = this.f1355a.p;
                if (map5 != null) {
                    map6 = this.f1355a.o;
                    map7 = this.f1355a.p;
                    map6.putAll(map7);
                    zax zaxVar4 = this.f1355a;
                    d2 = this.f1355a.d();
                    zaxVar4.r = d2;
                }
                connectionResult = this.f1355a.r;
                if (connectionResult != null) {
                    zax.a(this.f1355a, false);
                    zaawVar = this.f1355a.e;
                    connectionResult2 = this.f1355a.r;
                    zaawVar.zac(connectionResult2);
                } else {
                    this.f1355a.b();
                    this.f1355a.c();
                }
                condition = this.f1355a.i;
                condition.signalAll();
            }
        } finally {
            lock2 = this.f1355a.f;
            lock2.unlock();
        }
    }
}
