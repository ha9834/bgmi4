package androidx.appcompat.b.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class d extends Drawable {
    private static final float b = (float) Math.toRadians(45.0d);

    /* renamed from: a, reason: collision with root package name */
    private final Paint f207a;
    private float c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private final Path h;
    private final int i;
    private boolean j;
    private float k;
    private float l;
    private int m;

    private static float a(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.m;
        boolean z = false;
        if (i == 3) {
            if (androidx.core.graphics.drawable.a.h(this) == 0) {
                z = true;
            }
        } else {
            switch (i) {
                case 0:
                    break;
                case 1:
                    z = true;
                    break;
                default:
                    if (androidx.core.graphics.drawable.a.h(this) == 1) {
                        z = true;
                        break;
                    }
                    break;
            }
        }
        float f = this.c;
        float a2 = a(this.d, (float) Math.sqrt(f * f * 2.0f), this.k);
        float a3 = a(this.d, this.e, this.k);
        float round = Math.round(a(0.0f, this.l, this.k));
        float a4 = a(0.0f, b, this.k);
        float a5 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.k);
        double d = a2;
        double d2 = a4;
        double cos = Math.cos(d2);
        Double.isNaN(d);
        float round2 = (float) Math.round(cos * d);
        double sin = Math.sin(d2);
        Double.isNaN(d);
        float round3 = (float) Math.round(d * sin);
        this.h.rewind();
        float a6 = a(this.f + this.f207a.getStrokeWidth(), -this.l, this.k);
        float f2 = (-a3) / 2.0f;
        this.h.moveTo(f2 + round, 0.0f);
        this.h.rLineTo(a3 - (round * 2.0f), 0.0f);
        this.h.moveTo(f2, a6);
        this.h.rLineTo(round2, round3);
        this.h.moveTo(f2, -a6);
        this.h.rLineTo(round2, -round3);
        this.h.close();
        canvas.save();
        float strokeWidth = this.f207a.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * r6))) / 4) * 2) + (strokeWidth * 1.5f) + this.f);
        if (this.g) {
            canvas.rotate(a5 * (this.j ^ z ? -1 : 1));
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.h, this.f207a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f207a.getAlpha()) {
            this.f207a.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f207a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.i;
    }

    public void a(float f) {
        if (this.k != f) {
            this.k = f;
            invalidateSelf();
        }
    }
}
