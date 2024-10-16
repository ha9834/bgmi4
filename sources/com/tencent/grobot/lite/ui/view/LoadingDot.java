package com.tencent.grobot.lite.ui.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.grobot.lite.common.ViewUtils;

/* loaded from: classes2.dex */
public final class LoadingDot extends View implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    private float animDiff;
    private ValueAnimator animator;
    private boolean doAnim;
    private final int dotDst;
    private final int dotRadius;
    private int height;
    private boolean isReverse;
    private final Paint paint;
    private int width;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public LoadingDot(Context context) {
        this(context, null);
    }

    public LoadingDot(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingDot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.doAnim = false;
        this.isReverse = false;
        this.animDiff = 0.0f;
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor("#7D858E"));
        this.dotDst = ViewUtils.dip2px(context, 6.0f);
        this.dotRadius = ViewUtils.dip2px(context, 3.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        float f2;
        if (Build.VERSION.SDK_INT >= 17) {
            paddingLeft = ((getPaddingStart() + this.width) - getPaddingEnd()) / 2.0f;
        } else {
            paddingLeft = ((getPaddingLeft() + this.width) - getPaddingRight()) / 2.0f;
        }
        float f3 = this.height / 2.0f;
        float f4 = 0.0f;
        if (this.doAnim) {
            f4 = this.animDiff;
            float f5 = (r3 * 2) / 3.0f;
            float f6 = 2.0f * f5;
            f2 = this.isReverse ? ((float) (this.dotRadius * 2)) - f4 > f5 ? f5 + f4 : ((r3 * 4) - f5) - f4 : f4 >= f5 ? f4 - f5 : f5 - f4;
            if (this.isReverse) {
                int i = this.dotRadius;
                float f7 = this.animDiff;
                f = ((float) (i * 2)) - f7 > f6 ? f6 + f7 : ((i * 4) - f6) - f7;
            } else {
                float f8 = this.animDiff;
                f = f8 >= f6 ? f8 - f6 : f6 - f8;
            }
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        canvas.drawCircle((paddingLeft - (r5 * 2)) - this.dotDst, f3 - f4, this.dotRadius, this.paint);
        canvas.drawCircle(paddingLeft, f3 - f2, this.dotRadius, this.paint);
        canvas.drawCircle(paddingLeft + (r3 * 2) + this.dotDst, f3 - f, this.dotRadius, this.paint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            if (Build.VERSION.SDK_INT >= 17) {
                paddingLeft = getPaddingStart() == 0 ? this.dotDst : getPaddingStart();
                paddingRight = getPaddingEnd() == 0 ? this.dotDst : getPaddingEnd();
            } else {
                paddingLeft = getPaddingLeft() == 0 ? this.dotDst : getPaddingLeft();
                paddingRight = getPaddingRight() == 0 ? this.dotDst : getPaddingRight();
            }
            i3 = paddingLeft + paddingRight + (this.dotRadius * 6) + (this.dotDst * 3);
        } else {
            i3 = View.MeasureSpec.getSize(i);
        }
        setMeasuredDimension(i3, (mode2 == Integer.MIN_VALUE || mode2 == 0) ? (int) (i3 * 0.6f) : View.MeasureSpec.getSize(i2));
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.width = i3 - i;
        this.height = i4 - i2;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.animator == null) {
            this.animator = ValueAnimator.ofFloat(0.0f, this.dotRadius * 2);
            this.animator.setRepeatMode(2);
            this.animator.setRepeatCount(-1);
            this.animator.setDuration(500L);
            this.animator.addUpdateListener(this);
            this.animator.addListener(this);
        }
        this.animator.start();
        this.doAnim = true;
        this.isReverse = false;
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
        this.isReverse = false;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.animDiff = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.getRepeatMode();
        invalidate();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.isReverse = !this.isReverse;
    }
}
