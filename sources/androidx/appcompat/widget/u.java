package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.a;

/* loaded from: classes.dex */
class u extends q {

    /* renamed from: a, reason: collision with root package name */
    private final SeekBar f367a;
    private Drawable b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SeekBar seekBar) {
        super(seekBar);
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.f367a = seekBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.q
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        au a2 = au.a(this.f367a.getContext(), attributeSet, a.j.AppCompatSeekBar, i, 0);
        Drawable b = a2.b(a.j.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.f367a.setThumb(b);
        }
        a(a2.a(a.j.AppCompatSeekBar_tickMark));
        if (a2.g(a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = ac.a(a2.a(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (a2.g(a.j.AppCompatSeekBar_tickMarkTint)) {
            this.c = a2.e(a.j.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        a2.a();
        d();
    }

    void a(Drawable drawable) {
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f367a);
            androidx.core.graphics.drawable.a.b(drawable, androidx.core.f.v.f(this.f367a));
            if (drawable.isStateful()) {
                drawable.setState(this.f367a.getDrawableState());
            }
            d();
        }
        this.f367a.invalidate();
    }

    private void d() {
        if (this.b != null) {
            if (this.e || this.f) {
                this.b = androidx.core.graphics.drawable.a.g(this.b.mutate());
                if (this.e) {
                    androidx.core.graphics.drawable.a.a(this.b, this.c);
                }
                if (this.f) {
                    androidx.core.graphics.drawable.a.a(this.b, this.d);
                }
                if (this.b.isStateful()) {
                    this.b.setState(this.f367a.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f367a.getDrawableState())) {
            this.f367a.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.b != null) {
            int max = this.f367a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.b.getIntrinsicWidth();
                int intrinsicHeight = this.b.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.b.setBounds(-i, -i2, i, i2);
                float width = ((this.f367a.getWidth() - this.f367a.getPaddingLeft()) - this.f367a.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f367a.getPaddingLeft(), this.f367a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
