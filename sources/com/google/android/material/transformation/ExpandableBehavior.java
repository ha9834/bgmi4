package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.v;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.b<View> {

    /* renamed from: a, reason: collision with root package name */
    private int f5343a;

    protected abstract boolean a(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    public ExpandableBehavior() {
        this.f5343a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5343a = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final View view, int i) {
        final com.google.android.material.d.b a2;
        if (v.x(view) || (a2 = a(coordinatorLayout, view)) == null || !a(a2.a())) {
            return false;
        }
        this.f5343a = a2.a() ? 1 : 2;
        final int i2 = this.f5343a;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ExpandableBehavior.this.f5343a == i2) {
                    ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                    com.google.android.material.d.b bVar = a2;
                    expandableBehavior.a((View) bVar, view, bVar.a(), false);
                }
                return false;
            }
        });
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        com.google.android.material.d.b bVar = (com.google.android.material.d.b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.f5343a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected com.google.android.material.d.b a(CoordinatorLayout coordinatorLayout, View view) {
        List<View> c = coordinatorLayout.c(view);
        int size = c.size();
        for (int i = 0; i < size; i++) {
            View view2 = c.get(i);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (com.google.android.material.d.b) view2;
            }
        }
        return null;
    }

    private boolean a(boolean z) {
        if (!z) {
            return this.f5343a == 1;
        }
        int i = this.f5343a;
        return i == 0 || i == 2;
    }
}
