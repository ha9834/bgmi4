package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zax implements zabs {
    private final Map<Api<?>, Boolean> c;
    private final GoogleApiManager d;
    private final zaaw e;
    private final Lock f;
    private final Looper g;
    private final GoogleApiAvailabilityLight h;
    private final Condition i;
    private final ClientSettings j;
    private final boolean k;
    private final boolean l;

    @GuardedBy("mLock")
    private boolean n;

    @GuardedBy("mLock")
    private Map<zai<?>, ConnectionResult> o;

    @GuardedBy("mLock")
    private Map<zai<?>, ConnectionResult> p;

    @GuardedBy("mLock")
    private a q;

    @GuardedBy("mLock")
    private ConnectionResult r;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Api.AnyClientKey<?>, zaw<?>> f1405a = new HashMap();
    private final Map<Api.AnyClientKey<?>, zaw<?>> b = new HashMap();
    private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> m = new LinkedList();

    public zax(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zaaw zaawVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f = lock;
        this.g = looper;
        this.i = lock.newCondition();
        this.h = googleApiAvailabilityLight;
        this.e = zaawVar;
        this.c = map2;
        this.j = clientSettings;
        this.k = z;
        HashMap hashMap = new HashMap();
        for (Api<?> api : map2.keySet()) {
            hashMap.put(api.getClientKey(), api);
        }
        HashMap hashMap2 = new HashMap();
        ArrayList<zaq> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            zaq zaqVar = arrayList2.get(i);
            i++;
            zaq zaqVar2 = zaqVar;
            hashMap2.put(zaqVar2.mApi, zaqVar2);
        }
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api api2 = (Api) hashMap.get(entry.getKey());
            Api.Client value = entry.getValue();
            if (!value.requiresGooglePlayServices()) {
                z2 = z5;
                z3 = z7;
                z4 = false;
            } else if (this.c.get(api2).booleanValue()) {
                z4 = z6;
                z3 = z7;
                z2 = true;
            } else {
                z4 = z6;
                z3 = true;
                z2 = true;
            }
            zaw<?> zawVar = new zaw<>(context, api2, looper, value, (zaq) hashMap2.get(api2), clientSettings, abstractClientBuilder);
            this.f1405a.put(entry.getKey(), zawVar);
            if (value.requiresSignIn()) {
                this.b.put(entry.getKey(), zawVar);
            }
            z7 = z3;
            z6 = z4;
            z5 = z2;
        }
        this.l = (!z5 || z6 || z7) ? false : true;
        this.d = GoogleApiManager.zabc();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void zaw() {
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        if (this.k && a((zax) t)) {
            return t;
        }
        if (!isConnected()) {
            this.m.add(t);
            return t;
        }
        this.e.e.a(t);
        return (T) this.f1405a.get(t.getClientKey()).doRead((zaw<?>) t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        Api.AnyClientKey<A> clientKey = t.getClientKey();
        if (this.k && a((zax) t)) {
            return t;
        }
        this.e.e.a(t);
        return (T) this.f1405a.get(clientKey).doWrite((zaw<?>) t);
    }

    private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean a(T t) {
        Api.AnyClientKey<?> clientKey = t.getClientKey();
        ConnectionResult a2 = a(clientKey);
        if (a2 == null || a2.getErrorCode() != 4) {
            return false;
        }
        t.setFailedResult(new Status(4, null, this.d.a(this.f1405a.get(clientKey).zak(), System.identityHashCode(this.e))));
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void connect() {
        this.f.lock();
        try {
            if (this.n) {
                return;
            }
            this.n = true;
            this.o = null;
            this.p = null;
            this.q = null;
            this.r = null;
            this.d.zao();
            this.d.zaa(this.f1405a.values()).addOnCompleteListener(new HandlerExecutor(this.g), new bf(this));
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.i.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.r;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                disconnect();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.i.awaitNanos(nanos);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.r;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabs
    public final void disconnect() {
        this.f.lock();
        try {
            this.n = false;
            this.o = null;
            this.p = null;
            if (this.q != null) {
                this.q.a();
                this.q = null;
            }
            this.r = null;
            while (!this.m.isEmpty()) {
                BaseImplementation.ApiMethodImpl<?, ?> remove = this.m.remove();
                remove.zaa(null);
                remove.cancel();
            }
            this.i.signalAll();
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult getConnectionResult(Api<?> api) {
        return a(api.getClientKey());
    }

    private final ConnectionResult a(Api.AnyClientKey<?> anyClientKey) {
        this.f.lock();
        try {
            zaw<?> zawVar = this.f1405a.get(anyClientKey);
            if (this.o != null && zawVar != null) {
                return this.o.get(zawVar.zak());
            }
            this.f.unlock();
            return null;
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnected() {
        boolean z;
        this.f.lock();
        try {
            if (this.o != null) {
                if (this.r == null) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnecting() {
        boolean z;
        this.f.lock();
        try {
            if (this.o == null) {
                if (this.n) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean a() {
        this.f.lock();
        try {
            if (this.n && this.k) {
                Iterator<Api.AnyClientKey<?>> it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    ConnectionResult a2 = a(it.next());
                    if (a2 == null || !a2.isSuccess()) {
                        return false;
                    }
                }
                this.f.unlock();
                return true;
            }
            return false;
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.f.lock();
        try {
            if (this.n && !a()) {
                this.d.zao();
                this.q = new a(this, signInConnectionListener);
                this.d.zaa(this.b.values()).addOnCompleteListener(new HandlerExecutor(this.g), this.q);
                this.f.unlock();
                return true;
            }
            this.f.unlock();
            return false;
        } catch (Throwable th) {
            this.f.unlock();
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabs
    public final void maybeSignOut() {
        this.f.lock();
        try {
            this.d.a();
            if (this.q != null) {
                this.q.a();
                this.q = null;
            }
            if (this.p == null) {
                this.p = new androidx.b.a(this.b.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            Iterator<zaw<?>> it = this.b.values().iterator();
            while (it.hasNext()) {
                this.p.put(it.next().zak(), connectionResult);
            }
            if (this.o != null) {
                this.o.putAll(this.p);
            }
        } finally {
            this.f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void b() {
        ClientSettings clientSettings = this.j;
        if (clientSettings == null) {
            this.e.c = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(clientSettings.getRequiredScopes());
        Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.j.getOptionalApiSettings();
        for (Api<?> api : optionalApiSettings.keySet()) {
            ConnectionResult connectionResult = getConnectionResult(api);
            if (connectionResult != null && connectionResult.isSuccess()) {
                hashSet.addAll(optionalApiSettings.get(api).mScopes);
            }
        }
        this.e.c = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void c() {
        while (!this.m.isEmpty()) {
            execute(this.m.remove());
        }
        this.e.zab((Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(zaw<?> zawVar, ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && this.c.get(zawVar.getApi()).booleanValue() && zawVar.zaab().requiresGooglePlayServices() && this.h.isUserResolvableError(connectionResult.getErrorCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final ConnectionResult d() {
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i = 0;
        int i2 = 0;
        for (zaw<?> zawVar : this.f1405a.values()) {
            Api<?> api = zawVar.getApi();
            ConnectionResult connectionResult3 = this.o.get(zawVar.zak());
            if (!connectionResult3.isSuccess() && (!this.c.get(api).booleanValue() || connectionResult3.hasResolution() || this.h.isUserResolvableError(connectionResult3.getErrorCode()))) {
                if (connectionResult3.getErrorCode() == 4 && this.k) {
                    int priority = api.zah().getPriority();
                    if (connectionResult2 == null || i2 > priority) {
                        connectionResult2 = connectionResult3;
                        i2 = priority;
                    }
                } else {
                    int priority2 = api.zah().getPriority();
                    if (connectionResult == null || i > priority2) {
                        connectionResult = connectionResult3;
                        i = priority2;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i <= i2) ? connectionResult : connectionResult2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zax zaxVar, boolean z) {
        zaxVar.n = false;
        return false;
    }
}
