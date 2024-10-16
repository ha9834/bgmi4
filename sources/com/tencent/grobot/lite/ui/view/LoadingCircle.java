package com.tencent.grobot.lite.ui.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.grobot.lite.common.ViewUtils;

/* loaded from: classes2.dex */
public final class LoadingCircle extends View implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    private static final int NODE_COUNT = 8;
    private ValueAnimator animator;
    private int curIndex;
    private boolean doAnim;
    private int heigth;
    private final int minLength;
    private final Paint paint;
    private int width;
    private static final int COLOR_NORMAL = Color.parseColor("#F4F4F4");
    private static final int COLOR_CURRENT = Color.parseColor("#9EA5A8");

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public LoadingCircle(Context context) {
        this(context, null);
    }

    public LoadingCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.curIndex = 0;
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.minLength = ViewUtils.dip2px(context, 25.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int min = Math.min(this.width, this.heigth);
        float f = min;
        float f2 = 0.04f * f;
        int i = min / 2;
        float f3 = f * 0.28f;
        this.paint.setStrokeWidth(f2);
        canvas.save();
        int i2 = 0;
        do {
            if (i2 != this.curIndex) {
                this.paint.setColor(COLOR_NORMAL);
            } else {
                this.paint.setColor(COLOR_CURRENT);
            }
            float f4 = i;
            canvas.drawLine(f4, 0.0f, f4, f3, this.paint);
            canvas.rotate(45.0f, f4, f4);
            i2++;
        } while (i2 < 8);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i3 = this.minLength;
        } else {
            i3 = View.MeasureSpec.getSize(i);
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            i4 = this.minLength;
        } else {
            i4 = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.width = i3 - i;
        this.heigth = i4 - i2;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.animator == null) {
            this.animator = ValueAnimator.ofInt(0, 8);
            this.animator.setRepeatMode(1);
            this.animator.setRepeatCount(-1);
            this.animator.setDuration(1000L);
            this.animator.addUpdateListener(this);
            this.animator.addListener(this);
        }
        this.animator.start();
        this.doAnim = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.animator.removeUpdateListener(this);
            this.animator.removeListener(this);
            this.animator = null;
        }
        this.doAnim = false;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.curIndex = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }
}
