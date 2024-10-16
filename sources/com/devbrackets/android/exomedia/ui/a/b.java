package com.devbrackets.android.exomedia.ui.a;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.d.a.a.c;

/* loaded from: classes.dex */
public class b extends AnimationSet {

    /* renamed from: a, reason: collision with root package name */
    private View f1038a;
    private boolean b;

    public b(View view, boolean z, long j) {
        super(false);
        this.b = z;
        this.f1038a = view;
        AlphaAnimation alphaAnimation = new AlphaAnimation(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        alphaAnimation.setDuration(j);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, z ? -view.getHeight() : 0, z ? 0 : -view.getHeight());
        translateAnimation.setInterpolator(z ? new c() : new androidx.d.a.a.a());
        translateAnimation.setDuration(j);
        addAnimation(alphaAnimation);
        addAnimation(translateAnimation);
        setAnimationListener(new a());
    }

    /* loaded from: classes.dex */
    private class a implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        private a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.f1038a.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.f1038a.setVisibility(b.this.b ? 0 : 8);
        }
    }
}
