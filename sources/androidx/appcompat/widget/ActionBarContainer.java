package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.a;
import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    Drawable f250a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.core.f.v.a(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionBar);
        this.f250a = obtainStyledAttributes.getDrawable(a.j.ActionBar_background);
        this.b = obtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_height, -1);
        if (getId() == a.f.split_action_bar) {
            this.d = true;
            this.c = obtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.d ? !(this.f250a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(a.f.action_bar);
        this.i = findViewById(a.f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f250a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f250a);
        }
        this.f250a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.h;
            if (view != null) {
                this.f250a.setBounds(view.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        boolean z = true;
        if (!this.d ? this.f250a != null || this.b != null : this.c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.b);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.e && (drawable2 = this.b) != null) {
                drawable2.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }
        boolean z = true;
        if (!this.d ? this.f250a != null || this.b != null : this.c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.c);
        }
        this.c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d && (drawable2 = this.c) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.d ? !(this.f250a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f250a;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f250a && !this.d) || (drawable == this.b && this.e) || ((drawable == this.c && this.d) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f250a;
        if (drawable != null && drawable.isStateful()) {
            this.f250a.setState(getDrawableState());
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.b.setState(getDrawableState());
        }
        Drawable drawable3 = this.c;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.c.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f250a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(an anVar) {
        View view = this.g;
        if (view != null) {
            removeView(view);
        }
        this.g = anVar;
        if (anVar != null) {
            addView(anVar);
            ViewGroup.LayoutParams layoutParams = anVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            anVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int b;
        int i3;
        if (this.h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.j) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), BleSignal.UNKNOWN_TX_POWER);
        }
        super.onMeasure(i, i2);
        if (this.h == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view = this.g;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!a(this.h)) {
            b = b(this.h);
        } else {
            b = !a(this.i) ? b(this.i) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(b + b(this.g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.d) {
            Drawable drawable2 = this.c;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f250a != null) {
                if (this.h.getVisibility() == 0) {
                    this.f250a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                } else {
                    View view2 = this.i;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f250a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
                    } else {
                        this.f250a.setBounds(0, 0, 0, 0);
                    }
                }
                z3 = true;
            }
            this.e = z4;
            if (!z4 || (drawable = this.b) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }
}
