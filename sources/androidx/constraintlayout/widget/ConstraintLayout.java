package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.i;
import com.tencent.mtt.spcialcall.SpecialCallActivity;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    SparseArray<View> f440a;
    androidx.constraintlayout.solver.widgets.d b;
    int c;
    int d;
    int e;
    int f;
    private ArrayList<b> g;
    private final ArrayList<ConstraintWidget> h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private c o;
    private int p;
    private HashMap<String, Integer> q;
    private int r;
    private int s;
    private androidx.constraintlayout.solver.f t;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void a(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.q == null) {
                this.q = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.q.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public Object a(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.q;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.q.get(str);
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.f440a = new SparseArray<>();
        this.g = new ArrayList<>(4);
        this.h = new ArrayList<>(100);
        this.b = new androidx.constraintlayout.solver.widgets.d();
        this.i = 0;
        this.j = 0;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = true;
        this.n = 3;
        this.o = null;
        this.p = -1;
        this.q = new HashMap<>();
        this.r = -1;
        this.s = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        b(null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f440a = new SparseArray<>();
        this.g = new ArrayList<>(4);
        this.h = new ArrayList<>(100);
        this.b = new androidx.constraintlayout.solver.widgets.d();
        this.i = 0;
        this.j = 0;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = true;
        this.n = 3;
        this.o = null;
        this.p = -1;
        this.q = new HashMap<>();
        this.r = -1;
        this.s = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f440a = new SparseArray<>();
        this.g = new ArrayList<>(4);
        this.h = new ArrayList<>(100);
        this.b = new androidx.constraintlayout.solver.widgets.d();
        this.i = 0;
        this.j = 0;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = true;
        this.n = 3;
        this.o = null;
        this.p = -1;
        this.q = new HashMap<>();
        this.r = -1;
        this.s = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        b(attributeSet);
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f440a.remove(getId());
        super.setId(i);
        this.f440a.put(getId(), this);
    }

    private void b(AttributeSet attributeSet) {
        this.b.a(this);
        this.f440a.put(getId(), this);
        this.o = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == a.b.ConstraintLayout_Layout_android_minWidth) {
                    this.i = obtainStyledAttributes.getDimensionPixelOffset(index, this.i);
                } else if (index == a.b.ConstraintLayout_Layout_android_minHeight) {
                    this.j = obtainStyledAttributes.getDimensionPixelOffset(index, this.j);
                } else if (index == a.b.ConstraintLayout_Layout_android_maxWidth) {
                    this.k = obtainStyledAttributes.getDimensionPixelOffset(index, this.k);
                } else if (index == a.b.ConstraintLayout_Layout_android_maxHeight) {
                    this.l = obtainStyledAttributes.getDimensionPixelOffset(index, this.l);
                } else if (index == a.b.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.n = obtainStyledAttributes.getInt(index, this.n);
                } else if (index == a.b.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.o = new c();
                        this.o.a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.o = null;
                    }
                    this.p = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.b.a(this.n);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget a2 = a(view);
        if ((view instanceof e) && !(a2 instanceof androidx.constraintlayout.solver.widgets.e)) {
            a aVar = (a) view.getLayoutParams();
            aVar.al = new androidx.constraintlayout.solver.widgets.e();
            aVar.Y = true;
            ((androidx.constraintlayout.solver.widgets.e) aVar.al).a(aVar.S);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.a();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.g.contains(bVar)) {
                this.g.add(bVar);
            }
        }
        this.f440a.put(view.getId(), view);
        this.m = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f440a.remove(view.getId());
        ConstraintWidget a2 = a(view);
        this.b.c(a2);
        this.g.remove(view);
        this.h.remove(a2);
        this.m = true;
    }

    public void setMinWidth(int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.j) {
            return;
        }
        this.j = i;
        requestLayout();
    }

    public int getMinWidth() {
        return this.i;
    }

    public int getMinHeight() {
        return this.j;
    }

    public void setMaxWidth(int i) {
        if (i == this.k) {
            return;
        }
        this.k = i;
        requestLayout();
    }

    public void setMaxHeight(int i) {
        if (i == this.l) {
            return;
        }
        this.l = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.k;
    }

    public int getMaxHeight() {
        return this.l;
    }

    private void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            this.h.clear();
            c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01f8  */
    /* JADX WARN: Type inference failed for: r26v0, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v67 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c() {
        /*
            Method dump skipped, instructions count: 1043
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.c():void");
    }

    private final ConstraintWidget a(int i) {
        if (i == 0) {
            return this.b;
        }
        View view = this.f440a.get(i);
        if (view == this) {
            return this.b;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).al;
    }

    public final ConstraintWidget a(View view) {
        if (view == this) {
            return this.b;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).al;
    }

    private void a(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = aVar.al;
                if (!aVar.Y && !aVar.Z) {
                    constraintWidget.e(childAt.getVisibility());
                    int i4 = aVar.width;
                    int i5 = aVar.height;
                    if (aVar.V || aVar.W || (!aVar.V && aVar.I == 1) || aVar.width == -1 || (!aVar.W && (aVar.J == 1 || aVar.height == -1))) {
                        if (i4 == 0) {
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -2);
                            z = true;
                        } else if (i4 == -1) {
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -1);
                            z = false;
                        } else {
                            z = i4 == -2;
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, i4);
                        }
                        if (i5 == 0) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -2);
                            z2 = true;
                        } else if (i5 == -1) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -1);
                            z2 = false;
                        } else {
                            z2 = i5 == -2;
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, i5);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        androidx.constraintlayout.solver.f fVar = this.t;
                        if (fVar != null) {
                            fVar.f423a++;
                        }
                        constraintWidget.b(i4 == -2);
                        constraintWidget.c(i5 == -2);
                        i4 = childAt.getMeasuredWidth();
                        i5 = childAt.getMeasuredHeight();
                    } else {
                        z = false;
                        z2 = false;
                    }
                    constraintWidget.h(i4);
                    constraintWidget.i(i5);
                    if (z) {
                        constraintWidget.l(i4);
                    }
                    if (z2) {
                        constraintWidget.m(i5);
                    }
                    if (aVar.X && (baseline = childAt.getBaseline()) != -1) {
                        constraintWidget.n(baseline);
                    }
                }
            }
        }
    }

    private void d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof f) {
                ((f) childAt).b(this);
            }
        }
        int size = this.g.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.g.get(i2).c(this);
            }
        }
    }

    private void b(int i, int i2) {
        long j;
        int i3;
        int i4;
        int i5;
        long j2;
        boolean z;
        int childMeasureSpec;
        boolean z2;
        boolean z3;
        int childMeasureSpec2;
        int i6;
        a aVar;
        int baseline;
        int i7;
        int i8;
        int baseline2;
        ConstraintLayout constraintLayout = this;
        int i9 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            j = 1;
            i3 = 8;
            if (i10 >= childCount) {
                break;
            }
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i7 = paddingTop;
            } else {
                a aVar2 = (a) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = aVar2.al;
                if (aVar2.Y) {
                    i7 = paddingTop;
                } else if (aVar2.Z) {
                    i7 = paddingTop;
                } else {
                    constraintWidget.e(childAt.getVisibility());
                    int i11 = aVar2.width;
                    int i12 = aVar2.height;
                    if (i11 == 0 || i12 == 0) {
                        i7 = paddingTop;
                        constraintWidget.h().e();
                        constraintWidget.i().e();
                    } else {
                        boolean z4 = i11 == -2;
                        int childMeasureSpec3 = getChildMeasureSpec(i, paddingLeft, i11);
                        boolean z5 = i12 == -2;
                        childAt.measure(childMeasureSpec3, getChildMeasureSpec(i9, paddingTop, i12));
                        androidx.constraintlayout.solver.f fVar = constraintLayout.t;
                        if (fVar != null) {
                            i7 = paddingTop;
                            fVar.f423a++;
                            i8 = -2;
                        } else {
                            i7 = paddingTop;
                            i8 = -2;
                        }
                        constraintWidget.b(i11 == i8);
                        constraintWidget.c(i12 == i8);
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        constraintWidget.h(measuredWidth);
                        constraintWidget.i(measuredHeight);
                        if (z4) {
                            constraintWidget.l(measuredWidth);
                        }
                        if (z5) {
                            constraintWidget.m(measuredHeight);
                        }
                        if (aVar2.X && (baseline2 = childAt.getBaseline()) != -1) {
                            constraintWidget.n(baseline2);
                        }
                        if (aVar2.V && aVar2.W) {
                            constraintWidget.h().a(measuredWidth);
                            constraintWidget.i().a(measuredHeight);
                        }
                    }
                }
            }
            i10++;
            paddingTop = i7;
            i9 = i2;
        }
        int i13 = paddingTop;
        constraintLayout.b.N();
        int i14 = 0;
        while (i14 < childCount) {
            View childAt2 = constraintLayout.getChildAt(i14);
            if (childAt2.getVisibility() == i3) {
                i4 = i14;
                i5 = childCount;
                j2 = j;
            } else {
                a aVar3 = (a) childAt2.getLayoutParams();
                ConstraintWidget constraintWidget2 = aVar3.al;
                if (aVar3.Y) {
                    i4 = i14;
                    i5 = childCount;
                    j2 = j;
                } else if (aVar3.Z) {
                    i4 = i14;
                    i5 = childCount;
                    j2 = j;
                } else {
                    constraintWidget2.e(childAt2.getVisibility());
                    int i15 = aVar3.width;
                    int i16 = aVar3.height;
                    if (i15 == 0 || i16 == 0) {
                        i a2 = constraintWidget2.a(ConstraintAnchor.Type.LEFT).a();
                        i a3 = constraintWidget2.a(ConstraintAnchor.Type.RIGHT).a();
                        boolean z6 = (constraintWidget2.a(ConstraintAnchor.Type.LEFT).g() == null || constraintWidget2.a(ConstraintAnchor.Type.RIGHT).g() == null) ? false : true;
                        i a4 = constraintWidget2.a(ConstraintAnchor.Type.TOP).a();
                        i a5 = constraintWidget2.a(ConstraintAnchor.Type.BOTTOM).a();
                        i5 = childCount;
                        boolean z7 = (constraintWidget2.a(ConstraintAnchor.Type.TOP).g() == null || constraintWidget2.a(ConstraintAnchor.Type.BOTTOM).g() == null) ? false : true;
                        if (i15 == 0 && i16 == 0 && z6 && z7) {
                            i4 = i14;
                            j2 = 1;
                        } else {
                            i4 = i14;
                            boolean z8 = constraintLayout.b.F() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            boolean z9 = constraintLayout.b.G() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            if (!z8) {
                                constraintWidget2.h().e();
                            }
                            if (!z9) {
                                constraintWidget2.i().e();
                            }
                            if (i15 == 0) {
                                if (z8 && constraintWidget2.d() && z6 && a2.g() && a3.g()) {
                                    i15 = (int) (a3.d() - a2.d());
                                    constraintWidget2.h().a(i15);
                                    childMeasureSpec = getChildMeasureSpec(i, paddingLeft, i15);
                                    z = false;
                                } else {
                                    childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -2);
                                    z = true;
                                    z8 = false;
                                }
                            } else if (i15 == -1) {
                                childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -1);
                                z = false;
                            } else {
                                z = i15 == -2;
                                childMeasureSpec = getChildMeasureSpec(i, paddingLeft, i15);
                            }
                            if (i16 == 0) {
                                if (z9 && constraintWidget2.e() && z7 && a4.g() && a5.g()) {
                                    i16 = (int) (a5.d() - a4.d());
                                    constraintWidget2.i().a(i16);
                                    z3 = z9;
                                    childMeasureSpec2 = getChildMeasureSpec(i2, i13, i16);
                                    z2 = false;
                                } else {
                                    childMeasureSpec2 = getChildMeasureSpec(i2, i13, -2);
                                    z2 = true;
                                    z3 = false;
                                }
                            } else if (i16 == -1) {
                                z3 = z9;
                                childMeasureSpec2 = getChildMeasureSpec(i2, i13, -1);
                                z2 = false;
                            } else {
                                z2 = i16 == -2;
                                z3 = z9;
                                childMeasureSpec2 = getChildMeasureSpec(i2, i13, i16);
                            }
                            childAt2.measure(childMeasureSpec, childMeasureSpec2);
                            constraintLayout = this;
                            androidx.constraintlayout.solver.f fVar2 = constraintLayout.t;
                            if (fVar2 != null) {
                                j2 = 1;
                                fVar2.f423a++;
                                i6 = -2;
                            } else {
                                j2 = 1;
                                i6 = -2;
                            }
                            constraintWidget2.b(i15 == i6);
                            constraintWidget2.c(i16 == i6);
                            int measuredWidth2 = childAt2.getMeasuredWidth();
                            int measuredHeight2 = childAt2.getMeasuredHeight();
                            constraintWidget2.h(measuredWidth2);
                            constraintWidget2.i(measuredHeight2);
                            if (z) {
                                constraintWidget2.l(measuredWidth2);
                            }
                            if (z2) {
                                constraintWidget2.m(measuredHeight2);
                            }
                            if (z8) {
                                constraintWidget2.h().a(measuredWidth2);
                            } else {
                                constraintWidget2.h().c();
                            }
                            if (z3) {
                                constraintWidget2.i().a(measuredHeight2);
                                aVar = aVar3;
                            } else {
                                constraintWidget2.i().c();
                                aVar = aVar3;
                            }
                            if (aVar.X && (baseline = childAt2.getBaseline()) != -1) {
                                constraintWidget2.n(baseline);
                            }
                        }
                    } else {
                        i4 = i14;
                        i5 = childCount;
                        j2 = j;
                    }
                }
            }
            i14 = i4 + 1;
            childCount = i5;
            j = j2;
            i3 = 8;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int baseline;
        int i9;
        int i10 = i;
        System.currentTimeMillis();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.r != -1) {
            int i11 = this.s;
        }
        if (mode == 1073741824 && mode2 == 1073741824 && size == this.r) {
            int i12 = this.s;
        }
        boolean z3 = mode == this.e && mode2 == this.f;
        if (z3 && size == this.c) {
            int i13 = this.d;
        }
        if (z3 && mode == Integer.MIN_VALUE && mode2 == 1073741824 && size >= this.r) {
            int i14 = this.s;
        }
        if (z3 && mode == 1073741824 && mode2 == Integer.MIN_VALUE && size == this.r) {
            int i15 = this.s;
        }
        this.e = mode;
        this.f = mode2;
        this.c = size;
        this.d = size2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.b.f(paddingLeft);
        this.b.g(paddingTop);
        this.b.c(this.k);
        this.b.d(this.l);
        if (Build.VERSION.SDK_INT >= 17) {
            this.b.a(getLayoutDirection() == 1);
        }
        c(i, i2);
        int o = this.b.o();
        int q = this.b.q();
        if (this.m) {
            this.m = false;
            b();
        }
        boolean z4 = (this.n & 8) == 8;
        if (z4) {
            this.b.M();
            this.b.e(o, q);
            b(i, i2);
        } else {
            a(i, i2);
        }
        d();
        if (getChildCount() > 0) {
            a("First pass");
        }
        int size3 = this.h.size();
        int paddingBottom = paddingTop + getPaddingBottom();
        int paddingRight = paddingLeft + getPaddingRight();
        if (size3 > 0) {
            boolean z5 = this.b.F() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z6 = this.b.G() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int max = Math.max(this.b.o(), this.i);
            int max2 = Math.max(this.b.q(), this.j);
            int i16 = max;
            int i17 = 0;
            boolean z7 = false;
            int i18 = 0;
            while (i17 < size3) {
                ConstraintWidget constraintWidget = this.h.get(i17);
                View view = (View) constraintWidget.B();
                if (view == null) {
                    i6 = o;
                    i5 = q;
                    i4 = size3;
                    i7 = max2;
                    i8 = i18;
                } else {
                    i4 = size3;
                    a aVar = (a) view.getLayoutParams();
                    i5 = q;
                    if (aVar.Z) {
                        i6 = o;
                        i7 = max2;
                        i8 = i18;
                    } else if (aVar.Y) {
                        i6 = o;
                        i7 = max2;
                        i8 = i18;
                    } else {
                        i6 = o;
                        if (view.getVisibility() == 8) {
                            i7 = max2;
                            i8 = i18;
                        } else if (z4 && constraintWidget.h().g() && constraintWidget.i().g()) {
                            i7 = max2;
                            i8 = i18;
                        } else {
                            if (aVar.width == -2 && aVar.V) {
                                makeMeasureSpec = getChildMeasureSpec(i10, paddingRight, aVar.width);
                            } else {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.o(), 1073741824);
                            }
                            if (aVar.height == -2 && aVar.W) {
                                makeMeasureSpec2 = getChildMeasureSpec(i2, paddingBottom, aVar.height);
                            } else {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.q(), 1073741824);
                            }
                            view.measure(makeMeasureSpec, makeMeasureSpec2);
                            androidx.constraintlayout.solver.f fVar = this.t;
                            if (fVar != null) {
                                fVar.b++;
                            }
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            if (measuredWidth != constraintWidget.o()) {
                                constraintWidget.h(measuredWidth);
                                if (z4) {
                                    constraintWidget.h().a(measuredWidth);
                                }
                                if (z5 && constraintWidget.w() > i16) {
                                    i16 = Math.max(i16, constraintWidget.w() + constraintWidget.a(ConstraintAnchor.Type.RIGHT).e());
                                }
                                z7 = true;
                            }
                            if (measuredHeight != constraintWidget.q()) {
                                constraintWidget.i(measuredHeight);
                                if (z4) {
                                    constraintWidget.i().a(measuredHeight);
                                }
                                if (z6) {
                                    i9 = max2;
                                    if (constraintWidget.x() > i9) {
                                        max2 = Math.max(i9, constraintWidget.x() + constraintWidget.a(ConstraintAnchor.Type.BOTTOM).e());
                                        z7 = true;
                                    }
                                } else {
                                    i9 = max2;
                                }
                                max2 = i9;
                                z7 = true;
                            }
                            if (aVar.X && (baseline = view.getBaseline()) != -1 && baseline != constraintWidget.A()) {
                                constraintWidget.n(baseline);
                                z7 = true;
                            }
                            if (Build.VERSION.SDK_INT >= 11) {
                                i18 = combineMeasuredStates(i18, view.getMeasuredState());
                            }
                            i17++;
                            q = i5;
                            size3 = i4;
                            o = i6;
                            i10 = i;
                        }
                    }
                }
                max2 = i7;
                i18 = i8;
                i17++;
                q = i5;
                size3 = i4;
                o = i6;
                i10 = i;
            }
            int i19 = o;
            int i20 = q;
            int i21 = size3;
            int i22 = max2;
            i3 = i18;
            if (z7) {
                this.b.h(i19);
                this.b.i(i20);
                if (z4) {
                    this.b.N();
                }
                a("2nd pass");
                if (this.b.o() < i16) {
                    this.b.h(i16);
                    z = true;
                } else {
                    z = false;
                }
                if (this.b.q() < i22) {
                    this.b.i(i22);
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (z2) {
                    a("3rd pass");
                }
            }
            for (int i23 = 0; i23 < i21; i23++) {
                ConstraintWidget constraintWidget2 = this.h.get(i23);
                View view2 = (View) constraintWidget2.B();
                if (view2 != null && ((view2.getMeasuredWidth() != constraintWidget2.o() || view2.getMeasuredHeight() != constraintWidget2.q()) && constraintWidget2.k() != 8)) {
                    view2.measure(View.MeasureSpec.makeMeasureSpec(constraintWidget2.o(), 1073741824), View.MeasureSpec.makeMeasureSpec(constraintWidget2.q(), 1073741824));
                    androidx.constraintlayout.solver.f fVar2 = this.t;
                    if (fVar2 != null) {
                        fVar2.b++;
                    }
                }
            }
        } else {
            i3 = 0;
        }
        int o2 = this.b.o() + paddingRight;
        int q2 = this.b.q() + paddingBottom;
        if (Build.VERSION.SDK_INT >= 11) {
            int resolveSizeAndState = resolveSizeAndState(o2, i, i3);
            int resolveSizeAndState2 = resolveSizeAndState(q2, i2, i3 << 16) & 16777215;
            int min = Math.min(this.k, resolveSizeAndState & 16777215);
            int min2 = Math.min(this.l, resolveSizeAndState2);
            if (this.b.I()) {
                min |= SpecialCallActivity.FLAG_HARDWARE_ACCELERATED;
            }
            if (this.b.J()) {
                min2 |= SpecialCallActivity.FLAG_HARDWARE_ACCELERATED;
            }
            setMeasuredDimension(min, min2);
            this.r = min;
            this.s = min2;
            return;
        }
        setMeasuredDimension(o2, q2);
        this.r = o2;
        this.s = q2;
    }

    private void c(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode == Integer.MIN_VALUE) {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        } else if (mode == 0) {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            size = 0;
        } else {
            size = mode != 1073741824 ? 0 : Math.min(this.k, size) - paddingLeft;
        }
        if (mode2 == Integer.MIN_VALUE) {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        } else if (mode2 == 0) {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            size2 = 0;
        } else {
            size2 = mode2 != 1073741824 ? 0 : Math.min(this.l, size2) - paddingTop;
        }
        this.b.j(0);
        this.b.k(0);
        this.b.a(dimensionBehaviour);
        this.b.h(size);
        this.b.b(dimensionBehaviour2);
        this.b.i(size2);
        this.b.j((this.i - getPaddingLeft()) - getPaddingRight());
        this.b.k((this.j - getPaddingTop()) - getPaddingBottom());
    }

    protected void a(String str) {
        this.b.L();
        androidx.constraintlayout.solver.f fVar = this.t;
        if (fVar != null) {
            fVar.c++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = aVar.al;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || isInEditMode) && !aVar.aa) {
                int s = constraintWidget.s();
                int t = constraintWidget.t();
                int o = constraintWidget.o() + s;
                int q = constraintWidget.q() + t;
                childAt.layout(s, t, o, q);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(s, t, o, q);
                }
            }
        }
        int size = this.g.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.g.get(i6).b(this);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.b.a(i);
    }

    public int getOptimizationLevel() {
        return this.b.H();
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void setConstraintSet(c cVar) {
        this.o = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i2 = (int) ((parseInt / 1080.0f) * width);
                        int i3 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i2;
                        float f2 = i3;
                        float f3 = i2 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i3 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        boolean V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;

        /* renamed from: a, reason: collision with root package name */
        public int f441a;
        boolean aa;
        int ab;
        int ac;
        int ad;
        int ae;
        int af;
        int ag;
        float ah;
        int ai;
        int aj;
        float ak;
        ConstraintWidget al;
        public boolean am;
        public int b;
        public float c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public float o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0039a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f442a = new SparseIntArray();

            static {
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f442a.append(a.b.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f442a.append(a.b.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f442a.append(a.b.ConstraintLayout_Layout_android_orientation, 1);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f442a.append(a.b.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f442a.append(a.b.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f442a.append(a.b.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f442a.append(a.b.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f442a.append(a.b.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f442a.append(a.b.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f442a.append(a.b.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            this.f441a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = -1;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = 0.5f;
            this.al = new ConstraintWidget();
            this.am = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (C0039a.f442a.get(index)) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        this.m = obtainStyledAttributes.getResourceId(index, this.m);
                        if (this.m == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        this.o = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        float f = this.o;
                        if (f < 0.0f) {
                            this.o = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f441a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f441a);
                        break;
                    case 6:
                        this.b = obtainStyledAttributes.getDimensionPixelOffset(index, this.b);
                        break;
                    case 7:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 8:
                        this.d = obtainStyledAttributes.getResourceId(index, this.d);
                        if (this.d == -1) {
                            this.d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        this.e = obtainStyledAttributes.getResourceId(index, this.e);
                        if (this.e == -1) {
                            this.e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        this.f = obtainStyledAttributes.getResourceId(index, this.f);
                        if (this.f == -1) {
                            this.f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        this.g = obtainStyledAttributes.getResourceId(index, this.g);
                        if (this.g == -1) {
                            this.g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.h = obtainStyledAttributes.getResourceId(index, this.h);
                        if (this.h == -1) {
                            this.h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        this.i = obtainStyledAttributes.getResourceId(index, this.i);
                        if (this.i == -1) {
                            this.i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        this.j = obtainStyledAttributes.getResourceId(index, this.j);
                        if (this.j == -1) {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        this.k = obtainStyledAttributes.getResourceId(index, this.k);
                        if (this.k == -1) {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        this.l = obtainStyledAttributes.getResourceId(index, this.l);
                        if (this.l == -1) {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        this.p = obtainStyledAttributes.getResourceId(index, this.p);
                        if (this.p == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        this.q = obtainStyledAttributes.getResourceId(index, this.q);
                        if (this.q == -1) {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        this.r = obtainStyledAttributes.getResourceId(index, this.r);
                        if (this.r == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        this.s = obtainStyledAttributes.getResourceId(index, this.s);
                        if (this.s == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        this.I = obtainStyledAttributes.getInt(index, 0);
                        if (this.I == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        this.J = obtainStyledAttributes.getInt(index, 0);
                        if (this.J == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        break;
                    case 44:
                        this.B = obtainStyledAttributes.getString(index);
                        this.C = Float.NaN;
                        this.D = -1;
                        String str = this.B;
                        if (str != null) {
                            int length = str.length();
                            int indexOf = this.B.indexOf(44);
                            if (indexOf <= 0 || indexOf >= length - 1) {
                                i = 0;
                            } else {
                                String substring = this.B.substring(0, indexOf);
                                if (substring.equalsIgnoreCase("W")) {
                                    this.D = 0;
                                } else if (substring.equalsIgnoreCase("H")) {
                                    this.D = 1;
                                }
                                i = indexOf + 1;
                            }
                            int indexOf2 = this.B.indexOf(58);
                            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                String substring2 = this.B.substring(i, indexOf2);
                                String substring3 = this.B.substring(indexOf2 + 1);
                                if (substring2.length() > 0 && substring3.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring2);
                                        float parseFloat2 = Float.parseFloat(substring3);
                                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                            if (this.D == 1) {
                                                this.C = Math.abs(parseFloat2 / parseFloat);
                                                break;
                                            } else {
                                                this.C = Math.abs(parseFloat / parseFloat2);
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                        break;
                                    }
                                }
                            } else {
                                String substring4 = this.B.substring(i);
                                if (substring4.length() > 0) {
                                    this.C = Float.parseFloat(substring4);
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                        break;
                    case 45:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 46:
                        this.F = obtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 47:
                        this.G = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.H = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                        break;
                    case 50:
                        this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            if (this.width == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            if (this.height == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.V = false;
                if (this.width == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.W = false;
                if (this.height == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.c == -1.0f && this.f441a == -1 && this.b == -1) {
                return;
            }
            this.Y = true;
            this.V = true;
            this.W = true;
            if (!(this.al instanceof androidx.constraintlayout.solver.widgets.e)) {
                this.al = new androidx.constraintlayout.solver.widgets.e();
            }
            ((androidx.constraintlayout.solver.widgets.e) this.al).a(this.S);
        }

        public a(int i, int i2) {
            super(i, i2);
            this.f441a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = -1;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = 0.5f;
            this.al = new ConstraintWidget();
            this.am = false;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f441a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = -1;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = 0.5f;
            this.al = new ConstraintWidget();
            this.am = false;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            int i2 = this.leftMargin;
            int i3 = this.rightMargin;
            super.resolveLayoutDirection(i);
            this.ad = -1;
            this.ae = -1;
            this.ab = -1;
            this.ac = -1;
            this.af = -1;
            this.ag = -1;
            this.af = this.t;
            this.ag = this.v;
            this.ah = this.z;
            this.ai = this.f441a;
            this.aj = this.b;
            this.ak = this.c;
            boolean z = false;
            if (1 == getLayoutDirection()) {
                int i4 = this.p;
                if (i4 != -1) {
                    this.ad = i4;
                    z = true;
                } else {
                    int i5 = this.q;
                    if (i5 != -1) {
                        this.ae = i5;
                        z = true;
                    }
                }
                int i6 = this.r;
                if (i6 != -1) {
                    this.ac = i6;
                    z = true;
                }
                int i7 = this.s;
                if (i7 != -1) {
                    this.ab = i7;
                    z = true;
                }
                int i8 = this.x;
                if (i8 != -1) {
                    this.ag = i8;
                }
                int i9 = this.y;
                if (i9 != -1) {
                    this.af = i9;
                }
                if (z) {
                    this.ah = 1.0f - this.z;
                }
                if (this.Y && this.S == 1) {
                    float f = this.c;
                    if (f != -1.0f) {
                        this.ak = 1.0f - f;
                        this.ai = -1;
                        this.aj = -1;
                    } else {
                        int i10 = this.f441a;
                        if (i10 != -1) {
                            this.aj = i10;
                            this.ai = -1;
                            this.ak = -1.0f;
                        } else {
                            int i11 = this.b;
                            if (i11 != -1) {
                                this.ai = i11;
                                this.aj = -1;
                                this.ak = -1.0f;
                            }
                        }
                    }
                }
            } else {
                int i12 = this.p;
                if (i12 != -1) {
                    this.ac = i12;
                }
                int i13 = this.q;
                if (i13 != -1) {
                    this.ab = i13;
                }
                int i14 = this.r;
                if (i14 != -1) {
                    this.ad = i14;
                }
                int i15 = this.s;
                if (i15 != -1) {
                    this.ae = i15;
                }
                int i16 = this.x;
                if (i16 != -1) {
                    this.af = i16;
                }
                int i17 = this.y;
                if (i17 != -1) {
                    this.ag = i17;
                }
            }
            if (this.r == -1 && this.s == -1 && this.q == -1 && this.p == -1) {
                int i18 = this.f;
                if (i18 != -1) {
                    this.ad = i18;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                } else {
                    int i19 = this.g;
                    if (i19 != -1) {
                        this.ae = i19;
                        if (this.rightMargin <= 0 && i3 > 0) {
                            this.rightMargin = i3;
                        }
                    }
                }
                int i20 = this.d;
                if (i20 != -1) {
                    this.ab = i20;
                    if (this.leftMargin > 0 || i2 <= 0) {
                        return;
                    }
                    this.leftMargin = i2;
                    return;
                }
                int i21 = this.e;
                if (i21 != -1) {
                    this.ac = i21;
                    if (this.leftMargin > 0 || i2 <= 0) {
                        return;
                    }
                    this.leftMargin = i2;
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.m = true;
        this.r = -1;
        this.s = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
    }
}
