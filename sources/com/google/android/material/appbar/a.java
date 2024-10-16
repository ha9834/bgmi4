package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.v;
import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes2.dex */
abstract class a<V extends View> extends c<V> {

    /* renamed from: a, reason: collision with root package name */
    OverScroller f5218a;
    private Runnable b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private VelocityTracker g;

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    boolean c(V v) {
        return false;
    }

    public a() {
        this.d = -1;
        this.f = -1;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = -1;
        this.f = -1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f < 0) {
            this.f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.c) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.c = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (c(v) && coordinatorLayout.a(v, x, y)) {
                    this.e = y;
                    this.d = motionEvent.getPointerId(0);
                    c();
                    break;
                }
                break;
            case 1:
            case 3:
                this.c = false;
                this.d = -1;
                VelocityTracker velocityTracker = this.g;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.g = null;
                    break;
                }
                break;
            case 2:
                int i = this.d;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    if (Math.abs(y2 - this.e) > this.f) {
                        this.c = true;
                        this.e = y2;
                        break;
                    }
                }
                break;
        }
        VelocityTracker velocityTracker2 = this.g;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return this.c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f
            if (r0 >= 0) goto L12
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f = r0
        L12:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = -1
            r3 = 0
            switch(r0) {
                case 0: goto L89;
                case 1: goto L58;
                case 2: goto L1e;
                case 3: goto L7a;
                default: goto L1c;
            }
        L1c:
            goto Lac
        L1e:
            int r0 = r11.d
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r2) goto L27
            return r3
        L27:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.e
            int r2 = r2 - r0
            boolean r3 = r11.c
            if (r3 != 0) goto L45
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.f
            if (r3 <= r4) goto L45
            r11.c = r1
            if (r2 <= 0) goto L42
            int r2 = r2 - r4
            r6 = r2
            goto L46
        L42:
            int r2 = r2 + r4
            r6 = r2
            goto L46
        L45:
            r6 = r2
        L46:
            boolean r2 = r11.c
            if (r2 == 0) goto Lac
            r11.e = r0
            int r7 = r11.b(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.b(r4, r5, r6, r7, r8)
            goto Lac
        L58:
            android.view.VelocityTracker r0 = r11.g
            if (r0 == 0) goto L7a
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.g
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.g
            int r4 = r11.d
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.a(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a(r6, r7, r8, r9, r10)
        L7a:
            r11.c = r3
            r11.d = r2
            android.view.VelocityTracker r12 = r11.g
            if (r12 == 0) goto Lac
            r12.recycle()
            r12 = 0
            r11.g = r12
            goto Lac
        L89:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r2 = r14.getY()
            int r2 = (int) r2
            boolean r12 = r12.a(r13, r0, r2)
            if (r12 == 0) goto Lab
            boolean r12 = r11.c(r13)
            if (r12 == 0) goto Lab
            r11.e = r2
            int r12 = r14.getPointerId(r3)
            r11.d = r12
            r11.c()
            goto Lac
        Lab:
            return r3
        Lac:
            android.view.VelocityTracker r12 = r11.g
            if (r12 == 0) goto Lb3
            r12.addMovement(r14)
        Lb3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, (CoordinatorLayout) v, i, BleSignal.UNKNOWN_TX_POWER, Integer.MAX_VALUE);
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int a2;
        int b = b();
        if (i2 == 0 || b < i2 || b > i3 || b == (a2 = androidx.core.b.a.a(i, i2, i3))) {
            return 0;
        }
        a(a2);
        return b - a2;
    }

    int a() {
        return b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, (CoordinatorLayout) v, a() - i, i2, i3);
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        Runnable runnable = this.b;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.b = null;
        }
        if (this.f5218a == null) {
            this.f5218a = new OverScroller(v.getContext());
        }
        this.f5218a.fling(0, b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f5218a.computeScrollOffset()) {
            this.b = new RunnableC0114a(coordinatorLayout, v);
            v.a(v, this.b);
            return true;
        }
        a(coordinatorLayout, v);
        return false;
    }

    int b(V v) {
        return -v.getHeight();
    }

    int a(V v) {
        return v.getHeight();
    }

    private void c() {
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0114a implements Runnable {
        private final CoordinatorLayout b;
        private final V c;

        RunnableC0114a(CoordinatorLayout coordinatorLayout, V v) {
            this.b = coordinatorLayout;
            this.c = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c == null || a.this.f5218a == null) {
                return;
            }
            if (a.this.f5218a.computeScrollOffset()) {
                a aVar = a.this;
                aVar.a_(this.b, this.c, aVar.f5218a.getCurrY());
                v.a(this.c, this);
                return;
            }
            a.this.a(this.b, this.c);
        }
    }
}
