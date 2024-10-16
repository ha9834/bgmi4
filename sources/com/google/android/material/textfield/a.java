package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

/* loaded from: classes2.dex */
class a extends GradientDrawable {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f5340a = new Paint(1);
    private final RectF b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        c();
        this.b = new RectF();
    }

    private void c() {
        this.f5340a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f5340a.setColor(-1);
        this.f5340a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return !this.b.isEmpty();
    }

    void a(float f, float f2, float f3, float f4) {
        if (f == this.b.left && f2 == this.b.top && f3 == this.b.right && f4 == this.b.bottom) {
            return;
        }
        this.b.set(f, f2, f3, f4);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
        super.draw(canvas);
        canvas.drawRect(this.b, this.f5340a);
        c(canvas);
    }

    private void a(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (a(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            b(canvas);
        }
    }

    private void b(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void c(Canvas canvas) {
        if (a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.c);
    }

    private boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
