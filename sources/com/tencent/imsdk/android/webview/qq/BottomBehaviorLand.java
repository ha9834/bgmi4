package com.tencent.imsdk.android.webview.qq;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.d.a.a.b;

/* loaded from: classes.dex */
public class BottomBehaviorLand extends CoordinatorLayout.b<LinearLayout> {
    private static final Interpolator INTERPOLATOR = new b();
    private static boolean isHideAnimRunning = false;
    private static boolean isShowAnimRunning = false;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view, View view2, int i) {
        return true;
    }

    public BottomBehaviorLand(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view, int i, int i2, int i3, int i4) {
        if (i4 >= 0) {
            hide(linearLayout);
        } else {
            show(linearLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide(final View view) {
        if (isHideAnimRunning) {
            return;
        }
        ViewPropertyAnimator duration = view.animate().translationY(view.getHeight()).setInterpolator(INTERPOLATOR).setDuration(200L);
        duration.setListener(new Animator.AnimatorListener() { // from class: com.tencent.imsdk.android.webview.qq.BottomBehaviorLand.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                boolean unused = BottomBehaviorLand.isHideAnimRunning = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                boolean unused = BottomBehaviorLand.isHideAnimRunning = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                boolean unused = BottomBehaviorLand.isHideAnimRunning = false;
                BottomBehaviorLand.this.show(view);
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show(final View view) {
        if (isShowAnimRunning) {
            return;
        }
        ViewPropertyAnimator duration = view.animate().translationY(0.0f).setInterpolator(INTERPOLATOR).setDuration(200L);
        duration.setListener(new Animator.AnimatorListener() { // from class: com.tencent.imsdk.android.webview.qq.BottomBehaviorLand.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                boolean unused = BottomBehaviorLand.isShowAnimRunning = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                boolean unused = BottomBehaviorLand.isShowAnimRunning = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                boolean unused = BottomBehaviorLand.isShowAnimRunning = false;
                BottomBehaviorLand.this.hide(view);
            }
        });
        duration.start();
    }
}
