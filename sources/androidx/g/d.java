package androidx.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class d extends ai {
    public d(int i) {
        a(i);
    }

    public d() {
    }

    @Override // androidx.g.ai, androidx.g.m
    public void a(s sVar) {
        super.a(sVar);
        sVar.f740a.put("android:fade:transitionAlpha", Float.valueOf(ad.c(sVar.b)));
    }

    private Animator a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ad.a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ad.f706a, f2);
        ofFloat.addListener(new a(view));
        a(new n() { // from class: androidx.g.d.1
            @Override // androidx.g.n, androidx.g.m.c
            public void a(m mVar) {
                ad.a(view, 1.0f);
                ad.e(view);
                mVar.b(this);
            }
        });
        return ofFloat;
    }

    @Override // androidx.g.ai
    public Animator a(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float a2 = a(sVar, 0.0f);
        return a(view, a2 != 1.0f ? a2 : 0.0f, 1.0f);
    }

    @Override // androidx.g.ai
    public Animator b(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        ad.d(view);
        return a(view, a(sVar, 1.0f), 0.0f);
    }

    private static float a(s sVar, float f) {
        Float f2;
        return (sVar == null || (f2 = (Float) sVar.f740a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final View f722a;
        private boolean b = false;

        a(View view) {
            this.f722a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (androidx.core.f.v.r(this.f722a) && this.f722a.getLayerType() == 0) {
                this.b = true;
                this.f722a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ad.a(this.f722a, 1.0f);
            if (this.b) {
                this.f722a.setLayerType(0, null);
            }
        }
    }
}
