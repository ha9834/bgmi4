package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zaa extends ActivityLifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<a> f1382a;

    public zaa(Activity activity) {
        this(a.b(activity));
    }

    private zaa(a aVar) {
        this.f1382a = new WeakReference<>(aVar);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        a aVar = this.f1382a.get();
        if (aVar == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        aVar.a(runnable);
        return this;
    }

    /* loaded from: classes.dex */
    static class a extends LifecycleCallback {
        private List<Runnable> b;

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(Activity activity) {
            a aVar;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                aVar = (a) fragment.getCallbackOrNull("LifecycleObserverOnStop", a.class);
                if (aVar == null) {
                    aVar = new a(fragment);
                }
            }
            return aVar;
        }

        private a(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.b = new ArrayList();
            this.f1316a.addCallback("LifecycleObserverOnStop", this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void a(Runnable runnable) {
            this.b.add(runnable);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.b;
                this.b = new ArrayList();
            }
            Iterator<Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }
}
