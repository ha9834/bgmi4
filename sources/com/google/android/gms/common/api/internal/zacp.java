package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zacp {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    final Set<BasePendingResult<?>> f1398a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final au c = new as(this);
    private final Map<Api.AnyClientKey<?>, Api.Client> d;
    public static final Status zakx = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] b = new BasePendingResult[0];

    public zacp(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.d = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BasePendingResult<? extends Result> basePendingResult) {
        this.f1398a.add(basePendingResult);
        basePendingResult.zaa(this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void release() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f1398a.toArray(b)) {
            com.google.android.gms.common.api.zac zacVar = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            com.google.android.gms.common.api.zac zacVar2 = null;
            basePendingResult.zaa(null);
            if (basePendingResult.zam() == null) {
                if (basePendingResult.zat()) {
                    this.f1398a.remove(basePendingResult);
                }
            } else {
                basePendingResult.setResultCallback(null);
                IBinder serviceBrokerBinder = this.d.get(((BaseImplementation.ApiMethodImpl) basePendingResult).getClientKey()).getServiceBrokerBinder();
                if (basePendingResult.isReady()) {
                    basePendingResult.zaa(new at(basePendingResult, objArr4 == true ? 1 : 0, serviceBrokerBinder, objArr3 == true ? 1 : 0));
                } else if (serviceBrokerBinder != null && serviceBrokerBinder.isBinderAlive()) {
                    at atVar = new at(basePendingResult, objArr2 == true ? 1 : 0, serviceBrokerBinder, objArr == true ? 1 : 0);
                    basePendingResult.zaa(atVar);
                    try {
                        serviceBrokerBinder.linkToDeath(atVar, 0);
                    } catch (RemoteException unused) {
                        basePendingResult.cancel();
                        zacVar2.remove(basePendingResult.zam().intValue());
                    }
                } else {
                    basePendingResult.zaa(null);
                    basePendingResult.cancel();
                    zacVar.remove(basePendingResult.zam().intValue());
                }
                this.f1398a.remove(basePendingResult);
            }
        }
    }

    public final void zabx() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f1398a.toArray(b)) {
            basePendingResult.zab(zakx);
        }
    }
}
