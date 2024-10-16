package com.google.android.gms.internal.firebase_remote_config;

import android.util.Log;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes2.dex */
public final class zzeh {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, zzeh> f4159a = new HashMap();
    private static final Executor e = ap.f4032a;
    private final ExecutorService b;
    private final zzex c;
    private Task<zzep> d = null;

    private zzeh(ExecutorService executorService, zzex zzexVar) {
        this.b = executorService;
        this.c = zzexVar;
    }

    public final Task<zzep> zzb(zzep zzepVar) {
        b(zzepVar);
        return zza(zzepVar, false);
    }

    public final zzep zzco() {
        return a(5L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzep a(long j) {
        synchronized (this) {
            if (this.d != null && this.d.isSuccessful()) {
                return this.d.getResult();
            }
            try {
                Task<zzep> zzcp = zzcp();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                ar arVar = new ar();
                zzcp.addOnSuccessListener(e, arVar);
                zzcp.addOnFailureListener(e, arVar);
                zzcp.addOnCanceledListener(e, arVar);
                if (!arVar.a(5L, timeUnit)) {
                    throw new TimeoutException("Task await timed out.");
                }
                if (zzcp.isSuccessful()) {
                    return zzcp.getResult();
                }
                throw new ExecutionException(zzcp.getException());
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                Log.d("ConfigCacheClient", "Reading from storage file failed.", e2);
                return null;
            }
        }
    }

    public final Task<zzep> zzc(zzep zzepVar) {
        return zza(zzepVar, true);
    }

    public final Task<zzep> zza(final zzep zzepVar, final boolean z) {
        return Tasks.call(this.b, new Callable(this, zzepVar) { // from class: com.google.android.gms.internal.firebase_remote_config.ao

            /* renamed from: a, reason: collision with root package name */
            private final zzeh f4031a;
            private final zzep b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4031a = this;
                this.b = zzepVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f4031a.a(this.b);
            }
        }).onSuccessTask(this.b, new SuccessContinuation(this, z, zzepVar) { // from class: com.google.android.gms.internal.firebase_remote_config.an

            /* renamed from: a, reason: collision with root package name */
            private final zzeh f4030a;
            private final boolean b;
            private final zzep c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4030a = this;
                this.b = z;
                this.c = zzepVar;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f4030a.a(this.b, this.c, (Void) obj);
            }
        });
    }

    public final synchronized Task<zzep> zzcp() {
        if (this.d == null || (this.d.isComplete() && !this.d.isSuccessful())) {
            ExecutorService executorService = this.b;
            zzex zzexVar = this.c;
            zzexVar.getClass();
            this.d = Tasks.call(executorService, aq.a(zzexVar));
        }
        return this.d;
    }

    public final void clear() {
        synchronized (this) {
            this.d = Tasks.forResult(null);
        }
        this.c.zzdd();
    }

    private final synchronized void b(zzep zzepVar) {
        this.d = Tasks.forResult(zzepVar);
    }

    public static synchronized zzeh zza(ExecutorService executorService, zzex zzexVar) {
        zzeh zzehVar;
        synchronized (zzeh.class) {
            String a2 = zzexVar.a();
            if (!f4159a.containsKey(a2)) {
                f4159a.put(a2, new zzeh(executorService, zzexVar));
            }
            zzehVar = f4159a.get(a2);
        }
        return zzehVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(boolean z, zzep zzepVar, Void r3) throws Exception {
        if (z) {
            b(zzepVar);
        }
        return Tasks.forResult(zzepVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void a(zzep zzepVar) throws Exception {
        return this.c.zzf(zzepVar);
    }
}
