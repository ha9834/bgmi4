package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a extends f {
    private int ae = 0;
    private ArrayList<i> af = new ArrayList<>(4);
    private boolean ag = true;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean a() {
        return true;
    }

    public void a(int i) {
        this.ae = i;
    }

    public void a(boolean z) {
        this.ag = z;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void b() {
        super.b();
        this.af.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void b(int i) {
        i a2;
        i a3;
        if (this.C != null && ((d) this.C).q(2)) {
            switch (this.ae) {
                case 0:
                    a2 = this.r.a();
                    break;
                case 1:
                    a2 = this.t.a();
                    break;
                case 2:
                    a2 = this.s.a();
                    break;
                case 3:
                    a2 = this.u.a();
                    break;
                default:
                    return;
            }
            a2.b(5);
            int i2 = this.ae;
            if (i2 == 0 || i2 == 1) {
                this.s.a().a((i) null, 0.0f);
                this.u.a().a((i) null, 0.0f);
            } else {
                this.r.a().a((i) null, 0.0f);
                this.t.a().a((i) null, 0.0f);
            }
            this.af.clear();
            for (int i3 = 0; i3 < this.ad; i3++) {
                ConstraintWidget constraintWidget = this.ac[i3];
                if (this.ag || constraintWidget.a()) {
                    switch (this.ae) {
                        case 0:
                            a3 = constraintWidget.r.a();
                            break;
                        case 1:
                            a3 = constraintWidget.t.a();
                            break;
                        case 2:
                            a3 = constraintWidget.s.a();
                            break;
                        case 3:
                            a3 = constraintWidget.u.a();
                            break;
                        default:
                            a3 = null;
                            break;
                    }
                    if (a3 != null) {
                        this.af.add(a3);
                        a3.a(a2);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void c() {
        i a2;
        float f = Float.MAX_VALUE;
        switch (this.ae) {
            case 0:
                a2 = this.r.a();
                break;
            case 1:
                a2 = this.t.a();
                f = 0.0f;
                break;
            case 2:
                a2 = this.s.a();
                break;
            case 3:
                a2 = this.u.a();
                f = 0.0f;
                break;
            default:
                return;
        }
        int size = this.af.size();
        i iVar = null;
        for (int i = 0; i < size; i++) {
            i iVar2 = this.af.get(i);
            if (iVar2.i != 1) {
                return;
            }
            int i2 = this.ae;
            if (i2 == 0 || i2 == 2) {
                if (iVar2.f < f) {
                    f = iVar2.f;
                    iVar = iVar2.e;
                }
            } else if (iVar2.f > f) {
                f = iVar2.f;
                iVar = iVar2.e;
            }
        }
        if (androidx.constraintlayout.solver.e.a() != null) {
            androidx.constraintlayout.solver.e.a().z++;
        }
        a2.e = iVar;
        a2.f = f;
        a2.f();
        switch (this.ae) {
            case 0:
                this.t.a().a(iVar, f);
                return;
            case 1:
                this.r.a().a(iVar, f);
                return;
            case 2:
                this.u.a().a(iVar, f);
                return;
            case 3:
                this.s.a().a(iVar, f);
                return;
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void a(androidx.constraintlayout.solver.e eVar) {
        boolean z;
        this.z[0] = this.r;
        this.z[2] = this.s;
        this.z[1] = this.t;
        this.z[3] = this.u;
        for (int i = 0; i < this.z.length; i++) {
            this.z[i].f = eVar.a(this.z[i]);
        }
        int i2 = this.ae;
        if (i2 < 0 || i2 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.z[this.ae];
        int i3 = 0;
        while (true) {
            if (i3 >= this.ad) {
                z = false;
                break;
            }
            ConstraintWidget constraintWidget = this.ac[i3];
            if (this.ag || constraintWidget.a()) {
                int i4 = this.ae;
                if ((i4 != 0 && i4 != 1) || constraintWidget.F() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    int i5 = this.ae;
                    if ((i5 == 2 || i5 == 3) && constraintWidget.G() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        z = true;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            i3++;
        }
        int i6 = this.ae;
        if (i6 == 0 || i6 == 1) {
            if (j().F() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z = false;
            }
        } else if (j().G() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z = false;
        }
        for (int i7 = 0; i7 < this.ad; i7++) {
            ConstraintWidget constraintWidget2 = this.ac[i7];
            if (this.ag || constraintWidget2.a()) {
                SolverVariable a2 = eVar.a(constraintWidget2.z[this.ae]);
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.z;
                int i8 = this.ae;
                constraintAnchorArr[i8].f = a2;
                if (i8 == 0 || i8 == 2) {
                    eVar.b(constraintAnchor.f, a2, z);
                } else {
                    eVar.a(constraintAnchor.f, a2, z);
                }
            }
        }
        int i9 = this.ae;
        if (i9 == 0) {
            eVar.c(this.t.f, this.r.f, 0, 6);
            if (z) {
                return;
            }
            eVar.c(this.r.f, this.C.t.f, 0, 5);
            return;
        }
        if (i9 == 1) {
            eVar.c(this.r.f, this.t.f, 0, 6);
            if (z) {
                return;
            }
            eVar.c(this.r.f, this.C.r.f, 0, 5);
            return;
        }
        if (i9 == 2) {
            eVar.c(this.u.f, this.s.f, 0, 6);
            if (z) {
                return;
            }
            eVar.c(this.s.f, this.C.u.f, 0, 5);
            return;
        }
        if (i9 == 3) {
            eVar.c(this.s.f, this.u.f, 0, 6);
            if (z) {
                return;
            }
            eVar.c(this.s.f, this.C.s.f, 0, 5);
        }
    }
}
