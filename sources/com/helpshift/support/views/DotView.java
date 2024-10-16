package com.helpshift.support.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public class DotView extends View implements ValueAnimator.AnimatorUpdateListener {
    private float centerX;
    private float centerY;
    private int dotColor;
    private RectF ovalRectF;
    private Paint paint;
    private float radius;

    public DotView(Context context, int i) {
        super(context);
        this.centerX = -1.0f;
        this.centerY = -1.0f;
        this.dotColor = i;
        setup();
    }

    public DotView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.centerX = -1.0f;
        this.centerY = -1.0f;
    }

    public void setDotColor(int i) {
        this.dotColor = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawOval(this.ovalRectF, this.paint);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.centerX = getWidth() / 2;
        this.centerY = getHeight() / 2;
        this.radius = Math.min(this.centerX, this.centerY);
        updateOvalRectF();
    }

    private void updateOvalRectF() {
        RectF rectF = this.ovalRectF;
        float f = this.centerX;
        float f2 = this.radius;
        rectF.left = f - f2;
        rectF.right = f + f2;
        float f3 = this.centerY;
        rectF.top = f3 - f2;
        rectF.bottom = f3 + f2;
    }

    private void setup() {
        this.ovalRectF = new RectF();
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(this.dotColor);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.dotColor = Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), Color.red(this.dotColor), Color.green(this.dotColor), Color.blue(this.dotColor));
        this.paint.setColor(this.dotColor);
        invalidate();
    }
}
