package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.b;
import androidx.fragment.a;
import androidx.fragment.app.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Context context, Fragment fragment, boolean z, boolean z2) {
        int nextTransition = fragment.getNextTransition();
        int a2 = a(fragment, z, z2);
        boolean z3 = false;
        fragment.setAnimations(0, 0, 0, 0);
        if (fragment.mContainer != null && fragment.mContainer.getTag(a.b.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(a.b.visible_removing_fragment_view_tag, null);
        }
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, a2);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, a2);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (a2 == 0 && nextTransition != 0) {
            a2 = a(nextTransition, z);
        }
        if (a2 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a2));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a2);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, a2);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (equals) {
                        throw e2;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a2);
                    if (loadAnimation2 != null) {
                        return new a(loadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    private static int a(Fragment fragment, boolean z, boolean z2) {
        if (z2) {
            if (z) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        }
        if (z) {
            return fragment.getEnterAnim();
        }
        return fragment.getExitAnim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Fragment fragment, a aVar, final t.a aVar2) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        final androidx.core.os.b bVar = new androidx.core.os.b();
        bVar.a(new b.a() { // from class: androidx.fragment.app.d.1
            @Override // androidx.core.os.b.a
            public void a() {
                if (Fragment.this.getAnimatingAway() != null) {
                    View animatingAway = Fragment.this.getAnimatingAway();
                    Fragment.this.setAnimatingAway(null);
                    animatingAway.clearAnimation();
                }
                Fragment.this.setAnimator(null);
            }
        });
        aVar2.a(fragment, bVar);
        if (aVar.f665a != null) {
            b bVar2 = new b(aVar.f665a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            bVar2.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.d.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() { // from class: androidx.fragment.app.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway(null);
                                aVar2.b(fragment, bVar);
                            }
                        }
                    });
                }
            });
            fragment.mView.startAnimation(bVar2);
            return;
        }
        Animator animator = aVar.b;
        fragment.setAnimator(aVar.b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.d.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator animator3 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator3 == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                aVar2.b(fragment, bVar);
            }
        });
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int a(int i, boolean z) {
        if (i == 4097) {
            return z ? a.C0053a.fragment_open_enter : a.C0053a.fragment_open_exit;
        }
        if (i == 4099) {
            return z ? a.C0053a.fragment_fade_enter : a.C0053a.fragment_fade_exit;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? a.C0053a.fragment_close_enter : a.C0053a.fragment_close_exit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f665a;
        public final Animator b;

        a(Animation animation) {
            this.f665a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f665a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f666a;
        private final View b;
        private boolean c;
        private boolean d;
        private boolean e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.e = true;
            this.f666a = viewGroup;
            this.b = view;
            addAnimation(animation);
            this.f666a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                androidx.core.f.s.a(this.f666a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                androidx.core.f.s.a(this.f666a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c && this.e) {
                this.e = false;
                this.f666a.post(this);
            } else {
                this.f666a.endViewTransition(this.b);
                this.d = true;
            }
        }
    }
}
