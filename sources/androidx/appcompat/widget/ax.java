package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
class ax implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static ax j;
    private static ax k;

    /* renamed from: a, reason: collision with root package name */
    private final View f341a;
    private final CharSequence b;
    private final int c;
    private final Runnable d = new Runnable() { // from class: androidx.appcompat.widget.ax.1
        @Override // java.lang.Runnable
        public void run() {
            ax.this.a(false);
        }
    };
    private final Runnable e = new Runnable() { // from class: androidx.appcompat.widget.ax.2
        @Override // java.lang.Runnable
        public void run() {
            ax.this.a();
        }
    };
    private int f;
    private int g;
    private ay h;
    private boolean i;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public static void a(View view, CharSequence charSequence) {
        ax axVar = j;
        if (axVar != null && axVar.f341a == view) {
            a((ax) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            ax axVar2 = k;
            if (axVar2 != null && axVar2.f341a == view) {
                axVar2.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new ax(view, charSequence);
    }

    private ax(View view, CharSequence charSequence) {
        this.f341a = view;
        this.b = charSequence;
        this.c = androidx.core.f.w.a(ViewConfiguration.get(this.f341a.getContext()));
        d();
        this.f341a.setOnLongClickListener(this);
        this.f341a.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h != null && this.i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f341a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                d();
                a();
            }
        } else if (this.f341a.isEnabled() && this.h == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    void a(boolean z) {
        long longPressTimeout;
        if (androidx.core.f.v.A(this.f341a)) {
            a((ax) null);
            ax axVar = k;
            if (axVar != null) {
                axVar.a();
            }
            k = this;
            this.i = z;
            this.h = new ay(this.f341a.getContext());
            this.h.a(this.f341a, this.f, this.g, this.i, this.b);
            this.f341a.addOnAttachStateChangeListener(this);
            if (this.i) {
                longPressTimeout = 2500;
            } else if ((androidx.core.f.v.o(this.f341a) & 1) == 1) {
                longPressTimeout = 3000 - ViewConfiguration.getLongPressTimeout();
            } else {
                longPressTimeout = 15000 - ViewConfiguration.getLongPressTimeout();
            }
            this.f341a.removeCallbacks(this.e);
            this.f341a.postDelayed(this.e, longPressTimeout);
        }
    }

    void a() {
        if (k == this) {
            k = null;
            ay ayVar = this.h;
            if (ayVar != null) {
                ayVar.a();
                this.h = null;
                d();
                this.f341a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a((ax) null);
        }
        this.f341a.removeCallbacks(this.e);
    }

    private static void a(ax axVar) {
        ax axVar2 = j;
        if (axVar2 != null) {
            axVar2.c();
        }
        j = axVar;
        ax axVar3 = j;
        if (axVar3 != null) {
            axVar3.b();
        }
    }

    private void b() {
        this.f341a.postDelayed(this.d, ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.f341a.removeCallbacks(this.d);
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f) <= this.c && Math.abs(y - this.g) <= this.c) {
            return false;
        }
        this.f = x;
        this.g = y;
        return true;
    }

    private void d() {
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
    }
}
