package com.google.android.material.c;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.c.d;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5256a;
    private final a b;
    private final View c;
    private final Path d;
    private final Paint e;
    private final Paint f;
    private d.C0115d g;
    private Drawable h;
    private boolean i;
    private boolean j;

    /* loaded from: classes2.dex */
    interface a {
        void a(Canvas canvas);

        boolean c();
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f5256a = 2;
        } else if (Build.VERSION.SDK_INT >= 18) {
            f5256a = 1;
        } else {
            f5256a = 0;
        }
    }

    public void a() {
        if (f5256a == 0) {
            this.i = true;
            this.j = false;
            this.c.buildDrawingCache();
            Bitmap drawingCache = this.c.getDrawingCache();
            if (drawingCache == null && this.c.getWidth() != 0 && this.c.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.c.getWidth(), this.c.getHeight(), Bitmap.Config.ARGB_8888);
                this.c.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                this.e.setShader(new BitmapShader(drawingCache, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            }
            this.i = false;
            this.j = true;
        }
    }

    public void b() {
        if (f5256a == 0) {
            this.j = false;
            this.c.destroyDrawingCache();
            this.e.setShader(null);
            this.c.invalidate();
        }
    }

    public void a(d.C0115d c0115d) {
        if (c0115d == null) {
            this.g = null;
        } else {
            d.C0115d c0115d2 = this.g;
            if (c0115d2 == null) {
                this.g = new d.C0115d(c0115d);
            } else {
                c0115d2.a(c0115d);
            }
            if (com.google.android.material.e.a.b(c0115d.c, b(c0115d), 1.0E-4f)) {
                this.g.c = Float.MAX_VALUE;
            }
        }
        g();
    }

    public d.C0115d c() {
        d.C0115d c0115d = this.g;
        if (c0115d == null) {
            return null;
        }
        d.C0115d c0115d2 = new d.C0115d(c0115d);
        if (c0115d2.a()) {
            c0115d2.c = b(c0115d2);
        }
        return c0115d2;
    }

    public void a(int i) {
        this.f.setColor(i);
        this.c.invalidate();
    }

    public int d() {
        return this.f.getColor();
    }

    public Drawable e() {
        return this.h;
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        this.c.invalidate();
    }

    private void g() {
        if (f5256a == 1) {
            this.d.rewind();
            d.C0115d c0115d = this.g;
            if (c0115d != null) {
                this.d.addCircle(c0115d.f5260a, this.g.b, this.g.c, Path.Direction.CW);
            }
        }
        this.c.invalidate();
    }

    private float b(d.C0115d c0115d) {
        return com.google.android.material.e.a.a(c0115d.f5260a, c0115d.b, 0.0f, 0.0f, this.c.getWidth(), this.c.getHeight());
    }

    public void a(Canvas canvas) {
        if (h()) {
            switch (f5256a) {
                case 0:
                    canvas.drawCircle(this.g.f5260a, this.g.b, this.g.c, this.e);
                    if (i()) {
                        canvas.drawCircle(this.g.f5260a, this.g.b, this.g.c, this.f);
                        break;
                    }
                    break;
                case 1:
                    int save = canvas.save();
                    canvas.clipPath(this.d);
                    this.b.a(canvas);
                    if (i()) {
                        canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
                    }
                    canvas.restoreToCount(save);
                    break;
                case 2:
                    this.b.a(canvas);
                    if (i()) {
                        canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unsupported strategy " + f5256a);
            }
        } else {
            this.b.a(canvas);
            if (i()) {
                canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
            }
        }
        b(canvas);
    }

    private void b(Canvas canvas) {
        if (j()) {
            Rect bounds = this.h.getBounds();
            float width = this.g.f5260a - (bounds.width() / 2.0f);
            float height = this.g.b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.h.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public boolean f() {
        return this.b.c() && !h();
    }

    private boolean h() {
        d.C0115d c0115d = this.g;
        boolean z = c0115d == null || c0115d.a();
        return f5256a == 0 ? !z && this.j : !z;
    }

    private boolean i() {
        return (this.i || Color.alpha(this.f.getColor()) == 0) ? false : true;
    }

    private boolean j() {
        return (this.i || this.h == null || this.g == null) ? false : true;
    }
}
