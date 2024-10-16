package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.f.v;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.nearby.messages.BleSignal;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    View f914a;
    float b;
    int c;
    boolean d;
    final androidx.customview.a.a e;
    boolean f;
    final ArrayList<a> g;
    private int h;
    private int i;
    private Drawable j;
    private Drawable k;
    private final int l;
    private boolean m;
    private float n;
    private int o;
    private float p;
    private float q;
    private c r;
    private boolean s;
    private final Rect t;
    private Method u;
    private Field v;
    private boolean w;

    /* loaded from: classes.dex */
    public interface c {
    }

    public void setParallaxDistance(int i) {
        this.o = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.o;
    }

    public void setSliderFadeColor(int i) {
        this.h = i;
    }

    public int getSliderFadeColor() {
        return this.h;
    }

    public void setCoveredFadeColor(int i) {
        this.i = i;
    }

    public int getCoveredFadeColor() {
        return this.i;
    }

    public void setPanelSlideListener(c cVar) {
        this.r = cVar;
    }

    void a(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        View view2 = view;
        boolean f = f();
        int width = f ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !d(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i = view.getLeft();
            i2 = view.getRight();
            i3 = view.getTop();
            i4 = view.getBottom();
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt == view2) {
                return;
            }
            if (childAt.getVisibility() == 8) {
                z = f;
            } else {
                int max = Math.max(f ? paddingLeft : width, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                if (f) {
                    z = f;
                    i5 = width;
                } else {
                    z = f;
                    i5 = paddingLeft;
                }
                childAt.setVisibility((max < i || max2 < i3 || Math.min(i5, childAt.getRight()) > i2 || Math.min(height, childAt.getBottom()) > i4) ? 0 : 4);
            }
            i6++;
            f = z;
            view2 = view;
        }
    }

    void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean d(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).run();
        }
        this.g.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingTop;
        int i3;
        int i4;
        int i5;
        int makeMeasureSpec;
        int i6;
        int makeMeasureSpec2;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                mode2 = BleSignal.UNKNOWN_TX_POWER;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i3 = 0;
        } else if (mode2 != 1073741824) {
            i3 = 0;
            paddingTop = 0;
        } else {
            i3 = (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = i3;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f914a = null;
        int i7 = i3;
        int i8 = paddingLeft;
        int i9 = 0;
        boolean z2 = false;
        float f = 0.0f;
        while (true) {
            i4 = 8;
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            b bVar = (b) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                bVar.c = z;
            } else {
                if (bVar.f917a > 0.0f) {
                    f += bVar.f917a;
                    if (bVar.width == 0) {
                    }
                }
                int i10 = bVar.leftMargin + bVar.rightMargin;
                if (bVar.width == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i10, BleSignal.UNKNOWN_TX_POWER);
                } else if (bVar.width == -1) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i10, 1073741824);
                } else {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(bVar.width, 1073741824);
                }
                if (bVar.height == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, BleSignal.UNKNOWN_TX_POWER);
                } else if (bVar.height == -1) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                } else {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(bVar.height, 1073741824);
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i7) {
                    i7 = Math.min(measuredHeight, paddingTop);
                }
                i8 -= measuredWidth;
                boolean z3 = i8 < 0;
                bVar.b = z3;
                boolean z4 = z3 | z2;
                if (bVar.b) {
                    this.f914a = childAt;
                }
                z2 = z4;
            }
            i9++;
            z = false;
        }
        if (z2 || f > 0.0f) {
            int i11 = paddingLeft - this.l;
            int i12 = 0;
            while (i12 < childCount) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getVisibility() == i4) {
                    i5 = i11;
                } else {
                    b bVar2 = (b) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() == i4) {
                        i5 = i11;
                    } else {
                        boolean z5 = bVar2.width == 0 && bVar2.f917a > 0.0f;
                        int measuredWidth2 = z5 ? 0 : childAt2.getMeasuredWidth();
                        if (!z2 || childAt2 == this.f914a) {
                            if (bVar2.f917a > 0.0f) {
                                if (bVar2.width == 0) {
                                    if (bVar2.height == -2) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, BleSignal.UNKNOWN_TX_POWER);
                                    } else if (bVar2.height == -1) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(bVar2.height, 1073741824);
                                    }
                                } else {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i13 = paddingLeft - (bVar2.leftMargin + bVar2.rightMargin);
                                    i5 = i11;
                                    int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                                    if (measuredWidth2 != i13) {
                                        childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                    }
                                } else {
                                    i5 = i11;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((bVar2.f917a * Math.max(0, i8)) / f)), 1073741824), makeMeasureSpec);
                                }
                            } else {
                                i5 = i11;
                            }
                        } else if (bVar2.width >= 0 || (measuredWidth2 <= i11 && bVar2.f917a <= 0.0f)) {
                            i5 = i11;
                        } else {
                            if (z5) {
                                if (bVar2.height == -2) {
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, BleSignal.UNKNOWN_TX_POWER);
                                    i6 = 1073741824;
                                } else if (bVar2.height == -1) {
                                    i6 = 1073741824;
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    i6 = 1073741824;
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(bVar2.height, 1073741824);
                                }
                            } else {
                                i6 = 1073741824;
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i11, i6), makeMeasureSpec2);
                            i5 = i11;
                        }
                    }
                }
                i12++;
                i11 = i5;
                i4 = 8;
            }
        }
        setMeasuredDimension(size, i7 + getPaddingTop() + getPaddingBottom());
        this.m = z2;
        if (this.e.a() == 0 || z2) {
            return;
        }
        this.e.f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean f = f();
        if (f) {
            this.e.a(2);
        } else {
            this.e.a(1);
        }
        int i10 = i3 - i;
        int paddingRight = f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.s) {
            this.b = (this.m && this.f) ? 1.0f : 0.0f;
        }
        int i11 = paddingRight;
        int i12 = i11;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (bVar.b) {
                    int i14 = i10 - paddingLeft;
                    int min = (Math.min(i11, i14 - this.l) - i12) - (bVar.leftMargin + bVar.rightMargin);
                    this.c = min;
                    int i15 = f ? bVar.rightMargin : bVar.leftMargin;
                    bVar.c = ((i12 + i15) + min) + (measuredWidth / 2) > i14;
                    int i16 = (int) (min * this.b);
                    i5 = i15 + i16 + i12;
                    this.b = i16 / this.c;
                    i6 = 0;
                } else if (!this.m || (i7 = this.o) == 0) {
                    i5 = i11;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.b) * i7);
                    i5 = i11;
                }
                if (f) {
                    i9 = (i10 - i5) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i11 += childAt.getWidth();
                i12 = i5;
            }
        }
        if (this.s) {
            if (this.m) {
                if (this.o != 0) {
                    a(this.b);
                }
                if (((b) this.f914a.getLayoutParams()).c) {
                    a(this.f914a, this.b, this.h);
                }
            } else {
                for (int i17 = 0; i17 < childCount; i17++) {
                    a(getChildAt(i17), 0.0f, this.h);
                }
            }
            a(this.f914a);
            z2 = false;
        } else {
            z2 = false;
        }
        this.s = z2;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.s = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.m) {
            return;
        }
        this.f = view == this.f914a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.m && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f = !this.e.b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.m || (this.d && actionMasked != 0)) {
            this.e.e();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.e.e();
            return false;
        }
        if (actionMasked == 0) {
            this.d = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.p = x;
            this.q = y;
            if (this.e.b(this.f914a, (int) x, (int) y) && c(this.f914a)) {
                z = true;
                return this.e.a(motionEvent) || z;
            }
        } else if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float abs = Math.abs(x2 - this.p);
            float abs2 = Math.abs(y2 - this.q);
            if (abs > this.e.d() && abs2 > abs) {
                this.e.e();
                this.d = true;
                return false;
            }
        }
        z = false;
        if (this.e.a(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.m) {
            return super.onTouchEvent(motionEvent);
        }
        this.e.b(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.p = x;
                this.q = y;
                break;
            case 1:
                if (c(this.f914a)) {
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float f = x2 - this.p;
                    float f2 = y2 - this.q;
                    int d = this.e.d();
                    if ((f * f) + (f2 * f2) < d * d && this.e.b(this.f914a, (int) x2, (int) y2)) {
                        a(this.f914a, 0);
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private boolean a(View view, int i) {
        if (!this.s && !a(0.0f, i)) {
            return false;
        }
        this.f = false;
        return true;
    }

    private boolean b(View view, int i) {
        if (!this.s && !a(1.0f, i)) {
            return false;
        }
        this.f = true;
        return true;
    }

    public boolean b() {
        return b(this.f914a, 0);
    }

    public boolean c() {
        return a(this.f914a, 0);
    }

    public boolean d() {
        return !this.m || this.b == 1.0f;
    }

    public boolean e() {
        return this.m;
    }

    private void a(View view, float f, int i) {
        b bVar = (b) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & 16777215);
            if (bVar.d == null) {
                bVar.d = new Paint();
            }
            bVar.d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, bVar.d);
            }
            b(view);
            return;
        }
        if (view.getLayerType() != 0) {
            if (bVar.d != null) {
                bVar.d.setColorFilter(null);
            }
            a aVar = new a(view);
            this.g.add(aVar);
            v.a(this, aVar);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        b bVar = (b) view.getLayoutParams();
        int save = canvas.save();
        if (this.m && !bVar.b && this.f914a != null) {
            canvas.getClipBounds(this.t);
            if (f()) {
                Rect rect = this.t;
                rect.left = Math.max(rect.left, this.f914a.getRight());
            } else {
                Rect rect2 = this.t;
                rect2.right = Math.min(rect2.right, this.f914a.getLeft());
            }
            canvas.clipRect(this.t);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    void b(View view) {
        Field field;
        if (Build.VERSION.SDK_INT >= 17) {
            v.a(view, ((b) view.getLayoutParams()).d);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!this.w) {
                try {
                    this.u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException e) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
                }
                try {
                    this.v = View.class.getDeclaredField("mRecreateDisplayList");
                    this.v.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
                }
                this.w = true;
            }
            if (this.u == null || (field = this.v) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.u.invoke(view, (Object[]) null);
            } catch (Exception e3) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e3);
            }
        }
        v.a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    boolean a(float f, int i) {
        int paddingLeft;
        if (!this.m) {
            return false;
        }
        boolean f2 = f();
        b bVar = (b) this.f914a.getLayoutParams();
        if (f2) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + bVar.rightMargin) + (f * this.c)) + this.f914a.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + bVar.leftMargin + (f * this.c));
        }
        androidx.customview.a.a aVar = this.e;
        View view = this.f914a;
        if (!aVar.a(view, paddingLeft, view.getTop())) {
            return false;
        }
        a();
        v.d(this);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.e.a(true)) {
            if (!this.m) {
                this.e.f();
            } else {
                v.d(this);
            }
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.j = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.k = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(androidx.core.content.a.a(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(androidx.core.content.a.a(getContext(), i));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        super.draw(canvas);
        if (f()) {
            drawable = this.k;
        } else {
            drawable = this.j;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (f()) {
            i2 = childAt.getRight();
            i = intrinsicWidth + i2;
        } else {
            int left = childAt.getLeft();
            int i3 = left - intrinsicWidth;
            i = left;
            i2 = i3;
        }
        drawable.setBounds(i2, top, i, bottom);
        drawable.draw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.f()
            android.view.View r1 = r9.f914a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$b r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.b) r1
            boolean r2 = r1.c
            r3 = 0
            if (r2 == 0) goto L1c
            if (r0 == 0) goto L16
            int r1 = r1.rightMargin
            goto L18
        L16:
            int r1 = r1.leftMargin
        L18:
            if (r1 > 0) goto L1c
            r1 = 1
            goto L1d
        L1c:
            r1 = 0
        L1d:
            int r2 = r9.getChildCount()
        L21:
            if (r3 >= r2) goto L5b
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f914a
            if (r4 != r5) goto L2c
            goto L58
        L2c:
            float r5 = r9.n
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.o
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.n = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L44
            int r5 = -r5
        L44:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L58
            if (r0 == 0) goto L4f
            float r5 = r9.n
            float r5 = r5 - r6
            goto L53
        L4f:
            float r5 = r9.n
            float r5 = r6 - r5
        L53:
            int r6 = r9.i
            r9.a(r4, r5, r6)
        L58:
            int r3 = r3 + 1
            goto L21
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.a(float):void");
    }

    boolean c(View view) {
        if (view == null) {
            return false;
        }
        return this.m && ((b) view.getLayoutParams()).c && this.b > 0.0f;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof b) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f915a = e() ? d() : this.f;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.f915a) {
            b();
        } else {
            c();
        }
        this.f = savedState.f915a;
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        private static final int[] e = {R.attr.layout_weight};

        /* renamed from: a, reason: collision with root package name */
        public float f917a;
        boolean b;
        boolean c;
        Paint d;

        public b() {
            super(-1, -1);
            this.f917a = 0.0f;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f917a = 0.0f;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f917a = 0.0f;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f917a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.f917a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        boolean f915a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f915a = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f915a ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final View f916a;

        a(View view) {
            this.f916a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f916a.getParent() == SlidingPaneLayout.this) {
                this.f916a.setLayerType(0, null);
                SlidingPaneLayout.this.b(this.f916a);
            }
            SlidingPaneLayout.this.g.remove(this);
        }
    }

    boolean f() {
        return v.f(this) == 1;
    }
}
