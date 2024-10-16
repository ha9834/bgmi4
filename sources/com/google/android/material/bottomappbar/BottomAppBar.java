package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.v;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.i.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {

    /* renamed from: a, reason: collision with root package name */
    AnimatorListenerAdapter f5231a;
    private final int b;
    private final c c;
    private final a d;
    private Animator e;
    private Animator f;
    private Animator g;
    private int h;
    private boolean i;
    private boolean j;

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public int getFabAlignmentMode() {
        return this.h;
    }

    public void setFabAlignmentMode(int i) {
        a(i);
        a(i, this.j);
        this.h = i;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a(this.c, colorStateList);
    }

    public ColorStateList getBackgroundTint() {
        return this.c.a();
    }

    public float getFabCradleMargin() {
        return this.d.d();
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            this.d.d(f);
            this.c.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.d.e();
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            this.d.e(f);
            this.c.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return this.d.b();
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            this.d.b(f);
            this.c.invalidateSelf();
        }
    }

    public boolean getHideOnScroll() {
        return this.i;
    }

    public void setHideOnScroll(boolean z) {
        this.i = z;
    }

    void setFabDiameter(int i) {
        float f = i;
        if (f != this.d.c()) {
            this.d.c(f);
            this.c.invalidateSelf();
        }
    }

    private void a(int i) {
        if (this.h == i || !v.x(this)) {
            return;
        }
        Animator animator = this.f;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        a(i, arrayList);
        b(i, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f = animatorSet;
        this.f.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                BottomAppBar.this.f = null;
            }
        });
        this.f.start();
    }

    private void a(int i, List<Animator> list) {
        if (this.j) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.d.a(), b(i));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BottomAppBar.this.d.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    BottomAppBar.this.c.invalidateSelf();
                }
            });
            ofFloat.setDuration(300L);
            list.add(ofFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton a() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).d(this)) {
            if (view instanceof FloatingActionButton) {
                return (FloatingActionButton) view;
            }
        }
        return null;
    }

    private boolean b() {
        FloatingActionButton a2 = a();
        return a2 != null && a2.b();
    }

    private void b(int i, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a(), "translationX", b(i));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void a(int i, boolean z) {
        if (v.x(this)) {
            Animator animator = this.g;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!b()) {
                i = 0;
                z = false;
            }
            a(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.g = animatorSet;
            this.g.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    BottomAppBar.this.g = null;
                }
            });
            this.g.start();
        }
    }

    private void a(final int i, final boolean z, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.j && (!z || !b())) || (this.h != 1 && i != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        } else {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4

                /* renamed from: a, reason: collision with root package name */
                public boolean f5235a;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.f5235a = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.f5235a) {
                        return;
                    }
                    BottomAppBar.this.a(actionMenuView, i, z);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        }
    }

    private float a(boolean z) {
        FloatingActionButton a2 = a();
        if (a2 == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        a2.a(rect);
        float height = rect.height();
        if (height == 0.0f) {
            height = a2.getMeasuredHeight();
        }
        float height2 = a2.getHeight() - rect.bottom;
        float height3 = a2.getHeight() - rect.height();
        float f = (-getCradleVerticalOffset()) + (height / 2.0f) + height2;
        float paddingBottom = height3 - a2.getPaddingBottom();
        float f2 = -getMeasuredHeight();
        if (z) {
            paddingBottom = f;
        }
        return f2 + paddingBottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return a(this.j);
    }

    private int b(int i) {
        boolean z = v.f(this) == 1;
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - this.b) * (z ? -1 : 1);
        }
        return 0;
    }

    private float getFabTranslationX() {
        return b(this.h);
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = v.f(this) == 1;
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.b) && (((Toolbar.b) childAt.getLayoutParams()).f175a & 8388615) == 8388611) {
                i2 = Math.max(i2, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i == 1 && z) ? i2 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    private void c() {
        Animator animator = this.e;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.g;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.f;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        Animator animator;
        Animator animator2;
        Animator animator3 = this.e;
        return (animator3 != null && animator3.isRunning()) || ((animator = this.g) != null && animator.isRunning()) || ((animator2 = this.f) != null && animator2.isRunning());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.d.a(getFabTranslationX());
        FloatingActionButton a2 = a();
        this.c.a((this.j && b()) ? 1.0f : 0.0f);
        if (a2 != null) {
            a2.setTranslationY(getFabTranslationY());
            a2.setTranslationX(getFabTranslationX());
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!b()) {
                a(actionMenuView, 0, false);
            } else {
                a(actionMenuView, this.h, this.j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FloatingActionButton floatingActionButton) {
        b(floatingActionButton);
        floatingActionButton.c(this.f5231a);
        floatingActionButton.a(this.f5231a);
    }

    private void b(FloatingActionButton floatingActionButton) {
        floatingActionButton.d(this.f5231a);
        floatingActionButton.b(this.f5231a);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a
    public CoordinatorLayout.b<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f5236a;

        public Behavior() {
            this.f5236a = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5236a = new Rect();
        }

        private boolean a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).d = 17;
            bottomAppBar.a(floatingActionButton);
            return true;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            FloatingActionButton a2 = bottomAppBar.a();
            if (a2 != null) {
                a(a2, bottomAppBar);
                a2.b(this.f5236a);
                bottomAppBar.setFabDiameter(this.f5236a.height());
            }
            if (!bottomAppBar.d()) {
                bottomAppBar.e();
            }
            coordinatorLayout.b(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void a(BottomAppBar bottomAppBar) {
            super.a((Behavior) bottomAppBar);
            FloatingActionButton a2 = bottomAppBar.a();
            if (a2 != null) {
                a2.clearAnimation();
                a2.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(com.google.android.material.a.a.d).setDuration(225L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void b(BottomAppBar bottomAppBar) {
            super.b((Behavior) bottomAppBar);
            FloatingActionButton a2 = bottomAppBar.a();
            if (a2 != null) {
                a2.a(this.f5236a);
                float measuredHeight = a2.getMeasuredHeight() - this.f5236a.height();
                a2.clearAnimation();
                a2.animate().translationY((-a2.getPaddingBottom()) + measuredHeight).setInterpolator(com.google.android.material.a.a.c).setDuration(175L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5237a = this.h;
        savedState.b = this.j;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.h = savedState.f5237a;
        this.j = savedState.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.SavedState.1
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
        int f5237a;
        boolean b;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5237a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5237a);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }
}
