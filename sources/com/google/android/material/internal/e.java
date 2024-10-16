package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.ag;
import com.google.android.material.a;

/* loaded from: classes2.dex */
public class e extends ag {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f5291a;
    boolean b;
    private Drawable c;
    private final Rect d;
    private final Rect e;
    private int f;

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Rect();
        this.e = new Rect();
        this.f = 119;
        this.f5291a = true;
        this.b = false;
        TypedArray a2 = k.a(context, attributeSet, a.k.ForegroundLinearLayout, i, 0, new int[0]);
        this.f = a2.getInt(a.k.ForegroundLinearLayout_android_foregroundGravity, this.f);
        Drawable drawable = a2.getDrawable(a.k.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f5291a = a2.getBoolean(a.k.ForegroundLinearLayout_foregroundInsidePadding, true);
        a2.recycle();
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f;
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.f != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f = i;
            if (this.f == 119 && this.c != null) {
                this.c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.c;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.c.setState(getDrawableState());
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.c;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.c);
            }
            this.c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ag, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b = z | this.b;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.b = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.c;
        if (drawable != null) {
            if (this.b) {
                this.b = false;
                Rect rect = this.d;
                Rect rect2 = this.e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f5291a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }
}
