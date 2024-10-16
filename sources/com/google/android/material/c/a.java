package com.google.android.material.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.android.material.c.d;

/* loaded from: classes2.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static Animator a(d dVar, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(dVar, (Property<d, V>) d.b.f5258a, (TypeEvaluator) d.a.f5257a, (Object[]) new d.C0115d[]{new d.C0115d(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        d.C0115d revealInfo = dVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) dVar, (int) f, (int) f2, revealInfo.c, f3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofObject, createCircularReveal);
        return animatorSet;
    }

    public static Animator.AnimatorListener a(final d dVar) {
        return new AnimatorListenerAdapter() { // from class: com.google.android.material.c.a.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.a();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.b();
            }
        };
    }
}
