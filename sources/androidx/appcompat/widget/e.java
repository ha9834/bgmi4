package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.a;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private final View f353a;
    private as d;
    private as e;
    private as f;
    private int c = -1;
    private final j b = j.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(View view) {
        this.f353a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        au a2 = au.a(this.f353a.getContext(), attributeSet, a.j.ViewBackgroundHelper, i, 0);
        try {
            if (a2.g(a.j.ViewBackgroundHelper_android_background)) {
                this.c = a2.g(a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.b.b(this.f353a.getContext(), this.c);
                if (b != null) {
                    b(b);
                }
            }
            if (a2.g(a.j.ViewBackgroundHelper_backgroundTint)) {
                androidx.core.f.v.a(this.f353a, a2.e(a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(a.j.ViewBackgroundHelper_backgroundTintMode)) {
                androidx.core.f.v.a(this.f353a, ac.a(a2.a(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
        j jVar = this.b;
        b(jVar != null ? jVar.b(this.f353a.getContext(), i) : null);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.c = -1;
        b((ColorStateList) null);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new as();
        }
        as asVar = this.e;
        asVar.f335a = colorStateList;
        asVar.d = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a() {
        as asVar = this.e;
        if (asVar != null) {
            return asVar.f335a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new as();
        }
        as asVar = this.e;
        asVar.b = mode;
        asVar.c = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        as asVar = this.e;
        if (asVar != null) {
            return asVar.b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable background = this.f353a.getBackground();
        if (background != null) {
            if (d() && b(background)) {
                return;
            }
            as asVar = this.e;
            if (asVar != null) {
                j.a(background, asVar, this.f353a.getDrawableState());
                return;
            }
            as asVar2 = this.d;
            if (asVar2 != null) {
                j.a(background, asVar2, this.f353a.getDrawableState());
            }
        }
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new as();
            }
            as asVar = this.d;
            asVar.f335a = colorStateList;
            asVar.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new as();
        }
        as asVar = this.f;
        asVar.a();
        ColorStateList t = androidx.core.f.v.t(this.f353a);
        if (t != null) {
            asVar.d = true;
            asVar.f335a = t;
        }
        PorterDuff.Mode u = androidx.core.f.v.u(this.f353a);
        if (u != null) {
            asVar.c = true;
            asVar.b = u;
        }
        if (!asVar.d && !asVar.c) {
            return false;
        }
        j.a(drawable, asVar, this.f353a.getDrawableState());
        return true;
    }
}
