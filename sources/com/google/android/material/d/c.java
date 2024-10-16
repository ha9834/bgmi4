package com.google.android.material.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final View f5261a;
    private boolean b;
    private int c;

    public boolean a() {
        return this.b;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public void a(Bundle bundle) {
        this.b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            d();
        }
    }

    public void a(int i) {
        this.c = i;
    }

    public int c() {
        return this.c;
    }

    private void d() {
        ViewParent parent = this.f5261a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).b(this.f5261a);
        }
    }
}
