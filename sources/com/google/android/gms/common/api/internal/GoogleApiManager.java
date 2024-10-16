package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* loaded from: classes.dex */
public class GoogleApiManager implements Handler.Callback {

    @GuardedBy("lock")
    private static GoogleApiManager f;
    private final Context g;
    private final GoogleApiAvailability h;
    private final GoogleApiAvailabilityCache i;
    private final Handler p;
    public static final Status zahx = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: a, reason: collision with root package name */
    private static final Status f1310a = new Status(4, "The user must be signed in to make this API call.");
    private static final Object e = new Object();
    private long b = 5000;
    private long c = 120000;
    private long d = LogUtils.LOG_FUSE_TIME;
    private final AtomicInteger j = new AtomicInteger(1);
    private final AtomicInteger k = new AtomicInteger(0);
    private final Map<zai<?>, zaa<?>> l = new ConcurrentHashMap(5, 0.75f, 1);

    @GuardedBy("lock")
    private zaae m = null;

    @GuardedBy("lock")
    private final Set<zai<?>> n = new androidx.b.b();
    private final Set<zai<?>> o = new androidx.b.b();

    public static GoogleApiManager zab(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (e) {
            if (f == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = f;
        }
        return googleApiManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final zai<?> f1311a;
        private final Feature b;

        private a(zai<?> zaiVar, Feature feature) {
            this.f1311a = zaiVar;
            this.b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equal(this.f1311a, aVar.f1311a) && Objects.equal(this.b, aVar.b);
        }

        public final int hashCode() {
            return Objects.hashCode(this.f1311a, this.b);
        }

        public final String toString() {
            return Objects.toStringHelper(this).add("key", this.f1311a).add("feature", this.b).toString();
        }

        /* synthetic */ a(zai zaiVar, Feature feature, y yVar) {
            this(zaiVar, feature);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements zach, BaseGmsClient.ConnectionProgressReportCallbacks {
        private final Api.Client b;
        private final zai<?> c;
        private IAccountAccessor d = null;
        private Set<Scope> e = null;
        private boolean f = false;

        public b(Api.Client client, zai<?> zaiVar) {
            this.b = client;
            this.c = zaiVar;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            GoogleApiManager.this.p.post(new ae(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.zach
        public final void zag(ConnectionResult connectionResult) {
            ((zaa) GoogleApiManager.this.l.get(this.c)).zag(connectionResult);
        }

        @Override // com.google.android.gms.common.api.internal.zach
        public final void zaa(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                zag(new ConnectionResult(4));
            } else {
                this.d = iAccountAccessor;
                this.e = set;
                a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a() {
            IAccountAccessor iAccountAccessor;
            if (!this.f || (iAccountAccessor = this.d) == null) {
                return;
            }
            this.b.getRemoteService(iAccountAccessor, this.e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.f = true;
            return true;
        }
    }

    public static GoogleApiManager zabc() {
        GoogleApiManager googleApiManager;
        synchronized (e) {
            Preconditions.checkNotNull(f, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = f;
        }
        return googleApiManager;
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (e) {
            if (f != null) {
                GoogleApiManager googleApiManager = f;
                googleApiManager.k.incrementAndGet();
                googleApiManager.p.sendMessageAtFrontOfQueue(googleApiManager.p.obtainMessage(10));
            }
        }
    }

    /* loaded from: classes.dex */
    public class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar {
        private final Api.Client c;
        private final Api.AnyClient d;
        private final zai<O> e;
        private final zaab f;
        private final int i;
        private final zace j;
        private boolean k;
        private final Queue<zab> b = new LinkedList();
        private final Set<zak> g = new HashSet();
        private final Map<ListenerHolder.ListenerKey<?>, zabw> h = new HashMap();
        private final List<a> l = new ArrayList();
        private ConnectionResult m = null;

        public zaa(GoogleApi<O> googleApi) {
            this.c = googleApi.zaa(GoogleApiManager.this.p.getLooper(), this);
            Api.Client client = this.c;
            if (client instanceof SimpleClientAdapter) {
                this.d = ((SimpleClientAdapter) client).getClient();
            } else {
                this.d = client;
            }
            this.e = googleApi.zak();
            this.f = new zaab();
            this.i = googleApi.getInstanceId();
            if (!this.c.requiresSignIn()) {
                this.j = null;
            } else {
                this.j = googleApi.zaa(GoogleApiManager.this.g, GoogleApiManager.this.p);
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == GoogleApiManager.this.p.getLooper()) {
                c();
            } else {
                GoogleApiManager.this.p.post(new z(this));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c() {
            zabl();
            b(ConnectionResult.RESULT_SUCCESS);
            f();
            Iterator<zabw> it = this.h.values().iterator();
            while (it.hasNext()) {
                zabw next = it.next();
                if (a(next.zajx.getRequiredFeatures()) != null) {
                    it.remove();
                } else {
                    try {
                        next.zajx.a(this.d, new TaskCompletionSource<>());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(1);
                        this.c.disconnect();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            e();
            g();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void onConnectionSuspended(int i) {
            if (Looper.myLooper() == GoogleApiManager.this.p.getLooper()) {
                d();
            } else {
                GoogleApiManager.this.p.post(new aa(this));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d() {
            zabl();
            this.k = true;
            this.f.zaai();
            GoogleApiManager.this.p.sendMessageDelayed(Message.obtain(GoogleApiManager.this.p, 9, this.e), GoogleApiManager.this.b);
            GoogleApiManager.this.p.sendMessageDelayed(Message.obtain(GoogleApiManager.this.p, 11, this.e), GoogleApiManager.this.c);
            GoogleApiManager.this.i.flush();
        }

        public final void zag(ConnectionResult connectionResult) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            this.c.disconnect();
            onConnectionFailed(connectionResult);
        }

        private final boolean a(ConnectionResult connectionResult) {
            synchronized (GoogleApiManager.e) {
                if (GoogleApiManager.this.m == null || !GoogleApiManager.this.n.contains(this.e)) {
                    return false;
                }
                GoogleApiManager.this.m.zab(connectionResult, this.i);
                return true;
            }
        }

        @Override // com.google.android.gms.common.api.internal.zar
        public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
            if (Looper.myLooper() == GoogleApiManager.this.p.getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                GoogleApiManager.this.p.post(new ab(this, connectionResult));
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            zace zaceVar = this.j;
            if (zaceVar != null) {
                zaceVar.zabs();
            }
            zabl();
            GoogleApiManager.this.i.flush();
            b(connectionResult);
            if (connectionResult.getErrorCode() != 4) {
                if (this.b.isEmpty()) {
                    this.m = connectionResult;
                    return;
                }
                if (a(connectionResult) || GoogleApiManager.this.a(connectionResult, this.i)) {
                    return;
                }
                if (connectionResult.getErrorCode() == 18) {
                    this.k = true;
                }
                if (this.k) {
                    GoogleApiManager.this.p.sendMessageDelayed(Message.obtain(GoogleApiManager.this.p, 9, this.e), GoogleApiManager.this.b);
                    return;
                }
                String zan = this.e.zan();
                StringBuilder sb = new StringBuilder(String.valueOf(zan).length() + 38);
                sb.append("API: ");
                sb.append(zan);
                sb.append(" is not available on this device.");
                zac(new Status(17, sb.toString()));
                return;
            }
            zac(GoogleApiManager.f1310a);
        }

        private final void e() {
            ArrayList arrayList = new ArrayList(this.b);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zab zabVar = (zab) obj;
                if (!this.c.isConnected()) {
                    return;
                }
                if (a(zabVar)) {
                    this.b.remove(zabVar);
                }
            }
        }

        public final void zaa(zab zabVar) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            if (this.c.isConnected()) {
                if (a(zabVar)) {
                    g();
                    return;
                } else {
                    this.b.add(zabVar);
                    return;
                }
            }
            this.b.add(zabVar);
            ConnectionResult connectionResult = this.m;
            if (connectionResult != null && connectionResult.hasResolution()) {
                onConnectionFailed(this.m);
            } else {
                connect();
            }
        }

        public final void zabj() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            zac(GoogleApiManager.zahx);
            this.f.zaah();
            for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.h.keySet().toArray(new ListenerHolder.ListenerKey[this.h.size()])) {
                zaa(new zah(listenerKey, new TaskCompletionSource()));
            }
            b(new ConnectionResult(4));
            if (this.c.isConnected()) {
                this.c.onUserSignOut(new ac(this));
            }
        }

        public final Api.Client zaab() {
            return this.c;
        }

        public final Map<ListenerHolder.ListenerKey<?>, zabw> zabk() {
            return this.h;
        }

        public final void zabl() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            this.m = null;
        }

        public final ConnectionResult zabm() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            return this.m;
        }

        private final boolean a(zab zabVar) {
            if (!(zabVar instanceof zac)) {
                b(zabVar);
                return true;
            }
            zac zacVar = (zac) zabVar;
            Feature a2 = a(zacVar.zab(this));
            if (a2 == null) {
                b(zabVar);
                return true;
            }
            if (zacVar.zac(this)) {
                a aVar = new a(this.e, a2, null);
                int indexOf = this.l.indexOf(aVar);
                if (indexOf >= 0) {
                    a aVar2 = this.l.get(indexOf);
                    GoogleApiManager.this.p.removeMessages(15, aVar2);
                    GoogleApiManager.this.p.sendMessageDelayed(Message.obtain(GoogleApiManager.this.p, 15, aVar2), GoogleApiManager.this.b);
                    return false;
                }
                this.l.add(aVar);
                GoogleApiManager.this.p.sendMessageDelayed(Message.obtain(GoogleApiManager.this.p, 15, aVar), GoogleApiManager.this.b);
                GoogleApiManager.this.p.sendMessageDelayed(Message.obtain(GoogleApiManager.this.p, 16, aVar), GoogleApiManager.this.c);
                ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (a(connectionResult)) {
                    return false;
                }
                GoogleApiManager.this.a(connectionResult, this.i);
                return false;
            }
            zacVar.zaa(new UnsupportedApiCallException(a2));
            return false;
        }

        private final void b(zab zabVar) {
            zabVar.zaa(this.f, requiresSignIn());
            try {
                zabVar.zaa((zaa<?>) this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.c.disconnect();
            }
        }

        public final void zac(Status status) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            Iterator<zab> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().zaa(status);
            }
            this.b.clear();
        }

        public final void resume() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            if (this.k) {
                connect();
            }
        }

        private final void f() {
            if (this.k) {
                GoogleApiManager.this.p.removeMessages(11, this.e);
                GoogleApiManager.this.p.removeMessages(9, this.e);
                this.k = false;
            }
        }

        public final void zaav() {
            Status status;
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            if (this.k) {
                f();
                if (GoogleApiManager.this.h.isGooglePlayServicesAvailable(GoogleApiManager.this.g) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                zac(status);
                this.c.disconnect();
            }
        }

        private final void g() {
            GoogleApiManager.this.p.removeMessages(12, this.e);
            GoogleApiManager.this.p.sendMessageDelayed(GoogleApiManager.this.p.obtainMessage(12, this.e), GoogleApiManager.this.d);
        }

        public final boolean zabp() {
            return a(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean a(boolean z) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            if (!this.c.isConnected() || this.h.size() != 0) {
                return false;
            }
            if (!this.f.a()) {
                this.c.disconnect();
                return true;
            }
            if (z) {
                g();
            }
            return false;
        }

        public final void connect() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            if (this.c.isConnected() || this.c.isConnecting()) {
                return;
            }
            int clientAvailability = GoogleApiManager.this.i.getClientAvailability(GoogleApiManager.this.g, this.c);
            if (clientAvailability != 0) {
                onConnectionFailed(new ConnectionResult(clientAvailability, null));
                return;
            }
            b bVar = new b(this.c, this.e);
            if (this.c.requiresSignIn()) {
                this.j.zaa(bVar);
            }
            this.c.connect(bVar);
        }

        public final void zaa(zak zakVar) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.p);
            this.g.add(zakVar);
        }

        private final void b(ConnectionResult connectionResult) {
            for (zak zakVar : this.g) {
                String str = null;
                if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.c.getEndpointPackageName();
                }
                zakVar.zaa(this.e, connectionResult, str);
            }
            this.g.clear();
        }

        final boolean a() {
            return this.c.isConnected();
        }

        public final boolean requiresSignIn() {
            return this.c.requiresSignIn();
        }

        public final int getInstanceId() {
            return this.i;
        }

        final zad b() {
            zace zaceVar = this.j;
            if (zaceVar == null) {
                return null;
            }
            return zaceVar.zabq();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final Feature a(Feature[] featureArr) {
            if (featureArr == null || featureArr.length == 0) {
                return null;
            }
            Feature[] availableFeatures = this.c.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            androidx.b.a aVar = new androidx.b.a(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                aVar.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                if (!aVar.containsKey(feature2.getName()) || ((Long) aVar.get(feature2.getName())).longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(a aVar) {
            if (this.l.contains(aVar) && !this.k) {
                if (!this.c.isConnected()) {
                    connect();
                } else {
                    e();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(a aVar) {
            Feature[] zab;
            if (this.l.remove(aVar)) {
                GoogleApiManager.this.p.removeMessages(15, aVar);
                GoogleApiManager.this.p.removeMessages(16, aVar);
                Feature feature = aVar.b;
                ArrayList arrayList = new ArrayList(this.b.size());
                for (zab zabVar : this.b) {
                    if ((zabVar instanceof zac) && (zab = ((zac) zabVar).zab(this)) != null && ArrayUtils.contains(zab, feature)) {
                        arrayList.add(zabVar);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zab zabVar2 = (zab) obj;
                    this.b.remove(zabVar2);
                    zabVar2.zaa(new UnsupportedApiCallException(feature));
                }
            }
        }
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.g = context;
        this.p = new zap(looper, this);
        this.h = googleApiAvailability;
        this.i = new GoogleApiAvailabilityCache(googleApiAvailability);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public final int zabd() {
        return this.j.getAndIncrement();
    }

    public final void zaa(GoogleApi<?> googleApi) {
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    private final void a(GoogleApi<?> googleApi) {
        zai<?> zak = googleApi.zak();
        zaa<?> zaaVar = this.l.get(zak);
        if (zaaVar == null) {
            zaaVar = new zaa<>(googleApi);
            this.l.put(zak, zaaVar);
        }
        if (zaaVar.requiresSignIn()) {
            this.o.add(zak);
        }
        zaaVar.connect();
    }

    public final void zaa(zaae zaaeVar) {
        synchronized (e) {
            if (this.m != zaaeVar) {
                this.m = zaaeVar;
                this.n.clear();
            }
            this.n.addAll(zaaeVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zaae zaaeVar) {
        synchronized (e) {
            if (this.m == zaaeVar) {
                this.m = null;
                this.n.clear();
            }
        }
    }

    public final Task<Map<zai<?>, String>> zaa(Iterable<? extends GoogleApi<?>> iterable) {
        zak zakVar = new zak(iterable);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(2, zakVar));
        return zakVar.getTask();
    }

    public final void zao() {
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.k.incrementAndGet();
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(10));
    }

    public final Task<Boolean> zac(GoogleApi<?> googleApi) {
        d dVar = new d(googleApi.zak());
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(14, dVar));
        return dVar.b().getTask();
    }

    public final <O extends Api.ApiOptions> void zaa(GoogleApi<O> googleApi, int i, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zae zaeVar = new zae(i, apiMethodImpl);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(4, new zabv(zaeVar, this.k.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void zaa(GoogleApi<O> googleApi, int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zag zagVar = new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(4, new zabv(zagVar, this.k.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions> Task<Void> zaa(GoogleApi<O> googleApi, RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaf zafVar = new zaf(new zabw(registerListenerMethod, unregisterListenerMethod), taskCompletionSource);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(8, new zabv(zafVar, this.k.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> Task<Boolean> zaa(GoogleApi<O> googleApi, ListenerHolder.ListenerKey<?> listenerKey) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zah zahVar = new zah(listenerKey, taskCompletionSource);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(13, new zabv(zahVar, this.k.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        zaa<?> zaaVar;
        switch (message.what) {
            case 1:
                this.d = ((Boolean) message.obj).booleanValue() ? LogUtils.LOG_FUSE_TIME : 300000L;
                this.p.removeMessages(12);
                for (zai<?> zaiVar : this.l.keySet()) {
                    Handler handler = this.p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, zaiVar), this.d);
                }
                return true;
            case 2:
                zak zakVar = (zak) message.obj;
                Iterator<zai<?>> it = zakVar.zap().iterator();
                while (true) {
                    if (it.hasNext()) {
                        zai<?> next = it.next();
                        zaa<?> zaaVar2 = this.l.get(next);
                        if (zaaVar2 == null) {
                            zakVar.zaa(next, new ConnectionResult(13), null);
                        } else if (zaaVar2.a()) {
                            zakVar.zaa(next, ConnectionResult.RESULT_SUCCESS, zaaVar2.zaab().getEndpointPackageName());
                        } else if (zaaVar2.zabm() != null) {
                            zakVar.zaa(next, zaaVar2.zabm(), null);
                        } else {
                            zaaVar2.zaa(zakVar);
                            zaaVar2.connect();
                        }
                    }
                }
                return true;
            case 3:
                for (zaa<?> zaaVar3 : this.l.values()) {
                    zaaVar3.zabl();
                    zaaVar3.connect();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zabv zabvVar = (zabv) message.obj;
                zaa<?> zaaVar4 = this.l.get(zabvVar.zajt.zak());
                if (zaaVar4 == null) {
                    a(zabvVar.zajt);
                    zaaVar4 = this.l.get(zabvVar.zajt.zak());
                }
                if (zaaVar4.requiresSignIn() && this.k.get() != zabvVar.zajs) {
                    zabvVar.zajr.zaa(zahx);
                    zaaVar4.zabj();
                } else {
                    zaaVar4.zaa(zabvVar.zajr);
                }
                return true;
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zaa<?>> it2 = this.l.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zaaVar = it2.next();
                        if (zaaVar.getInstanceId() == i) {
                        }
                    } else {
                        zaaVar = null;
                    }
                }
                if (zaaVar != null) {
                    String errorString = this.h.getErrorString(connectionResult.getErrorCode());
                    String errorMessage = connectionResult.getErrorMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(errorString).length() + 69 + String.valueOf(errorMessage).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(errorString);
                    sb.append(": ");
                    sb.append(errorMessage);
                    zaaVar.zac(new Status(17, sb.toString()));
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                }
                return true;
            case 6:
                if (PlatformVersion.isAtLeastIceCreamSandwich() && (this.g.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.initialize((Application) this.g.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new y(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.d = 300000L;
                    }
                }
                return true;
            case 7:
                a((GoogleApi<?>) message.obj);
                return true;
            case 9:
                if (this.l.containsKey(message.obj)) {
                    this.l.get(message.obj).resume();
                }
                return true;
            case 10:
                Iterator<zai<?>> it3 = this.o.iterator();
                while (it3.hasNext()) {
                    this.l.remove(it3.next()).zabj();
                }
                this.o.clear();
                return true;
            case 11:
                if (this.l.containsKey(message.obj)) {
                    this.l.get(message.obj).zaav();
                }
                return true;
            case 12:
                if (this.l.containsKey(message.obj)) {
                    this.l.get(message.obj).zabp();
                }
                return true;
            case 14:
                d dVar = (d) message.obj;
                zai<?> a2 = dVar.a();
                if (!this.l.containsKey(a2)) {
                    dVar.b().setResult(false);
                } else {
                    dVar.b().setResult(Boolean.valueOf(this.l.get(a2).a(false)));
                }
                return true;
            case 15:
                a aVar = (a) message.obj;
                if (this.l.containsKey(aVar.f1311a)) {
                    this.l.get(aVar.f1311a).a(aVar);
                }
                return true;
            case 16:
                a aVar2 = (a) message.obj;
                if (this.l.containsKey(aVar2.f1311a)) {
                    this.l.get(aVar2.f1311a).b(aVar2);
                }
                return true;
            default:
                int i2 = message.what;
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingIntent a(zai<?> zaiVar, int i) {
        zad b2;
        zaa<?> zaaVar = this.l.get(zaiVar);
        if (zaaVar == null || (b2 = zaaVar.b()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.g, i, b2.getSignInIntent(), 134217728);
    }

    final boolean a(ConnectionResult connectionResult, int i) {
        return this.h.zaa(this.g, connectionResult, i);
    }

    public final void zaa(ConnectionResult connectionResult, int i) {
        if (a(connectionResult, i)) {
            return;
        }
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }
}
