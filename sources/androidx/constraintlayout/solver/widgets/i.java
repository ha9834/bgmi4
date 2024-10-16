package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import com.facebook.internal.security.CertificateUtil;

/* loaded from: classes.dex */
public class i extends k {

    /* renamed from: a, reason: collision with root package name */
    ConstraintAnchor f436a;
    float b;
    i c;
    float d;
    i e;
    float f;
    private i j;
    private float k;
    int g = 0;
    private j l = null;
    private int m = 1;
    private j n = null;
    private int o = 1;

    String a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public i(ConstraintAnchor constraintAnchor) {
        this.f436a = constraintAnchor;
    }

    public String toString() {
        if (this.i == 1) {
            if (this.e == this) {
                return "[" + this.f436a + ", RESOLVED: " + this.f + "]  type: " + a(this.g);
            }
            return "[" + this.f436a + ", RESOLVED: " + this.e + CertificateUtil.DELIMITER + this.f + "] type: " + a(this.g);
        }
        return "{ " + this.f436a + " UNRESOLVED} type: " + a(this.g);
    }

    public void a(i iVar, float f) {
        if (this.i == 0 || !(this.e == iVar || this.f == f)) {
            this.e = iVar;
            this.f = f;
            if (this.i == 1) {
                e();
            }
            f();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.k
    public void a() {
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5;
        i iVar6;
        float f;
        float o;
        float f2;
        i iVar7;
        boolean z = true;
        if (this.i == 1 || this.g == 4) {
            return;
        }
        j jVar = this.l;
        if (jVar != null) {
            if (jVar.i != 1) {
                return;
            } else {
                this.d = this.m * this.l.f437a;
            }
        }
        j jVar2 = this.n;
        if (jVar2 != null) {
            if (jVar2.i != 1) {
                return;
            } else {
                this.k = this.o * this.n.f437a;
            }
        }
        if (this.g == 1 && ((iVar7 = this.c) == null || iVar7.i == 1)) {
            i iVar8 = this.c;
            if (iVar8 == null) {
                this.e = this;
                this.f = this.d;
            } else {
                this.e = iVar8.e;
                this.f = iVar8.f + this.d;
            }
            f();
            return;
        }
        if (this.g == 2 && (iVar4 = this.c) != null && iVar4.i == 1 && (iVar5 = this.j) != null && (iVar6 = iVar5.c) != null && iVar6.i == 1) {
            if (androidx.constraintlayout.solver.e.a() != null) {
                androidx.constraintlayout.solver.e.a().w++;
            }
            this.e = this.c.e;
            i iVar9 = this.j;
            iVar9.e = iVar9.c.e;
            int i = 0;
            if (this.f436a.b != ConstraintAnchor.Type.RIGHT && this.f436a.b != ConstraintAnchor.Type.BOTTOM) {
                z = false;
            }
            if (z) {
                f = this.c.f - this.j.c.f;
            } else {
                f = this.j.c.f - this.c.f;
            }
            if (this.f436a.b == ConstraintAnchor.Type.LEFT || this.f436a.b == ConstraintAnchor.Type.RIGHT) {
                o = f - this.f436a.f425a.o();
                f2 = this.f436a.f425a.P;
            } else {
                o = f - this.f436a.f425a.q();
                f2 = this.f436a.f425a.Q;
            }
            int e = this.f436a.e();
            int e2 = this.j.f436a.e();
            if (this.f436a.g() == this.j.f436a.g()) {
                f2 = 0.5f;
                e2 = 0;
            } else {
                i = e;
            }
            float f3 = i;
            float f4 = e2;
            float f5 = (o - f3) - f4;
            if (z) {
                i iVar10 = this.j;
                iVar10.f = iVar10.c.f + f4 + (f5 * f2);
                this.f = (this.c.f - f3) - (f5 * (1.0f - f2));
            } else {
                this.f = this.c.f + f3 + (f5 * f2);
                i iVar11 = this.j;
                iVar11.f = (iVar11.c.f - f4) - (f5 * (1.0f - f2));
            }
            f();
            this.j.f();
            return;
        }
        if (this.g == 3 && (iVar = this.c) != null && iVar.i == 1 && (iVar2 = this.j) != null && (iVar3 = iVar2.c) != null && iVar3.i == 1) {
            if (androidx.constraintlayout.solver.e.a() != null) {
                androidx.constraintlayout.solver.e.a().x++;
            }
            i iVar12 = this.c;
            this.e = iVar12.e;
            i iVar13 = this.j;
            i iVar14 = iVar13.c;
            iVar13.e = iVar14.e;
            this.f = iVar12.f + this.d;
            iVar13.f = iVar14.f + iVar13.d;
            f();
            this.j.f();
            return;
        }
        if (this.g == 5) {
            this.f436a.f425a.c();
        }
    }

    public void b(int i) {
        this.g = i;
    }

    @Override // androidx.constraintlayout.solver.widgets.k
    public void b() {
        super.b();
        this.c = null;
        this.d = 0.0f;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.e = null;
        this.f = 0.0f;
        this.b = 0.0f;
        this.j = null;
        this.k = 0.0f;
        this.g = 0;
    }

    public void c() {
        ConstraintAnchor g = this.f436a.g();
        if (g == null) {
            return;
        }
        if (g.g() == this.f436a) {
            this.g = 4;
            g.a().g = 4;
        }
        int e = this.f436a.e();
        if (this.f436a.b == ConstraintAnchor.Type.RIGHT || this.f436a.b == ConstraintAnchor.Type.BOTTOM) {
            e = -e;
        }
        a(g.a(), e);
    }

    public void a(int i, i iVar, int i2) {
        this.g = i;
        this.c = iVar;
        this.d = i2;
        this.c.a(this);
    }

    public void a(i iVar, int i) {
        this.c = iVar;
        this.d = i;
        this.c.a(this);
    }

    public void a(i iVar, int i, j jVar) {
        this.c = iVar;
        this.c.a(this);
        this.l = jVar;
        this.m = i;
        this.l.a(this);
    }

    public void b(i iVar, float f) {
        this.j = iVar;
        this.k = f;
    }

    public void b(i iVar, int i, j jVar) {
        this.j = iVar;
        this.n = jVar;
        this.o = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(androidx.constraintlayout.solver.e eVar) {
        SolverVariable b = this.f436a.b();
        i iVar = this.e;
        if (iVar == null) {
            eVar.a(b, (int) this.f);
        } else {
            eVar.c(b, eVar.a(iVar.f436a), (int) this.f, 6);
        }
    }

    public float d() {
        return this.f;
    }
}
