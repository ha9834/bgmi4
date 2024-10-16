package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.a;
import androidx.core.e.d;
import androidx.core.f.ad;
import androidx.core.f.o;
import androidx.core.f.q;
import androidx.core.f.r;
import androidx.core.f.v;
import androidx.customview.view.AbsSavedState;
import com.tencent.smtt.sdk.WebView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements o {

    /* renamed from: a, reason: collision with root package name */
    static final String f450a;
    static final Class<?>[] b;
    static final ThreadLocal<Map<String, Constructor<b>>> c;
    static final Comparator<View> d;
    private static final d.a<Rect> f;
    ViewGroup.OnHierarchyChangeListener e;
    private final List<View> g;
    private final androidx.coordinatorlayout.widget.a<View> h;
    private final List<View> i;
    private final List<View> j;
    private final int[] k;
    private Paint l;
    private boolean m;
    private boolean n;
    private int[] o;
    private View p;
    private View q;
    private f r;
    private boolean s;
    private ad t;
    private boolean u;
    private Drawable v;
    private r w;
    private final q x;

    /* loaded from: classes.dex */
    public interface a {
        b getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface c {
        Class<? extends b> a();
    }

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static int c(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int d(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    private static int e(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f450a = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            d = new g();
        } else {
            d = null;
        }
        b = new Class[]{Context.class, AttributeSet.class};
        c = new ThreadLocal<>();
        f = new d.c(12);
    }

    private static Rect e() {
        Rect a2 = f.a();
        return a2 == null ? new Rect() : a2;
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        f.a(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0040a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.g = new ArrayList();
        this.h = new androidx.coordinatorlayout.widget.a<>();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new int[2];
        this.x = new q(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.CoordinatorLayout, 0, a.b.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.CoordinatorLayout, i, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(a.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.o = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.o.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.o[i2] = (int) (r1[i2] * f2);
            }
        }
        this.v = obtainStyledAttributes.getDrawable(a.c.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        g();
        super.setOnHierarchyChangeListener(new d());
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.e = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.s) {
            if (this.r == null) {
                this.r = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        if (this.t == null && v.q(this)) {
            v.p(this);
        }
        this.n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.s && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        View view = this.q;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.n = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.v;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.v = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.v;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.v.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.v, v.f(this));
                this.v.setVisible(getVisibility() == 0, false);
                this.v.setCallback(this);
            }
            v.d(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.v;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.v;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.v;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.v;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.v.setVisible(z, false);
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? androidx.core.content.a.a(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    final ad a(ad adVar) {
        if (androidx.core.e.b.a(this.t, adVar)) {
            return adVar;
        }
        this.t = adVar;
        this.u = adVar != null && adVar.b() > 0;
        setWillNotDraw(!this.u && getBackground() == null);
        ad b2 = b(adVar);
        requestLayout();
        return b2;
    }

    public final ad getLastWindowInsets() {
        return this.t;
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            b b2 = ((e) childAt.getLayoutParams()).b();
            if (b2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    b2.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    b2.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((e) getChildAt(i2).getLayoutParams()).f();
        }
        this.p = null;
        this.m = false;
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = d;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
    
        if (r7 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0063, code lost:
    
        r21.p = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(android.view.MotionEvent r22, int r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            int r2 = r22.getActionMasked()
            java.util.List<android.view.View> r3 = r0.i
            r0.a(r3)
            int r4 = r3.size()
            r5 = 0
            r6 = 0
            r9 = r6
            r6 = 0
            r7 = 0
            r8 = 0
        L17:
            if (r6 >= r4) goto L7c
            java.lang.Object r10 = r3.get(r6)
            android.view.View r10 = (android.view.View) r10
            android.view.ViewGroup$LayoutParams r11 = r10.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r11 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r11
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r12 = r11.b()
            if (r7 != 0) goto L2d
            if (r8 == 0) goto L50
        L2d:
            if (r2 == 0) goto L50
            if (r12 == 0) goto L79
            if (r9 != 0) goto L44
            long r15 = android.os.SystemClock.uptimeMillis()
            r17 = 3
            r18 = 0
            r19 = 0
            r20 = 0
            r13 = r15
            android.view.MotionEvent r9 = android.view.MotionEvent.obtain(r13, r15, r17, r18, r19, r20)
        L44:
            switch(r23) {
                case 0: goto L4c;
                case 1: goto L48;
                default: goto L47;
            }
        L47:
            goto L79
        L48:
            r12.onTouchEvent(r0, r10, r9)
            goto L79
        L4c:
            r12.onInterceptTouchEvent(r0, r10, r9)
            goto L79
        L50:
            if (r7 != 0) goto L65
            if (r12 == 0) goto L65
            switch(r23) {
                case 0: goto L5d;
                case 1: goto L58;
                default: goto L57;
            }
        L57:
            goto L61
        L58:
            boolean r7 = r12.onTouchEvent(r0, r10, r1)
            goto L61
        L5d:
            boolean r7 = r12.onInterceptTouchEvent(r0, r10, r1)
        L61:
            if (r7 == 0) goto L65
            r0.p = r10
        L65:
            boolean r8 = r11.e()
            boolean r10 = r11.a(r0, r10)
            if (r10 == 0) goto L73
            if (r8 != 0) goto L73
            r8 = 1
            goto L74
        L73:
            r8 = 0
        L74:
            if (r10 == 0) goto L79
            if (r8 != 0) goto L79
            goto L7c
        L79:
            int r6 = r6 + 1
            goto L17
        L7c:
            r3.clear()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.a(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.p
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.a(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = 0
            goto L2e
        L17:
            r3 = 0
        L18:
            android.view.View r6 = r0.p
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r6 = r6.b()
            if (r6 == 0) goto L2d
            android.view.View r7 = r0.p
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
            goto L2e
        L2d:
            r6 = 0
        L2e:
            android.view.View r7 = r0.p
            r8 = 0
            if (r7 != 0) goto L39
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4c
        L39:
            if (r3 == 0) goto L4c
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4c:
            if (r8 == 0) goto L51
            r8.recycle()
        L51:
            if (r2 == r4) goto L56
            r1 = 3
            if (r2 != r1) goto L59
        L56:
            r0.a(r5)
        L59:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.m) {
            return;
        }
        a(false);
        this.m = true;
    }

    private int b(int i) {
        int[] iArr = this.o;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i < 0 || i >= iArr.length) {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
        return iArr[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    static b a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f450a)) {
            str = f450a + '.' + str;
        }
        try {
            Map map = c.get();
            if (map == null) {
                map = new HashMap();
                c.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (b) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    e a(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.b) {
            if (view instanceof a) {
                b behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                eVar.a(behavior);
                eVar.b = true;
            } else {
                c cVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (c) cls.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.a(cVar.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + cVar.a().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                eVar.b = true;
            }
        }
        return eVar;
    }

    private void f() {
        this.g.clear();
        this.h.a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e a2 = a(childAt);
            a2.b(this, childAt);
            this.h.a((androidx.coordinatorlayout.widget.a<View>) childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (a2.a(this, childAt, childAt2)) {
                        if (!this.h.b(childAt2)) {
                            this.h.a((androidx.coordinatorlayout.widget.a<View>) childAt2);
                        }
                        this.h.a(childAt2, childAt);
                    }
                }
            }
        }
        this.g.addAll(this.h.b());
        Collections.reverse(this.g);
    }

    void a(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.b(this, view, rect);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x011b, code lost:
    
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    private ad b(ad adVar) {
        b b2;
        if (adVar.e()) {
            return adVar;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (v.q(childAt) && (b2 = ((e) childAt.getLayoutParams()).b()) != null) {
                adVar = b2.onApplyWindowInsets(this, childAt, adVar);
                if (adVar.e()) {
                    break;
                }
            }
        }
        return adVar;
    }

    public void b(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (eVar.k != null) {
            a(view, eVar.k, i);
        } else if (eVar.e >= 0) {
            b(view, eVar.e, i);
        } else {
            d(view, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b b2;
        int f2 = v.f(this);
        int size = this.g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.g.get(i5);
            if (view.getVisibility() != 8 && ((b2 = ((e) view.getLayoutParams()).b()) == null || !b2.onLayoutChild(this, view, f2))) {
                b(view, f2);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.u || this.v == null) {
            return;
        }
        ad adVar = this.t;
        int b2 = adVar != null ? adVar.b() : 0;
        if (b2 > 0) {
            this.v.setBounds(0, 0, getWidth(), b2);
            this.v.draw(canvas);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        g();
    }

    void b(View view, Rect rect) {
        ((e) view.getLayoutParams()).a(rect);
    }

    void c(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).c());
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void a(View view, int i, Rect rect, Rect rect2, e eVar, int i2, int i3) {
        int width;
        int height;
        int a2 = androidx.core.f.d.a(e(eVar.c), i);
        int a3 = androidx.core.f.d.a(c(eVar.d), i);
        int i4 = a2 & 7;
        int i5 = a2 & 112;
        int i6 = a3 & 7;
        int i7 = a3 & 112;
        if (i6 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i6 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i7 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i7 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i4 == 1) {
            width -= i2 / 2;
        } else if (i4 != 5) {
            width -= i2;
        }
        if (i5 == 16) {
            height -= i3 / 2;
        } else if (i5 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    private void a(e eVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - eVar.bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    void a(View view, int i, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i, rect, rect2, eVar, measuredWidth, measuredHeight);
        a(eVar, rect2, measuredWidth, measuredHeight);
    }

    private void a(View view, View view2, int i) {
        Rect e2 = e();
        Rect e3 = e();
        try {
            a(view2, e2);
            a(view, i, e2, e3);
            view.layout(e3.left, e3.top, e3.right, e3.bottom);
        } finally {
            a(e2);
            a(e3);
        }
    }

    private void b(View view, int i, int i2) {
        e eVar = (e) view.getLayoutParams();
        int a2 = androidx.core.f.d.a(d(eVar.c), i2);
        int i3 = a2 & 7;
        int i4 = a2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b2 = b(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            b2 += measuredWidth / 2;
        } else if (i3 == 5) {
            b2 += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(b2, ((width - getPaddingRight()) - measuredWidth) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void d(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        Rect e2 = e();
        e2.set(getPaddingLeft() + eVar.leftMargin, getPaddingTop() + eVar.topMargin, (getWidth() - getPaddingRight()) - eVar.rightMargin, (getHeight() - getPaddingBottom()) - eVar.bottomMargin);
        if (this.t != null && v.q(this) && !v.q(view)) {
            e2.left += this.t.a();
            e2.top += this.t.b();
            e2.right -= this.t.c();
            e2.bottom -= this.t.d();
        }
        Rect e3 = e();
        androidx.core.f.d.a(c(eVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), e2, e3, i);
        view.layout(e3.left, e3.top, e3.right, e3.bottom);
        a(e2);
        a(e3);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.f454a != null) {
            float scrimOpacity = eVar.f454a.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.l == null) {
                    this.l = new Paint();
                }
                this.l.setColor(eVar.f454a.getScrimColor(this, view));
                this.l.setAlpha(a(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.l);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    final void a(int i) {
        boolean z;
        int f2 = v.f(this);
        int size = this.g.size();
        Rect e2 = e();
        Rect e3 = e();
        Rect e4 = e();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.g.get(i2);
            e eVar = (e) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (eVar.l == this.g.get(i3)) {
                        c(view, f2);
                    }
                }
                a(view, true, e3);
                if (eVar.g != 0 && !e3.isEmpty()) {
                    int a2 = androidx.core.f.d.a(eVar.g, f2);
                    int i4 = a2 & 112;
                    if (i4 == 48) {
                        e2.top = Math.max(e2.top, e3.bottom);
                    } else if (i4 == 80) {
                        e2.bottom = Math.max(e2.bottom, getHeight() - e3.top);
                    }
                    int i5 = a2 & 7;
                    if (i5 == 3) {
                        e2.left = Math.max(e2.left, e3.right);
                    } else if (i5 == 5) {
                        e2.right = Math.max(e2.right, getWidth() - e3.left);
                    }
                }
                if (eVar.h != 0 && view.getVisibility() == 0) {
                    a(view, e2, f2);
                }
                if (i != 2) {
                    c(view, e4);
                    if (!e4.equals(e3)) {
                        b(view, e3);
                    }
                }
                for (int i6 = i2 + 1; i6 < size; i6++) {
                    View view2 = this.g.get(i6);
                    e eVar2 = (e) view2.getLayoutParams();
                    b b2 = eVar2.b();
                    if (b2 != null && b2.layoutDependsOn(this, view2, view)) {
                        if (i == 0 && eVar2.g()) {
                            eVar2.h();
                        } else {
                            if (i == 2) {
                                b2.onDependentViewRemoved(this, view2, view);
                                z = true;
                            } else {
                                z = b2.onDependentViewChanged(this, view2, view);
                            }
                            if (i == 1) {
                                eVar2.a(z);
                            }
                        }
                    }
                }
            }
        }
        a(e2);
        a(e3);
        a(e4);
    }

    private void a(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int height;
        int i3;
        if (v.x(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            b b2 = eVar.b();
            Rect e2 = e();
            Rect e3 = e();
            e3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (b2 != null && b2.getInsetDodgeRect(this, view, e2)) {
                if (!e3.contains(e2)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + e2.toShortString() + " | Bounds:" + e3.toShortString());
                }
            } else {
                e2.set(e3);
            }
            a(e3);
            if (e2.isEmpty()) {
                a(e2);
                return;
            }
            int a2 = androidx.core.f.d.a(eVar.h, i);
            if ((a2 & 48) != 48 || (i3 = (e2.top - eVar.topMargin) - eVar.j) >= rect.top) {
                z = false;
            } else {
                f(view, rect.top - i3);
                z = true;
            }
            if ((a2 & 80) == 80 && (height = ((getHeight() - e2.bottom) - eVar.bottomMargin) + eVar.j) < rect.bottom) {
                f(view, height - rect.bottom);
                z = true;
            }
            if (!z) {
                f(view, 0);
            }
            if ((a2 & 3) != 3 || (i2 = (e2.left - eVar.leftMargin) - eVar.i) >= rect.left) {
                z2 = false;
            } else {
                e(view, rect.left - i2);
                z2 = true;
            }
            if ((a2 & 5) == 5 && (width = ((getWidth() - e2.right) - eVar.rightMargin) + eVar.i) < rect.right) {
                e(view, width - rect.right);
                z2 = true;
            }
            if (!z2) {
                e(view, 0);
            }
            a(e2);
        }
    }

    private void e(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.i != i) {
            v.f(view, i - eVar.i);
            eVar.i = i;
        }
    }

    private void f(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.j != i) {
            v.e(view, i - eVar.j);
            eVar.j = i;
        }
    }

    public void b(View view) {
        List c2 = this.h.c(view);
        if (c2 == null || c2.isEmpty()) {
            return;
        }
        for (int i = 0; i < c2.size(); i++) {
            View view2 = (View) c2.get(i);
            b b2 = ((e) view2.getLayoutParams()).b();
            if (b2 != null) {
                b2.onDependentViewChanged(this, view2, view);
            }
        }
    }

    public List<View> c(View view) {
        List<View> d2 = this.h.d(view);
        this.j.clear();
        if (d2 != null) {
            this.j.addAll(d2);
        }
        return this.j;
    }

    public List<View> d(View view) {
        List c2 = this.h.c(view);
        this.j.clear();
        if (c2 != null) {
            this.j.addAll(c2);
        }
        return this.j;
    }

    final List<View> getDependencySortedChildren() {
        f();
        return Collections.unmodifiableList(this.g);
    }

    void a() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (e(getChildAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        if (z != this.s) {
            if (z) {
                b();
            } else {
                c();
            }
        }
    }

    private boolean e(View view) {
        return this.h.e(view);
    }

    void b() {
        if (this.n) {
            if (this.r == null) {
                this.r = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        this.s = true;
    }

    void c() {
        if (this.n && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        this.s = false;
    }

    void c(View view, int i) {
        b b2;
        e eVar = (e) view.getLayoutParams();
        if (eVar.k != null) {
            Rect e2 = e();
            Rect e3 = e();
            Rect e4 = e();
            a(eVar.k, e2);
            a(view, false, e3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i, e2, e4, eVar, measuredWidth, measuredHeight);
            boolean z = (e4.left == e3.left && e4.top == e3.top) ? false : true;
            a(eVar, e4, measuredWidth, measuredHeight);
            int i2 = e4.left - e3.left;
            int i3 = e4.top - e3.top;
            if (i2 != 0) {
                v.f(view, i2);
            }
            if (i3 != 0) {
                v.e(view, i3);
            }
            if (z && (b2 = eVar.b()) != null) {
                b2.onDependentViewChanged(this, view, eVar.k);
            }
            a(e2);
            a(e3);
            a(e4);
        }
    }

    public boolean a(View view, int i, int i2) {
        Rect e2 = e();
        a(view, e2);
        try {
            return e2.contains(i, i2);
        } finally {
            a(e2);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.f.n
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return a(view, view2, i, 0);
    }

    @Override // androidx.core.f.o
    public boolean a(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b b2 = eVar.b();
                if (b2 != null) {
                    boolean onStartNestedScroll = b2.onStartNestedScroll(this, childAt, view, view2, i, i2);
                    eVar.a(i2, onStartNestedScroll);
                    z |= onStartNestedScroll;
                } else {
                    eVar.a(i2, false);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.f.n
    public void onNestedScrollAccepted(View view, View view2, int i) {
        b(view, view2, i, 0);
    }

    @Override // androidx.core.f.o
    public void b(View view, View view2, int i, int i2) {
        b b2;
        this.x.a(view, view2, i, i2);
        this.q = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.b(i2) && (b2 = eVar.b()) != null) {
                b2.onNestedScrollAccepted(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.f.n
    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    @Override // androidx.core.f.o
    public void a(View view, int i) {
        this.x.a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.b(i)) {
                b b2 = eVar.b();
                if (b2 != null) {
                    b2.onStopNestedScroll(this, childAt, view, i);
                }
                eVar.a(i);
                eVar.h();
            }
        }
        this.q = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.f.n
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, i4, 0);
    }

    @Override // androidx.core.f.o
    public void a(View view, int i, int i2, int i3, int i4, int i5) {
        b b2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(i5) && (b2 = eVar.b()) != null) {
                    b2.onNestedScroll(this, childAt, view, i, i2, i3, i4, i5);
                    z = true;
                }
            }
        }
        if (z) {
            a(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.f.n
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    @Override // androidx.core.f.o
    public void a(View view, int i, int i2, int[] iArr, int i3) {
        b b2;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(i3) && (b2 = eVar.b()) != null) {
                    int[] iArr2 = this.k;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    b2.onNestedPreScroll(this, childAt, view, i, i2, iArr2, i3);
                    if (i > 0) {
                        min = Math.max(i4, this.k[0]);
                    } else {
                        min = Math.min(i4, this.k[0]);
                    }
                    if (i2 > 0) {
                        min2 = Math.max(i5, this.k[1]);
                    } else {
                        min2 = Math.min(i5, this.k[1]);
                    }
                    i4 = min;
                    i5 = min2;
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            a(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.f.n
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        b b2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(0) && (b2 = eVar.b()) != null) {
                    z2 |= b2.onNestedFling(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.f.n
    public boolean onNestedPreFling(View view, float f2, float f3) {
        b b2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(0) && (b2 = eVar.b()) != null) {
                    z |= b2.onNestedPreFling(this, childAt, view, f2, f3);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.x.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class g implements Comparator<View> {
        g() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float y = v.y(view);
            float y2 = v.y(view2);
            if (y > y2) {
                return -1;
            }
            return y < y2 ? 1 : 0;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<V extends View> {
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return WebView.NIGHT_MODE_COLOR;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public ad onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, ad adVar) {
            return adVar;
        }

        public void onAttachedToLayoutParams(e eVar) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public b() {
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public static void setTag(View view, Object obj) {
            ((e) view.getLayoutParams()).n = obj;
        }

        public static Object getTag(View view) {
            return ((e) view.getLayoutParams()).n;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, i);
            }
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        b f454a;
        boolean b;
        public int c;
        public int d;
        public int e;
        int f;
        public int g;
        public int h;
        int i;
        int j;
        View k;
        View l;
        final Rect m;
        Object n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;

        public e(int i, int i2) {
            super(i, i2);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.CoordinatorLayout_Layout);
            this.c = obtainStyledAttributes.getInteger(a.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = obtainStyledAttributes.getResourceId(a.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = obtainStyledAttributes.getInteger(a.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = obtainStyledAttributes.getInteger(a.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = obtainStyledAttributes.getInt(a.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = obtainStyledAttributes.getInt(a.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.b = obtainStyledAttributes.hasValue(a.c.CoordinatorLayout_Layout_layout_behavior);
            if (this.b) {
                this.f454a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(a.c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            b bVar = this.f454a;
            if (bVar != null) {
                bVar.onAttachedToLayoutParams(this);
            }
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public int a() {
            return this.f;
        }

        public b b() {
            return this.f454a;
        }

        public void a(b bVar) {
            b bVar2 = this.f454a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.onDetachedFromLayoutParams();
                }
                this.f454a = bVar;
                this.n = null;
                this.b = true;
                if (bVar != null) {
                    bVar.onAttachedToLayoutParams(this);
                }
            }
        }

        void a(Rect rect) {
            this.m.set(rect);
        }

        Rect c() {
            return this.m;
        }

        boolean d() {
            return this.k == null && this.f != -1;
        }

        boolean e() {
            if (this.f454a == null) {
                this.o = false;
            }
            return this.o;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.o;
            if (z) {
                return true;
            }
            b bVar = this.f454a;
            boolean blocksInteractionBelow = (bVar != null ? bVar.blocksInteractionBelow(coordinatorLayout, view) : false) | z;
            this.o = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        void f() {
            this.o = false;
        }

        void a(int i) {
            a(i, false);
        }

        void a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.p = z;
                    return;
                case 1:
                    this.q = z;
                    return;
                default:
                    return;
            }
        }

        boolean b(int i) {
            switch (i) {
                case 0:
                    return this.p;
                case 1:
                    return this.q;
                default:
                    return false;
            }
        }

        boolean g() {
            return this.r;
        }

        void a(boolean z) {
            this.r = z;
        }

        void h() {
            this.r = false;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            b bVar;
            return view2 == this.l || a(view2, v.f(coordinatorLayout)) || ((bVar = this.f454a) != null && bVar.layoutDependsOn(coordinatorLayout, view, view2));
        }

        View b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f);
            View view2 = this.k;
            if (view2 == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
            }
            if (view2 == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.l = null;
                        this.k = null;
                        return;
                    }
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.l = view2;
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.l = view2;
            return true;
        }

        private boolean a(View view, int i) {
            int a2 = androidx.core.f.d.a(((e) view.getLayoutParams()).g, i);
            return a2 != 0 && (androidx.core.f.d.a(this.h, i) & a2) == a2;
        }
    }

    /* loaded from: classes.dex */
    private class d implements ViewGroup.OnHierarchyChangeListener {
        d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.e != null) {
                CoordinatorLayout.this.e.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            if (CoordinatorLayout.this.e != null) {
                CoordinatorLayout.this.e.onChildViewRemoved(view, view2);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f452a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b b2 = a(childAt).b();
            if (id != -1 && b2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                b2.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b b2 = ((e) childAt.getLayoutParams()).b();
            if (id != -1 && b2 != null && (onSaveInstanceState = b2.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        savedState.f452a = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        b b2 = ((e) view.getLayoutParams()).b();
        if (b2 == null || !b2.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void g() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (v.q(this)) {
            if (this.w == null) {
                this.w = new r() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                    @Override // androidx.core.f.r
                    public ad a(View view, ad adVar) {
                        return CoordinatorLayout.this.a(adVar);
                    }
                };
            }
            v.a(this, this.w);
            setSystemUiVisibility(1280);
            return;
        }
        v.a(this, (r) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState.1
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
        SparseArray<Parcelable> f452a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f452a = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f452a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f452a;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f452a.keyAt(i2);
                parcelableArr[i2] = this.f452a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }
}
