package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba implements zabs {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1351a;
    private final zaaw b;
    private final Looper c;
    private final zabe d;
    private final zabe e;
    private final Map<Api.AnyClientKey<?>, zabe> f;
    private final Api.Client h;
    private Bundle i;
    private final Lock m;
    private final Set<SignInConnectionListener> g = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult j = null;
    private ConnectionResult k = null;
    private boolean l = false;

    @GuardedBy("mLock")
    private int n = 0;

    public static ba a(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList) {
        androidx.b.a aVar = new androidx.b.a();
        androidx.b.a aVar2 = new androidx.b.a();
        Api.Client client = null;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api.Client value = entry.getValue();
            if (value.providesSignIn()) {
                client = value;
            }
            if (value.requiresSignIn()) {
                aVar.put(entry.getKey(), value);
            } else {
                aVar2.put(entry.getKey(), value);
            }
        }
        Preconditions.checkState(!aVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        androidx.b.a aVar3 = new androidx.b.a();
        androidx.b.a aVar4 = new androidx.b.a();
        for (Api<?> api : map2.keySet()) {
            Api.AnyClientKey<?> clientKey = api.getClientKey();
            if (aVar.containsKey(clientKey)) {
                aVar3.put(api, map2.get(api));
            } else if (aVar2.containsKey(clientKey)) {
                aVar4.put(api, map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<zaq> arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            zaq zaqVar = arrayList4.get(i);
            i++;
            zaq zaqVar2 = zaqVar;
            if (aVar3.containsKey(zaqVar2.mApi)) {
                arrayList2.add(zaqVar2);
            } else if (aVar4.containsKey(zaqVar2.mApi)) {
                arrayList3.add(zaqVar2);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new ba(context, zaawVar, lock, looper, googleApiAvailabilityLight, aVar, aVar2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, aVar3, aVar4);
    }

    private ba(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zaq> arrayList, ArrayList<zaq> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.f1351a = context;
        this.b = zaawVar;
        this.m = lock;
        this.c = looper;
        this.h = client;
        this.d = new zabe(context, this.b, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new bc(this, null));
        this.e = new zabe(context, this.b, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new bd(this, null));
        androidx.b.a aVar = new androidx.b.a();
        Iterator<Api.AnyClientKey<?>> it = map2.keySet().iterator();
        while (it.hasNext()) {
            aVar.put(it.next(), this.d);
        }
        Iterator<Api.AnyClientKey<?>> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            aVar.put(it2.next(), this.e);
        }
        this.f = Collections.unmodifiableMap(aVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        if (a((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            if (c()) {
                t.setFailedResult(new Status(4, null, d()));
                return t;
            }
            return (T) this.e.enqueue(t);
        }
        return (T) this.d.enqueue(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        if (a((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            if (c()) {
                t.setFailedResult(new Status(4, null, d()));
                return t;
            }
            return (T) this.e.execute(t);
        }
        return (T) this.d.execute(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(Api<?> api) {
        if (this.f.get(api.getClientKey()).equals(this.e)) {
            if (c()) {
                return new ConnectionResult(4, d());
            }
            return this.e.getConnectionResult(api);
        }
        return this.d.getConnectionResult(api);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final void connect() {
        this.n = 2;
        this.l = false;
        this.k = null;
        this.j = null;
        this.d.connect();
        this.e.connect();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final void disconnect() {
        this.k = null;
        this.j = null;
        this.n = 0;
        this.d.disconnect();
        this.e.disconnect();
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r2.n == 1) goto L13;
     */
    @Override // com.google.android.gms.common.api.internal.zabs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isConnected() {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.m
            r0.lock()
            com.google.android.gms.common.api.internal.zabe r0 = r2.d     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L28
            r1 = 1
            if (r0 == 0) goto L21
            com.google.android.gms.common.api.internal.zabe r0 = r2.e     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            boolean r0 = r2.c()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            int r0 = r2.n     // Catch: java.lang.Throwable -> L28
            if (r0 != r1) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            java.util.concurrent.locks.Lock r0 = r2.m
            r0.unlock()
            return r1
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.m
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.ba.isConnected():boolean");
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnecting() {
        this.m.lock();
        try {
            return this.n == 2;
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.m.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.e.isConnected()) {
                this.g.add(signInConnectionListener);
                if (this.n == 0) {
                    this.n = 1;
                }
                this.k = null;
                this.e.connect();
                return true;
            }
            this.m.unlock();
            return false;
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final void zaw() {
        this.d.zaw();
        this.e.zaw();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void maybeSignOut() {
        this.m.lock();
        try {
            boolean isConnecting = isConnecting();
            this.e.disconnect();
            this.k = new ConnectionResult(4);
            if (isConnecting) {
                new zap(this.c).post(new bb(this));
            } else {
                b();
            }
        } finally {
            this.m.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void a() {
        if (b(this.j)) {
            if (b(this.k) || c()) {
                switch (this.n) {
                    case 2:
                        this.b.zab(this.i);
                    case 1:
                        b();
                        break;
                    default:
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        break;
                }
                this.n = 0;
                return;
            }
            ConnectionResult connectionResult = this.k;
            if (connectionResult != null) {
                if (this.n == 1) {
                    b();
                    return;
                } else {
                    a(connectionResult);
                    this.d.disconnect();
                    return;
                }
            }
            return;
        }
        if (this.j != null && b(this.k)) {
            this.e.disconnect();
            a(this.j);
            return;
        }
        ConnectionResult connectionResult2 = this.j;
        if (connectionResult2 == null || this.k == null) {
            return;
        }
        if (this.e.c < this.d.c) {
            connectionResult2 = this.k;
        }
        a(connectionResult2);
    }

    @GuardedBy("mLock")
    private final void a(ConnectionResult connectionResult) {
        switch (this.n) {
            case 2:
                this.b.zac(connectionResult);
            case 1:
                b();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.n = 0;
    }

    @GuardedBy("mLock")
    private final void b() {
        Iterator<SignInConnectionListener> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.g.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void a(int i, boolean z) {
        this.b.zab(i, z);
        this.k = null;
        this.j = null;
    }

    @GuardedBy("mLock")
    private final boolean c() {
        ConnectionResult connectionResult = this.k;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private final boolean a(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Api.AnyClientKey<? extends Api.AnyClient> clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.f.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f.get(clientKey).equals(this.e);
    }

    private final PendingIntent d() {
        if (this.h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f1351a, System.identityHashCode(this.b), this.h.getSignInIntent(), 134217728);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Bundle bundle) {
        Bundle bundle2 = this.i;
        if (bundle2 == null) {
            this.i = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private static boolean b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(CertificateUtil.DELIMITER);
        this.e.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(CertificateUtil.DELIMITER);
        this.d.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }
}
