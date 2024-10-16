package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.ad;
import androidx.core.f.j;
import androidx.core.f.r;
import androidx.core.f.v;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a;
import com.google.android.material.internal.k;
import com.twitter.sdk.android.core.internal.scribe.ScribeConfig;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.c(a = Behavior.class)
/* loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f5213a;
    private int b;
    private int c;
    private boolean d;
    private int e;
    private ad f;
    private List<a> g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int[] l;

    /* loaded from: classes2.dex */
    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5213a = -1;
        this.b = -1;
        this.c = -1;
        this.e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(this);
            e.a(this, attributeSet, 0, a.j.Widget_Design_AppBarLayout);
        }
        TypedArray a2 = k.a(context, attributeSet, a.k.AppBarLayout, 0, a.j.Widget_Design_AppBarLayout, new int[0]);
        v.a(this, a2.getDrawable(a.k.AppBarLayout_android_background));
        if (a2.hasValue(a.k.AppBarLayout_expanded)) {
            a(a2.getBoolean(a.k.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && a2.hasValue(a.k.AppBarLayout_elevation)) {
            e.a(this, a2.getDimensionPixelSize(a.k.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a2.hasValue(a.k.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(a2.getBoolean(a.k.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (a2.hasValue(a.k.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(a2.getBoolean(a.k.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.k = a2.getBoolean(a.k.AppBarLayout_liftOnScroll, false);
        a2.recycle();
        v.a(this, new r() { // from class: com.google.android.material.appbar.AppBarLayout.1
            @Override // androidx.core.f.r
            public ad a(View view, ad adVar) {
                return AppBarLayout.this.a(adVar);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        g();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        g();
        this.d = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            if (((b) getChildAt(i5).getLayoutParams()).b() != null) {
                this.d = true;
                break;
            }
            i5++;
        }
        if (this.h) {
            return;
        }
        b(this.k || f());
    }

    private boolean f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((b) getChildAt(i).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        this.f5213a = -1;
        this.b = -1;
        this.c = -1;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        a(z, v.x(this));
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        this.e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new b((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    boolean b() {
        return this.d;
    }

    public final int getTotalScrollRange() {
        int i = this.f5213a;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = bVar.f5217a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight + bVar.topMargin + bVar.bottomMargin;
            if ((i4 & 2) != 0) {
                i3 -= v.k(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3 - getTopInset());
        this.f5213a = max;
        return max;
    }

    boolean c() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = bVar.f5217a;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
            } else {
                int i4 = i2 + bVar.topMargin + bVar.bottomMargin;
                if ((i3 & 8) != 0) {
                    i2 = i4 + v.k(childAt);
                } else if ((i3 & 2) != 0) {
                    i2 = i4 + (measuredHeight - v.k(childAt));
                } else {
                    i2 = i4 + (measuredHeight - getTopInset());
                }
            }
        }
        int max = Math.max(0, i2);
        this.b = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin;
            int i4 = bVar.f5217a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= v.k(childAt) + getTopInset();
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.c = max;
        return max;
    }

    void a(int i) {
        List<a> list = this.g;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.g.get(i2);
                if (aVar != null) {
                    aVar.a(this, i);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int k = v.k(this);
        if (k != 0) {
            return (k * 2) + topInset;
        }
        int childCount = getChildCount();
        int k2 = childCount >= 1 ? v.k(getChildAt(childCount - 1)) : 0;
        return k2 != 0 ? (k2 * 2) + topInset : getHeight() / 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.l == null) {
            this.l = new int[4];
        }
        int[] iArr = this.l;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.i ? a.b.state_liftable : -a.b.state_liftable;
        iArr[1] = (this.i && this.j) ? a.b.state_lifted : -a.b.state_lifted;
        iArr[2] = this.i ? a.b.state_collapsible : -a.b.state_collapsible;
        iArr[3] = (this.i && this.j) ? a.b.state_collapsed : -a.b.state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    private boolean b(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        return true;
    }

    boolean a(boolean z) {
        if (this.j == z) {
            return false;
        }
        this.j = z;
        refreshDrawableState();
        return true;
    }

    public void setLiftOnScroll(boolean z) {
        this.k = z;
    }

    public boolean d() {
        return this.k;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(this, f);
        }
    }

    int getPendingAction() {
        return this.e;
    }

    void e() {
        this.e = 0;
    }

    final int getTopInset() {
        ad adVar = this.f;
        if (adVar != null) {
            return adVar.b();
        }
        return 0;
    }

    ad a(ad adVar) {
        ad adVar2 = v.q(this) ? adVar : null;
        if (!androidx.core.e.b.a(this.f, adVar2)) {
            this.f = adVar2;
            g();
        }
        return adVar;
    }

    /* loaded from: classes2.dex */
    public static class b extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f5217a;
        Interpolator b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5217a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.AppBarLayout_Layout);
            this.f5217a = obtainStyledAttributes.getInt(a.k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(a.k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(a.k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public b(int i, int i2) {
            super(i, i2);
            this.f5217a = 1;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5217a = 1;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5217a = 1;
        }

        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5217a = 1;
        }

        public void a(int i) {
            this.f5217a = i;
        }

        public int a() {
            return this.f5217a;
        }

        public Interpolator b() {
            return this.b;
        }

        boolean c() {
            int i = this.f5217a;
            return (i & 1) == 1 && (i & 10) != 0;
        }
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.onStopNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: b */
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a<T> {
        private int b;
        private int c;
        private ValueAnimator d;
        private int e;
        private boolean f;
        private float g;
        private WeakReference<View> h;
        private a i;

        /* loaded from: classes2.dex */
        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        public BaseBehavior() {
            this.e = -1;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (t.d() || a(coordinatorLayout, (CoordinatorLayout) t, view));
            if (z && (valueAnimator = this.d) != null) {
                valueAnimator.cancel();
            }
            this.h = null;
            this.c = i2;
            return z;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.c() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i6 = -t.getTotalScrollRange();
                    i4 = i6;
                    i5 = t.getDownNestedPreScrollRange() + i6;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i4 != i5) {
                    iArr[1] = b(coordinatorLayout, t, i2, i4, i5);
                    a(i2, (int) t, view, i3);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                b(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
                a(i4, (int) t, view, i5);
            }
            if (t.d()) {
                t.a(view.getScrollY() > 0);
            }
        }

        private void a(int i, T t, View view, int i2) {
            if (i2 == 1) {
                int a2 = a();
                if ((i >= 0 || a2 != 0) && (i <= 0 || a2 != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                v.d(view, 1);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.c == 0 || i == 1) {
                c(coordinatorLayout, (CoordinatorLayout) t);
            }
            this.h = new WeakReference<>(view);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int height;
            int abs = Math.abs(a() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, (CoordinatorLayout) t, i, height);
        }

        private void a(final CoordinatorLayout coordinatorLayout, final T t, int i, int i2) {
            int a2 = a();
            if (a2 == i) {
                ValueAnimator valueAnimator = this.d;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.d.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.d;
            if (valueAnimator2 == null) {
                this.d = new ValueAnimator();
                this.d.setInterpolator(com.google.android.material.a.a.e);
                this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        BaseBehavior.this.a_(coordinatorLayout, t, ((Integer) valueAnimator3.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.d.setDuration(Math.min(i2, ScribeConfig.DEFAULT_SEND_INTERVAL_SECONDS));
            this.d.setIntValues(a2, i);
            this.d.start();
        }

        private int a(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                b bVar = (b) childAt.getLayoutParams();
                if (a(bVar.a(), 32)) {
                    top -= bVar.topMargin;
                    bottom += bVar.bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        private void c(CoordinatorLayout coordinatorLayout, T t) {
            int a2 = a();
            int a3 = a((BaseBehavior<T>) t, a2);
            if (a3 >= 0) {
                View childAt = t.getChildAt(a3);
                b bVar = (b) childAt.getLayoutParams();
                int a4 = bVar.a();
                if ((a4 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (a3 == t.getChildCount() - 1) {
                        i2 += t.getTopInset();
                    }
                    if (a(a4, 2)) {
                        i2 += v.k(childAt);
                    } else if (a(a4, 5)) {
                        int k = v.k(childAt) + i2;
                        if (a2 < k) {
                            i = k;
                        } else {
                            i2 = k;
                        }
                    }
                    if (a(a4, 32)) {
                        i += bVar.topMargin;
                        i2 -= bVar.bottomMargin;
                    }
                    if (a2 < (i2 + i) / 2) {
                        i = i2;
                    }
                    a(coordinatorLayout, (CoordinatorLayout) t, androidx.core.b.a.a(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.e) t.getLayoutParams()).height == -2) {
                coordinatorLayout.a(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, t, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, T t, int i) {
            int round;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, t, i);
            int pendingAction = t.getPendingAction();
            int i2 = this.e;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i2);
                int i3 = -childAt.getBottom();
                if (this.f) {
                    round = i3 + v.k(childAt) + t.getTopInset();
                } else {
                    round = i3 + Math.round(childAt.getHeight() * this.g);
                }
                a_(coordinatorLayout, t, round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, i4, 0.0f);
                    } else {
                        a_(coordinatorLayout, t, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, t, 0);
                    }
                }
            }
            t.e();
            this.e = -1;
            a(androidx.core.b.a.a(b(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, (CoordinatorLayout) t, b(), 0, true);
            t.a(b());
            return onLayoutChild;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean c(T t) {
            a aVar = this.i;
            if (aVar != null) {
                return aVar.a(t);
            }
            WeakReference<View> weakReference = this.h;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        public void a(CoordinatorLayout coordinatorLayout, T t) {
            c(coordinatorLayout, (CoordinatorLayout) t);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(T t) {
            return t.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        public int a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int a2 = a();
            int i4 = 0;
            if (i2 != 0 && a2 >= i2 && a2 <= i3) {
                int a3 = androidx.core.b.a.a(i, i2, i3);
                if (a2 != a3) {
                    int b = t.b() ? b((BaseBehavior<T>) t, a3) : a3;
                    boolean a4 = a(b);
                    i4 = a2 - a3;
                    this.b = a3 - b;
                    if (!a4 && t.b()) {
                        coordinatorLayout.b(t);
                    }
                    t.a(b());
                    a(coordinatorLayout, (CoordinatorLayout) t, a3, a3 < a2 ? -1 : 1, false);
                }
            } else {
                this.b = 0;
            }
            return i4;
        }

        private int b(T t, int i) {
            int abs = Math.abs(i);
            int childCount = t.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i3);
                b bVar = (b) childAt.getLayoutParams();
                Interpolator b = bVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (b != null) {
                    int a2 = bVar.a();
                    if ((a2 & 1) != 0) {
                        i2 = 0 + childAt.getHeight() + bVar.topMargin + bVar.bottomMargin;
                        if ((a2 & 2) != 0) {
                            i2 -= v.k(childAt);
                        }
                    }
                    if (v.q(childAt)) {
                        i2 -= t.getTopInset();
                    }
                    if (i2 > 0) {
                        float f = i2;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * b.getInterpolation((abs - childAt.getTop()) / f)));
                    }
                }
            }
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = c(r7, r8)
                if (r0 == 0) goto L73
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$b r1 = (com.google.android.material.appbar.AppBarLayout.b) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L46
                int r2 = androidx.core.f.v.k(r0)
                if (r9 <= 0) goto L31
                r9 = r1 & 12
                if (r9 == 0) goto L31
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L2f
                r8 = 1
                goto L47
            L2f:
                r8 = 0
                goto L47
            L31:
                r9 = r1 & 2
                if (r9 == 0) goto L46
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L44
                r8 = 1
                goto L47
            L44:
                r8 = 0
                goto L47
            L46:
                r8 = 0
            L47:
                boolean r9 = r7.d()
                if (r9 == 0) goto L5c
                android.view.View r9 = r5.a(r6)
                if (r9 == 0) goto L5c
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L5b
                r8 = 1
                goto L5c
            L5b:
                r8 = 0
            L5c:
                boolean r8 = r7.a(r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L73
                if (r10 != 0) goto L70
                if (r8 == 0) goto L73
                boolean r6 = r5.d(r6, r7)
                if (r6 == 0) goto L73
            L70:
                r7.jumpDrawablesToCurrentState()
            L73:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        private boolean d(CoordinatorLayout coordinatorLayout, T t) {
            List<View> d = coordinatorLayout.d(t);
            int size = d.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.b b = ((CoordinatorLayout.e) d.get(i).getLayoutParams()).b();
                if (b instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) b).c() != 0;
                }
            }
            return false;
        }

        private static View c(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt instanceof j) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.a
        int a() {
            return b() + this.b;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t);
            int b = b();
            int childCount = t.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + b;
                if (childAt.getTop() + b <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.f5216a = i;
                    savedState.d = bottom == v.k(childAt) + t.getTopInset();
                    savedState.b = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, t, savedState.a());
                this.e = savedState.f5216a;
                this.g = savedState.b;
                this.f = savedState.d;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t, parcelable);
            this.e = -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes2.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
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
            int f5216a;
            float b;
            boolean d;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f5216a = parcel.readInt();
                this.b = parcel.readFloat();
                this.d = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f5216a);
                parcel.writeFloat(this.b);
                parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        @Override // com.google.android.material.appbar.b
        /* synthetic */ View b(List list) {
            return a((List<View>) list);
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.onLayoutChild(coordinatorLayout, view, i);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(a.k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a2 = a(coordinatorLayout.c(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f5220a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void a(View view, View view2) {
            CoordinatorLayout.b b = ((CoordinatorLayout.e) view2.getLayoutParams()).b();
            if (b instanceof BaseBehavior) {
                v.e(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) b).b) + a()) - c(view2));
            }
        }

        @Override // com.google.android.material.appbar.b
        float a(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + a2 > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (a2 / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.b b = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).b();
            if (b instanceof BaseBehavior) {
                return ((BaseBehavior) b).a();
            }
            return 0;
        }

        AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        public int b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.b(view);
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.d()) {
                    appBarLayout.a(view.getScrollY() > 0);
                }
            }
        }
    }
}
