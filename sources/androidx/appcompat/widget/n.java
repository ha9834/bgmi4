package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f360a;
    private as b;
    private as c;
    private as d;

    public n(ImageView imageView) {
        this.f360a = imageView;
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        au a2 = au.a(this.f360a.getContext(), attributeSet, a.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f360a.getDrawable();
            if (drawable == null && (g = a2.g(a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.a.a.a.b(this.f360a.getContext(), g)) != null) {
                this.f360a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                ac.a(drawable);
            }
            if (a2.g(a.j.AppCompatImageView_tint)) {
                androidx.core.widget.e.a(this.f360a, a2.e(a.j.AppCompatImageView_tint));
            }
            if (a2.g(a.j.AppCompatImageView_tintMode)) {
                androidx.core.widget.e.a(this.f360a, ac.a(a2.a(a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b = androidx.appcompat.a.a.a.b(this.f360a.getContext(), i);
            if (b != null) {
                ac.a(b);
            }
            this.f360a.setImageDrawable(b);
        } else {
            this.f360a.setImageDrawable(null);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f360a.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new as();
        }
        as asVar = this.c;
        asVar.f335a = colorStateList;
        asVar.d = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        as asVar = this.c;
        if (asVar != null) {
            return asVar.f335a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new as();
        }
        as asVar = this.c;
        asVar.b = mode;
        asVar.c = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        as asVar = this.c;
        if (asVar != null) {
            return asVar.b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Drawable drawable = this.f360a.getDrawable();
        if (drawable != null) {
            ac.a(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            as asVar = this.c;
            if (asVar != null) {
                j.a(drawable, asVar, this.f360a.getDrawableState());
                return;
            }
            as asVar2 = this.b;
            if (asVar2 != null) {
                j.a(drawable, asVar2, this.f360a.getDrawableState());
            }
        }
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new as();
        }
        as asVar = this.d;
        asVar.a();
        ColorStateList a2 = androidx.core.widget.e.a(this.f360a);
        if (a2 != null) {
            asVar.d = true;
            asVar.f335a = a2;
        }
        PorterDuff.Mode b = androidx.core.widget.e.b(this.f360a);
        if (b != null) {
            asVar.c = true;
            asVar.b = b;
        }
        if (!asVar.d && !asVar.c) {
            return false;
        }
        j.a(drawable, asVar, this.f360a.getDrawableState());
        return true;
    }
}
