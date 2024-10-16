package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private int f438a;
    private int b;
    private int c;
    private int d;
    private ArrayList<a> e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private ConstraintAnchor f439a;
        private ConstraintAnchor b;
        private int c;
        private ConstraintAnchor.Strength d;
        private int e;

        public a(ConstraintAnchor constraintAnchor) {
            this.f439a = constraintAnchor;
            this.b = constraintAnchor.g();
            this.c = constraintAnchor.e();
            this.d = constraintAnchor.f();
            this.e = constraintAnchor.h();
        }

        public void a(ConstraintWidget constraintWidget) {
            this.f439a = constraintWidget.a(this.f439a.d());
            ConstraintAnchor constraintAnchor = this.f439a;
            if (constraintAnchor != null) {
                this.b = constraintAnchor.g();
                this.c = this.f439a.e();
                this.d = this.f439a.f();
                this.e = this.f439a.h();
                return;
            }
            this.b = null;
            this.c = 0;
            this.d = ConstraintAnchor.Strength.STRONG;
            this.e = 0;
        }

        public void b(ConstraintWidget constraintWidget) {
            constraintWidget.a(this.f439a.d()).a(this.b, this.c, this.d, this.e);
        }
    }

    public l(ConstraintWidget constraintWidget) {
        this.f438a = constraintWidget.m();
        this.b = constraintWidget.n();
        this.c = constraintWidget.o();
        this.d = constraintWidget.q();
        ArrayList<ConstraintAnchor> C = constraintWidget.C();
        int size = C.size();
        for (int i = 0; i < size; i++) {
            this.e.add(new a(C.get(i)));
        }
    }

    public void a(ConstraintWidget constraintWidget) {
        this.f438a = constraintWidget.m();
        this.b = constraintWidget.n();
        this.c = constraintWidget.o();
        this.d = constraintWidget.q();
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).a(constraintWidget);
        }
    }

    public void b(ConstraintWidget constraintWidget) {
        constraintWidget.f(this.f438a);
        constraintWidget.g(this.b);
        constraintWidget.h(this.c);
        constraintWidget.i(this.d);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).b(constraintWidget);
        }
    }
}
