package com.devbrackets.android.exomedia.ui.a;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.d.a.a.c;

/* loaded from: classes.dex */
public class a extends AnimationSet {

    /* renamed from: a, reason: collision with root package name */
    private View f1036a;
    private boolean b;

    public a(View view, boolean z, long j) {
        super(false);
        this.b = z;
        this.f1036a = view;
        AlphaAnimation alphaAnimation = new AlphaAnimation(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        alphaAnimation.setDuration(j);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, z ? a(view) : 0, z ? 0 : a(view));
        translateAnimation.setInterpolator(z ? new c() : new androidx.d.a.a.a());
        translateAnimation.setDuration(j);
        addAnimation(alphaAnimation);
        addAnimation(translateAnimation);
        setAnimationListener(new AnimationAnimationListenerC0078a());
    }

    private int a(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - view.getTop();
    }

    /* renamed from: com.devbrackets.android.exomedia.ui.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class AnimationAnimationListenerC0078a implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        private AnimationAnimationListenerC0078a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            a.this.f1036a.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.f1036a.setVisibility(a.this.b ? 0 : 8);
        }
    }
}
