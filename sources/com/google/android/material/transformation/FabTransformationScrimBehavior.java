package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.i;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: a, reason: collision with root package name */
    private final i f5353a;
    private final i b;

    public FabTransformationScrimBehavior() {
        this.f5353a = new i(75L, 150L);
        this.b = new i(0L, 150L);
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5353a = new i(75L, 150L);
        this.b = new i(0L, 150L);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet b(View view, final View view2, final boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        a(view2, z, z2, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationScrimBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    return;
                }
                view2.setVisibility(4);
            }
        });
        return animatorSet;
    }

    private void a(View view, boolean z, boolean z2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        i iVar = z ? this.f5353a : this.b;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        iVar.a((Animator) ofFloat);
        list.add(ofFloat);
    }
}
