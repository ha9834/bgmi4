package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d extends m {
    int ad;
    int ae;
    int af;
    int ag;
    private l ao;
    private boolean an = false;
    protected androidx.constraintlayout.solver.e ac = new androidx.constraintlayout.solver.e();
    int ah = 0;
    int ai = 0;
    c[] aj = new c[4];
    c[] ak = new c[4];
    private int ap = 3;
    private boolean aq = false;
    private boolean ar = false;
    int al = 0;

    public boolean Q() {
        return false;
    }

    public void a(int i) {
        this.ap = i;
    }

    public int H() {
        return this.ap;
    }

    public boolean q(int i) {
        return (this.ap & i) == i;
    }

    @Override // androidx.constraintlayout.solver.widgets.m, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void f() {
        this.ac.b();
        this.ad = 0;
        this.af = 0;
        this.ae = 0;
        this.ag = 0;
        super.f();
    }

    public boolean I() {
        return this.aq;
    }

    public boolean J() {
        return this.ar;
    }

    public boolean d(androidx.constraintlayout.solver.e eVar) {
        a(eVar);
        int size = this.am.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.am.get(i);
            if (constraintWidget instanceof d) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.B[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.B[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.a(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.b(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.a(eVar);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.a(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.b(dimensionBehaviour2);
                }
            } else {
                g.a(this, eVar, constraintWidget);
                constraintWidget.a(eVar);
            }
        }
        if (this.ah > 0) {
            b.a(this, eVar, 0);
        }
        if (this.ai > 0) {
            b.a(this, eVar, 1);
        }
        return true;
    }

    public void a(androidx.constraintlayout.solver.e eVar, boolean[] zArr) {
        zArr[2] = false;
        c(eVar);
        int size = this.am.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.am.get(i);
            constraintWidget.c(eVar);
            if (constraintWidget.B[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.o() < constraintWidget.p()) {
                zArr[2] = true;
            }
            if (constraintWidget.B[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.q() < constraintWidget.r()) {
                zArr[2] = true;
            }
        }
    }

    public void a(boolean z) {
        this.an = z;
    }

    public boolean K() {
        return this.an;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void b(int i) {
        super.b(i);
        int size = this.am.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.am.get(i2).b(i);
        }
    }

    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v20 */
    @Override // androidx.constraintlayout.solver.widgets.m
    public void L() {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        ?? r12;
        int i2 = this.H;
        int i3 = this.I;
        char c = 0;
        int max = Math.max(0, o());
        int max2 = Math.max(0, q());
        this.aq = false;
        this.ar = false;
        if (this.C != null) {
            if (this.ao == null) {
                this.ao = new l(this);
            }
            this.ao.a(this);
            f(this.ad);
            g(this.ae);
            E();
            a(this.ac.g());
        } else {
            this.H = 0;
            this.I = 0;
        }
        if (this.ap != 0) {
            if (!q(8)) {
                O();
            }
            P();
            this.ac.c = true;
        } else {
            this.ac.c = false;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.B[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.B[0];
        T();
        int size = this.am.size();
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget = this.am.get(i4);
            if (constraintWidget instanceof m) {
                ((m) constraintWidget).L();
            }
        }
        int i5 = 0;
        boolean z4 = true;
        boolean z5 = false;
        while (z4) {
            int i6 = i5 + 1;
            try {
                this.ac.b();
                b(this.ac);
                for (int i7 = 0; i7 < size; i7++) {
                    this.am.get(i7).b(this.ac);
                }
                z4 = d(this.ac);
                if (z4) {
                    this.ac.f();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("EXCEPTION : " + e);
            }
            if (z4) {
                a(this.ac, g.f435a);
                i = 8;
            } else {
                c(this.ac);
                int i8 = 0;
                while (true) {
                    if (i8 >= size) {
                        i = 8;
                        break;
                    }
                    ConstraintWidget constraintWidget2 = this.am.get(i8);
                    if (constraintWidget2.B[c] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        z = true;
                    } else {
                        if (constraintWidget2.o() < constraintWidget2.p()) {
                            g.f435a[2] = true;
                            i = 8;
                            break;
                        }
                        z = true;
                    }
                    if (constraintWidget2.B[z ? 1 : 0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.q() < constraintWidget2.r()) {
                        g.f435a[2] = z;
                        i = 8;
                        break;
                    } else {
                        i8++;
                        c = 0;
                    }
                }
            }
            if (i6 >= i || !g.f435a[2]) {
                z2 = z5;
                z3 = false;
            } else {
                int i9 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    ConstraintWidget constraintWidget3 = this.am.get(i11);
                    i9 = Math.max(i9, constraintWidget3.H + constraintWidget3.o());
                    i10 = Math.max(i10, constraintWidget3.I + constraintWidget3.q());
                }
                int max3 = Math.max(this.M, i9);
                int max4 = Math.max(this.N, i10);
                if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || o() >= max3) {
                    z3 = false;
                } else {
                    h(max3);
                    this.B[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    z3 = true;
                    z5 = true;
                }
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || q() >= max4) {
                    z2 = z5;
                } else {
                    i(max4);
                    this.B[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    z3 = true;
                    z2 = true;
                }
            }
            int max5 = Math.max(this.M, o());
            if (max5 > o()) {
                h(max5);
                this.B[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                z3 = true;
                z2 = true;
            }
            int max6 = Math.max(this.N, q());
            if (max6 > q()) {
                i(max6);
                r12 = 1;
                this.B[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z3 = true;
                z2 = true;
            } else {
                r12 = 1;
            }
            if (z2) {
                z4 = z3;
                z5 = z2;
            } else {
                if (this.B[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && max > 0 && o() > max) {
                    this.aq = r12;
                    this.B[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    h(max);
                    z3 = true;
                    z2 = true;
                }
                if (this.B[r12] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || max2 <= 0 || q() <= max2) {
                    z4 = z3;
                    z5 = z2;
                } else {
                    this.ar = r12;
                    this.B[r12] = ConstraintWidget.DimensionBehaviour.FIXED;
                    i(max2);
                    z4 = true;
                    z5 = true;
                }
            }
            i5 = i6;
            c = 0;
        }
        if (this.C != null) {
            int max7 = Math.max(this.M, o());
            int max8 = Math.max(this.N, q());
            this.ao.b(this);
            h(max7 + this.ad + this.af);
            i(max8 + this.ae + this.ag);
        } else {
            this.H = i2;
            this.I = i3;
        }
        if (z5) {
            this.B[0] = dimensionBehaviour2;
            this.B[1] = dimensionBehaviour;
        }
        a(this.ac.g());
        if (this == R()) {
            D();
        }
    }

    public void M() {
        O();
        b(this.ap);
    }

    public void N() {
        i a2 = a(ConstraintAnchor.Type.LEFT).a();
        i a3 = a(ConstraintAnchor.Type.TOP).a();
        a2.a((i) null, 0.0f);
        a3.a((i) null, 0.0f);
    }

    public void e(int i, int i2) {
        if (this.B[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.c != null) {
            this.c.a(i);
        }
        if (this.B[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.d == null) {
            return;
        }
        this.d.a(i2);
    }

    public void O() {
        int size = this.am.size();
        b();
        for (int i = 0; i < size; i++) {
            this.am.get(i).b();
        }
    }

    public void P() {
        if (!q(8)) {
            b(this.ap);
        }
        N();
    }

    private void T() {
        this.ah = 0;
        this.ai = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            d(constraintWidget);
        } else if (i == 1) {
            e(constraintWidget);
        }
    }

    private void d(ConstraintWidget constraintWidget) {
        int i = this.ah + 1;
        c[] cVarArr = this.ak;
        if (i >= cVarArr.length) {
            this.ak = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.ak[this.ah] = new c(constraintWidget, 0, K());
        this.ah++;
    }

    private void e(ConstraintWidget constraintWidget) {
        int i = this.ai + 1;
        c[] cVarArr = this.aj;
        if (i >= cVarArr.length) {
            this.aj = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.aj[this.ai] = new c(constraintWidget, 1, K());
        this.ai++;
    }
}
