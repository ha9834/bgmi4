package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class zzeh implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f3631a = new Handler(Looper.getMainLooper());
    private final Context b;
    private Application c;
    private final PowerManager d;
    private final KeyguardManager e;
    private final zzdy f;
    private BroadcastReceiver g;
    private WeakReference<ViewTreeObserver> h;
    private WeakReference<View> i;
    private aeg j;
    private byte k = -1;
    private int l = -1;
    private long m = -3;

    public zzeh(zzdy zzdyVar, View view) {
        this.f = zzdyVar;
        this.b = zzdyVar.f3628a;
        this.d = (PowerManager) this.b.getSystemService("power");
        this.e = (KeyguardManager) this.b.getSystemService("keyguard");
        Context context = this.b;
        if (context instanceof Application) {
            this.c = (Application) context;
            this.j = new aeg((Application) context, this);
        }
        a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(View view) {
        WeakReference<View> weakReference = this.i;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            c(view2);
        }
        this.i = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                b(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.m = -2L;
            return;
        }
        this.m = -3L;
    }

    private final void a() {
        f3631a.post(new aiy(this));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.l = -1;
        b(view);
        b();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.l = -1;
        b();
        a();
        c(view);
    }

    private final void a(Activity activity, int i) {
        Window window;
        if (this.i == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.i.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.l = i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 0);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 0);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 0);
        b();
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 4);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        b();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        b();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        b();
    }

    public final long zzcv() {
        if (this.m <= -2 && this.i.get() == null) {
            this.m = -3L;
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0066, code lost:
    
        if (r7 == false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.i
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L15
            r9.m = r2
            r9.k = r1
            return
        L15:
            int r4 = r0.getVisibility()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L1f
            r4 = 1
            goto L20
        L1f:
            r4 = 0
        L20:
            boolean r7 = r0.isShown()
            if (r7 != 0) goto L29
            r4 = r4 | 2
            byte r4 = (byte) r4
        L29:
            android.os.PowerManager r7 = r9.d
            if (r7 == 0) goto L36
            boolean r7 = r7.isScreenOn()
            if (r7 != 0) goto L36
            r4 = r4 | 4
            byte r4 = (byte) r4
        L36:
            com.google.android.gms.internal.ads.zzdy r7 = r9.f
            boolean r7 = r7.zzco()
            if (r7 != 0) goto L6a
            android.app.KeyguardManager r7 = r9.e
            if (r7 == 0) goto L69
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L69
            android.app.Activity r7 = com.google.android.gms.internal.ads.zzef.zzc(r0)
            if (r7 == 0) goto L65
            android.view.Window r7 = r7.getWindow()
            if (r7 != 0) goto L56
            r7 = 0
            goto L5a
        L56:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
        L5a:
            if (r7 == 0) goto L65
            int r7 = r7.flags
            r8 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r8
            if (r7 == 0) goto L65
            r7 = 1
            goto L66
        L65:
            r7 = 0
        L66:
            if (r7 == 0) goto L69
            goto L6a
        L69:
            r5 = 0
        L6a:
            if (r5 != 0) goto L6f
            r4 = r4 | 8
            byte r4 = (byte) r4
        L6f:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L7d
            r4 = r4 | 16
            byte r4 = (byte) r4
        L7d:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L8b
            r4 = r4 | 32
            byte r4 = (byte) r4
        L8b:
            int r0 = r0.getWindowVisibility()
            int r5 = r9.l
            if (r5 == r1) goto L94
            r0 = r5
        L94:
            if (r0 == 0) goto L99
            r0 = r4 | 64
            byte r4 = (byte) r0
        L99:
            byte r0 = r9.k
            if (r0 == r4) goto Lad
            r9.k = r4
            byte r0 = r9.k
            if (r0 != 0) goto La8
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto Lab
        La8:
            long r0 = (long) r0
            long r0 = r2 - r0
        Lab:
            r9.m = r0
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeh.b():void");
    }

    private final void b(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.h = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.g = new aiz(this);
            this.b.registerReceiver(this.g, intentFilter);
        }
        Application application = this.c;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.j);
            } catch (Exception unused) {
            }
        }
    }

    private final void c(View view) {
        try {
            if (this.h != null) {
                ViewTreeObserver viewTreeObserver = this.h.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.h = null;
            }
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.g;
        if (broadcastReceiver != null) {
            try {
                this.b.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.g = null;
        }
        Application application = this.c;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.j);
            } catch (Exception unused4) {
            }
        }
    }
}
