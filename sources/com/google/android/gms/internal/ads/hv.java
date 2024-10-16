package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzard
/* loaded from: classes2.dex */
abstract class hv {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f2227a;

    public hv(View view) {
        this.f2227a = new WeakReference<>(view);
    }

    protected abstract void a(ViewTreeObserver viewTreeObserver);

    protected abstract void b(ViewTreeObserver viewTreeObserver);

    public final void a() {
        ViewTreeObserver c = c();
        if (c != null) {
            a(c);
        }
    }

    public final void b() {
        ViewTreeObserver c = c();
        if (c != null) {
            b(c);
        }
    }

    private final ViewTreeObserver c() {
        ViewTreeObserver viewTreeObserver;
        View view = this.f2227a.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }
}
