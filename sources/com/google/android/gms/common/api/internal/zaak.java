package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import com.tencent.abase.utils.ConstantUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zaak implements zabd {

    /* renamed from: a, reason: collision with root package name */
    private final zabe f1386a;
    private final Lock b;
    private final Context c;
    private final GoogleApiAvailabilityLight d;
    private ConnectionResult e;
    private int f;
    private int h;
    private zad k;
    private boolean l;
    private boolean m;
    private boolean n;
    private IAccountAccessor o;
    private boolean p;
    private boolean q;
    private final ClientSettings r;
    private final Map<Api<?>, Boolean> s;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> t;
    private int g = 0;
    private final Bundle i = new Bundle();
    private final Set<Api.AnyClientKey> j = new HashSet();
    private ArrayList<Future<?>> u = new ArrayList<>();

    public zaak(zabe zabeVar, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.f1386a = zabeVar;
        this.r = clientSettings;
        this.s = map;
        this.d = googleApiAvailabilityLight;
        this.t = abstractClientBuilder;
        this.b = lock;
        this.c = context;
    }

    private static String b(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return ConstantUtils.NET_UNKNOWN;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void connect() {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    @GuardedBy("mLock")
    public final void begin() {
        this.f1386a.b.clear();
        this.m = false;
        g gVar = null;
        this.e = null;
        this.g = 0;
        this.l = true;
        this.n = false;
        this.p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api<?> api : this.s.keySet()) {
            Api.Client client = this.f1386a.f1390a.get(api.getClientKey());
            z |= api.zah().getPriority() == 1;
            boolean booleanValue = this.s.get(api).booleanValue();
            if (client.requiresSignIn()) {
                this.m = true;
                if (booleanValue) {
                    this.j.add(api.getClientKey());
                } else {
                    this.l = false;
                }
            }
            hashMap.put(client, new h(this, api, booleanValue));
        }
        if (z) {
            this.m = false;
        }
        if (this.m) {
            this.r.setClientSessionId(Integer.valueOf(System.identityHashCode(this.f1386a.d)));
            o oVar = new o(this, gVar);
            Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.t;
            Context context = this.c;
            Looper looper = this.f1386a.d.getLooper();
            ClientSettings clientSettings = this.r;
            this.k = abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), oVar, oVar);
        }
        this.h = this.f1386a.f1390a.size();
        this.u.add(zabh.zabb().submit(new i(this, hashMap)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean a() {
        this.h--;
        int i = this.h;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GoogleApiClientConnecting", this.f1386a.d.d());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            b(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.e;
        if (connectionResult == null) {
            return true;
        }
        this.f1386a.c = this.f;
        b(connectionResult);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void a(com.google.android.gms.signin.internal.zaj zajVar) {
        if (a(0)) {
            ConnectionResult connectionResult = zajVar.getConnectionResult();
            if (connectionResult.isSuccess()) {
                ResolveAccountResponse zacx = zajVar.zacx();
                ConnectionResult connectionResult2 = zacx.getConnectionResult();
                if (!connectionResult2.isSuccess()) {
                    String valueOf = String.valueOf(connectionResult2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
                    b(connectionResult2);
                    return;
                }
                this.n = true;
                this.o = zacx.getAccountAccessor();
                this.p = zacx.getSaveDefaultAccount();
                this.q = zacx.isFromCrossClientAuth();
                b();
                return;
            }
            if (a(connectionResult)) {
                d();
                b();
            } else {
                b(connectionResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void b() {
        if (this.h != 0) {
            return;
        }
        if (!this.m || this.n) {
            ArrayList arrayList = new ArrayList();
            this.g = 1;
            this.h = this.f1386a.f1390a.size();
            for (Api.AnyClientKey<?> anyClientKey : this.f1386a.f1390a.keySet()) {
                if (this.f1386a.b.containsKey(anyClientKey)) {
                    if (a()) {
                        c();
                    }
                } else {
                    arrayList.add(this.f1386a.f1390a.get(anyClientKey));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.u.add(zabh.zabb().submit(new l(this, arrayList)));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    @GuardedBy("mLock")
    public final void onConnected(Bundle bundle) {
        if (a(1)) {
            if (bundle != null) {
                this.i.putAll(bundle);
            }
            if (a()) {
                c();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    @GuardedBy("mLock")
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (a(1)) {
            a(connectionResult, api, z);
            if (a()) {
                c();
            }
        }
    }

    @GuardedBy("mLock")
    private final void c() {
        this.f1386a.b();
        zabh.zabb().execute(new g(this));
        zad zadVar = this.k;
        if (zadVar != null) {
            if (this.p) {
                zadVar.zaa(this.o, this.q);
            }
            a(false);
        }
        Iterator<Api.AnyClientKey<?>> it = this.f1386a.b.keySet().iterator();
        while (it.hasNext()) {
            this.f1386a.f1390a.get(it.next()).disconnect();
        }
        this.f1386a.e.zab(this.i.isEmpty() ? null : this.i);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        this.f1386a.d.f1388a.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    @GuardedBy("mLock")
    public final boolean disconnect() {
        e();
        a(true);
        this.f1386a.a((ConnectionResult) null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    @GuardedBy("mLock")
    public final void onConnectionSuspended(int i) {
        b(new ConnectionResult(8, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r7 != false) goto L12;
     */
    @javax.annotation.concurrent.GuardedBy("mLock")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.Api<?> r6, boolean r7) {
        /*
            r4 = this;
            com.google.android.gms.common.api.Api$BaseClientBuilder r0 = r6.zah()
            int r0 = r0.getPriority()
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L25
            boolean r7 = r5.hasResolution()
            if (r7 == 0) goto L14
            r7 = 1
            goto L23
        L14:
            com.google.android.gms.common.GoogleApiAvailabilityLight r7 = r4.d
            int r3 = r5.getErrorCode()
            android.content.Intent r7 = r7.getErrorResolutionIntent(r3)
            if (r7 == 0) goto L22
            r7 = 1
            goto L23
        L22:
            r7 = 0
        L23:
            if (r7 == 0) goto L2e
        L25:
            com.google.android.gms.common.ConnectionResult r7 = r4.e
            if (r7 == 0) goto L2d
            int r7 = r4.f
            if (r0 >= r7) goto L2e
        L2d:
            r1 = 1
        L2e:
            if (r1 == 0) goto L34
            r4.e = r5
            r4.f = r0
        L34:
            com.google.android.gms.common.api.internal.zabe r7 = r4.f1386a
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r7 = r7.b
            com.google.android.gms.common.api.Api$AnyClientKey r6 = r6.getClientKey()
            r7.put(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaak.a(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void d() {
        this.m = false;
        this.f1386a.d.c = Collections.emptySet();
        for (Api.AnyClientKey<?> anyClientKey : this.j) {
            if (!this.f1386a.b.containsKey(anyClientKey)) {
                this.f1386a.b.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean a(ConnectionResult connectionResult) {
        return this.l && !connectionResult.hasResolution();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void b(ConnectionResult connectionResult) {
        e();
        a(!connectionResult.hasResolution());
        this.f1386a.a(connectionResult);
        this.f1386a.e.zac(connectionResult);
    }

    @GuardedBy("mLock")
    private final void a(boolean z) {
        zad zadVar = this.k;
        if (zadVar != null) {
            if (zadVar.isConnected() && z) {
                this.k.zacw();
            }
            this.k.disconnect();
            if (this.r.isSignInClientDisconnectFixEnabled()) {
                this.k = null;
            }
            this.o = null;
        }
    }

    private final void e() {
        ArrayList<Future<?>> arrayList = this.u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Future<?> future = arrayList.get(i);
            i++;
            future.cancel(true);
        }
        this.u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<Scope> f() {
        ClientSettings clientSettings = this.r;
        if (clientSettings == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(clientSettings.getRequiredScopes());
        Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.r.getOptionalApiSettings();
        for (Api<?> api : optionalApiSettings.keySet()) {
            if (!this.f1386a.b.containsKey(api.getClientKey())) {
                hashSet.addAll(optionalApiSettings.get(api).mScopes);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean a(int i) {
        if (this.g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f1386a.d.d());
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(valueOf);
        Log.w("GoogleApiClientConnecting", sb.toString());
        int i2 = this.h;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i2);
        Log.w("GoogleApiClientConnecting", sb2.toString());
        String b = b(this.g);
        String b2 = b(i);
        StringBuilder sb3 = new StringBuilder(String.valueOf(b).length() + 70 + String.valueOf(b2).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(b);
        sb3.append(" but received callback for step ");
        sb3.append(b2);
        Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
        b(new ConnectionResult(8, null));
        return false;
    }
}
