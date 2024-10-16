package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class g extends RecyclerView.s {
    protected PointF c;
    private final float f;

    /* renamed from: a, reason: collision with root package name */
    protected final LinearInterpolator f900a = new LinearInterpolator();
    protected final DecelerateInterpolator b = new DecelerateInterpolator();
    protected int d = 0;
    protected int e = 0;

    private int b(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    protected void a() {
    }

    public g(Context context) {
        this.f = a(context.getResources().getDisplayMetrics());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    protected void a(View view, RecyclerView.t tVar, RecyclerView.s.a aVar) {
        int b = b(view, c());
        int a2 = a(view, d());
        int a3 = a((int) Math.sqrt((b * b) + (a2 * a2)));
        if (a3 > 0) {
            aVar.a(-b, -a2, a3, this.b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    protected void a(int i, int i2, RecyclerView.t tVar, RecyclerView.s.a aVar) {
        if (j() == 0) {
            f();
            return;
        }
        this.d = b(this.d, i);
        this.e = b(this.e, i2);
        if (this.d == 0 && this.e == 0) {
            a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    protected void b() {
        this.e = 0;
        this.d = 0;
        this.c = null;
    }

    protected float a(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int a(int i) {
        double b = b(i);
        Double.isNaN(b);
        return (int) Math.ceil(b / 0.3356d);
    }

    protected int b(int i) {
        return (int) Math.ceil(Math.abs(i) * this.f);
    }

    protected int c() {
        PointF pointF = this.c;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.c.x > 0.0f ? 1 : -1;
    }

    protected int d() {
        PointF pointF = this.c;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.c.y > 0.0f ? 1 : -1;
    }

    protected void a(RecyclerView.s.a aVar) {
        PointF d = d(i());
        if (d == null || (d.x == 0.0f && d.y == 0.0f)) {
            aVar.a(i());
            f();
            return;
        }
        a(d);
        this.c = d;
        this.d = (int) (d.x * 10000.0f);
        this.e = (int) (d.y * 10000.0f);
        aVar.a((int) (this.d * 1.2f), (int) (this.e * 1.2f), (int) (b(10000) * 1.2f), this.f900a);
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                int i7 = i4 - i2;
                if (i7 < 0) {
                    return i7;
                }
                return 0;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int a(View view, int i) {
        RecyclerView.i e = e();
        if (e == null || !e.g()) {
            return 0;
        }
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return a(e.i(view) - jVar.topMargin, e.k(view) + jVar.bottomMargin, e.E(), e.C() - e.G(), i);
    }

    public int b(View view, int i) {
        RecyclerView.i e = e();
        if (e == null || !e.f()) {
            return 0;
        }
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return a(e.h(view) - jVar.leftMargin, e.j(view) + jVar.rightMargin, e.D(), e.B() - e.F(), i);
    }
}
