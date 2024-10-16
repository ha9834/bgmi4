package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zak {
    private int d;
    private final androidx.b.a<zai<?>, String> b = new androidx.b.a<>();
    private final TaskCompletionSource<Map<zai<?>, String>> c = new TaskCompletionSource<>();
    private boolean e = false;

    /* renamed from: a, reason: collision with root package name */
    private final androidx.b.a<zai<?>, ConnectionResult> f1403a = new androidx.b.a<>();

    public zak(Iterable<? extends GoogleApi<?>> iterable) {
        Iterator<? extends GoogleApi<?>> it = iterable.iterator();
        while (it.hasNext()) {
            this.f1403a.put(it.next().zak(), null);
        }
        this.d = this.f1403a.keySet().size();
    }

    public final Set<zai<?>> zap() {
        return this.f1403a.keySet();
    }

    public final Task<Map<zai<?>, String>> getTask() {
        return this.c.getTask();
    }

    public final void zaa(zai<?> zaiVar, ConnectionResult connectionResult, String str) {
        this.f1403a.put(zaiVar, connectionResult);
        this.b.put(zaiVar, str);
        this.d--;
        if (!connectionResult.isSuccess()) {
            this.e = true;
        }
        if (this.d == 0) {
            if (this.e) {
                this.c.setException(new AvailabilityException(this.f1403a));
            } else {
                this.c.setResult(this.b);
            }
        }
    }
}
