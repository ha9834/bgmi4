package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: a, reason: collision with root package name */
    private AnimatorSet f5345a;

    protected abstract AnimatorSet b(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.f5345a != null;
        if (z3) {
            this.f5345a.cancel();
        }
        this.f5345a = b(view, view2, z, z3);
        this.f5345a.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.ExpandableTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ExpandableTransformationBehavior.this.f5345a = null;
            }
        });
        this.f5345a.start();
        if (!z2) {
            this.f5345a.end();
        }
        return true;
    }
}
