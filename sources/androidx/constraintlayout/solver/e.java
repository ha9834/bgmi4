package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class e {
    public static f g = null;
    private static int h = 1000;
    b[] b;
    public boolean c;
    int d;
    int e;
    final c f;
    private a j;
    private int l;
    private boolean[] m;
    private int n;
    private SolverVariable[] o;
    private int p;
    private b[] q;
    private final a r;

    /* renamed from: a, reason: collision with root package name */
    int f422a = 0;
    private HashMap<String, SolverVariable> i = null;
    private int k = 32;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        SolverVariable a(e eVar, boolean[] zArr);

        void a(a aVar);

        void d(SolverVariable solverVariable);

        void f();

        SolverVariable g();
    }

    public e() {
        int i = this.k;
        this.l = i;
        this.b = null;
        this.c = false;
        this.m = new boolean[i];
        this.d = 1;
        this.e = 0;
        this.n = i;
        this.o = new SolverVariable[h];
        this.p = 0;
        this.q = new b[i];
        this.b = new b[i];
        i();
        this.f = new c();
        this.j = new d(this.f);
        this.r = new b(this.f);
    }

    public static f a() {
        return g;
    }

    private void h() {
        this.k *= 2;
        this.b = (b[]) Arrays.copyOf(this.b, this.k);
        c cVar = this.f;
        cVar.c = (SolverVariable[]) Arrays.copyOf(cVar.c, this.k);
        int i = this.k;
        this.m = new boolean[i];
        this.l = i;
        this.n = i;
        f fVar = g;
        if (fVar != null) {
            fVar.d++;
            f fVar2 = g;
            fVar2.p = Math.max(fVar2.p, this.k);
            f fVar3 = g;
            fVar3.D = fVar3.p;
        }
    }

    private void i() {
        int i = 0;
        while (true) {
            b[] bVarArr = this.b;
            if (i >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i];
            if (bVar != null) {
                this.f.f421a.a(bVar);
            }
            this.b[i] = null;
            i++;
        }
    }

    public void b() {
        for (int i = 0; i < this.f.c.length; i++) {
            SolverVariable solverVariable = this.f.c[i];
            if (solverVariable != null) {
                solverVariable.b();
            }
        }
        this.f.b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.f.c, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f422a = 0;
        this.j.f();
        this.d = 1;
        for (int i2 = 0; i2 < this.e; i2++) {
            this.b[i2].c = false;
        }
        i();
        this.e = 0;
    }

    public SolverVariable a(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.d + 1 >= this.l) {
            h();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.b();
            if (solverVariable == null) {
                constraintAnchor.a(this.f);
                solverVariable = constraintAnchor.b();
            }
            if (solverVariable.f417a == -1 || solverVariable.f417a > this.f422a || this.f.c[solverVariable.f417a] == null) {
                if (solverVariable.f417a != -1) {
                    solverVariable.b();
                }
                this.f422a++;
                this.d++;
                solverVariable.f417a = this.f422a;
                solverVariable.f = SolverVariable.Type.UNRESTRICTED;
                this.f.c[this.f422a] = solverVariable;
            }
        }
        return solverVariable;
    }

    public b c() {
        b a2 = this.f.f421a.a();
        if (a2 == null) {
            a2 = new b(this.f);
        } else {
            a2.c();
        }
        SolverVariable.a();
        return a2;
    }

    public SolverVariable d() {
        f fVar = g;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.d + 1 >= this.l) {
            h();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        this.f422a++;
        this.d++;
        a2.f417a = this.f422a;
        this.f.c[this.f422a] = a2;
        return a2;
    }

    public SolverVariable e() {
        f fVar = g;
        if (fVar != null) {
            fVar.o++;
        }
        if (this.d + 1 >= this.l) {
            h();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        this.f422a++;
        this.d++;
        a2.f417a = this.f422a;
        this.f.c[this.f422a] = a2;
        return a2;
    }

    private void b(b bVar) {
        bVar.a(this, 0);
    }

    void a(b bVar, int i, int i2) {
        bVar.c(a(i2, (String) null), i);
    }

    public SolverVariable a(int i, String str) {
        f fVar = g;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.d + 1 >= this.l) {
            h();
        }
        SolverVariable a2 = a(SolverVariable.Type.ERROR, str);
        this.f422a++;
        this.d++;
        a2.f417a = this.f422a;
        a2.c = i;
        this.f.c[this.f422a] = a2;
        this.j.d(a2);
        return a2;
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable a2 = this.f.b.a();
        if (a2 == null) {
            a2 = new SolverVariable(type, str);
            a2.a(type, str);
        } else {
            a2.b();
            a2.a(type, str);
        }
        int i = this.p;
        int i2 = h;
        if (i >= i2) {
            h = i2 * 2;
            this.o = (SolverVariable[]) Arrays.copyOf(this.o, h);
        }
        SolverVariable[] solverVariableArr = this.o;
        int i3 = this.p;
        this.p = i3 + 1;
        solverVariableArr[i3] = a2;
        return a2;
    }

    public int b(Object obj) {
        SolverVariable b = ((ConstraintAnchor) obj).b();
        if (b != null) {
            return (int) (b.d + 0.5f);
        }
        return 0;
    }

    public void f() throws Exception {
        f fVar = g;
        if (fVar != null) {
            fVar.e++;
        }
        if (this.c) {
            f fVar2 = g;
            if (fVar2 != null) {
                fVar2.r++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.e) {
                    z = true;
                    break;
                } else if (!this.b[i].e) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                a(this.j);
                return;
            }
            f fVar3 = g;
            if (fVar3 != null) {
                fVar3.q++;
            }
            j();
            return;
        }
        a(this.j);
    }

    void a(a aVar) throws Exception {
        f fVar = g;
        if (fVar != null) {
            fVar.t++;
            f fVar2 = g;
            fVar2.u = Math.max(fVar2.u, this.d);
            f fVar3 = g;
            fVar3.v = Math.max(fVar3.v, this.e);
        }
        c((b) aVar);
        b(aVar);
        a(aVar, false);
        j();
    }

    private final void c(b bVar) {
        if (this.e > 0) {
            bVar.d.a(bVar, this.b);
            if (bVar.d.f419a == 0) {
                bVar.e = true;
            }
        }
    }

    public void a(b bVar) {
        SolverVariable b;
        if (bVar == null) {
            return;
        }
        f fVar = g;
        if (fVar != null) {
            fVar.f++;
            if (bVar.e) {
                g.g++;
            }
        }
        if (this.e + 1 >= this.n || this.d + 1 >= this.l) {
            h();
        }
        boolean z = false;
        if (!bVar.e) {
            c(bVar);
            if (bVar.e()) {
                return;
            }
            bVar.d();
            if (bVar.a(this)) {
                SolverVariable e = e();
                bVar.f420a = e;
                d(bVar);
                this.r.a(bVar);
                a(this.r, true);
                if (e.b == -1) {
                    if (bVar.f420a == e && (b = bVar.b(e)) != null) {
                        f fVar2 = g;
                        if (fVar2 != null) {
                            fVar2.j++;
                        }
                        bVar.c(b);
                    }
                    if (!bVar.e) {
                        bVar.f420a.c(bVar);
                    }
                    this.e--;
                }
                z = true;
            }
            if (!bVar.a()) {
                return;
            }
        }
        if (z) {
            return;
        }
        d(bVar);
    }

    private final void d(b bVar) {
        if (this.b[this.e] != null) {
            this.f.f421a.a(this.b[this.e]);
        }
        this.b[this.e] = bVar;
        SolverVariable solverVariable = bVar.f420a;
        int i = this.e;
        solverVariable.b = i;
        this.e = i + 1;
        bVar.f420a.c(bVar);
    }

    private final int a(a aVar, boolean z) {
        f fVar = g;
        if (fVar != null) {
            fVar.h++;
        }
        for (int i = 0; i < this.d; i++) {
            this.m[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            f fVar2 = g;
            if (fVar2 != null) {
                fVar2.i++;
            }
            i2++;
            if (i2 >= this.d * 2) {
                return i2;
            }
            if (aVar.g() != null) {
                this.m[aVar.g().f417a] = true;
            }
            SolverVariable a2 = aVar.a(this, this.m);
            if (a2 != null) {
                if (this.m[a2.f417a]) {
                    return i2;
                }
                this.m[a2.f417a] = true;
            }
            if (a2 != null) {
                int i3 = -1;
                float f = Float.MAX_VALUE;
                for (int i4 = 0; i4 < this.e; i4++) {
                    b bVar = this.b[i4];
                    if (bVar.f420a.f != SolverVariable.Type.UNRESTRICTED && !bVar.e && bVar.a(a2)) {
                        float b = bVar.d.b(a2);
                        if (b < 0.0f) {
                            float f2 = (-bVar.b) / b;
                            if (f2 < f) {
                                i3 = i4;
                                f = f2;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    b bVar2 = this.b[i3];
                    bVar2.f420a.b = -1;
                    f fVar3 = g;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.c(a2);
                    bVar2.f420a.b = i3;
                    bVar2.f420a.c(bVar2);
                } else {
                    z2 = true;
                }
            } else {
                z2 = true;
            }
        }
        return i2;
    }

    private int b(a aVar) throws Exception {
        float f;
        boolean z;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= this.e) {
                z = false;
                break;
            }
            if (this.b[i].f420a.f != SolverVariable.Type.UNRESTRICTED && this.b[i].b < 0.0f) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            f fVar = g;
            if (fVar != null) {
                fVar.k++;
            }
            i2++;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            float f2 = Float.MAX_VALUE;
            int i6 = 0;
            while (i3 < this.e) {
                b bVar = this.b[i3];
                if (bVar.f420a.f != SolverVariable.Type.UNRESTRICTED && !bVar.e && bVar.b < f) {
                    int i7 = 1;
                    while (i7 < this.d) {
                        SolverVariable solverVariable = this.f.c[i7];
                        float b = bVar.d.b(solverVariable);
                        if (b > f) {
                            int i8 = i6;
                            float f3 = f2;
                            int i9 = i5;
                            int i10 = i4;
                            for (int i11 = 0; i11 < 7; i11++) {
                                float f4 = solverVariable.e[i11] / b;
                                if ((f4 < f3 && i11 == i8) || i11 > i8) {
                                    i9 = i7;
                                    i10 = i3;
                                    f3 = f4;
                                    i8 = i11;
                                }
                            }
                            i4 = i10;
                            i5 = i9;
                            f2 = f3;
                            i6 = i8;
                        }
                        i7++;
                        f = 0.0f;
                    }
                }
                i3++;
                f = 0.0f;
            }
            if (i4 != -1) {
                b bVar2 = this.b[i4];
                bVar2.f420a.b = -1;
                f fVar2 = g;
                if (fVar2 != null) {
                    fVar2.j++;
                }
                bVar2.c(this.f.c[i5]);
                bVar2.f420a.b = i4;
                bVar2.f420a.c(bVar2);
            } else {
                z2 = true;
            }
            if (i2 > this.d / 2) {
                z2 = true;
            }
            f = 0.0f;
        }
        return i2;
    }

    private void j() {
        for (int i = 0; i < this.e; i++) {
            b bVar = this.b[i];
            bVar.f420a.d = bVar.b;
        }
    }

    public c g() {
        return this.f;
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b c = c();
        SolverVariable d = d();
        d.c = 0;
        c.a(solverVariable, solverVariable2, d, i);
        if (i2 != 6) {
            a(c, (int) (c.d.b(d) * (-1.0f)), i2);
        }
        a(c);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        b c = c();
        SolverVariable d = d();
        d.c = 0;
        c.a(solverVariable, solverVariable2, d, 0);
        if (z) {
            a(c, (int) (c.d.b(d) * (-1.0f)), 1);
        }
        a(c);
    }

    public void b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b c = c();
        SolverVariable d = d();
        d.c = 0;
        c.b(solverVariable, solverVariable2, d, i);
        if (i2 != 6) {
            a(c, (int) (c.d.b(d) * (-1.0f)), i2);
        }
        a(c);
    }

    public void b(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        b c = c();
        SolverVariable d = d();
        d.c = 0;
        c.b(solverVariable, solverVariable2, d, 0);
        if (z) {
            a(c, (int) (c.d.b(d) * (-1.0f)), 1);
        }
        a(c);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        b c = c();
        c.a(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i3 != 6) {
            c.a(this, i3);
        }
        a(c);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        b c = c();
        c.a(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 6) {
            c.a(this, i);
        }
        a(c);
    }

    public b c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b c = c();
        c.a(solverVariable, solverVariable2, i);
        if (i2 != 6) {
            c.a(this, i2);
        }
        a(c);
        return c;
    }

    public void a(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.b;
        if (solverVariable.b != -1) {
            b bVar = this.b[i2];
            if (bVar.e) {
                bVar.b = i;
                return;
            }
            if (bVar.d.f419a == 0) {
                bVar.e = true;
                bVar.b = i;
                return;
            } else {
                b c = c();
                c.b(solverVariable, i);
                a(c);
                return;
            }
        }
        b c2 = c();
        c2.a(solverVariable, i);
        a(c2);
    }

    public static b a(e eVar, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f, boolean z) {
        b c = eVar.c();
        if (z) {
            eVar.b(c);
        }
        return c.a(solverVariable, solverVariable2, solverVariable3, f);
    }

    public void a(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        SolverVariable a2 = a(constraintWidget.a(ConstraintAnchor.Type.LEFT));
        SolverVariable a3 = a(constraintWidget.a(ConstraintAnchor.Type.TOP));
        SolverVariable a4 = a(constraintWidget.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable a5 = a(constraintWidget.a(ConstraintAnchor.Type.BOTTOM));
        SolverVariable a6 = a(constraintWidget2.a(ConstraintAnchor.Type.LEFT));
        SolverVariable a7 = a(constraintWidget2.a(ConstraintAnchor.Type.TOP));
        SolverVariable a8 = a(constraintWidget2.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable a9 = a(constraintWidget2.a(ConstraintAnchor.Type.BOTTOM));
        b c = c();
        double d = f;
        double sin = Math.sin(d);
        double d2 = i;
        Double.isNaN(d2);
        c.b(a3, a5, a7, a9, (float) (sin * d2));
        a(c);
        b c2 = c();
        double cos = Math.cos(d);
        Double.isNaN(d2);
        c2.b(a2, a4, a6, a8, (float) (cos * d2));
        a(c2);
    }
}
