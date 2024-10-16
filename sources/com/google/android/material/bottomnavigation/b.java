package com.google.android.material.bottomnavigation;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.core.e.d;
import androidx.core.f.v;
import androidx.g.o;
import androidx.g.q;
import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes2.dex */
public class b extends ViewGroup implements n {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f5244a = {R.attr.state_checked};
    private static final int[] b = {-16842910};
    private final q c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final View.OnClickListener i;
    private final d.a<a> j;
    private boolean k;
    private int l;
    private a[] m;
    private int n;
    private int o;
    private ColorStateList p;
    private int q;
    private ColorStateList r;
    private final ColorStateList s;
    private int t;
    private int u;
    private Drawable v;
    private int w;
    private int[] x;
    private BottomNavigationPresenter y;
    private g z;

    private boolean a(int i, int i2) {
        if (i == -1) {
            if (i2 > 3) {
                return true;
            }
        } else if (i == 0) {
            return true;
        }
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(g gVar) {
        this.z = gVar;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.z.j().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (a(this.l, size2) && this.k) {
            View childAt = getChildAt(this.o);
            int i3 = this.g;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f, BleSignal.UNKNOWN_TX_POWER), makeMeasureSpec);
                i3 = Math.max(i3, childAt.getMeasuredWidth());
            }
            int i4 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.e * i4), Math.min(i3, this.f));
            int i5 = size - min;
            int min2 = Math.min(i5 / (i4 == 0 ? 1 : i4), this.d);
            int i6 = i5 - (i4 * min2);
            int i7 = 0;
            while (i7 < childCount) {
                if (getChildAt(i7).getVisibility() != 8) {
                    this.x[i7] = i7 == this.o ? min : min2;
                    if (i6 > 0) {
                        int[] iArr = this.x;
                        iArr[i7] = iArr[i7] + 1;
                        i6--;
                    }
                } else {
                    this.x[i7] = 0;
                }
                i7++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f);
            int i8 = size - (size2 * min3);
            for (int i9 = 0; i9 < childCount; i9++) {
                if (getChildAt(i9).getVisibility() != 8) {
                    int[] iArr2 = this.x;
                    iArr2[i9] = min3;
                    if (i8 > 0) {
                        iArr2[i9] = iArr2[i9] + 1;
                        i8--;
                    }
                } else {
                    this.x[i9] = 0;
                }
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.x[i11], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i10 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i10, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0), View.resolveSizeAndState(this.h, makeMeasureSpec, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (v.f(this) == 1) {
                    int i9 = i5 - i7;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.p = colorStateList;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.p;
    }

    public void setItemIconSize(int i) {
        this.q = i;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.setIconSize(i);
            }
        }
    }

    public int getItemIconSize() {
        return this.q;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.r = colorStateList;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.r;
    }

    public void setItemTextAppearanceInactive(int i) {
        this.t = i;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.setTextAppearanceInactive(i);
                ColorStateList colorStateList = this.r;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public int getItemTextAppearanceInactive() {
        return this.t;
    }

    public void setItemTextAppearanceActive(int i) {
        this.u = i;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.setTextAppearanceActive(i);
                ColorStateList colorStateList = this.r;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public int getItemTextAppearanceActive() {
        return this.u;
    }

    public void setItemBackgroundRes(int i) {
        this.w = i;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.setItemBackground(i);
            }
        }
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.w;
    }

    public void setItemBackground(Drawable drawable) {
        this.v = drawable;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.setItemBackground(drawable);
            }
        }
    }

    public Drawable getItemBackground() {
        a[] aVarArr = this.m;
        if (aVarArr != null && aVarArr.length > 0) {
            return aVarArr[0].getBackground();
        }
        return this.v;
    }

    public void setLabelVisibilityMode(int i) {
        this.l = i;
    }

    public int getLabelVisibilityMode() {
        return this.l;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.k = z;
    }

    public boolean a() {
        return this.k;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.y = bottomNavigationPresenter;
    }

    public void b() {
        removeAllViews();
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                if (aVar != null) {
                    this.j.a(aVar);
                }
            }
        }
        if (this.z.size() == 0) {
            this.n = 0;
            this.o = 0;
            this.m = null;
            return;
        }
        this.m = new a[this.z.size()];
        boolean a2 = a(this.l, this.z.j().size());
        for (int i = 0; i < this.z.size(); i++) {
            this.y.b(true);
            this.z.getItem(i).setCheckable(true);
            this.y.b(false);
            a newItem = getNewItem();
            this.m[i] = newItem;
            newItem.setIconTintList(this.p);
            newItem.setIconSize(this.q);
            newItem.setTextColor(this.s);
            newItem.setTextAppearanceInactive(this.t);
            newItem.setTextAppearanceActive(this.u);
            newItem.setTextColor(this.r);
            Drawable drawable = this.v;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.w);
            }
            newItem.setShifting(a2);
            newItem.setLabelVisibilityMode(this.l);
            newItem.a((i) this.z.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.i);
            addView(newItem);
        }
        this.o = Math.min(this.z.size() - 1, this.o);
        this.z.getItem(this.o).setChecked(true);
    }

    public void c() {
        g gVar = this.z;
        if (gVar == null || this.m == null) {
            return;
        }
        int size = gVar.size();
        if (size != this.m.length) {
            b();
            return;
        }
        int i = this.n;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.z.getItem(i2);
            if (item.isChecked()) {
                this.n = item.getItemId();
                this.o = i2;
            }
        }
        if (i != this.n) {
            o.a(this, this.c);
        }
        boolean a2 = a(this.l, this.z.j().size());
        for (int i3 = 0; i3 < size; i3++) {
            this.y.b(true);
            this.m[i3].setLabelVisibilityMode(this.l);
            this.m[i3].setShifting(a2);
            this.m[i3].a((i) this.z.getItem(i3), 0);
            this.y.b(false);
        }
    }

    private a getNewItem() {
        a a2 = this.j.a();
        return a2 == null ? new a(getContext()) : a2;
    }

    public int getSelectedItemId() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.z.getItem(i2);
            if (i == item.getItemId()) {
                this.n = i;
                this.o = i2;
                item.setChecked(true);
                return;
            }
        }
    }
}
