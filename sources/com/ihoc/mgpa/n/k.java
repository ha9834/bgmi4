package com.ihoc.mgpa.n;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class k implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static k f5674a;
    private boolean b = true;
    private boolean c = true;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final List<a> e = new CopyOnWriteArrayList();
    private Runnable f;

    /* loaded from: classes2.dex */
    public interface a {
        void onBecameBackground();

        void onBecameForeground();
    }

    public static k a(Application application) {
        if (f5674a == null) {
            f5674a = new k();
            application.registerActivityLifecycleCallbacks(f5674a);
        }
        return f5674a;
    }

    public static k a(Context context) {
        if (f5674a == null) {
            Context applicationContext = context.getApplicationContext();
            if (!(applicationContext instanceof Application)) {
                throw new IllegalStateException("Foreground is not initialised and cannot obtain the Application object");
            }
            a((Application) applicationContext);
        }
        return f5674a;
    }

    public void a(a aVar) {
        this.e.add(aVar);
    }

    public boolean a() {
        return !this.b;
    }

    public void b(a aVar) {
        this.e.remove(aVar);
    }

    public boolean b() {
        return this.b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.c = true;
        Runnable runnable = this.f;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
        }
        Handler handler = this.d;
        j jVar = new j(this);
        this.f = jVar;
        handler.postDelayed(jVar, 500L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.c = false;
        boolean z = !this.b;
        this.b = true;
        Runnable runnable = this.f;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
        }
        if (!z) {
            m.a("TGPA_ForegroundCallbacks", "still foreground");
            return;
        }
        Iterator<a> it = this.e.iterator();
        while (it.hasNext()) {
            try {
                it.next().onBecameForeground();
            } catch (Exception e) {
                m.b("TGPA_ForegroundCallbacks", "Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
