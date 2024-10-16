package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzby;
import com.google.android.gms.internal.gtm.zzch;
import com.google.android.gms.internal.gtm.zzcw;
import com.google.android.gms.internal.gtm.zzcy;
import com.google.android.gms.internal.gtm.zzda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@VisibleForTesting
/* loaded from: classes.dex */
public final class GoogleAnalytics extends zza {
    private static List<Runnable> b = new ArrayList();
    private boolean c;
    private Set<a> d;
    private boolean e;
    private boolean f;
    private volatile boolean g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(Activity activity);

        void b(Activity activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(14)
    /* loaded from: classes.dex */
    public class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.b(activity);
        }
    }

    public final void zzag() {
        zzda zzcu = a().zzcu();
        zzcu.zzgh();
        if (zzcu.zzgi()) {
            setDryRun(zzcu.zzgj());
        }
        zzcu.zzgh();
        this.c = true;
    }

    public final boolean isInitialized() {
        return this.c;
    }

    @VisibleForTesting
    public GoogleAnalytics(zzap zzapVar) {
        super(zzapVar);
        this.d = new HashSet();
    }

    public static GoogleAnalytics getInstance(Context context) {
        return zzap.zzc(context).zzde();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzah() {
        synchronized (GoogleAnalytics.class) {
            if (b != null) {
                Iterator<Runnable> it = b.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                b = null;
            }
        }
    }

    public final void setDryRun(boolean z) {
        this.f = z;
    }

    public final boolean isDryRunEnabled() {
        return this.f;
    }

    @TargetApi(14)
    public final void enableAutoActivityReports(Application application) {
        if (this.e) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new b());
        this.e = true;
    }

    public final void reportActivityStart(Activity activity) {
        if (this.e) {
            return;
        }
        a(activity);
    }

    @VisibleForTesting
    final void a(Activity activity) {
        Iterator<a> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(activity);
        }
    }

    public final void reportActivityStop(Activity activity) {
        if (this.e) {
            return;
        }
        b(activity);
    }

    @VisibleForTesting
    final void b(Activity activity) {
        Iterator<a> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().b(activity);
        }
    }

    public final Tracker newTracker(String str) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(a(), str, null);
            tracker.zzag();
        }
        return tracker;
    }

    public final Tracker newTracker(int i) {
        Tracker tracker;
        zzcy zzq;
        synchronized (this) {
            tracker = new Tracker(a(), null, null);
            if (i > 0 && (zzq = new zzcw(a()).zzq(i)) != null) {
                tracker.a(zzq);
            }
            tracker.zzag();
        }
        return tracker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(a aVar) {
        this.d.add(aVar);
        Context context = a().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(a aVar) {
        this.d.remove(aVar);
    }

    public final void setAppOptOut(boolean z) {
        this.g = z;
        if (this.g) {
            a().zzcs().zzch();
        }
    }

    public final boolean getAppOptOut() {
        return this.g;
    }

    @Deprecated
    public final Logger getLogger() {
        return zzch.getLogger();
    }

    @Deprecated
    public final void setLogger(Logger logger) {
        zzch.setLogger(logger);
        if (this.h) {
            return;
        }
        String str = zzby.zzzb.get();
        String str2 = zzby.zzzb.get();
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 112);
        sb.append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
        sb.append(str2);
        sb.append(" DEBUG");
        Log.i(str, sb.toString());
        this.h = true;
    }

    public final void setLocalDispatchPeriod(int i) {
        a().zzcs().setLocalDispatchPeriod(i);
    }

    public final void dispatchLocalHits() {
        a().zzcs().zzci();
    }
}
