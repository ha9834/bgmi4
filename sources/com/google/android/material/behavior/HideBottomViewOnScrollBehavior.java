package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.a;

/* loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a, reason: collision with root package name */
    private int f5226a;
    private int b;
    private ViewPropertyAnimator c;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior() {
        this.f5226a = 0;
        this.b = 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5226a = 0;
        this.b = 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f5226a = v.getMeasuredHeight();
        return super.onLayoutChild(coordinatorLayout, v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (this.b != 1 && i2 > 0) {
            b(v);
        } else {
            if (this.b == 2 || i2 >= 0) {
                return;
            }
            a(v);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.b = 2;
        a(v, 0, 225L, a.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.b = 1;
        a(v, this.f5226a, 175L, a.c);
    }

    private void a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.c = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.c = null;
            }
        });
    }
}
