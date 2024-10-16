package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class j extends k {

    /* renamed from: a, reason: collision with root package name */
    float f437a = 0.0f;

    @Override // androidx.constraintlayout.solver.widgets.k
    public void b() {
        super.b();
        this.f437a = 0.0f;
    }

    public void a(int i) {
        if (this.i == 0 || this.f437a != i) {
            this.f437a = i;
            if (this.i == 1) {
                e();
            }
            f();
        }
    }

    public void c() {
        this.i = 2;
    }
}
