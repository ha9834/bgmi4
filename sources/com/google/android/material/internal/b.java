package com.google.android.material.internal;

import android.R;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.widget.au;
import androidx.core.f.v;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f5288a;
    private static final Paint b;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int[] H;
    private boolean I;
    private TimeInterpolator L;
    private TimeInterpolator M;
    private float N;
    private float O;
    private float P;
    private int Q;
    private float R;
    private float S;
    private float T;
    private int U;
    private final View c;
    private boolean d;
    private float e;
    private ColorStateList m;
    private ColorStateList n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;
    private int i = 16;
    private int j = 16;
    private float k = 15.0f;
    private float l = 15.0f;
    private final TextPaint J = new TextPaint(129);
    private final TextPaint K = new TextPaint(this.J);
    private final Rect g = new Rect();
    private final Rect f = new Rect();
    private final RectF h = new RectF();

    static {
        f5288a = Build.VERSION.SDK_INT < 18;
        b = null;
        Paint paint = b;
        if (paint != null) {
            paint.setAntiAlias(true);
            b.setColor(-65281);
        }
    }

    public b(View view) {
        this.c = view;
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.M = timeInterpolator;
        g();
    }

    public void b(TimeInterpolator timeInterpolator) {
        this.L = timeInterpolator;
        g();
    }

    public void a(float f) {
        if (this.k != f) {
            this.k = f;
            g();
        }
    }

    public void a(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            g();
        }
    }

    public void b(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            g();
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (a(this.f, i, i2, i3, i4)) {
            return;
        }
        this.f.set(i, i2, i3, i4);
        this.I = true;
        c();
    }

    public void b(int i, int i2, int i3, int i4) {
        if (a(this.g, i, i2, i3, i4)) {
            return;
        }
        this.g.set(i, i2, i3, i4);
        this.I = true;
        c();
    }

    public float a() {
        if (this.x == null) {
            return 0.0f;
        }
        a(this.K);
        TextPaint textPaint = this.K;
        CharSequence charSequence = this.x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public float b() {
        a(this.K);
        return -this.K.ascent();
    }

    public void a(RectF rectF) {
        float a2;
        boolean b2 = b(this.x);
        if (!b2) {
            a2 = this.g.left;
        } else {
            a2 = this.g.right - a();
        }
        rectF.left = a2;
        rectF.top = this.g.top;
        rectF.right = !b2 ? rectF.left + a() : this.g.right;
        rectF.bottom = this.g.top + b();
    }

    private void a(TextPaint textPaint) {
        textPaint.setTextSize(this.l);
        textPaint.setTypeface(this.u);
    }

    void c() {
        this.d = this.g.width() > 0 && this.g.height() > 0 && this.f.width() > 0 && this.f.height() > 0;
    }

    public void a(int i) {
        if (this.i != i) {
            this.i = i;
            g();
        }
    }

    public void b(int i) {
        if (this.j != i) {
            this.j = i;
            g();
        }
    }

    public void c(int i) {
        au a2 = au.a(this.c.getContext(), i, a.j.TextAppearance);
        if (a2.g(a.j.TextAppearance_android_textColor)) {
            this.n = a2.e(a.j.TextAppearance_android_textColor);
        }
        if (a2.g(a.j.TextAppearance_android_textSize)) {
            this.l = a2.e(a.j.TextAppearance_android_textSize, (int) this.l);
        }
        this.Q = a2.a(a.j.TextAppearance_android_shadowColor, 0);
        this.O = a2.a(a.j.TextAppearance_android_shadowDx, 0.0f);
        this.P = a2.a(a.j.TextAppearance_android_shadowDy, 0.0f);
        this.N = a2.a(a.j.TextAppearance_android_shadowRadius, 0.0f);
        a2.a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.u = d(i);
        }
        g();
    }

    private Typeface d(int i) {
        TypedArray obtainStyledAttributes = this.c.getContext().obtainStyledAttributes(i, new int[]{R.attr.fontFamily});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void a(Typeface typeface) {
        this.v = typeface;
        this.u = typeface;
        g();
    }

    public void b(float f) {
        float a2 = androidx.core.b.a.a(f, 0.0f, 1.0f);
        if (a2 != this.e) {
            this.e = a2;
            i();
        }
    }

    public final boolean a(int[] iArr) {
        this.H = iArr;
        if (!d()) {
            return false;
        }
        g();
        return true;
    }

    public final boolean d() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.n;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.m) != null && colorStateList.isStateful());
    }

    public float e() {
        return this.e;
    }

    private void i() {
        c(this.e);
    }

    private void c(float f) {
        d(f);
        this.s = a(this.q, this.r, f, this.L);
        this.t = a(this.o, this.p, f, this.L);
        e(a(this.k, this.l, f, this.M));
        if (this.n != this.m) {
            this.J.setColor(a(j(), f(), f));
        } else {
            this.J.setColor(f());
        }
        this.J.setShadowLayer(a(this.R, this.N, f, (TimeInterpolator) null), a(this.S, this.O, f, (TimeInterpolator) null), a(this.T, this.P, f, (TimeInterpolator) null), a(this.U, this.Q, f));
        v.d(this.c);
    }

    private int j() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.m.getColorForState(iArr, 0);
        }
        return this.m.getDefaultColor();
    }

    public int f() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.n.getColorForState(iArr, 0);
        }
        return this.n.getDefaultColor();
    }

    private void k() {
        float f = this.G;
        f(this.l);
        CharSequence charSequence = this.y;
        float measureText = charSequence != null ? this.J.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int a2 = androidx.core.f.d.a(this.j, this.z ? 1 : 0);
        int i = a2 & 112;
        if (i == 48) {
            this.p = this.g.top - this.J.ascent();
        } else if (i == 80) {
            this.p = this.g.bottom;
        } else {
            this.p = this.g.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        }
        int i2 = a2 & 8388615;
        if (i2 == 1) {
            this.r = this.g.centerX() - (measureText / 2.0f);
        } else if (i2 == 5) {
            this.r = this.g.right - measureText;
        } else {
            this.r = this.g.left;
        }
        f(this.k);
        CharSequence charSequence2 = this.y;
        float measureText2 = charSequence2 != null ? this.J.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int a3 = androidx.core.f.d.a(this.i, this.z ? 1 : 0);
        int i3 = a3 & 112;
        if (i3 == 48) {
            this.o = this.f.top - this.J.ascent();
        } else if (i3 == 80) {
            this.o = this.f.bottom;
        } else {
            this.o = this.f.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        }
        int i4 = a3 & 8388615;
        if (i4 == 1) {
            this.q = this.f.centerX() - (measureText2 / 2.0f);
        } else if (i4 == 5) {
            this.q = this.f.right - measureText2;
        } else {
            this.q = this.f.left;
        }
        m();
        e(f);
    }

    private void d(float f) {
        this.h.left = a(this.f.left, this.g.left, f, this.L);
        this.h.top = a(this.o, this.p, f, this.L);
        this.h.right = a(this.f.right, this.g.right, f, this.L);
        this.h.bottom = a(this.f.bottom, this.g.bottom, f, this.L);
    }

    public void a(Canvas canvas) {
        float ascent;
        int save = canvas.save();
        if (this.y != null && this.d) {
            float f = this.s;
            float f2 = this.t;
            boolean z = this.A && this.B != null;
            if (z) {
                ascent = this.D * this.F;
                float f3 = this.E;
            } else {
                ascent = this.J.ascent() * this.F;
                this.J.descent();
                float f4 = this.F;
            }
            float f5 = z ? f2 + ascent : f2;
            float f6 = this.F;
            if (f6 != 1.0f) {
                canvas.scale(f6, f6, f, f5);
            }
            if (z) {
                canvas.drawBitmap(this.B, f, f5, this.C);
            } else {
                CharSequence charSequence = this.y;
                canvas.drawText(charSequence, 0, charSequence.length(), f, f5, this.J);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean b(CharSequence charSequence) {
        return (v.f(this.c) == 1 ? androidx.core.d.d.d : androidx.core.d.d.c).a(charSequence, 0, charSequence.length());
    }

    private void e(float f) {
        f(f);
        this.A = f5288a && this.F != 1.0f;
        if (this.A) {
            l();
        }
        v.d(this.c);
    }

    private void f(float f) {
        float f2;
        boolean z;
        boolean z2;
        if (this.x == null) {
            return;
        }
        float width = this.g.width();
        float width2 = this.f.width();
        if (a(f, this.l)) {
            float f3 = this.l;
            this.F = 1.0f;
            Typeface typeface = this.w;
            Typeface typeface2 = this.u;
            if (typeface != typeface2) {
                this.w = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
            f2 = f3;
            z = z2;
        } else {
            f2 = this.k;
            Typeface typeface3 = this.w;
            Typeface typeface4 = this.v;
            if (typeface3 != typeface4) {
                this.w = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (a(f, this.k)) {
                this.F = 1.0f;
            } else {
                this.F = f / this.k;
            }
            float f4 = this.l / this.k;
            width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
        }
        if (width > 0.0f) {
            z = this.G != f2 || this.I || z;
            this.G = f2;
            this.I = false;
        }
        if (this.y == null || z) {
            this.J.setTextSize(this.G);
            this.J.setTypeface(this.w);
            this.J.setLinearText(this.F != 1.0f);
            CharSequence ellipsize = TextUtils.ellipsize(this.x, this.J, width, TextUtils.TruncateAt.END);
            if (TextUtils.equals(ellipsize, this.y)) {
                return;
            }
            this.y = ellipsize;
            this.z = b(this.y);
        }
    }

    private void l() {
        if (this.B != null || this.f.isEmpty() || TextUtils.isEmpty(this.y)) {
            return;
        }
        c(0.0f);
        this.D = this.J.ascent();
        this.E = this.J.descent();
        TextPaint textPaint = this.J;
        CharSequence charSequence = this.y;
        int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int round2 = Math.round(this.E - this.D);
        if (round <= 0 || round2 <= 0) {
            return;
        }
        this.B = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.B);
        CharSequence charSequence2 = this.y;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, round2 - this.J.descent(), this.J);
        if (this.C == null) {
            this.C = new Paint(3);
        }
    }

    public void g() {
        if (this.c.getHeight() <= 0 || this.c.getWidth() <= 0) {
            return;
        }
        k();
        i();
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.x)) {
            this.x = charSequence;
            this.y = null;
            m();
            g();
        }
    }

    private void m() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private static boolean a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    public ColorStateList h() {
        return this.n;
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    private static float a(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return com.google.android.material.a.a.a(f, f2, f3);
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
