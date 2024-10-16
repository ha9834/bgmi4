package com.google.android.material.appbar;

import android.view.View;
import androidx.core.f.v;

/* loaded from: classes2.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final View f5222a;
    private int b;
    private int c;
    private int d;
    private int e;

    public d(View view) {
        this.f5222a = view;
    }

    public void a() {
        this.b = this.f5222a.getTop();
        this.c = this.f5222a.getLeft();
        c();
    }

    private void c() {
        View view = this.f5222a;
        v.e(view, this.d - (view.getTop() - this.b));
        View view2 = this.f5222a;
        v.f(view2, this.e - (view2.getLeft() - this.c));
    }

    public boolean a(int i) {
        if (this.d == i) {
            return false;
        }
        this.d = i;
        c();
        return true;
    }

    public boolean b(int i) {
        if (this.e == i) {
            return false;
        }
        this.e = i;
        c();
        return true;
    }

    public int b() {
        return this.d;
    }
}
