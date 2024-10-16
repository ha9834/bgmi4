package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ag;
import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes.dex */
public class ActionMenuView extends ag implements g.b, androidx.appcompat.view.menu.n {

    /* renamed from: a, reason: collision with root package name */
    g.a f264a;
    e b;
    private androidx.appcompat.view.menu.g c;
    private Context d;
    private int e;
    private boolean f;
    private ActionMenuPresenter g;
    private m.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* loaded from: classes.dex */
    public interface a {
        boolean c();

        boolean d();
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean a(MenuItem menuItem);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (f * 4.0f);
        this.d = context;
        this.e = 0;
    }

    public void setPopupTheme(int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.e;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.g = actionMenuPresenter;
        this.g.a(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(false);
            if (this.g.j()) {
                this.g.g();
                this.g.e();
            }
        }
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ag, android.view.View
    public void onMeasure(int i, int i2) {
        androidx.appcompat.view.menu.g gVar;
        boolean z = this.i;
        this.i = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.i) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.i && (gVar = this.c) != null && size != this.j) {
            this.j = size;
            gVar.b(true);
        }
        int childCount = getChildCount();
        if (this.i && childCount > 0) {
            a(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            cVar.rightMargin = 0;
            cVar.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x0240 A[ADDED_TO_REGION, LOOP:5: B:146:0x0240->B:151:0x025f, LOOP_START, PHI: r13
      0x0240: PHI (r13v4 int) = (r13v3 int), (r13v5 int) binds: [B:145:0x023e, B:151:0x025f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0269  */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(int r30, int r31) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.a(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.b();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, BleSignal.UNKNOWN_TX_POWER), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        cVar.d = !cVar.f265a && z;
        cVar.b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ag, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int i7;
        if (!this.i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i3 - i;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = ba.a(this);
        int i10 = paddingRight;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f265a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (a(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i7 = getPaddingLeft() + cVar.leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i14 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i14, width, measuredHeight + i14);
                    i10 -= measuredWidth;
                    i11 = 1;
                } else {
                    i10 -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    a(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i9 / 2) - (measuredWidth2 / 2);
            int i16 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        if (i17 > 0) {
            i6 = i10 / i17;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int max = Math.max(i5, i6);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f265a) {
                    int i18 = width2 - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
                i5++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f265a) {
                int i20 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + cVar3.rightMargin + max;
            }
            i5++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.d();
    }

    public boolean a() {
        return this.f;
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ag, android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.ag, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ag, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
            if (cVar.h <= 0) {
                cVar.h = 16;
            }
            return cVar;
        }
        return generateDefaultLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ag, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public c c() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f265a = true;
        return generateDefaultLayoutParams;
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(androidx.appcompat.view.menu.i iVar) {
        return this.c.a(iVar, 0);
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(androidx.appcompat.view.menu.g gVar) {
        this.c = gVar;
    }

    public Menu getMenu() {
        if (this.c == null) {
            Context context = getContext();
            this.c = new androidx.appcompat.view.menu.g(context);
            this.c.a(new d());
            this.g = new ActionMenuPresenter(context);
            this.g.b(true);
            ActionMenuPresenter actionMenuPresenter = this.g;
            m.a aVar = this.h;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter.a(aVar);
            this.c.a(this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    public void a(m.a aVar, g.a aVar2) {
        this.h = aVar;
        this.f264a = aVar2;
    }

    public androidx.appcompat.view.menu.g d() {
        return this.c;
    }

    public boolean e() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.e();
    }

    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.g();
    }

    public boolean g() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.j();
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.k();
    }

    public void i() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h();
        }
    }

    protected boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).d();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).c();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.c(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return ActionMenuView.this.b != null && ActionMenuView.this.b.a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
            if (ActionMenuView.this.f264a != null) {
                ActionMenuView.this.f264a.a(gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements m.a {
        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            return false;
        }

        b() {
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ag.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f265a;

        @ViewDebug.ExportedProperty
        public int b;

        @ViewDebug.ExportedProperty
        public int c;

        @ViewDebug.ExportedProperty
        public boolean d;

        @ViewDebug.ExportedProperty
        public boolean e;
        boolean f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f265a = cVar.f265a;
        }

        public c(int i, int i2) {
            super(i, i2);
            this.f265a = false;
        }
    }
}
