package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.abase.utils.ConstantUtils;
import com.tencent.imsdk.android.IR;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class BaseGmsClient<T extends IInterface> {

    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;

    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";

    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private boolean A;
    private volatile zzb B;

    /* renamed from: a, reason: collision with root package name */
    final Handler f1434a;

    @VisibleForTesting
    protected ConnectionProgressReportCallbacks b;

    @VisibleForTesting
    protected AtomicInteger c;
    private int e;
    private long f;
    private long g;
    private int h;
    private long i;

    @VisibleForTesting
    private zzh j;
    private final Context k;
    private final Looper l;
    private final GmsClientSupervisor m;
    private final GoogleApiAvailabilityLight n;
    private final Object o;
    private final Object p;

    @GuardedBy("mServiceBrokerLock")
    private IGmsServiceBroker q;

    @GuardedBy("mLock")
    private T r;
    private final ArrayList<zzc<?>> s;

    @GuardedBy("mLock")
    private zze t;

    @GuardedBy("mLock")
    private int u;
    private final BaseConnectionCallbacks v;
    private final BaseOnConnectionFailedListener w;
    private final int x;
    private final String y;
    private ConnectionResult z;
    private static final Feature[] d = new Feature[0];

    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BaseConnectionCallbacks {
        @KeepForSdk
        void onConnected(Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public void onReportServiceBinding(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.g());
            } else if (BaseGmsClient.this.w != null) {
                BaseGmsClient.this.w.onConnectionFailed(connectionResult);
            }
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    @KeepForSdk
    protected abstract String a();

    @KeepForSdk
    void a(int i, T t) {
    }

    @KeepForSdk
    protected String b() {
        return "com.google.android.gms";
    }

    @KeepForSdk
    protected String c() {
        return null;
    }

    @KeepForSdk
    protected abstract T createServiceInterface(IBinder iBinder);

    @KeepForSdk
    protected boolean f() {
        return false;
    }

    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    @KeepForSdk
    protected abstract String getStartServiceAction();

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailabilityLight.getInstance(), i, (BaseConnectionCallbacks) Preconditions.checkNotNull(baseConnectionCallbacks), (BaseOnConnectionFailedListener) Preconditions.checkNotNull(baseOnConnectionFailedListener), str);
    }

    /* loaded from: classes.dex */
    final class b extends com.google.android.gms.internal.common.zze {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (BaseGmsClient.this.c.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            if ((message.what == 1 || message.what == 7 || ((message.what == 4 && !BaseGmsClient.this.f()) || message.what == 5)) && !BaseGmsClient.this.isConnecting()) {
                a(message);
                return;
            }
            if (message.what != 4) {
                if (message.what != 5) {
                    if (message.what == 3) {
                        ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
                        BaseGmsClient.this.b.onReportServiceBinding(connectionResult3);
                        BaseGmsClient.this.onConnectionFailed(connectionResult3);
                        return;
                    }
                    if (message.what != 6) {
                        if (message.what == 2 && !BaseGmsClient.this.isConnected()) {
                            a(message);
                            return;
                        }
                        if (b(message)) {
                            ((zzc) message.obj).zzo();
                            return;
                        }
                        int i = message.what;
                        StringBuilder sb = new StringBuilder(45);
                        sb.append("Don't know how to handle message: ");
                        sb.append(i);
                        Log.wtf("GmsClient", sb.toString(), new Exception());
                        return;
                    }
                    BaseGmsClient.this.b(5, null);
                    if (BaseGmsClient.this.v != null) {
                        BaseGmsClient.this.v.onConnectionSuspended(message.arg2);
                    }
                    BaseGmsClient.this.onConnectionSuspended(message.arg2);
                    BaseGmsClient.this.a(5, 1, (int) null);
                    return;
                }
                if (BaseGmsClient.this.z == null) {
                    connectionResult = new ConnectionResult(8);
                } else {
                    connectionResult = BaseGmsClient.this.z;
                }
                BaseGmsClient.this.b.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
                return;
            }
            BaseGmsClient.this.z = new ConnectionResult(message.arg2);
            if (BaseGmsClient.this.j() && !BaseGmsClient.this.A) {
                BaseGmsClient.this.b(3, null);
                return;
            }
            if (BaseGmsClient.this.z == null) {
                connectionResult2 = new ConnectionResult(8);
            } else {
                connectionResult2 = BaseGmsClient.this.z;
            }
            BaseGmsClient.this.b.onReportServiceBinding(connectionResult2);
            BaseGmsClient.this.onConnectionFailed(connectionResult2);
        }

        private static void a(Message message) {
            zzc zzcVar = (zzc) message.obj;
            zzcVar.b();
            zzcVar.unregister();
        }

        private static boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class zzg extends a {
        public zzg(int i, Bundle bundle) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final void a(ConnectionResult connectionResult) {
            if (!BaseGmsClient.this.f() || !BaseGmsClient.this.j()) {
                BaseGmsClient.this.b.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
            } else {
                BaseGmsClient.this.a(16);
            }
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final boolean a() {
            BaseGmsClient.this.b.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public abstract class zzc<TListener> {

        /* renamed from: a, reason: collision with root package name */
        private TListener f1438a;
        private boolean b = false;

        public zzc(TListener tlistener) {
            this.f1438a = tlistener;
        }

        protected abstract void a(TListener tlistener);

        protected abstract void b();

        public final void zzo() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f1438a;
                if (this.b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e) {
                    b();
                    throw e;
                }
            } else {
                b();
            }
            synchronized (this) {
                this.b = true;
            }
            unregister();
        }

        public final void unregister() {
            removeListener();
            synchronized (BaseGmsClient.this.s) {
                BaseGmsClient.this.s.remove(this);
            }
        }

        public final void removeListener() {
            synchronized (this) {
                this.f1438a = null;
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class zzd extends IGmsCallbacks.zza {

        /* renamed from: a, reason: collision with root package name */
        private BaseGmsClient f1439a;
        private final int b;

        public zzd(BaseGmsClient baseGmsClient, int i) {
            this.f1439a = baseGmsClient;
            this.b = i;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void zza(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
            Preconditions.checkNotNull(this.f1439a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f1439a.a(i, iBinder, bundle, this.b);
            this.f1439a = null;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void zza(int i, IBinder iBinder, zzb zzbVar) {
            Preconditions.checkNotNull(this.f1439a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(zzbVar);
            this.f1439a.a(zzbVar);
            onPostInitComplete(i, iBinder, zzbVar.f1476a);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public final class zze implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final int f1440a;

        public zze(int i) {
            this.f1440a = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker aVar;
            if (iBinder == null) {
                BaseGmsClient.this.a(16);
                return;
            }
            synchronized (BaseGmsClient.this.p) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                if (iBinder == null) {
                    aVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof IGmsServiceBroker)) {
                        aVar = (IGmsServiceBroker) queryLocalInterface;
                    } else {
                        aVar = new IGmsServiceBroker.Stub.a(iBinder);
                    }
                }
                baseGmsClient.q = aVar;
            }
            BaseGmsClient.this.a(0, (Bundle) null, this.f1440a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.p) {
                BaseGmsClient.this.q = null;
            }
            BaseGmsClient.this.f1434a.sendMessage(BaseGmsClient.this.f1434a.obtainMessage(6, this.f1440a, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class zzf extends a {

        /* renamed from: a, reason: collision with root package name */
        private final IBinder f1441a;

        public zzf(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.f1441a = iBinder;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final void a(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.w != null) {
                BaseGmsClient.this.w.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final boolean a() {
            try {
                String interfaceDescriptor = this.f1441a.getInterfaceDescriptor();
                if (!BaseGmsClient.this.a().equals(interfaceDescriptor)) {
                    String a2 = BaseGmsClient.this.a();
                    StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(a2);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface createServiceInterface = BaseGmsClient.this.createServiceInterface(this.f1441a);
                if (createServiceInterface == null || !(BaseGmsClient.this.a(2, 4, (int) createServiceInterface) || BaseGmsClient.this.a(3, 4, (int) createServiceInterface))) {
                    return false;
                }
                BaseGmsClient.this.z = null;
                Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                if (BaseGmsClient.this.v == null) {
                    return true;
                }
                BaseGmsClient.this.v.onConnected(connectionHint);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    private abstract class a extends zzc<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        private final int f1436a;
        private final Bundle b;

        protected a(int i, Bundle bundle) {
            super(true);
            this.f1436a = i;
            this.b = bundle;
        }

        protected abstract void a(ConnectionResult connectionResult);

        protected abstract boolean a();

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        protected final void b() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        protected final /* synthetic */ void a(Boolean bool) {
            if (bool != null) {
                int i = this.f1436a;
                if (i == 0) {
                    if (a()) {
                        return;
                    }
                    BaseGmsClient.this.b(1, null);
                    a(new ConnectionResult(8, null));
                    return;
                }
                if (i != 10) {
                    BaseGmsClient.this.b(1, null);
                    Bundle bundle = this.b;
                    a(new ConnectionResult(this.f1436a, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
                    return;
                }
                BaseGmsClient.this.b(1, null);
                throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), BaseGmsClient.this.getStartServiceAction(), BaseGmsClient.this.a()));
            }
            BaseGmsClient.this.b(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    @KeepForSdk
    public BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.o = new Object();
        this.p = new Object();
        this.s = new ArrayList<>();
        this.u = 1;
        this.z = null;
        this.A = false;
        this.B = null;
        this.c = new AtomicInteger(0);
        this.k = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.l = (Looper) Preconditions.checkNotNull(looper, "Looper must not be null");
        this.m = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.n = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.f1434a = new b(looper);
        this.x = i;
        this.v = baseConnectionCallbacks;
        this.w = baseOnConnectionFailedListener;
        this.y = str;
    }

    private final String h() {
        String str = this.y;
        return str == null ? this.k.getClass().getName() : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzb zzbVar) {
        this.B = zzbVar;
    }

    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        zzb zzbVar = this.B;
        if (zzbVar == null) {
            return null;
        }
        return zzbVar.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public void onConnectedLocked(T t) {
        this.g = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public void onConnectionSuspended(int i) {
        this.e = i;
        this.f = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.h = connectionResult.getErrorCode();
        this.i = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i, T t) {
        zzh zzhVar;
        Preconditions.checkArgument((i == 4) == (t != null));
        synchronized (this.o) {
            this.u = i;
            this.r = t;
            a(i, (int) t);
            switch (i) {
                case 1:
                    if (this.t != null) {
                        this.m.zza(this.j.a(), this.j.b(), this.j.c(), this.t, h());
                        this.t = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (this.t != null && this.j != null) {
                        String a2 = this.j.a();
                        String b2 = this.j.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 70 + String.valueOf(b2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(a2);
                        sb.append(" on ");
                        sb.append(b2);
                        Log.e("GmsClient", sb.toString());
                        this.m.zza(this.j.a(), this.j.b(), this.j.c(), this.t, h());
                        this.c.incrementAndGet();
                    }
                    this.t = new zze(this.c.get());
                    if (this.u == 3 && c() != null) {
                        zzhVar = new zzh(getContext().getPackageName(), c(), true, 129);
                    } else {
                        zzhVar = new zzh(b(), getStartServiceAction(), false, 129);
                    }
                    this.j = zzhVar;
                    if (!this.m.a(new GmsClientSupervisor.zza(this.j.a(), this.j.b(), this.j.c()), this.t, h())) {
                        String a3 = this.j.a();
                        String b3 = this.j.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(a3).length() + 34 + String.valueOf(b3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(a3);
                        sb2.append(" on ");
                        sb2.append(b3);
                        Log.e("GmsClient", sb2.toString());
                        a(16, (Bundle) null, this.c.get());
                        break;
                    }
                    break;
                case 4:
                    onConnectedLocked(t);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(int i, int i2, T t) {
        synchronized (this.o) {
            if (this.u != i) {
                return false;
            }
            b(i2, t);
            return true;
        }
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.n.isGooglePlayServicesAvailable(this.k, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            b(1, null);
            a(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, (PendingIntent) null);
        } else {
            connect(new LegacyClientCallbackAdapter());
        }
    }

    @KeepForSdk
    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.b = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        b(2, null);
    }

    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.o) {
            z = this.u == 4;
        }
        return z;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.o) {
            z = this.u == 2 || this.u == 3;
        }
        return z;
    }

    private final boolean i() {
        boolean z;
        synchronized (this.o) {
            z = this.u == 3;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @KeepForSdk
    public void disconnect() {
        this.c.incrementAndGet();
        synchronized (this.s) {
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                this.s.get(i).removeListener();
            }
            this.s.clear();
        }
        synchronized (this.p) {
            this.q = null;
        }
        b(1, null);
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i) {
        Handler handler = this.f1434a;
        handler.sendMessage(handler.obtainMessage(6, this.c.get(), i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        int i2;
        if (i()) {
            i2 = 5;
            this.A = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.f1434a;
        handler.sendMessage(handler.obtainMessage(i2, this.c.get(), 16));
    }

    @VisibleForTesting
    @KeepForSdk
    protected void a(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, PendingIntent pendingIntent) {
        this.b = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        Handler handler = this.f1434a;
        handler.sendMessage(handler.obtainMessage(3, this.c.get(), i, pendingIntent));
    }

    @KeepForSdk
    public final Context getContext() {
        return this.k;
    }

    @KeepForSdk
    public final Looper getLooper() {
        return this.l;
    }

    @KeepForSdk
    public Feature[] getApiFeatures() {
        return d;
    }

    @KeepForSdk
    protected Bundle d() {
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.f1434a;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
    }

    protected final void a(int i, Bundle bundle, int i2) {
        Handler handler = this.f1434a;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(i, null)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public final void e() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.o) {
            if (this.u == 5) {
                throw new DeadObjectException();
            }
            e();
            Preconditions.checkState(this.r != null, "Client is connected but service is null");
            t = this.r;
        }
        return t;
    }

    @KeepForSdk
    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle d2 = d();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.x);
        getServiceRequest.f1449a = this.k.getPackageName();
        getServiceRequest.d = d2;
        if (set != null) {
            getServiceRequest.c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            getServiceRequest.e = getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
            if (iAccountAccessor != null) {
                getServiceRequest.b = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.e = getAccount();
        }
        getServiceRequest.f = d;
        getServiceRequest.g = getApiFeatures();
        try {
            synchronized (this.p) {
                if (this.q != null) {
                    this.q.getService(new zzd(this, this.c.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(1);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            a(8, (IBinder) null, (Bundle) null, this.c.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            a(8, (IBinder) null, (Bundle) null, this.c.get());
        }
    }

    @KeepForSdk
    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @KeepForSdk
    protected Set<Scope> g() {
        return Collections.EMPTY_SET;
    }

    @KeepForSdk
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.o) {
            i = this.u;
            t = this.r;
        }
        synchronized (this.p) {
            iGmsServiceBroker = this.q;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print(ConstantUtils.NET_UNKNOWN);
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append(com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID);
        } else {
            printWriter.append((CharSequence) a()).append(IR.account.EMAIL_TAG).append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println(com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID);
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.g > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.g;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.f > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.e;
            switch (i2) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append((CharSequence) String.valueOf(i2));
                    break;
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.i > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.h));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.i;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        synchronized (this.p) {
            if (this.q == null) {
                return null;
            }
            return this.q.asBinder();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        if (this.A || TextUtils.isEmpty(a()) || TextUtils.isEmpty(c())) {
            return false;
        }
        try {
            Class.forName(a());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @KeepForSdk
    public String getEndpointPackageName() {
        zzh zzhVar;
        if (isConnected() && (zzhVar = this.j) != null) {
            return zzhVar.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
