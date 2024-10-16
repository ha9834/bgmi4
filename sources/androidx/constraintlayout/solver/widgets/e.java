package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class e extends ConstraintWidget {
    protected float ac = -1.0f;
    protected int ad = -1;
    protected int ae = -1;
    private ConstraintAnchor af = this.s;
    private int ag = 0;
    private boolean ah = false;
    private int ai = 0;
    private h aj = new h();
    private int ak = 8;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean a() {
        return true;
    }

    public e() {
        this.A.clear();
        this.A.add(this.af);
        int length = this.z.length;
        for (int i = 0; i < length; i++) {
            this.z[i] = this.af;
        }
    }

    public void a(int i) {
        if (this.ag == i) {
            return;
        }
        this.ag = i;
        this.A.clear();
        if (this.ag == 1) {
            this.af = this.r;
        } else {
            this.af = this.s;
        }
        this.A.add(this.af);
        int length = this.z.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.z[i2] = this.af;
        }
    }

    public int H() {
        return this.ag;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
            case RIGHT:
                if (this.ag == 1) {
                    return this.af;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.ag == 0) {
                    return this.af;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(type.name());
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ArrayList<ConstraintAnchor> C() {
        return this.A;
    }

    public void e(float f) {
        if (f > -1.0f) {
            this.ac = f;
            this.ad = -1;
            this.ae = -1;
        }
    }

    public void q(int i) {
        if (i > -1) {
            this.ac = -1.0f;
            this.ad = i;
            this.ae = -1;
        }
    }

    public void r(int i) {
        if (i > -1) {
            this.ac = -1.0f;
            this.ad = -1;
            this.ae = i;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void b(int i) {
        ConstraintWidget j = j();
        if (j == null) {
            return;
        }
        if (H() == 1) {
            this.s.a().a(1, j.s.a(), 0);
            this.u.a().a(1, j.s.a(), 0);
            if (this.ad != -1) {
                this.r.a().a(1, j.r.a(), this.ad);
                this.t.a().a(1, j.r.a(), this.ad);
                return;
            } else if (this.ae != -1) {
                this.r.a().a(1, j.t.a(), -this.ae);
                this.t.a().a(1, j.t.a(), -this.ae);
                return;
            } else {
                if (this.ac == -1.0f || j.F() != ConstraintWidget.DimensionBehaviour.FIXED) {
                    return;
                }
                int i2 = (int) (j.D * this.ac);
                this.r.a().a(1, j.r.a(), i2);
                this.t.a().a(1, j.r.a(), i2);
                return;
            }
        }
        this.r.a().a(1, j.r.a(), 0);
        this.t.a().a(1, j.r.a(), 0);
        if (this.ad != -1) {
            this.s.a().a(1, j.s.a(), this.ad);
            this.u.a().a(1, j.s.a(), this.ad);
        } else if (this.ae != -1) {
            this.s.a().a(1, j.u.a(), -this.ae);
            this.u.a().a(1, j.u.a(), -this.ae);
        } else {
            if (this.ac == -1.0f || j.G() != ConstraintWidget.DimensionBehaviour.FIXED) {
                return;
            }
            int i3 = (int) (j.E * this.ac);
            this.s.a().a(1, j.s.a(), i3);
            this.u.a().a(1, j.s.a(), i3);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void a(androidx.constraintlayout.solver.e eVar) {
        d dVar = (d) j();
        if (dVar == null) {
            return;
        }
        ConstraintAnchor a2 = dVar.a(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor a3 = dVar.a(ConstraintAnchor.Type.RIGHT);
        boolean z = this.C != null && this.C.B[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.ag == 0) {
            a2 = dVar.a(ConstraintAnchor.Type.TOP);
            a3 = dVar.a(ConstraintAnchor.Type.BOTTOM);
            z = this.C != null && this.C.B[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.ad != -1) {
            SolverVariable a4 = eVar.a(this.af);
            eVar.c(a4, eVar.a(a2), this.ad, 6);
            if (z) {
                eVar.a(eVar.a(a3), a4, 0, 5);
                return;
            }
            return;
        }
        if (this.ae == -1) {
            if (this.ac != -1.0f) {
                eVar.a(androidx.constraintlayout.solver.e.a(eVar, eVar.a(this.af), eVar.a(a2), eVar.a(a3), this.ac, this.ah));
                return;
            }
            return;
        }
        SolverVariable a5 = eVar.a(this.af);
        SolverVariable a6 = eVar.a(a3);
        eVar.c(a5, a6, -this.ae, 6);
        if (z) {
            eVar.a(a5, eVar.a(a2), 0, 5);
            eVar.a(a6, a5, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void c(androidx.constraintlayout.solver.e eVar) {
        if (j() == null) {
            return;
        }
        int b = eVar.b(this.af);
        if (this.ag == 1) {
            f(b);
            g(0);
            i(j().q());
            h(0);
            return;
        }
        f(0);
        g(b);
        h(j().o());
        i(0);
    }
}
