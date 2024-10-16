package com.google.android.material.c;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.c.c;

/* loaded from: classes2.dex */
public interface d extends c.a {
    void a();

    void b();

    int getCircularRevealScrimColor();

    C0115d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(C0115d c0115d);

    /* renamed from: com.google.android.material.c.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0115d {

        /* renamed from: a, reason: collision with root package name */
        public float f5260a;
        public float b;
        public float c;

        private C0115d() {
        }

        public C0115d(float f, float f2, float f3) {
            this.f5260a = f;
            this.b = f2;
            this.c = f3;
        }

        public C0115d(C0115d c0115d) {
            this(c0115d.f5260a, c0115d.b, c0115d.c);
        }

        public void a(float f, float f2, float f3) {
            this.f5260a = f;
            this.b = f2;
            this.c = f3;
        }

        public void a(C0115d c0115d) {
            a(c0115d.f5260a, c0115d.b, c0115d.c);
        }

        public boolean a() {
            return this.c == Float.MAX_VALUE;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Property<d, C0115d> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, C0115d> f5258a = new b("circularReveal");

        private b(String str) {
            super(C0115d.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0115d get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, C0115d c0115d) {
            dVar.setRevealInfo(c0115d);
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements TypeEvaluator<C0115d> {

        /* renamed from: a, reason: collision with root package name */
        public static final TypeEvaluator<C0115d> f5257a = new a();
        private final C0115d b = new C0115d();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0115d evaluate(float f, C0115d c0115d, C0115d c0115d2) {
            this.b.a(com.google.android.material.e.a.a(c0115d.f5260a, c0115d2.f5260a, f), com.google.android.material.e.a.a(c0115d.b, c0115d2.b, f), com.google.android.material.e.a.a(c0115d.c, c0115d2.c, f));
            return this.b;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends Property<d, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, Integer> f5259a = new c("circularRevealScrimColor");

        private c(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }
}
