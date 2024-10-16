package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.a.c;
import androidx.core.f.ad;
import androidx.core.f.r;
import androidx.core.f.v;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.material.a;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.k;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a, reason: collision with root package name */
    static final Handler f5314a;
    private static final boolean d;
    private static final int[] e;
    protected final e b;
    final b.a c = new b.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
        @Override // com.google.android.material.snackbar.b.a
        public void a() {
            BaseTransientBottomBar.f5314a.sendMessage(BaseTransientBottomBar.f5314a.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.a
        public void a(int i) {
            BaseTransientBottomBar.f5314a.sendMessage(BaseTransientBottomBar.f5314a.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    };
    private final ViewGroup f;
    private final Context g;
    private final com.google.android.material.snackbar.a h;
    private int i;
    private List<a<B>> j;
    private Behavior k;
    private final AccessibilityManager l;

    /* loaded from: classes2.dex */
    public static abstract class a<B> {
        public void a(B b) {
        }

        public void a(B b, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface c {
        void a(View view);

        void b(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface d {
        void a(View view, int i, int i2, int i3, int i4);
    }

    static {
        d = Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19;
        e = new int[]{a.b.snackbarStyle};
        f5314a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        ((BaseTransientBottomBar) message.obj).k();
                        return true;
                    case 1:
                        ((BaseTransientBottomBar) message.obj).c(message.arg1);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar(ViewGroup viewGroup, View view, com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f = viewGroup;
        this.h = aVar;
        this.g = viewGroup.getContext();
        k.a(this.g);
        this.b = (e) LayoutInflater.from(this.g).inflate(a(), this.f, false);
        this.b.addView(view);
        v.c(this.b, 1);
        v.b(this.b, 1);
        v.b((View) this.b, true);
        v.a(this.b, new r() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
            @Override // androidx.core.f.r
            public ad a(View view2, ad adVar) {
                view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), adVar.d());
                return adVar;
            }
        });
        v.a(this.b, new androidx.core.f.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
            @Override // androidx.core.f.a
            public void a(View view2, androidx.core.f.a.d dVar) {
                super.a(view2, dVar);
                dVar.a(Constants.MB);
                dVar.e(true);
            }

            @Override // androidx.core.f.a
            public boolean a(View view2, int i, Bundle bundle) {
                if (i == 1048576) {
                    BaseTransientBottomBar.this.g();
                    return true;
                }
                return super.a(view2, i, bundle);
            }
        });
        this.l = (AccessibilityManager) this.g.getSystemService("accessibility");
    }

    protected int a() {
        return b() ? a.h.mtrl_layout_snackbar : a.h.design_layout_snackbar;
    }

    protected boolean b() {
        TypedArray obtainStyledAttributes = this.g.obtainStyledAttributes(e);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public B a(int i) {
        this.i = i;
        return this;
    }

    public int c() {
        return this.i;
    }

    public Context d() {
        return this.g;
    }

    public View e() {
        return this.b;
    }

    public void f() {
        com.google.android.material.snackbar.b.a().a(c(), this.c);
    }

    public void g() {
        b(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        com.google.android.material.snackbar.b.a().a(this.c, i);
    }

    public boolean h() {
        return com.google.android.material.snackbar.b.a().e(this.c);
    }

    public boolean i() {
        return com.google.android.material.snackbar.b.a().f(this.c);
    }

    protected SwipeDismissBehavior<? extends View> j() {
        return new Behavior();
    }

    final void k() {
        if (this.b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) layoutParams;
                SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.k;
                if (swipeDismissBehavior == null) {
                    swipeDismissBehavior = j();
                }
                if (swipeDismissBehavior instanceof Behavior) {
                    ((Behavior) swipeDismissBehavior).a((BaseTransientBottomBar<?>) this);
                }
                swipeDismissBehavior.a(new SwipeDismissBehavior.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.7
                    @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
                    public void a(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.b(0);
                    }

                    @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
                    public void a(int i) {
                        switch (i) {
                            case 0:
                                com.google.android.material.snackbar.b.a().d(BaseTransientBottomBar.this.c);
                                return;
                            case 1:
                            case 2:
                                com.google.android.material.snackbar.b.a().c(BaseTransientBottomBar.this.c);
                                return;
                            default:
                                return;
                        }
                    }
                });
                eVar.a(swipeDismissBehavior);
                eVar.g = 80;
            }
            this.f.addView(this.b);
        }
        this.b.setOnAttachStateChangeListener(new c() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
            public void a(View view) {
            }

            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
            public void b(View view) {
                if (BaseTransientBottomBar.this.i()) {
                    BaseTransientBottomBar.f5314a.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseTransientBottomBar.this.d(3);
                        }
                    });
                }
            }
        });
        if (v.x(this.b)) {
            if (n()) {
                l();
                return;
            } else {
                m();
                return;
            }
        }
        this.b.setOnLayoutChangeListener(new d() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.9
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.d
            public void a(View view, int i, int i2, int i3, int i4) {
                BaseTransientBottomBar.this.b.setOnLayoutChangeListener(null);
                if (BaseTransientBottomBar.this.n()) {
                    BaseTransientBottomBar.this.l();
                } else {
                    BaseTransientBottomBar.this.m();
                }
            }
        });
    }

    void l() {
        final int p = p();
        if (d) {
            v.e(this.b, p);
        } else {
            this.b.setTranslationY(p);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(p, 0);
        valueAnimator.setInterpolator(com.google.android.material.a.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.h.a(70, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.m();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.11
            private int c;

            {
                this.c = p;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.d) {
                    v.e(BaseTransientBottomBar.this.b, intValue - this.c);
                } else {
                    BaseTransientBottomBar.this.b.setTranslationY(intValue);
                }
                this.c = intValue;
            }
        });
        valueAnimator.start();
    }

    private void e(final int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, p());
        valueAnimator.setInterpolator(com.google.android.material.a.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.h.b(0, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.d(i);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3
            private int b = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.d) {
                    v.e(BaseTransientBottomBar.this.b, intValue - this.b);
                } else {
                    BaseTransientBottomBar.this.b.setTranslationY(intValue);
                }
                this.b = intValue;
            }
        });
        valueAnimator.start();
    }

    private int p() {
        int height = this.b.getHeight();
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    final void c(int i) {
        if (n() && this.b.getVisibility() == 0) {
            e(i);
        } else {
            d(i);
        }
    }

    void m() {
        com.google.android.material.snackbar.b.a().b(this.c);
        List<a<B>> list = this.j;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.j.get(size).a(this);
            }
        }
    }

    void d(int i) {
        com.google.android.material.snackbar.b.a().a(this.c);
        List<a<B>> list = this.j;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.j.get(size).a(this, i);
            }
        }
        ViewParent parent = this.b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.b);
        }
    }

    boolean n() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.l.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class e extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        private final AccessibilityManager f5327a;
        private final c.a b;
        private d c;
        private c d;

        /* JADX INFO: Access modifiers changed from: protected */
        public e(Context context) {
            this(context, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(a.k.SnackbarLayout_elevation)) {
                v.a(this, obtainStyledAttributes.getDimensionPixelSize(a.k.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            this.f5327a = (AccessibilityManager) context.getSystemService("accessibility");
            this.b = new c.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.e.1
                @Override // androidx.core.f.a.c.a
                public void a(boolean z) {
                    e.this.setClickableOrFocusableBasedOnAccessibility(z);
                }
            };
            androidx.core.f.a.c.a(this.f5327a, this.b);
            setClickableOrFocusableBasedOnAccessibility(this.f5327a.isTouchExplorationEnabled());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
            setClickable(!z);
            setFocusable(z);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            d dVar = this.c;
            if (dVar != null) {
                dVar.a(this, i, i2, i3, i4);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            c cVar = this.d;
            if (cVar != null) {
                cVar.a(this);
            }
            v.p(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            c cVar = this.d;
            if (cVar != null) {
                cVar.b(this);
            }
            androidx.core.f.a.c.b(this.f5327a, this.b);
        }

        void setOnLayoutChangeListener(d dVar) {
            this.c = dVar;
        }

        void setOnAttachStateChangeListener(c cVar) {
            this.d = cVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        private final b g = new b(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.g.a(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return this.g.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.g.a(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private b.a f5326a;

        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.a(0.1f);
            swipeDismissBehavior.b(0.6f);
            swipeDismissBehavior.a(0);
        }

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f5326a = baseTransientBottomBar.c;
        }

        public boolean a(View view) {
            return view instanceof e;
        }

        public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                            com.google.android.material.snackbar.b.a().c(this.f5326a);
                            return;
                        }
                        return;
                    case 1:
                        break;
                    default:
                        return;
                }
            }
            com.google.android.material.snackbar.b.a().d(this.f5326a);
        }
    }
}
