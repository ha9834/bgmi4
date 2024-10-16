package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class m extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> am = new ArrayList<>();

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void f() {
        this.am.clear();
        super.f();
    }

    public void b(ConstraintWidget constraintWidget) {
        this.am.add(constraintWidget);
        if (constraintWidget.j() != null) {
            ((m) constraintWidget.j()).c(constraintWidget);
        }
        constraintWidget.a((ConstraintWidget) this);
    }

    public void c(ConstraintWidget constraintWidget) {
        this.am.remove(constraintWidget);
        constraintWidget.a((ConstraintWidget) null);
    }

    public d R() {
        ConstraintWidget j = j();
        d dVar = this instanceof d ? (d) this : null;
        while (j != null) {
            ConstraintWidget j2 = j.j();
            if (j instanceof d) {
                dVar = (d) j;
                j = j2;
            } else {
                j = j2;
            }
        }
        return dVar;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void b(int i, int i2) {
        super.b(i, i2);
        int size = this.am.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.am.get(i3).b(u(), v());
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void D() {
        super.D();
        ArrayList<ConstraintWidget> arrayList = this.am;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.am.get(i);
            constraintWidget.b(s(), t());
            if (!(constraintWidget instanceof d)) {
                constraintWidget.D();
            }
        }
    }

    public void L() {
        D();
        ArrayList<ConstraintWidget> arrayList = this.am;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.am.get(i);
            if (constraintWidget instanceof m) {
                ((m) constraintWidget).L();
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void a(androidx.constraintlayout.solver.c cVar) {
        super.a(cVar);
        int size = this.am.size();
        for (int i = 0; i < size; i++) {
            this.am.get(i).a(cVar);
        }
    }

    public void S() {
        this.am.clear();
    }
}
