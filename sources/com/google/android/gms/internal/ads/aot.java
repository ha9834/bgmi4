package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class aot implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private Activity f2016a;
    private Context b;
    private Runnable h;
    private long j;
    private final Object c = new Object();
    private boolean d = true;
    private boolean e = false;

    @GuardedBy("lock")
    private final List<zzut> f = new ArrayList();

    @GuardedBy("lock")
    private final List<zzvg> g = new ArrayList();
    private boolean i = false;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void a(Application application, Context context) {
        if (this.i) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            a((Activity) context);
        }
        this.b = application;
        this.j = ((Long) zzyt.zzpe().zzd(zzacu.zzcox)).longValue();
        this.i = true;
    }

    public final void a(zzut zzutVar) {
        synchronized (this.c) {
            this.f.add(zzutVar);
        }
    }

    public final Activity a() {
        return this.f2016a;
    }

    public final Context b() {
        return this.b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity);
        this.e = false;
        boolean z = !this.d;
        this.d = true;
        if (this.h != null) {
            zzaxi.zzdvv.removeCallbacks(this.h);
        }
        synchronized (this.c) {
            Iterator<zzvg> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityResumed(activity);
                } catch (Exception e) {
                    zzk.zzlk().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbad.zzc("", e);
                }
            }
            if (z) {
                Iterator<zzut> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().zzp(true);
                    } catch (Exception e2) {
                        zzbad.zzc("", e2);
                    }
                }
            } else {
                zzawz.zzdp("App is still foreground.");
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity);
        synchronized (this.c) {
            Iterator<zzvg> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityPaused(activity);
                } catch (Exception e) {
                    zzk.zzlk().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbad.zzc("", e);
                }
            }
        }
        this.e = true;
        if (this.h != null) {
            zzaxi.zzdvv.removeCallbacks(this.h);
        }
        Handler handler = zzaxi.zzdvv;
        aou aouVar = new aou(this);
        this.h = aouVar;
        handler.postDelayed(aouVar, this.j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.c) {
            if (this.f2016a == null) {
                return;
            }
            if (this.f2016a.equals(activity)) {
                this.f2016a = null;
            }
            Iterator<zzvg> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().zza(activity)) {
                        it.remove();
                    }
                } catch (Exception e) {
                    zzk.zzlk().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    zzbad.zzc("", e);
                }
            }
        }
    }

    private final void a(Activity activity) {
        synchronized (this.c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f2016a = activity;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(aot aotVar, boolean z) {
        aotVar.d = false;
        return false;
    }
}
