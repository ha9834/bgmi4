package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    final Paint f5286a;
    final Rect b;
    final RectF c;
    final C0117a d;
    float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ColorStateList j;
    private int k;
    private boolean l;
    private float m;

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            this.f5286a.setShader(a());
            this.l = false;
        }
        float strokeWidth = this.f5286a.getStrokeWidth() / 2.0f;
        RectF rectF = this.c;
        copyBounds(this.b);
        rectF.set(this.b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f5286a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int round = Math.round(this.e);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5286a.setAlpha(i);
        invalidateSelf();
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList.getColorForState(getState(), this.k);
        }
        this.j = colorStateList;
        this.l = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5286a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.e > 0.0f ? -3 : -2;
    }

    public final void a(float f) {
        if (f != this.m) {
            this.m = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.j;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.j;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.k)) != this.k) {
            this.l = true;
            this.k = colorForState;
        }
        if (this.l) {
            invalidateSelf();
        }
        return this.l;
    }

    private Shader a() {
        copyBounds(this.b);
        float height = this.e / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{androidx.core.graphics.b.a(this.f, this.k), androidx.core.graphics.b.a(this.g, this.k), androidx.core.graphics.b.a(androidx.core.graphics.b.b(this.g, 0), this.k), androidx.core.graphics.b.a(androidx.core.graphics.b.b(this.i, 0), this.k), androidx.core.graphics.b.a(this.i, this.k), androidx.core.graphics.b.a(this.h, this.k)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0117a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f5287a;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return this.f5287a;
        }
    }
}
