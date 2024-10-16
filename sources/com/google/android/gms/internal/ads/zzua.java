package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ScrollView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@zzard
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzua implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private static final long f3749a = ((Long) zzyt.zzpe().zzd(zzacu.zzcqi)).longValue();
    private final Context b;
    private Application c;
    private final WindowManager d;
    private final PowerManager e;
    private final KeyguardManager f;

    @VisibleForTesting
    private BroadcastReceiver g;
    private WeakReference<ViewTreeObserver> h;
    private WeakReference<View> i;
    private aol j;
    private zzazj k = new zzazj(f3749a);
    private boolean l = false;
    private int m = -1;
    private final HashSet<zzue> n = new HashSet<>();
    private final DisplayMetrics o;
    private final Rect p;

    public zzua(Context context, View view) {
        this.b = context.getApplicationContext();
        this.d = (WindowManager) context.getSystemService("window");
        this.e = (PowerManager) this.b.getSystemService("power");
        this.f = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.b;
        if (context2 instanceof Application) {
            this.c = (Application) context2;
            this.j = new aol((Application) context2, this);
        }
        this.o = context.getResources().getDisplayMetrics();
        this.p = new Rect();
        this.p.right = this.d.getDefaultDisplay().getWidth();
        this.p.bottom = this.d.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.i;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            c(view2);
        }
        this.i = new WeakReference<>(view);
        if (view != null) {
            if (zzk.zzli().isAttachedToWindow(view)) {
                b(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public final void zza(zzue zzueVar) {
        this.n.add(zzueVar);
        a(3);
    }

    public final void zzb(zzue zzueVar) {
        this.n.remove(zzueVar);
    }

    private final void a() {
        zzk.zzlg();
        zzaxi.zzdvv.post(new aoj(this));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.m = -1;
        b(view);
        a(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.m = -1;
        a(3);
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
        this.m = i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 0);
        a(3);
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 0);
        a(3);
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 0);
        a(3);
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 4);
        a(3);
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(3);
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(3);
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(3);
        a();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        a(2);
        a();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        WeakReference<View> weakReference;
        boolean z;
        boolean z2;
        List<Rect> emptyList;
        if (this.n.size() == 0 || (weakReference = this.i) == null) {
            return;
        }
        View view = weakReference.get();
        boolean z3 = i == 1;
        boolean z4 = view == null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
            boolean localVisibleRect = view.getLocalVisibleRect(rect3);
            view.getHitRect(rect4);
            try {
                view.getLocationOnScreen(iArr);
                view.getLocationInWindow(iArr2);
            } catch (Exception e) {
                zzawz.zzc("Failure getting view location.", e);
            }
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            z = globalVisibleRect;
            z2 = localVisibleRect;
        } else {
            z = false;
            z2 = false;
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcql)).booleanValue() && view != null) {
            emptyList = a(view);
        } else {
            emptyList = Collections.emptyList();
        }
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        int i2 = this.m;
        if (i2 != -1) {
            windowVisibility = i2;
        }
        boolean z5 = !z4 && zzk.zzlg().zza(view, this.e, this.f) && z && z2 && windowVisibility == 0;
        if (z3 && !this.k.tryAcquire() && z5 == this.l) {
            return;
        }
        if (z5 || this.l || i != 1) {
            zzud zzudVar = new zzud(zzk.zzln().elapsedRealtime(), this.e.isScreenOn(), view != null && zzk.zzli().isAttachedToWindow(view), view != null ? view.getWindowVisibility() : 8, a(this.p), a(rect), a(rect2), z, a(rect3), z2, a(rect4), this.o.density, z5, emptyList);
            Iterator<zzue> it = this.n.iterator();
            while (it.hasNext()) {
                it.next().zza(zzudVar);
            }
            this.l = z5;
        }
    }

    private final Rect a(Rect rect) {
        return new Rect(b(rect.left), b(rect.top), b(rect.right), b(rect.bottom));
    }

    private final int b(int i) {
        return (int) (i / this.o.density);
    }

    private final List<Rect> a(View view) {
        boolean z;
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (Build.VERSION.SDK_INT >= 16) {
                    z = view2.isScrollContainer();
                } else {
                    if (!(view2 instanceof ScrollView) && !(view2 instanceof ListView)) {
                        z = false;
                    }
                    z = true;
                }
                if (z && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(a(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzk.zzlk().zza(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
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
            this.g = new aok(this);
            zzk.zzmb().zza(this.b, this.g, intentFilter);
        }
        Application application = this.c;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.j);
            } catch (Exception e) {
                zzawz.zzc("Error registering activity lifecycle callbacks.", e);
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
        } catch (Exception e) {
            zzawz.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzawz.zzc("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.g != null) {
            try {
                zzk.zzmb().zza(this.b, this.g);
            } catch (IllegalStateException e3) {
                zzawz.zzc("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzk.zzlk().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.g = null;
        }
        Application application = this.c;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.j);
            } catch (Exception e5) {
                zzawz.zzc("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void zzes(long j) {
        this.k.zzfe(j);
    }

    public final void zzmk() {
        this.k.zzfe(f3749a);
    }
}
