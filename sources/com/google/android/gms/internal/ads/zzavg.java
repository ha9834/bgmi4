package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzavg {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<ThreadPoolExecutor> f2812a = new AtomicReference<>(null);
    private final Object b = new Object();

    @GuardedBy("gmpAppIdLock")
    private String c = null;

    @GuardedBy("gmpAppIdLock")
    private String d = null;

    @VisibleForTesting
    private final AtomicBoolean e = new AtomicBoolean(false);

    @VisibleForTesting
    private final AtomicInteger f = new AtomicInteger(-1);
    private final AtomicReference<Object> g = new AtomicReference<>(null);
    private final AtomicReference<Object> h = new AtomicReference<>(null);
    private final ConcurrentMap<String, Method> i = new ConcurrentHashMap(9);
    private final AtomicReference<zzbjf> j = new AtomicReference<>(null);

    @GuardedBy("proxyReference")
    private final List<FutureTask> k = new ArrayList();

    public final boolean zzx(Context context) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcns)).booleanValue() || this.e.get()) {
            return false;
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoc)).booleanValue()) {
            return true;
        }
        if (this.f.get() == -1) {
            zzyt.zzpa();
            if (!zzazt.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzyt.zzpa();
                if (zzazt.zzbg(context)) {
                    zzawz.zzep("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                    this.f.set(0);
                }
            }
            this.f.set(1);
        }
        return this.f.get() == 1;
    }

    @VisibleForTesting
    private static boolean b(Context context) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcnz)).booleanValue()) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcoa)).booleanValue()) {
                return false;
            }
        }
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcob)).booleanValue()) {
            return true;
        }
        try {
            context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        }
    }

    public final void zzd(Context context, final String str) {
        if (zzx(context)) {
            if (b(context)) {
                a("beginAdUnitExposure", new fb(str) { // from class: com.google.android.gms.internal.ads.em

                    /* renamed from: a, reason: collision with root package name */
                    private final String f2150a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2150a = str;
                    }

                    @Override // com.google.android.gms.internal.ads.fb
                    public final void a(zzbjf zzbjfVar) {
                        zzbjfVar.beginAdUnitExposure(this.f2150a);
                    }
                });
            } else {
                a(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zze(Context context, final String str) {
        if (zzx(context)) {
            if (b(context)) {
                a("endAdUnitExposure", new fb(str) { // from class: com.google.android.gms.internal.ads.en

                    /* renamed from: a, reason: collision with root package name */
                    private final String f2151a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2151a = str;
                    }

                    @Override // com.google.android.gms.internal.ads.fb
                    public final void a(zzbjf zzbjfVar) {
                        zzbjfVar.endAdUnitExposure(this.f2151a);
                    }
                });
            } else {
                a(context, str, "endAdUnitExposure");
            }
        }
    }

    public final String zzz(Context context) {
        if (!zzx(context)) {
            return "";
        }
        if (b(context)) {
            return (String) a("getCurrentScreenNameOrScreenClass", "", (fa<String>) er.f2155a);
        }
        if (!a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            return "";
        }
        try {
            String str = (String) b(context, "getCurrentScreenName").invoke(this.g.get(), new Object[0]);
            if (str == null) {
                str = (String) b(context, "getCurrentScreenClass").invoke(this.g.get(), new Object[0]);
            }
            return str != null ? str : "";
        } catch (Exception e) {
            a(e, "getCurrentScreenName", false);
            return "";
        }
    }

    public final void zzf(final Context context, final String str) {
        if (zzx(context) && (context instanceof Activity)) {
            if (b(context)) {
                a("setScreenName", new fb(context, str) { // from class: com.google.android.gms.internal.ads.es

                    /* renamed from: a, reason: collision with root package name */
                    private final Context f2156a;
                    private final String b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2156a = context;
                        this.b = str;
                    }

                    @Override // com.google.android.gms.internal.ads.fb
                    public final void a(zzbjf zzbjfVar) {
                        Context context2 = this.f2156a;
                        zzbjfVar.zzb(ObjectWrapper.wrap(context2), this.b, context2.getPackageName());
                    }
                });
                return;
            }
            if (a(context, "com.google.firebase.analytics.FirebaseAnalytics", this.h, false)) {
                try {
                    c(context, "setCurrentScreen").invoke(this.h.get(), (Activity) context, str, context.getPackageName());
                } catch (Exception e) {
                    a(e, "setCurrentScreen", false);
                }
            }
        }
    }

    public final String zzaa(Context context) {
        if (!zzx(context)) {
            return null;
        }
        synchronized (this.b) {
            if (this.c != null) {
                return this.c;
            }
            if (b(context)) {
                this.c = (String) a("getGmpAppId", this.c, (fa<String>) et.f2157a);
            } else {
                this.c = (String) a("getGmpAppId", context);
            }
            return this.c;
        }
    }

    public final String zzab(final Context context) {
        if (!zzx(context)) {
            return null;
        }
        long longValue = ((Long) zzyt.zzpe().zzd(zzacu.zzcnx)).longValue();
        if (b(context)) {
            try {
                if (longValue < 0) {
                    return (String) a("getAppInstanceId", eu.f2158a).get();
                }
                return (String) a("getAppInstanceId", ev.f2159a).get(longValue, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                if (e instanceof TimeoutException) {
                    return "TIME_OUT";
                }
                return null;
            }
        }
        if (longValue < 0) {
            return (String) a("getAppInstanceId", context);
        }
        Future submit = a().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.ew

            /* renamed from: a, reason: collision with root package name */
            private final zzavg f2160a;
            private final Context b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2160a = this;
                this.b = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2160a.a(this.b);
            }
        });
        try {
            return (String) submit.get(longValue, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            submit.cancel(true);
            if (e2 instanceof TimeoutException) {
                return "TIME_OUT";
            }
            return null;
        }
    }

    public final String zzac(Context context) {
        if (!zzx(context)) {
            return null;
        }
        if (b(context)) {
            Long l = (Long) a("getAdEventId", (String) null, (fa<String>) ex.f2161a);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object a2 = a("generateEventId", context);
        if (a2 != null) {
            return a2.toString();
        }
        return null;
    }

    public final String zzad(Context context) {
        if (!zzx(context)) {
            return null;
        }
        synchronized (this.b) {
            if (this.d != null) {
                return this.d;
            }
            if (b(context)) {
                this.d = (String) a("getAppIdOrigin", this.d, (fa<String>) ey.f2162a);
            } else {
                this.d = "fa";
            }
            return this.d;
        }
    }

    public final void zzg(Context context, String str) {
        a(context, "_ac", str, (Bundle) null);
    }

    public final void zzh(Context context, String str) {
        a(context, "_ai", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        a(context, "_aq", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        a(context, "_aa", str, (Bundle) null);
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzx(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("type", str3);
            bundle.putInt("value", i);
            a(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzawz.zzds(sb.toString());
        }
    }

    private final void a(Context context, final String str, String str2, Bundle bundle) {
        if (zzx(context)) {
            final Bundle a2 = a(str2, str);
            if (bundle != null) {
                a2.putAll(bundle);
            }
            if (b(context)) {
                a("logEventInternal", new fb(str, a2) { // from class: com.google.android.gms.internal.ads.eo

                    /* renamed from: a, reason: collision with root package name */
                    private final String f2152a;
                    private final Bundle b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2152a = str;
                        this.b = a2;
                    }

                    @Override // com.google.android.gms.internal.ads.fb
                    public final void a(zzbjf zzbjfVar) {
                        zzbjfVar.logEvent("am", this.f2152a, this.b);
                    }
                });
                return;
            }
            if (a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
                try {
                    c(context).invoke(this.g.get(), "am", str, a2);
                } catch (Exception e) {
                    a(e, "logEventInternal", true);
                }
            }
        }
    }

    private static Bundle a(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzawz.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    private final Method c(Context context) {
        Method method = this.i.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.i.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            a(e, "logEventInternal", true);
            return null;
        }
    }

    private final Method a(Context context, String str) {
        Method method = this.i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            a(e, str, false);
            return null;
        }
    }

    private final Method b(Context context, String str) {
        Method method = this.i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            a(e, str, false);
            return null;
        }
    }

    private final Method c(Context context, String str) {
        Method method = this.i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            a(e, str, false);
            return null;
        }
    }

    private final void a(Context context, String str, String str2) {
        if (a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            try {
                a(context, str2).invoke(this.g.get(), str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzawz.zzds(sb.toString());
            } catch (Exception e) {
                a(e, str2, false);
            }
        }
    }

    private final Object a(String str, Context context) {
        if (!a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            return null;
        }
        try {
            return b(context, str).invoke(this.g.get(), new Object[0]);
        } catch (Exception e) {
            a(e, str, true);
            return null;
        }
    }

    private final void a(Exception exc, String str, boolean z) {
        if (this.e.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
        sb.append("Invoke Firebase method ");
        sb.append(str);
        sb.append(" error.");
        zzawz.zzep(sb.toString());
        if (z) {
            zzawz.zzep("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.e.set(true);
        }
    }

    private final ThreadPoolExecutor a() {
        if (this.f2812a.get() == null) {
            this.f2812a.compareAndSet(null, new ThreadPoolExecutor(((Integer) zzyt.zzpe().zzd(zzacu.zzcny)).intValue(), ((Integer) zzyt.zzpe().zzd(zzacu.zzcny)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ez(this)));
        }
        return this.f2812a.get();
    }

    private final boolean a(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception e) {
                a(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void a(final String str, final fb fbVar) {
        synchronized (this.j) {
            FutureTask futureTask = new FutureTask(new Runnable(this, fbVar, str) { // from class: com.google.android.gms.internal.ads.ep

                /* renamed from: a, reason: collision with root package name */
                private final zzavg f2153a;
                private final fb b;
                private final String c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2153a = this;
                    this.b = fbVar;
                    this.c = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2153a.a(this.b, this.c);
                }
            }, null);
            if (this.j.get() != null) {
                futureTask.run();
            } else {
                this.k.add(futureTask);
            }
        }
    }

    private final <T> Future<T> a(final String str, final fa<T> faVar) {
        FutureTask futureTask;
        synchronized (this.j) {
            futureTask = new FutureTask(new Callable(this, faVar, str) { // from class: com.google.android.gms.internal.ads.eq

                /* renamed from: a, reason: collision with root package name */
                private final zzavg f2154a;
                private final fa b;
                private final String c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2154a = this;
                    this.b = faVar;
                    this.c = str;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f2154a.a(this.b, this.c);
                }
            });
            if (this.j.get() != null) {
                a().submit(futureTask);
            } else {
                this.k.add(futureTask);
            }
        }
        return futureTask;
    }

    private final <T> T a(String str, T t, fa<T> faVar) {
        synchronized (this.j) {
            if (this.j.get() != null) {
                try {
                    return faVar.a(this.j.get());
                } catch (Exception e) {
                    a(e, str, false);
                }
            }
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object a(fa faVar, String str) throws Exception {
        try {
            return faVar.a(this.j.get());
        } catch (Exception e) {
            a(e, str, false);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(fb fbVar, String str) {
        if (this.j.get() != null) {
            try {
                fbVar.a(this.j.get());
            } catch (Exception e) {
                a(e, str, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String a(Context context) throws Exception {
        return (String) a("getAppInstanceId", context);
    }
}
