package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.v;
import com.google.android.material.a;
import com.google.android.material.a.c;
import com.google.android.material.a.e;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.c.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f5347a;
    private final RectF b;
    private final RectF c;
    private final int[] d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public h f5352a;
        public j b;
    }

    protected abstract a a(Context context, boolean z);

    public FabTransformationBehavior() {
        this.f5347a = new Rect();
        this.b = new RectF();
        this.c = new RectF();
        this.d = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5347a = new Rect();
        this.b = new RectF();
        this.c = new RectF();
        this.d = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
        if (eVar.h == 0) {
            eVar.h = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet b(final View view, final View view2, final boolean z, boolean z2) {
        a a2 = a(view2.getContext(), z);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            a(view, view2, z, z2, a2, arrayList, arrayList2);
        }
        RectF rectF = this.b;
        a(view, view2, z, z2, a2, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        b(view, view2, z, z2, a2, arrayList, arrayList2);
        a(view, view2, z, z2, a2, width, height, arrayList, arrayList2);
        c(view, view2, z, z2, a2, arrayList, arrayList2);
        d(view, view2, z, z2, a2, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    return;
                }
                view2.setVisibility(4);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }
        });
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }

    @TargetApi(21)
    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float m = v.m(view2) - v.m(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-m);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -m);
        }
        aVar.f5352a.b("elevation").a((Animator) ofFloat);
        list.add(ofFloat);
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        i b;
        i b2;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float a2 = a(view, view2, aVar.b);
        float b3 = b(view, view2, aVar.b);
        if (a2 == 0.0f || b3 == 0.0f) {
            b = aVar.f5352a.b("translationXLinear");
            b2 = aVar.f5352a.b("translationYLinear");
        } else if ((z && b3 < 0.0f) || (!z && b3 > 0.0f)) {
            b = aVar.f5352a.b("translationXCurveUpwards");
            b2 = aVar.f5352a.b("translationYCurveUpwards");
        } else {
            b = aVar.f5352a.b("translationXCurveDownwards");
            b2 = aVar.f5352a.b("translationYCurveDownwards");
        }
        if (z) {
            if (!z2) {
                view2.setTranslationX(-a2);
                view2.setTranslationY(-b3);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            a(view2, aVar, b, b2, -a2, -b3, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -a2);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -b3);
        }
        b.a((Animator) ofFloat);
        b2.a((Animator) ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(View view, final View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof d) && (view instanceof ImageView)) {
            final d dVar = (d) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, e.f5207a, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, e.f5207a, 255);
            }
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transformation.FabTransformationBehavior.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view2.invalidate();
                }
            });
            aVar.f5352a.b("iconFade").a((Animator) ofInt);
            list.add(ofInt);
            list2.add(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    dVar.setCircularRevealOverlayDrawable(drawable);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    dVar.setCircularRevealOverlayDrawable(null);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(View view, View view2, boolean z, boolean z2, a aVar, float f, float f2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof d) {
            final d dVar = (d) view2;
            float c = c(view, view2, aVar.b);
            float d = d(view, view2, aVar.b);
            ((FloatingActionButton) view).a(this.f5347a);
            float width = this.f5347a.width() / 2.0f;
            i b = aVar.f5352a.b("expansion");
            if (z) {
                if (!z2) {
                    dVar.setRevealInfo(new d.C0115d(c, d, width));
                }
                if (z2) {
                    width = dVar.getRevealInfo().c;
                }
                animator = com.google.android.material.c.a.a(dVar, c, d, com.google.android.material.e.a.a(c, d, 0.0f, 0.0f, f, f2));
                animator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        d.C0115d revealInfo = dVar.getRevealInfo();
                        revealInfo.c = Float.MAX_VALUE;
                        dVar.setRevealInfo(revealInfo);
                    }
                });
                a(view2, b.a(), (int) c, (int) d, width, list);
            } else {
                float f3 = dVar.getRevealInfo().c;
                Animator a2 = com.google.android.material.c.a.a(dVar, c, d, width);
                int i = (int) c;
                int i2 = (int) d;
                a(view2, b.a(), i, i2, f3, list);
                a(view2, b.a(), b.b(), aVar.f5352a.a(), i, i2, width, list);
                animator = a2;
            }
            b.a(animator);
            list.add(animator);
            list2.add(com.google.android.material.c.a.a(dVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof d) {
            d dVar = (d) view2;
            int c = c(view);
            int i = 16777215 & c;
            if (z) {
                if (!z2) {
                    dVar.setCircularRevealScrimColor(c);
                }
                ofInt = ObjectAnimator.ofInt(dVar, d.c.f5259a, i);
            } else {
                ofInt = ObjectAnimator.ofInt(dVar, d.c.f5259a, c);
            }
            ofInt.setEvaluator(c.a());
            aVar.f5352a.b("color").a((Animator) ofInt);
            list.add(ofInt);
        }
    }

    private void d(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup a2;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof d) && com.google.android.material.c.c.f5256a == 0) || (a2 = a(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    com.google.android.material.a.d.f5206a.set(a2, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(a2, com.google.android.material.a.d.f5206a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(a2, com.google.android.material.a.d.f5206a, 0.0f);
            }
            aVar.f5352a.b("contentFade").a((Animator) ofFloat);
            list.add(ofFloat);
        }
    }

    private float a(View view, View view2, j jVar) {
        float centerX;
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        a(view, rectF);
        a(view2, rectF2);
        int i = jVar.f5212a & 7;
        if (i == 1) {
            centerX = rectF2.centerX() - rectF.centerX();
        } else if (i == 3) {
            centerX = rectF2.left - rectF.left;
        } else {
            centerX = i != 5 ? 0.0f : rectF2.right - rectF.right;
        }
        return centerX + jVar.b;
    }

    private float b(View view, View view2, j jVar) {
        float centerY;
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        a(view, rectF);
        a(view2, rectF2);
        int i = jVar.f5212a & 112;
        if (i == 16) {
            centerY = rectF2.centerY() - rectF.centerY();
        } else if (i == 48) {
            centerY = rectF2.top - rectF.top;
        } else {
            centerY = i != 80 ? 0.0f : rectF2.bottom - rectF.bottom;
        }
        return centerY + jVar.c;
    }

    private void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.d);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private float c(View view, View view2, j jVar) {
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(-a(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float d(View view, View view2, j jVar) {
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(0.0f, -b(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private void a(View view, a aVar, i iVar, i iVar2, float f, float f2, float f3, float f4, RectF rectF) {
        float a2 = a(aVar, iVar, f, f3);
        float a3 = a(aVar, iVar2, f2, f4);
        Rect rect = this.f5347a;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.b;
        rectF2.set(rect);
        RectF rectF3 = this.c;
        a(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float a(a aVar, i iVar, float f, float f2) {
        long a2 = iVar.a();
        long b = iVar.b();
        i b2 = aVar.f5352a.b("expansion");
        return com.google.android.material.a.a.a(f, f2, iVar.c().getInterpolation(((float) (((b2.a() + b2.b()) + 17) - a2)) / ((float) b)));
    }

    private ViewGroup a(View view) {
        View findViewById = view.findViewById(a.f.mtrl_child_content_container);
        if (findViewById != null) {
            return b(findViewById);
        }
        if ((view instanceof b) || (view instanceof com.google.android.material.transformation.a)) {
            return b(((ViewGroup) view).getChildAt(0));
        }
        return b(view);
    }

    private ViewGroup b(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private int c(View view) {
        ColorStateList t = v.t(view);
        if (t != null) {
            return t.getColorForState(view.getDrawableState(), t.getDefaultColor());
        }
        return 0;
    }

    private void a(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j);
        list.add(createCircularReveal);
    }

    private void a(View view, long j, long j2, long j3, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }
}
