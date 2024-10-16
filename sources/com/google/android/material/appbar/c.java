package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
class c<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a, reason: collision with root package name */
    private d f5221a;
    private int b;
    private int c;

    public c() {
        this.b = 0;
        this.c = 0;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        a(coordinatorLayout, v, i);
        if (this.f5221a == null) {
            this.f5221a = new d(v);
        }
        this.f5221a.a();
        int i2 = this.b;
        if (i2 != 0) {
            this.f5221a.a(i2);
            this.b = 0;
        }
        int i3 = this.c;
        if (i3 == 0) {
            return true;
        }
        this.f5221a.b(i3);
        this.c = 0;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.b(v, i);
    }

    public boolean a(int i) {
        d dVar = this.f5221a;
        if (dVar != null) {
            return dVar.a(i);
        }
        this.b = i;
        return false;
    }

    public int b() {
        d dVar = this.f5221a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }
}
