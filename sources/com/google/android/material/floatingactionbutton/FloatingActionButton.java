package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.n;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.u;
import androidx.core.f.v;
import androidx.core.widget.l;
import com.google.android.material.a;
import com.google.android.material.a.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.d.c;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.m;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;

@CoordinatorLayout.c(a = Behavior.class)
/* loaded from: classes2.dex */
public class FloatingActionButton extends m implements u, l, com.google.android.material.d.a {

    /* renamed from: a, reason: collision with root package name */
    boolean f5262a;
    final Rect b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private ColorStateList e;
    private PorterDuff.Mode f;
    private ColorStateList g;
    private int h;
    private int i;
    private int j;
    private int k;
    private final Rect l;
    private final n m;
    private final c n;
    private com.google.android.material.floatingactionbutton.a o;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.j = (sizeDimension - this.k) / 2;
        getImpl().j();
        int min = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        setMeasuredDimension(this.b.left + min + this.b.right, min + this.b.top + this.b.bottom);
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.g;
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            getImpl().b(this.g);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.c != colorStateList) {
            this.c = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.d;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            getImpl().a(mode);
        }
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.f.u
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.f.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            c();
        }
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        return this.e;
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            c();
        }
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f;
    }

    private void c() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.e;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.a.f(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(j.a(colorForState, mode));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.m.a(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().d();
    }

    void a(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    void b(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        getImpl().c(animatorListener);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    @Override // com.google.android.material.d.b
    public boolean a() {
        return this.n.a();
    }

    public void setExpandedComponentIdHint(int i) {
        this.n.a(i);
    }

    public int getExpandedComponentIdHint() {
        return this.n.c();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f5262a != z) {
            this.f5262a = z;
            getImpl().i();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f5262a;
    }

    public void setSize(int i) {
        this.i = 0;
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.h;
    }

    private a.d a(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a.d() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButton.1
            @Override // com.google.android.material.floatingactionbutton.a.d
            public void a() {
                aVar.a(FloatingActionButton.this);
            }

            @Override // com.google.android.material.floatingactionbutton.a.d
            public void b() {
                aVar.b(FloatingActionButton.this);
            }
        };
    }

    public boolean b() {
        return getImpl().o();
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        this.i = i;
    }

    public int getCustomSize() {
        return this.i;
    }

    int getSizeDimension() {
        return a(this.h);
    }

    private int a(int i) {
        int i2 = this.i;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            if (i == 1) {
                return resources.getDimensionPixelSize(a.d.design_fab_size_mini);
            }
            return resources.getDimensionPixelSize(a.d.design_fab_size_normal);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        }
        return a(0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().k();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().l();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        extendableSavedState.f5334a.put("expandableWidgetHelper", this.n.b());
        return extendableSavedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.n.a(extendableSavedState.f5334a.get("expandableWidgetHelper"));
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (!v.x(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    private void c(Rect rect) {
        rect.left += this.b.left;
        rect.top += this.b.top;
        rect.right -= this.b.right;
        rect.bottom -= this.b.bottom;
    }

    public Drawable getContentBackground() {
        return getImpl().h();
    }

    private static int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && a(this.l) && !this.l.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
            super.onAttachedToLayoutParams(eVar);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes2.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.b<T> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f5264a;
        private a b;
        private boolean c;

        public BaseBehavior() {
            this.c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.FloatingActionButton_Behavior_Layout);
            this.c = obtainStyledAttributes.getBoolean(a.k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
            if (eVar.h == 0) {
                eVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, floatingActionButton);
            return false;
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.c && ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).a() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f5264a == null) {
                this.f5264a = new Rect();
            }
            Rect rect = this.f5264a;
            com.google.android.material.internal.c.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.b, false);
                return true;
            }
            floatingActionButton.a(this.b, false);
            return true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.b(this.b, false);
                return true;
            }
            floatingActionButton.a(this.b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> c = coordinatorLayout.c(floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = c.get(i2);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.b(floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.b;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.b;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - eVar.rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= eVar.leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - eVar.bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= eVar.topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                v.e(floatingActionButton, i2);
            }
            if (i != 0) {
                v.f(floatingActionButton, i);
            }
        }
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public void setCompatElevation(float f) {
        getImpl().a(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().b();
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().b(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().c();
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().c(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public h getShowMotionSpec() {
        return getImpl().e();
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().a(hVar);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(h.a(getContext(), i));
    }

    public h getHideMotionSpec() {
        return getImpl().f();
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().b(hVar);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(h.a(getContext(), i));
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.o == null) {
            this.o = d();
        }
        return this.o;
    }

    private com.google.android.material.floatingactionbutton.a d() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.google.android.material.floatingactionbutton.b(this, new b());
        }
        return new com.google.android.material.floatingactionbutton.a(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements com.google.android.material.h.b {
        b() {
        }

        @Override // com.google.android.material.h.b
        public float a() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // com.google.android.material.h.b
        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.b.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.j, i2 + FloatingActionButton.this.j, i3 + FloatingActionButton.this.j, i4 + FloatingActionButton.this.j);
        }

        @Override // com.google.android.material.h.b
        public void a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.h.b
        public boolean b() {
            return FloatingActionButton.this.f5262a;
        }
    }
}
