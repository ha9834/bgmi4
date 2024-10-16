package androidx.core.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    Runnable f551a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(View view) {
        this.d = new WeakReference<>(view);
    }

    /* loaded from: classes.dex */
    static class a implements aa {

        /* renamed from: a, reason: collision with root package name */
        z f554a;
        boolean b;

        a(z zVar) {
            this.f554a = zVar;
        }

        @Override // androidx.core.f.aa
        public void a(View view) {
            this.b = false;
            if (this.f554a.c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f554a.f551a != null) {
                Runnable runnable = this.f554a.f551a;
                this.f554a.f551a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            aa aaVar = tag instanceof aa ? (aa) tag : null;
            if (aaVar != null) {
                aaVar.a(view);
            }
        }

        @Override // androidx.core.f.aa
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            if (this.f554a.c > -1) {
                view.setLayerType(this.f554a.c, null);
                this.f554a.c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                if (this.f554a.b != null) {
                    Runnable runnable = this.f554a.b;
                    this.f554a.b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                aa aaVar = tag instanceof aa ? (aa) tag : null;
                if (aaVar != null) {
                    aaVar.b(view);
                }
                this.b = true;
            }
        }

        @Override // androidx.core.f.aa
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            aa aaVar = tag instanceof aa ? (aa) tag : null;
            if (aaVar != null) {
                aaVar.c(view);
            }
        }
    }

    public z a(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public z a(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public z b(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public long a() {
        View view = this.d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public z a(Interpolator interpolator) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public z b(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public z a(aa aaVar) {
        View view = this.d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, aaVar);
            } else {
                view.setTag(2113929216, aaVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(final View view, final aa aaVar) {
        if (aaVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.f.z.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    aaVar.c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    aaVar.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    aaVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public z a(final ac acVar) {
        final View view = this.d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(acVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.f.z.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    acVar.a(view);
                }
            } : null);
        }
        return this;
    }
}
