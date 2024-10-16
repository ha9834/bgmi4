package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class af implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final float f312a;
    private final int b;
    final View c;
    private final int d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    public abstract androidx.appcompat.view.menu.p a();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public af(View view) {
        this.c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f312a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.d = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        if (z2) {
            z = b(motionEvent) || !c();
        } else {
            z = a(motionEvent) && b();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.c.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.h = -1;
        Runnable runnable = this.e;
        if (runnable != null) {
            this.c.removeCallbacks(runnable);
        }
    }

    protected boolean b() {
        androidx.appcompat.view.menu.p a2 = a();
        if (a2 == null || a2.e()) {
            return true;
        }
        a2.d_();
        return true;
    }

    protected boolean c() {
        androidx.appcompat.view.menu.p a2 = a();
        if (a2 == null || !a2.e()) {
            return true;
        }
        a2.d();
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean a(MotionEvent motionEvent) {
        View view = this.c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.h = motionEvent.getPointerId(0);
                if (this.e == null) {
                    this.e = new a();
                }
                view.postDelayed(this.e, this.b);
                if (this.f == null) {
                    this.f = new b();
                }
                view.postDelayed(this.f, this.d);
                return false;
            case 1:
            case 3:
                e();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.h);
                if (findPointerIndex >= 0 && !a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f312a)) {
                    e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private void e() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.c.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.e;
        if (runnable2 != null) {
            this.c.removeCallbacks(runnable2);
        }
    }

    void d() {
        e();
        View view = this.c;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.g = true;
        }
    }

    private boolean b(MotionEvent motionEvent) {
        ad adVar;
        View view = this.c;
        androidx.appcompat.view.menu.p a2 = a();
        if (a2 == null || !a2.e() || (adVar = (ad) a2.g()) == null || !adVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        b(view, obtainNoHistory);
        a(adVar, obtainNoHistory);
        boolean a3 = adVar.a(obtainNoHistory, this.h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return a3 && (actionMasked != 1 && actionMasked != 3);
    }

    private static boolean a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = af.this.c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            af.this.d();
        }
    }
}
