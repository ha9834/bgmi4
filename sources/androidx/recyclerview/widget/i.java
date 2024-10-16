package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    protected final RecyclerView.i f902a;
    final Rect b;
    private int c;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    private i(RecyclerView.i iVar) {
        this.c = BleSignal.UNKNOWN_TX_POWER;
        this.b = new Rect();
        this.f902a = iVar;
    }

    public void a() {
        this.c = f();
    }

    public int b() {
        if (Integer.MIN_VALUE == this.c) {
            return 0;
        }
        return f() - this.c;
    }

    public static i a(RecyclerView.i iVar, int i) {
        switch (i) {
            case 0:
                return a(iVar);
            case 1:
                return b(iVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static i a(RecyclerView.i iVar) {
        return new i(iVar) { // from class: androidx.recyclerview.widget.i.1
            @Override // androidx.recyclerview.widget.i
            public int d() {
                return this.f902a.B() - this.f902a.F();
            }

            @Override // androidx.recyclerview.widget.i
            public int e() {
                return this.f902a.B();
            }

            @Override // androidx.recyclerview.widget.i
            public void a(int i) {
                this.f902a.j(i);
            }

            @Override // androidx.recyclerview.widget.i
            public int c() {
                return this.f902a.D();
            }

            @Override // androidx.recyclerview.widget.i
            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f902a.f(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // androidx.recyclerview.widget.i
            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f902a.g(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.i
            public int b(View view) {
                return this.f902a.j(view) + ((RecyclerView.j) view.getLayoutParams()).rightMargin;
            }

            @Override // androidx.recyclerview.widget.i
            public int a(View view) {
                return this.f902a.h(view) - ((RecyclerView.j) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.i
            public int c(View view) {
                this.f902a.a(view, true, this.b);
                return this.b.right;
            }

            @Override // androidx.recyclerview.widget.i
            public int d(View view) {
                this.f902a.a(view, true, this.b);
                return this.b.left;
            }

            @Override // androidx.recyclerview.widget.i
            public int f() {
                return (this.f902a.B() - this.f902a.D()) - this.f902a.F();
            }

            @Override // androidx.recyclerview.widget.i
            public int g() {
                return this.f902a.F();
            }

            @Override // androidx.recyclerview.widget.i
            public int h() {
                return this.f902a.z();
            }

            @Override // androidx.recyclerview.widget.i
            public int i() {
                return this.f902a.A();
            }
        };
    }

    public static i b(RecyclerView.i iVar) {
        return new i(iVar) { // from class: androidx.recyclerview.widget.i.2
            @Override // androidx.recyclerview.widget.i
            public int d() {
                return this.f902a.C() - this.f902a.G();
            }

            @Override // androidx.recyclerview.widget.i
            public int e() {
                return this.f902a.C();
            }

            @Override // androidx.recyclerview.widget.i
            public void a(int i) {
                this.f902a.k(i);
            }

            @Override // androidx.recyclerview.widget.i
            public int c() {
                return this.f902a.E();
            }

            @Override // androidx.recyclerview.widget.i
            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f902a.g(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.i
            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f902a.f(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // androidx.recyclerview.widget.i
            public int b(View view) {
                return this.f902a.k(view) + ((RecyclerView.j) view.getLayoutParams()).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.i
            public int a(View view) {
                return this.f902a.i(view) - ((RecyclerView.j) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.i
            public int c(View view) {
                this.f902a.a(view, true, this.b);
                return this.b.bottom;
            }

            @Override // androidx.recyclerview.widget.i
            public int d(View view) {
                this.f902a.a(view, true, this.b);
                return this.b.top;
            }

            @Override // androidx.recyclerview.widget.i
            public int f() {
                return (this.f902a.C() - this.f902a.E()) - this.f902a.G();
            }

            @Override // androidx.recyclerview.widget.i
            public int g() {
                return this.f902a.G();
            }

            @Override // androidx.recyclerview.widget.i
            public int h() {
                return this.f902a.A();
            }

            @Override // androidx.recyclerview.widget.i
            public int i() {
                return this.f902a.z();
            }
        };
    }
}
