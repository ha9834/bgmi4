package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.uqm.crashsight.CrashSight;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class zzz {
    private static volatile zzz b = null;
    private static Boolean h = null;
    private static Boolean i = null;
    private static boolean j = false;
    private static Boolean k = null;

    @VisibleForTesting
    private static String l = "use_dynamite_api";

    @VisibleForTesting
    private static String m = "allow_remote_dynamite";
    private static boolean n;
    private static boolean o;

    /* renamed from: a, reason: collision with root package name */
    protected final Clock f4643a;
    private final String c;
    private final ExecutorService d;
    private final AppMeasurementSdk e;
    private List<Pair<com.google.android.gms.measurement.internal.zzgn, d>> f;
    private int g;
    private boolean p;
    private String q;
    private zzk r;

    /* loaded from: classes2.dex */
    class c implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzz.this.a(new ad(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzz.this.a(new ac(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzz.this.a(new af(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzz.this.a(new ae(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzz.this.a(new ah(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzl zzlVar = new zzl();
            zzz.this.a(new ag(this, activity, zzlVar));
            Bundle zzb = zzlVar.zzb(50L);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzz.this.a(new ai(this, activity));
        }
    }

    public static zzz zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public abstract class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final long f4645a;
        final long b;
        private final boolean c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(zzz zzzVar) {
            this(true);
        }

        abstract void a() throws RemoteException;

        protected void b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(boolean z) {
            this.f4645a = zzz.this.f4643a.currentTimeMillis();
            this.b = zzz.this.f4643a.elapsedRealtime();
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzz.this.p) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e) {
                zzz.this.a(e, false, this.c);
                b();
            }
        }
    }

    public static zzz zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (b == null) {
            synchronized (zzz.class) {
                if (b == null) {
                    b = new zzz(context, str, str2, str3, bundle);
                }
            }
        }
        return b;
    }

    /* loaded from: classes2.dex */
    static class a extends zzt {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.gms.measurement.internal.zzgk f4644a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(com.google.android.gms.measurement.internal.zzgk zzgkVar) {
            this.f4644a = zzgkVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzq
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.f4644a.interceptEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzq
        public final int id() {
            return System.identityHashCode(this.f4644a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d extends zzt {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.gms.measurement.internal.zzgn f4647a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(com.google.android.gms.measurement.internal.zzgn zzgnVar) {
            this.f4647a = zzgnVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzq
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.f4647a.onEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzq
        public final int id() {
            return System.identityHashCode(this.f4647a);
        }
    }

    public final AppMeasurementSdk zzg() {
        return this.e;
    }

    private zzz(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !a(str2, str3)) {
            this.c = "FA";
        } else {
            this.c = str;
        }
        this.f4643a = DefaultClock.getInstance();
        this.d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.e = new AppMeasurementSdk(this);
        if (!(!d(context) || b())) {
            this.q = null;
            this.p = true;
            Log.w(this.c, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!a(str2, str3)) {
            this.q = "fa";
            if (str2 != null && str3 != null) {
                Log.v(this.c, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.p = true;
                return;
            } else {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.c, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            }
        } else {
            this.q = str2;
        }
        a(new es(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.c, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new c());
        }
    }

    private static boolean d(Context context) {
        try {
            GoogleServices.initialize(context);
            return GoogleServices.getGoogleAppId() != null;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(String str, String str2) {
        return (str2 == null || str == null || b()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(b bVar) {
        this.d.execute(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzk a(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        try {
            if (z) {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } else {
                versionPolicy = DynamiteModule.PREFER_LOCAL;
            }
            return zzn.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            a((Exception) e, true, false);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Exception exc, boolean z, boolean z2) {
        this.p |= z;
        if (z) {
            Log.w(this.c, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.c, "Error with data collection. Data lost.", exc);
    }

    private static boolean b() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zza(com.google.android.gms.measurement.internal.zzgk zzgkVar) {
        a(new l(this, zzgkVar));
    }

    public final void zza(com.google.android.gms.measurement.internal.zzgn zzgnVar) {
        Preconditions.checkNotNull(zzgnVar);
        a(new u(this, zzgnVar));
    }

    public final void zzb(com.google.android.gms.measurement.internal.zzgn zzgnVar) {
        Preconditions.checkNotNull(zzgnVar);
        a(new z(this, zzgnVar));
    }

    public final void logEvent(String str, Bundle bundle) {
        a(null, str, bundle, false, true, null);
    }

    public final void logEventInternal(String str, String str2, Bundle bundle) {
        a(str, str2, bundle, true, true, null);
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j2) {
        a(str, str2, bundle, true, false, Long.valueOf(j2));
    }

    private final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l2) {
        a(new y(this, l2, str, str2, bundle, z, z2));
    }

    public final void setUserProperty(String str, String str2) {
        a((String) null, str, (Object) str2, false);
    }

    public final void setUserPropertyInternal(String str, String str2, Object obj) {
        a(str, str2, obj, true);
    }

    private final void a(String str, String str2, Object obj, boolean z) {
        a(new ab(this, str, str2, obj, z));
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        a(new aa(this, bundle));
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        a(new com.google.android.gms.internal.measurement.b(this, str, str2, bundle));
    }

    public final List<Bundle> getConditionalUserProperties(String str, String str2) {
        zzl zzlVar = new zzl();
        a(new com.google.android.gms.internal.measurement.a(this, str, str2, zzlVar));
        List<Bundle> list = (List) zzl.zza(zzlVar.zzb(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void setUserId(String str) {
        a(new com.google.android.gms.internal.measurement.d(this, str));
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        a(new com.google.android.gms.internal.measurement.c(this, activity, str, str2));
    }

    public final void setMeasurementEnabled(boolean z) {
        a(new f(this, z));
    }

    public final void resetAnalyticsData() {
        a(new e(this));
    }

    public final void setMinimumSessionDuration(long j2) {
        a(new h(this, j2));
    }

    public final void setSessionTimeoutDuration(long j2) {
        a(new g(this, j2));
    }

    public final void beginAdUnitExposure(String str) {
        a(new j(this, str));
    }

    public final void endAdUnitExposure(String str) {
        a(new i(this, str));
    }

    public final String getGmpAppId() {
        zzl zzlVar = new zzl();
        a(new k(this, zzlVar));
        return zzlVar.zza(500L);
    }

    public final String zzi() {
        zzl zzlVar = new zzl();
        a(new n(this, zzlVar));
        return zzlVar.zza(50L);
    }

    public final long generateEventId() {
        zzl zzlVar = new zzl();
        a(new m(this, zzlVar));
        Long l2 = (Long) zzl.zza(zzlVar.zzb(500L), Long.class);
        if (l2 == null) {
            long nextLong = new Random(System.nanoTime() ^ this.f4643a.currentTimeMillis()).nextLong();
            int i2 = this.g + 1;
            this.g = i2;
            return nextLong + i2;
        }
        return l2.longValue();
    }

    public final String getCurrentScreenName() {
        zzl zzlVar = new zzl();
        a(new p(this, zzlVar));
        return zzlVar.zza(500L);
    }

    public final String getCurrentScreenClass() {
        zzl zzlVar = new zzl();
        a(new o(this, zzlVar));
        return zzlVar.zza(500L);
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzl zzlVar = new zzl();
        a(new r(this, str, str2, z, zzlVar));
        Bundle zzb = zzlVar.zzb(5000L);
        if (zzb == null || zzb.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb.size());
        for (String str3 : zzb.keySet()) {
            Object obj = zzb.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i2, String str, Object obj, Object obj2, Object obj3) {
        a(new q(this, false, 5, str, obj, null, null));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzl zzlVar = new zzl();
        a(new t(this, bundle, zzlVar));
        if (z) {
            return zzlVar.zzb(5000L);
        }
        return null;
    }

    public final int getMaxUserProperties(String str) {
        zzl zzlVar = new zzl();
        a(new s(this, str, zzlVar));
        Integer num = (Integer) zzl.zza(zzlVar.zzb(LogUtils.LOG_FUSE_TIME), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String getAppInstanceId() {
        zzl zzlVar = new zzl();
        a(new v(this, zzlVar));
        return zzlVar.zza(120000L);
    }

    public final String getAppIdOrigin() {
        return this.q;
    }

    public final Object zzb(int i2) {
        zzl zzlVar = new zzl();
        a(new x(this, zzlVar, i2));
        return zzl.zza(zzlVar.zzb(15000L), Object.class);
    }

    public final void setDataCollectionEnabled(boolean z) {
        a(new w(this, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context) {
        synchronized (zzz.class) {
            try {
            } catch (ClassCastException | IllegalStateException | NullPointerException e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                h = false;
                i = false;
            }
            if (h == null || i == null) {
                if (a(context, "app_measurement_internal_disable_startup_flags")) {
                    h = false;
                    i = false;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                h = Boolean.valueOf(sharedPreferences.getBoolean(l, false));
                i = Boolean.valueOf(sharedPreferences.getBoolean(m, false));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(l);
                edit.remove(m);
                edit.apply();
            }
        }
    }

    public static boolean zzf(Context context) {
        g(context);
        synchronized (zzz.class) {
            if (!j) {
                try {
                    try {
                        String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "measurement.dynamite.enabled", "");
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str)) {
                            k = true;
                        } else if (CrashSight.SDK_IS_DEV.equals(str)) {
                            k = false;
                        } else {
                            k = null;
                        }
                        j = true;
                    } finally {
                        j = true;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    Log.e("FA", "Unable to call SystemProperties.get()", e);
                    k = null;
                }
            }
        }
        Boolean bool = k;
        if (bool == null) {
            bool = h;
        }
        return bool.booleanValue();
    }

    private static boolean a(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData.getBoolean(str);
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
