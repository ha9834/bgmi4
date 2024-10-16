package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.f.v;
import com.google.android.material.a;
import com.google.android.material.a.g;
import com.google.android.material.a.h;
import com.google.android.material.internal.j;
import com.google.android.material.internal.m;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final TimeInterpolator f5266a = com.google.android.material.a.a.c;
    static final int[] p = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] q = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] r = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] s = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] t = {R.attr.state_enabled};
    static final int[] u = new int[0];
    private float A;
    private ArrayList<Animator.AnimatorListener> B;
    private ArrayList<Animator.AnimatorListener> C;
    private ViewTreeObserver.OnPreDrawListener H;
    Animator c;
    h d;
    h e;
    com.google.android.material.h.a f;
    Drawable g;
    Drawable h;
    com.google.android.material.internal.a i;
    Drawable j;
    float k;
    float l;
    float m;
    int n;
    final m v;
    final com.google.android.material.h.b w;
    private h x;
    private h y;
    int b = 0;
    float o = 1.0f;
    private final Rect D = new Rect();
    private final RectF E = new RectF();
    private final RectF F = new RectF();
    private final Matrix G = new Matrix();
    private final j z = new j();

    /* loaded from: classes2.dex */
    interface d {
        void a();

        void b();
    }

    void b(Rect rect) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
    }

    boolean m() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(m mVar, com.google.android.material.h.b bVar) {
        this.v = mVar;
        this.w = bVar;
        this.z.a(p, a((f) new c()));
        this.z.a(q, a((f) new b()));
        this.z.a(r, a((f) new b()));
        this.z.a(s, a((f) new b()));
        this.z.a(t, a((f) new e()));
        this.z.a(u, a((f) new C0116a()));
        this.A = this.v.getRotation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.g;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
        com.google.android.material.internal.a aVar = this.i;
        if (aVar != null) {
            aVar.a(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        Drawable drawable = this.g;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.h;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, com.google.android.material.g.a.a(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            a(this.k, this.l, this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(float f2) {
        if (this.l != f2) {
            this.l = f2;
            a(this.k, this.l, this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(float f2) {
        if (this.m != f2) {
            this.m = f2;
            a(this.k, this.l, this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        d(this.o);
    }

    final void d(float f2) {
        this.o = f2;
        Matrix matrix = this.G;
        a(f2, matrix);
        this.v.setImageMatrix(matrix);
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        if (this.v.getDrawable() == null || this.n == 0) {
            return;
        }
        RectF rectF = this.E;
        RectF rectF2 = this.F;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i = this.n;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.n;
        matrix.postScale(f2, f2, i2 / 2.0f, i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(h hVar) {
        this.d = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h f() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(h hVar) {
        this.e = hVar;
    }

    void a(float f2, float f3, float f4) {
        com.google.android.material.h.a aVar = this.f;
        if (aVar != null) {
            aVar.a(f2, this.m + f2);
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr) {
        this.z.a(iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.z.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Animator.AnimatorListener animatorListener) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.B;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(animatorListener);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.C;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final d dVar, final boolean z) {
        if (p()) {
            return;
        }
        Animator animator = this.c;
        if (animator != null) {
            animator.cancel();
        }
        if (t()) {
            h hVar = this.e;
            if (hVar == null) {
                hVar = r();
            }
            AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.a.1
                private boolean d;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    a.this.v.a(0, z);
                    a aVar = a.this;
                    aVar.b = 1;
                    aVar.c = animator2;
                    this.d = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    this.d = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    a aVar = a.this;
                    aVar.b = 0;
                    aVar.c = null;
                    if (this.d) {
                        return;
                    }
                    aVar.v.a(z ? 8 : 4, z);
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.b();
                    }
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.C;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.v.a(z ? 8 : 4, z);
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final d dVar, final boolean z) {
        if (o()) {
            return;
        }
        Animator animator = this.c;
        if (animator != null) {
            animator.cancel();
        }
        if (t()) {
            if (this.v.getVisibility() != 0) {
                this.v.setAlpha(0.0f);
                this.v.setScaleY(0.0f);
                this.v.setScaleX(0.0f);
                d(0.0f);
            }
            h hVar = this.d;
            if (hVar == null) {
                hVar = q();
            }
            AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.a.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    a.this.v.a(0, z);
                    a aVar = a.this;
                    aVar.b = 2;
                    aVar.c = animator2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    a aVar = a.this;
                    aVar.b = 0;
                    aVar.c = null;
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a();
                    }
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.B;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.v.a(0, z);
        this.v.setAlpha(1.0f);
        this.v.setScaleY(1.0f);
        this.v.setScaleX(1.0f);
        d(1.0f);
        if (dVar != null) {
            dVar.a();
        }
    }

    private h q() {
        if (this.x == null) {
            this.x = h.a(this.v.getContext(), a.C0113a.design_fab_show_motion_spec);
        }
        return this.x;
    }

    private h r() {
        if (this.y == null) {
            this.y = h.a(this.v.getContext(), a.C0113a.design_fab_hide_motion_spec);
        }
        return this.y;
    }

    private AnimatorSet a(h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.v, (Property<m, Float>) View.ALPHA, f2);
        hVar.b("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.v, (Property<m, Float>) View.SCALE_X, f3);
        hVar.b("scale").a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.v, (Property<m, Float>) View.SCALE_Y, f3);
        hVar.b("scale").a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.G);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.v, new com.google.android.material.a.f(), new g(), new Matrix(this.G));
        hVar.b("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable h() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() {
        Rect rect = this.D;
        a(rect);
        b(rect);
        this.w.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void a(Rect rect) {
        this.f.getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (m()) {
            s();
            this.v.getViewTreeObserver().addOnPreDrawListener(this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (this.H != null) {
            this.v.getViewTreeObserver().removeOnPreDrawListener(this.H);
            this.H = null;
        }
    }

    void n() {
        float rotation = this.v.getRotation();
        if (this.A != rotation) {
            this.A = rotation;
            u();
        }
    }

    private void s() {
        if (this.H == null) {
            this.H = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.a.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    a.this.n();
                    return true;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.v.getVisibility() != 0 ? this.b == 2 : this.b != 1;
    }

    boolean p() {
        return this.v.getVisibility() == 0 ? this.b == 1 : this.b != 2;
    }

    private ValueAnimator a(f fVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f5266a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(fVar);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    /* loaded from: classes2.dex */
    private abstract class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f5274a;
        private float c;
        private float d;

        protected abstract float a();

        private f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f5274a) {
                this.c = a.this.f.b();
                this.d = a();
                this.f5274a = true;
            }
            com.google.android.material.h.a aVar = a.this.f;
            float f = this.c;
            aVar.a(f + ((this.d - f) * valueAnimator.getAnimatedFraction()));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f.a(this.d);
            this.f5274a = false;
        }
    }

    /* loaded from: classes2.dex */
    private class e extends f {
        e() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return a.this.k;
        }
    }

    /* loaded from: classes2.dex */
    private class b extends f {
        b() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return a.this.k + a.this.l;
        }
    }

    /* loaded from: classes2.dex */
    private class c extends f {
        c() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return a.this.k + a.this.m;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0116a extends f {
        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return 0.0f;
        }

        C0116a() {
            super();
        }
    }

    private boolean t() {
        return v.x(this.v) && !this.v.isInEditMode();
    }

    private void u() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.A % 90.0f != 0.0f) {
                if (this.v.getLayerType() != 1) {
                    this.v.setLayerType(1, null);
                }
            } else if (this.v.getLayerType() != 0) {
                this.v.setLayerType(0, null);
            }
        }
        com.google.android.material.h.a aVar = this.f;
        if (aVar != null) {
            aVar.b(-this.A);
        }
        com.google.android.material.internal.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.a(-this.A);
        }
    }
}
