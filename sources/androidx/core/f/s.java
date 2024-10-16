package androidx.core.f;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class s implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f543a;
    private ViewTreeObserver b;
    private final Runnable c;

    private s(View view, Runnable runnable) {
        this.f543a = view;
        this.b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static s a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        s sVar = new s(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(sVar);
        view.addOnAttachStateChangeListener(sVar);
        return sVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    public void a() {
        if (this.b.isAlive()) {
            this.b.removeOnPreDrawListener(this);
        } else {
            this.f543a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f543a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
