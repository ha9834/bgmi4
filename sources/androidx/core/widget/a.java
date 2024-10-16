package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.f.v;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    final View b;
    boolean c;
    boolean d;
    boolean e;
    private Runnable g;
    private int j;
    private int k;
    private boolean o;
    private boolean p;
    private boolean q;

    /* renamed from: a, reason: collision with root package name */
    final C0050a f574a = new C0050a();
    private final Interpolator f = new AccelerateInterpolator();
    private float[] h = {0.0f, 0.0f};
    private float[] i = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] l = {0.0f, 0.0f};
    private float[] m = {0.0f, 0.0f};
    private float[] n = {Float.MAX_VALUE, Float.MAX_VALUE};

    static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public abstract void a(int i, int i2);

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    public a(View view) {
        this.b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = i;
        a(f, f);
        float f2 = i2;
        b(f2, f2);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(500);
        d(500);
    }

    public a a(boolean z) {
        if (this.p && !z) {
            d();
        }
        this.p = z;
        return this;
    }

    public a a(float f, float f2) {
        float[] fArr = this.n;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a b(float f, float f2) {
        float[] fArr = this.m;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a c(float f, float f2) {
        float[] fArr = this.l;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a a(int i) {
        this.j = i;
        return this;
    }

    public a d(float f, float f2) {
        float[] fArr = this.h;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public a e(float f, float f2) {
        float[] fArr = this.i;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public a b(int i) {
        this.k = i;
        return this;
    }

    public a c(int i) {
        this.f574a.a(i);
        return this;
    }

    public a d(int i) {
        this.f574a.b(i);
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.d = true;
                this.o = false;
                this.f574a.a(a(0, motionEvent.getX(), view.getWidth(), this.b.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.b.getHeight()));
                if (!this.e && a()) {
                    c();
                    break;
                }
                break;
            case 1:
            case 3:
                d();
                break;
            case 2:
                this.f574a.a(a(0, motionEvent.getX(), view.getWidth(), this.b.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.b.getHeight()));
                if (!this.e) {
                    c();
                    break;
                }
                break;
        }
        return this.q && this.e;
    }

    boolean a() {
        C0050a c0050a = this.f574a;
        int f = c0050a.f();
        int e = c0050a.e();
        return (f != 0 && f(f)) || (e != 0 && e(e));
    }

    private void c() {
        int i;
        if (this.g == null) {
            this.g = new b();
        }
        this.e = true;
        this.c = true;
        if (!this.o && (i = this.k) > 0) {
            v.a(this.b, this.g, i);
        } else {
            this.g.run();
        }
        this.o = true;
    }

    private void d() {
        if (this.c) {
            this.e = false;
        } else {
            this.f574a.b();
        }
    }

    private float a(int i, float f, float f2, float f3) {
        float a2 = a(this.h[i], f2, this.i[i], f);
        if (a2 == 0.0f) {
            return 0.0f;
        }
        float f4 = this.l[i];
        float f5 = this.m[i];
        float f6 = this.n[i];
        float f7 = f4 * f3;
        if (a2 > 0.0f) {
            return a(a2 * f7, f5, f6);
        }
        return -a((-a2) * f7, f5, f6);
    }

    private float a(float f, float f2, float f3, float f4) {
        float interpolation;
        float a2 = a(f * f2, 0.0f, f3);
        float f5 = f(f2 - f4, a2) - f(f4, a2);
        if (f5 < 0.0f) {
            interpolation = -this.f.getInterpolation(-f5);
        } else {
            if (f5 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f.getInterpolation(f5);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.j;
        switch (i) {
            case 0:
            case 1:
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.e && i == 1) {
                        return 1.0f;
                    }
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.b.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.e) {
                if (a.this.c) {
                    a aVar = a.this;
                    aVar.c = false;
                    aVar.f574a.a();
                }
                C0050a c0050a = a.this.f574a;
                if (c0050a.c() || !a.this.a()) {
                    a.this.e = false;
                    return;
                }
                if (a.this.d) {
                    a aVar2 = a.this;
                    aVar2.d = false;
                    aVar2.b();
                }
                c0050a.d();
                a.this.a(c0050a.g(), c0050a.h());
                v.a(a.this.b, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0050a {

        /* renamed from: a, reason: collision with root package name */
        private int f575a;
        private int b;
        private float c;
        private float d;
        private float j;
        private int k;
        private long e = Long.MIN_VALUE;
        private long i = -1;
        private long f = 0;
        private int g = 0;
        private int h = 0;

        private float a(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        C0050a() {
        }

        public void a(int i) {
            this.f575a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void a() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.e), 0, this.b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public boolean c() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        private float a(long j) {
            if (j < this.e) {
                return 0.0f;
            }
            long j2 = this.i;
            if (j2 < 0 || j < j2) {
                return a.a(((float) (j - this.e)) / this.f575a, 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f = this.j;
            return (1.0f - f) + (f * a.a(((float) j3) / this.k, 0.0f, 1.0f));
        }

        public void d() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a2 = a(a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f;
            this.f = currentAnimationTimeMillis;
            float f = ((float) j) * a2;
            this.g = (int) (this.c * f);
            this.h = (int) (f * this.d);
        }

        public void a(float f, float f2) {
            this.c = f;
            this.d = f2;
        }

        public int e() {
            float f = this.c;
            return (int) (f / Math.abs(f));
        }

        public int f() {
            float f = this.d;
            return (int) (f / Math.abs(f));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }
}
