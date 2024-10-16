package com.google.android.material.i;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class c extends Drawable implements androidx.core.graphics.drawable.b {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f5277a;
    private final Matrix[] b;
    private final Matrix[] c;
    private final d[] d;
    private final Matrix e;
    private final Path f;
    private final PointF g;
    private final d h;
    private final Region i;
    private final Region j;
    private final float[] k;
    private final float[] l;
    private e m;
    private boolean n;
    private boolean o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private float u;
    private float v;
    private Paint.Style w;
    private PorterDuffColorFilter x;
    private PorterDuff.Mode y;
    private ColorStateList z;

    private static int a(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ColorStateList a() {
        return this.z;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.z = colorStateList;
        b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.y = mode;
        b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5277a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect bounds = getBounds();
        this.i.set(bounds);
        b(bounds.width(), bounds.height(), this.f);
        this.j.setPath(this.f, this.i);
        this.i.op(this.j, Region.Op.DIFFERENCE);
        return this.i;
    }

    public void a(float f) {
        this.p = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f5277a.setColorFilter(this.x);
        int alpha = this.f5277a.getAlpha();
        this.f5277a.setAlpha(a(alpha, this.t));
        this.f5277a.setStrokeWidth(this.v);
        this.f5277a.setStyle(this.w);
        int i = this.r;
        if (i > 0 && this.n) {
            this.f5277a.setShadowLayer(this.s, 0.0f, i, this.q);
        }
        if (this.m != null) {
            b(canvas.getWidth(), canvas.getHeight(), this.f);
            canvas.drawPath(this.f, this.f5277a);
        } else {
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f5277a);
        }
        this.f5277a.setAlpha(alpha);
    }

    public void a(int i, int i2, Path path) {
        path.rewind();
        if (this.m == null) {
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            a(i3, i, i2);
            b(i3, i, i2);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            a(i4, path);
            b(i4, path);
        }
        path.close();
    }

    private void a(int i, int i2, int i3) {
        a(i, i2, i3, this.g);
        a(i).a(c(i, i2, i3), this.p, this.d[i]);
        float d = d(((i - 1) + 4) % 4, i2, i3) + 1.5707964f;
        this.b[i].reset();
        this.b[i].setTranslate(this.g.x, this.g.y);
        this.b[i].preRotate((float) Math.toDegrees(d));
    }

    private void b(int i, int i2, int i3) {
        this.k[0] = this.d[i].c;
        this.k[1] = this.d[i].d;
        this.b[i].mapPoints(this.k);
        float d = d(i, i2, i3);
        this.c[i].reset();
        Matrix matrix = this.c[i];
        float[] fArr = this.k;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.c[i].preRotate((float) Math.toDegrees(d));
    }

    private void a(int i, Path path) {
        this.k[0] = this.d[i].f5278a;
        this.k[1] = this.d[i].b;
        this.b[i].mapPoints(this.k);
        if (i == 0) {
            float[] fArr = this.k;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            float[] fArr2 = this.k;
            path.lineTo(fArr2[0], fArr2[1]);
        }
        this.d[i].a(this.b[i], path);
    }

    private void b(int i, Path path) {
        int i2 = (i + 1) % 4;
        this.k[0] = this.d[i].c;
        this.k[1] = this.d[i].d;
        this.b[i].mapPoints(this.k);
        this.l[0] = this.d[i2].f5278a;
        this.l[1] = this.d[i2].b;
        this.b[i2].mapPoints(this.l);
        float f = this.k[0];
        float[] fArr = this.l;
        float hypot = (float) Math.hypot(f - fArr[0], r0[1] - fArr[1]);
        this.h.a(0.0f, 0.0f);
        b(i).a(hypot, this.p, this.h);
        this.h.a(this.c[i], path);
    }

    private a a(int i) {
        switch (i) {
            case 1:
                return this.m.b();
            case 2:
                return this.m.c();
            case 3:
                return this.m.d();
            default:
                return this.m.a();
        }
    }

    private b b(int i) {
        switch (i) {
            case 1:
                return this.m.f();
            case 2:
                return this.m.g();
            case 3:
                return this.m.h();
            default:
                return this.m.e();
        }
    }

    private void a(int i, int i2, int i3, PointF pointF) {
        switch (i) {
            case 1:
                pointF.set(i2, 0.0f);
                return;
            case 2:
                pointF.set(i2, i3);
                return;
            case 3:
                pointF.set(0.0f, i3);
                return;
            default:
                pointF.set(0.0f, 0.0f);
                return;
        }
    }

    private float c(int i, int i2, int i3) {
        a(((i - 1) + 4) % 4, i2, i3, this.g);
        float f = this.g.x;
        float f2 = this.g.y;
        a((i + 1) % 4, i2, i3, this.g);
        float f3 = this.g.x;
        float f4 = this.g.y;
        a(i, i2, i3, this.g);
        float f5 = this.g.x;
        float f6 = this.g.y;
        float atan2 = ((float) Math.atan2(f2 - f6, f - f5)) - ((float) Math.atan2(f4 - f6, f3 - f5));
        if (atan2 >= 0.0f) {
            return atan2;
        }
        double d = atan2;
        Double.isNaN(d);
        return (float) (d + 6.283185307179586d);
    }

    private float d(int i, int i2, int i3) {
        int i4 = (i + 1) % 4;
        a(i, i2, i3, this.g);
        float f = this.g.x;
        float f2 = this.g.y;
        a(i4, i2, i3, this.g);
        return (float) Math.atan2(this.g.y - f2, this.g.x - f);
    }

    private void b(int i, int i2, Path path) {
        a(i, i2, path);
        if (this.u == 1.0f) {
            return;
        }
        this.e.reset();
        Matrix matrix = this.e;
        float f = this.u;
        matrix.setScale(f, f, i / 2, i2 / 2);
        path.transform(this.e);
    }

    private void b() {
        ColorStateList colorStateList = this.z;
        if (colorStateList == null || this.y == null) {
            this.x = null;
            return;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        this.x = new PorterDuffColorFilter(colorForState, this.y);
        if (this.o) {
            this.q = colorForState;
        }
    }
}
