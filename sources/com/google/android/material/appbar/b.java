package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.ad;
import androidx.core.f.v;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.List;

/* loaded from: classes2.dex */
abstract class b extends c<View> {

    /* renamed from: a, reason: collision with root package name */
    final Rect f5220a;
    final Rect b;
    private int c;
    private int d;

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    float a(View view) {
        return 1.0f;
    }

    abstract View b(List<View> list);

    public b() {
        this.f5220a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5220a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View b;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (b = b(coordinatorLayout.c(view))) == null) {
            return false;
        }
        if (v.q(b) && !v.q(view)) {
            v.b(view, true);
            if (v.q(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.a(view, i, i2, View.MeasureSpec.makeMeasureSpec((size - b.getMeasuredHeight()) + b(b), i5 == -1 ? 1073741824 : BleSignal.UNKNOWN_TX_POWER), i4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.c
    public void a(CoordinatorLayout coordinatorLayout, View view, int i) {
        View b = b(coordinatorLayout.c(view));
        if (b != null) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
            Rect rect = this.f5220a;
            rect.set(coordinatorLayout.getPaddingLeft() + eVar.leftMargin, b.getBottom() + eVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin, ((coordinatorLayout.getHeight() + b.getBottom()) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
            ad lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && v.q(coordinatorLayout) && !v.q(view)) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.b;
            androidx.core.f.d.a(c(eVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = c(b);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.c = rect2.top - b.getBottom();
            return;
        }
        super.a(coordinatorLayout, view, i);
        this.c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c(View view) {
        if (this.d == 0) {
            return 0;
        }
        float a2 = a(view);
        int i = this.d;
        return androidx.core.b.a.a((int) (a2 * i), 0, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.c;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final int c() {
        return this.d;
    }
}
