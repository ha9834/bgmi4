package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.f.v;
import androidx.customview.a.a;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    static final boolean b;
    private static final boolean d;
    private float A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private Object E;
    private boolean F;
    private Drawable G;
    private Drawable H;
    private Drawable I;
    private Drawable J;
    private final ArrayList<View> K;
    private Rect L;
    private Matrix M;
    private final a e;
    private float f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private final androidx.customview.a.a k;
    private final androidx.customview.a.a l;
    private final d m;
    private final d n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private b x;
    private List<b> y;
    private float z;
    private static final int[] c = {R.attr.colorPrimaryDark};

    /* renamed from: a, reason: collision with root package name */
    static final int[] f588a = {R.attr.layout_gravity};

    /* loaded from: classes.dex */
    public interface b {
        void a(int i);

        void a(View view);

        void a(View view, float f);

        void b(View view);
    }

    static {
        b = Build.VERSION.SDK_INT >= 19;
        d = Build.VERSION.SDK_INT >= 21;
    }

    public void setDrawerElevation(float f) {
        this.f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (g(childAt)) {
                v.a(childAt, this.f);
            }
        }
    }

    public float getDrawerElevation() {
        if (d) {
            return this.f;
        }
        return 0.0f;
    }

    public void setScrimColor(int i) {
        this.h = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(b bVar) {
        b bVar2 = this.x;
        if (bVar2 != null) {
            b(bVar2);
        }
        if (bVar != null) {
            a(bVar);
        }
        this.x = bVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.y == null) {
            this.y = new ArrayList();
        }
        this.y.add(bVar);
    }

    public void b(b bVar) {
        List<b> list;
        if (bVar == null || (list = this.y) == null) {
            return;
        }
        list.remove(bVar);
    }

    public void setDrawerLockMode(int i) {
        a(i, 3);
        a(i, 5);
    }

    public void a(int i, int i2) {
        int a2 = androidx.core.f.d.a(i2, v.f(this));
        if (i2 == 3) {
            this.r = i;
        } else if (i2 == 5) {
            this.s = i;
        } else if (i2 == 8388611) {
            this.t = i;
        } else if (i2 == 8388613) {
            this.u = i;
        }
        if (i != 0) {
            (a2 == 3 ? this.k : this.l).e();
        }
        switch (i) {
            case 1:
                View b2 = b(a2);
                if (b2 != null) {
                    i(b2);
                    return;
                }
                return;
            case 2:
                View b3 = b(a2);
                if (b3 != null) {
                    h(b3);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int a(int i) {
        int f = v.f(this);
        if (i == 3) {
            int i2 = this.r;
            if (i2 != 3) {
                return i2;
            }
            int i3 = f == 0 ? this.t : this.u;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.s;
            if (i4 != 3) {
                return i4;
            }
            int i5 = f == 0 ? this.u : this.t;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.t;
            if (i6 != 3) {
                return i6;
            }
            int i7 = f == 0 ? this.r : this.s;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.u;
        if (i8 != 3) {
            return i8;
        }
        int i9 = f == 0 ? this.s : this.r;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    public int a(View view) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return a(((c) view.getLayoutParams()).f590a);
    }

    private boolean a(float f, float f2, View view) {
        if (this.L == null) {
            this.L = new Rect();
        }
        view.getHitRect(this.L);
        return this.L.contains((int) f, (int) f2);
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent b2 = b(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(b2);
            b2.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent b(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.M == null) {
                this.M = new Matrix();
            }
            matrix.invert(this.M);
            obtain.transform(this.M);
        }
        return obtain;
    }

    void a(int i, int i2, View view) {
        int a2 = this.k.a();
        int a3 = this.l.a();
        int i3 = 2;
        if (a2 == 1 || a3 == 1) {
            i3 = 1;
        } else if (a2 != 2 && a3 != 2) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            c cVar = (c) view.getLayoutParams();
            if (cVar.b == 0.0f) {
                b(view);
            } else if (cVar.b == 1.0f) {
                c(view);
            }
        }
        if (i3 != this.o) {
            this.o = i3;
            List<b> list = this.y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y.get(size).a(i3);
                }
            }
        }
    }

    void b(View view) {
        View rootView;
        c cVar = (c) view.getLayoutParams();
        if ((cVar.d & 1) == 1) {
            cVar.d = 0;
            List<b> list = this.y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y.get(size).b(view);
                }
            }
            c(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void c(View view) {
        c cVar = (c) view.getLayoutParams();
        if ((cVar.d & 1) == 0) {
            cVar.d = 1;
            List<b> list = this.y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y.get(size).a(view);
                }
            }
            c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    private void c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z && !g(childAt)) || (z && childAt == view)) {
                v.b(childAt, 1);
            } else {
                v.b(childAt, 4);
            }
        }
    }

    void a(View view, float f) {
        List<b> list = this.y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.y.get(size).a(view, f);
            }
        }
    }

    void b(View view, float f) {
        c cVar = (c) view.getLayoutParams();
        if (f == cVar.b) {
            return;
        }
        cVar.b = f;
        a(view, f);
    }

    float d(View view) {
        return ((c) view.getLayoutParams()).b;
    }

    int e(View view) {
        return androidx.core.f.d.a(((c) view.getLayoutParams()).f590a, v.f(this));
    }

    boolean a(View view, int i) {
        return (e(view) & i) == i;
    }

    View a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((c) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    void c(View view, float f) {
        float d2 = d(view);
        float width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (d2 * width));
        if (!a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        b(view, f);
    }

    View b(int i) {
        int a2 = androidx.core.f.d.a(i, v.f(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((e(childAt) & 7) == a2) {
                return childAt;
            }
        }
        return null;
    }

    static String c(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.E != null && v.q(this);
        int f = v.f(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (z) {
                    int a2 = androidx.core.f.d.a(cVar.f590a, f);
                    if (v.q(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.E;
                            if (a2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (a2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.E;
                        if (a2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i3, windowInsets2.getSystemWindowInsetBottom());
                        } else if (a2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i3, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        cVar.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        cVar.topMargin = windowInsets2.getSystemWindowInsetTop();
                        cVar.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        cVar.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (f(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - cVar.leftMargin) - cVar.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - cVar.topMargin) - cVar.bottomMargin, 1073741824));
                } else if (g(childAt)) {
                    if (d) {
                        float m = v.m(childAt);
                        float f2 = this.f;
                        if (m != f2) {
                            v.a(childAt, f2);
                        }
                    }
                    int e = e(childAt) & 7;
                    boolean z4 = e == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + c(e) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(getChildMeasureSpec(i, this.g + cVar.leftMargin + cVar.rightMargin, cVar.width), getChildMeasureSpec(i2, cVar.topMargin + cVar.bottomMargin, cVar.height));
                    i4++;
                    i3 = 0;
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i4++;
            i3 = 0;
        }
    }

    private void d() {
        if (d) {
            return;
        }
        this.C = e();
        this.D = f();
    }

    private Drawable e() {
        int f = v.f(this);
        if (f == 0) {
            Drawable drawable = this.G;
            if (drawable != null) {
                a(drawable, f);
                return this.G;
            }
        } else {
            Drawable drawable2 = this.H;
            if (drawable2 != null) {
                a(drawable2, f);
                return this.H;
            }
        }
        return this.I;
    }

    private Drawable f() {
        int f = v.f(this);
        if (f == 0) {
            Drawable drawable = this.H;
            if (drawable != null) {
                a(drawable, f);
                return this.H;
            }
        } else {
            Drawable drawable2 = this.G;
            if (drawable2 != null) {
                a(drawable2, f);
                return this.G;
            }
        }
        return this.J;
    }

    private boolean a(Drawable drawable, int i) {
        if (drawable == null || !androidx.core.graphics.drawable.a.b(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable, i);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        this.p = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(cVar.leftMargin, cVar.topMargin, cVar.leftMargin + childAt.getMeasuredWidth(), cVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f2 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (cVar.b * f2));
                        f = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i6 - r11) / f3;
                        i5 = i6 - ((int) (cVar.b * f3));
                    }
                    boolean z2 = f != cVar.b;
                    int i8 = cVar.f590a & 112;
                    if (i8 == 16) {
                        int i9 = i4 - i2;
                        int i10 = (i9 - measuredHeight) / 2;
                        if (i10 < cVar.topMargin) {
                            i10 = cVar.topMargin;
                        } else if (i10 + measuredHeight > i9 - cVar.bottomMargin) {
                            i10 = (i9 - cVar.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i5, i10, measuredWidth + i5, measuredHeight + i10);
                    } else if (i8 != 80) {
                        childAt.layout(i5, cVar.topMargin, measuredWidth + i5, cVar.topMargin + measuredHeight);
                    } else {
                        int i11 = i4 - i2;
                        childAt.layout(i5, (i11 - cVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i11 - cVar.bottomMargin);
                    }
                    if (z2) {
                        b(childAt, f);
                    }
                    int i12 = cVar.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i12) {
                        childAt.setVisibility(i12);
                    }
                }
            }
        }
        this.p = false;
        this.q = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.p) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((c) getChildAt(i).getLayoutParams()).b);
        }
        this.i = f;
        boolean a2 = this.k.a(true);
        boolean a3 = this.l.a(true);
        if (a2 || a3) {
            v.d(this);
        }
    }

    private static boolean m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    public void setStatusBarBackground(int i) {
        this.B = i != 0 ? androidx.core.content.a.a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.B = new ColorDrawable(i);
        invalidate();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        d();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (!this.F || this.B == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Object obj = this.E;
            i = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        } else {
            i = 0;
        }
        if (i > 0) {
            this.B.setBounds(0, 0, getWidth(), i);
            this.B.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = f(view);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (f) {
            int childCount = getChildCount();
            i = width;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && m(childAt) && g(childAt) && childAt.getHeight() >= height) {
                    if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < i) {
                            i = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, i, getHeight());
            i2 = i3;
        } else {
            i = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f2 = this.i;
        if (f2 > 0.0f && f) {
            this.j.setColor((this.h & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f2)) << 24));
            canvas.drawRect(i2, 0.0f, i, getHeight(), this.j);
        } else if (this.C != null && a(view, 3)) {
            int intrinsicWidth = this.C.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.k.b(), 1.0f));
            this.C.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.C.setAlpha((int) (max * 255.0f));
            this.C.draw(canvas);
        } else if (this.D != null && a(view, 5)) {
            int intrinsicWidth2 = this.D.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.l.b(), 1.0f));
            this.D.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.D.setAlpha((int) (max2 * 255.0f));
            this.D.draw(canvas);
        }
        return drawChild;
    }

    boolean f(View view) {
        return ((c) view.getLayoutParams()).f590a == 0;
    }

    boolean g(View view) {
        int a2 = androidx.core.f.d.a(((c) view.getLayoutParams()).f590a, v.f(view));
        return ((a2 & 3) == 0 && (a2 & 5) == 0) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View d2;
        int actionMasked = motionEvent.getActionMasked();
        boolean a2 = this.k.a(motionEvent) | this.l.a(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.z = x;
                this.A = y;
                z = this.i > 0.0f && (d2 = this.k.d((int) x, (int) y)) != null && f(d2);
                this.v = false;
                this.w = false;
                break;
            case 1:
            case 3:
                a(true);
                this.v = false;
                this.w = false;
                z = false;
                break;
            case 2:
                if (this.k.d(3)) {
                    this.m.a();
                    this.n.a();
                }
                z = false;
                break;
            default:
                z = false;
                break;
        }
        return a2 || z || g() || this.w;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.i <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (a(x, y, childAt) && !f(childAt) && a(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View a2;
        this.k.b(motionEvent);
        this.l.b(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 3) {
            switch (action) {
                case 0:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.z = x;
                    this.A = y;
                    this.v = false;
                    this.w = false;
                    break;
                case 1:
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    View d2 = this.k.d((int) x2, (int) y2);
                    if (d2 != null && f(d2)) {
                        float f = x2 - this.z;
                        float f2 = y2 - this.A;
                        int d3 = this.k.d();
                        if ((f * f) + (f2 * f2) < d3 * d3 && (a2 = a()) != null) {
                            z = a(a2) == 2;
                            a(z);
                            this.v = false;
                            break;
                        }
                    }
                    z = true;
                    a(z);
                    this.v = false;
                    break;
            }
        } else {
            a(true);
            this.v = false;
            this.w = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.v = z;
        if (z) {
            a(true);
        }
    }

    public void b() {
        a(false);
    }

    void a(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            c cVar = (c) childAt.getLayoutParams();
            if (g(childAt) && (!z || cVar.c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    z2 |= this.k.a(childAt, -width, childAt.getTop());
                } else {
                    z2 |= this.l.a(childAt, getWidth(), childAt.getTop());
                }
                cVar.c = false;
            }
        }
        this.m.a();
        this.n.a();
        if (z2) {
            invalidate();
        }
    }

    public void h(View view) {
        a(view, true);
    }

    public void a(View view, boolean z) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        c cVar = (c) view.getLayoutParams();
        if (this.q) {
            cVar.b = 1.0f;
            cVar.d = 1;
            c(view, true);
        } else if (z) {
            cVar.d |= 2;
            if (a(view, 3)) {
                this.k.a(view, 0, view.getTop());
            } else {
                this.l.a(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            c(view, 1.0f);
            a(cVar.f590a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void i(View view) {
        b(view, true);
    }

    public void b(View view, boolean z) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        c cVar = (c) view.getLayoutParams();
        if (this.q) {
            cVar.b = 0.0f;
            cVar.d = 0;
        } else if (z) {
            cVar.d |= 4;
            if (a(view, 3)) {
                this.k.a(view, -view.getWidth(), view.getTop());
            } else {
                this.l.a(view, getWidth(), view.getTop());
            }
        } else {
            c(view, 0.0f);
            a(cVar.f590a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public boolean j(View view) {
        if (g(view)) {
            return (((c) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean k(View view) {
        if (g(view)) {
            return ((c) view.getLayoutParams()).b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    private boolean g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((c) getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c ? new c((c) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (g(childAt)) {
                if (j(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            } else {
                this.K.add(childAt);
            }
        }
        if (!z) {
            int size = this.K.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.K.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.K.clear();
    }

    private boolean h() {
        return c() != null;
    }

    View c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (g(childAt) && k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && h()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View c2 = c();
            if (c2 != null && a(c2) == 0) {
                b();
            }
            return c2 != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View b2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.f589a != 0 && (b2 = b(savedState.f589a)) != null) {
            h(b2);
        }
        if (savedState.b != 3) {
            a(savedState.b, 3);
        }
        if (savedState.d != 3) {
            a(savedState.d, 5);
        }
        if (savedState.e != 3) {
            a(savedState.e, 8388611);
        }
        if (savedState.f != 3) {
            a(savedState.f, 8388613);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c cVar = (c) getChildAt(i).getLayoutParams();
            boolean z = cVar.d == 1;
            boolean z2 = cVar.d == 2;
            if (z || z2) {
                savedState.f589a = cVar.f590a;
                break;
            }
        }
        savedState.b = this.r;
        savedState.d = this.s;
        savedState.e = this.t;
        savedState.f = this.u;
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (a() != null || g(view)) {
            v.b(view, 4);
        } else {
            v.b(view, 1);
        }
        if (b) {
            return;
        }
        v.a(view, this.e);
    }

    static boolean l(View view) {
        return (v.e(view) == 4 || v.e(view) == 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
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
        int f589a;
        int b;
        int d;
        int e;
        int f;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f589a = 0;
            this.f589a = parcel.readInt();
            this.b = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f589a = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f589a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends a.AbstractC0051a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DrawerLayout f591a;
        private final int b;
        private androidx.customview.a.a c;
        private final Runnable d;

        @Override // androidx.customview.a.a.AbstractC0051a
        public boolean b(int i) {
            return false;
        }

        public void a() {
            this.f591a.removeCallbacks(this.d);
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public boolean b(View view, int i) {
            return this.f591a.g(view) && this.f591a.a(view, this.b) && this.f591a.a(view) == 0;
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void a(int i) {
            this.f591a.a(this.b, i, this.c.c());
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void a(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = this.f591a.a(view, 3) ? (i + width) / width : (this.f591a.getWidth() - i) / width;
            this.f591a.b(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            this.f591a.invalidate();
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void a(View view, int i) {
            ((c) view.getLayoutParams()).c = false;
            b();
        }

        private void b() {
            View b = this.f591a.b(this.b == 3 ? 5 : 3);
            if (b != null) {
                this.f591a.i(b);
            }
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void a(View view, float f, float f2) {
            int i;
            float d = this.f591a.d(view);
            int width = view.getWidth();
            if (this.f591a.a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
            } else {
                int width2 = this.f591a.getWidth();
                if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.c.a(i, view.getTop());
            this.f591a.invalidate();
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void a(int i, int i2) {
            this.f591a.postDelayed(this.d, 160L);
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void b(int i, int i2) {
            View b;
            if ((i & 1) == 1) {
                b = this.f591a.b(3);
            } else {
                b = this.f591a.b(5);
            }
            if (b == null || this.f591a.a(b) != 0) {
                return;
            }
            this.c.a(b, i2);
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public int a(View view) {
            if (this.f591a.g(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public int a(View view, int i, int i2) {
            if (this.f591a.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.f591a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f590a;
        float b;
        boolean c;
        int d;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f590a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f588a);
            this.f590a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public c(int i, int i2) {
            super(i, i2);
            this.f590a = 0;
        }

        public c(c cVar) {
            super((ViewGroup.MarginLayoutParams) cVar);
            this.f590a = 0;
            this.f590a = cVar.f590a;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f590a = 0;
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f590a = 0;
        }
    }

    /* loaded from: classes.dex */
    static final class a extends androidx.core.f.a {
        @Override // androidx.core.f.a
        public void a(View view, androidx.core.f.a.d dVar) {
            super.a(view, dVar);
            if (DrawerLayout.l(view)) {
                return;
            }
            dVar.a((View) null);
        }
    }
}
