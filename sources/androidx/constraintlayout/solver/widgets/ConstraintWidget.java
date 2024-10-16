package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ConstraintWidget {
    public static float O = 0.5f;
    protected int M;
    protected int N;
    float P;
    float Q;
    boolean R;
    boolean S;
    int T;
    int U;
    boolean V;
    boolean W;
    float[] X;
    protected ConstraintWidget[] Y;
    protected ConstraintWidget[] Z;
    ConstraintWidget aa;
    ConstraintWidget ab;
    private int ai;
    private int aj;
    private Object ak;
    private int al;
    private int am;
    private String an;
    private String ao;
    j c;
    j d;
    boolean n;
    boolean o;

    /* renamed from: a, reason: collision with root package name */
    public int f430a = -1;
    public int b = -1;
    int e = 0;
    int f = 0;
    int[] g = new int[2];
    int h = 0;
    int i = 0;
    float j = 1.0f;
    int k = 0;
    int l = 0;
    float m = 1.0f;
    int p = -1;
    float q = 1.0f;
    private int[] ac = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float ad = 0.0f;
    ConstraintAnchor r = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    ConstraintAnchor s = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    ConstraintAnchor t = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor u = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor v = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor w = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor x = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    ConstraintAnchor y = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
    protected ConstraintAnchor[] z = {this.r, this.t, this.s, this.u, this.v, this.y};
    protected ArrayList<ConstraintAnchor> A = new ArrayList<>();
    protected DimensionBehaviour[] B = {DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
    ConstraintWidget C = null;
    int D = 0;
    int E = 0;
    protected float F = 0.0f;
    protected int G = -1;
    protected int H = 0;
    protected int I = 0;
    private int ae = 0;
    private int af = 0;
    private int ag = 0;
    private int ah = 0;
    protected int J = 0;
    protected int K = 0;
    int L = 0;

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void c() {
    }

    public void c(int i) {
        this.ac[0] = i;
    }

    public void d(int i) {
        this.ac[1] = i;
    }

    public boolean d() {
        return this.e == 0 && this.F == 0.0f && this.h == 0 && this.i == 0 && this.B[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean e() {
        return this.f == 0 && this.F == 0.0f && this.k == 0 && this.l == 0 && this.B[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void f() {
        this.r.i();
        this.s.i();
        this.t.i();
        this.u.i();
        this.v.i();
        this.w.i();
        this.x.i();
        this.y.i();
        this.C = null;
        this.ad = 0.0f;
        this.D = 0;
        this.E = 0;
        this.F = 0.0f;
        this.G = -1;
        this.H = 0;
        this.I = 0;
        this.ae = 0;
        this.af = 0;
        this.ag = 0;
        this.ah = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.ai = 0;
        this.aj = 0;
        float f = O;
        this.P = f;
        this.Q = f;
        this.B[0] = DimensionBehaviour.FIXED;
        this.B[1] = DimensionBehaviour.FIXED;
        this.ak = null;
        this.al = 0;
        this.am = 0;
        this.ao = null;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        float[] fArr = this.X;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f430a = -1;
        this.b = -1;
        int[] iArr = this.ac;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.e = 0;
        this.f = 0;
        this.j = 1.0f;
        this.m = 1.0f;
        this.i = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.h = 0;
        this.k = 0;
        this.p = -1;
        this.q = 1.0f;
        j jVar = this.c;
        if (jVar != null) {
            jVar.b();
        }
        j jVar2 = this.d;
        if (jVar2 != null) {
            jVar2.b();
        }
    }

    public void b() {
        for (int i = 0; i < 6; i++) {
            this.z[i].a().b();
        }
    }

    public void g() {
        for (int i = 0; i < 6; i++) {
            this.z[i].a().c();
        }
    }

    public void b(int i) {
        g.a(i, this);
    }

    public j h() {
        if (this.c == null) {
            this.c = new j();
        }
        return this.c;
    }

    public j i() {
        if (this.d == null) {
            this.d = new j();
        }
        return this.d;
    }

    public ConstraintWidget() {
        float f = O;
        this.P = f;
        this.Q = f;
        this.al = 0;
        this.am = 0;
        this.an = null;
        this.ao = null;
        this.T = 0;
        this.U = 0;
        this.X = new float[]{-1.0f, -1.0f};
        this.Y = new ConstraintWidget[]{null, null};
        this.Z = new ConstraintWidget[]{null, null};
        this.aa = null;
        this.ab = null;
        H();
    }

    public void a(androidx.constraintlayout.solver.c cVar) {
        this.r.a(cVar);
        this.s.a(cVar);
        this.t.a(cVar);
        this.u.a(cVar);
        this.v.a(cVar);
        this.y.a(cVar);
        this.w.a(cVar);
        this.x.a(cVar);
    }

    private void H() {
        this.A.add(this.r);
        this.A.add(this.s);
        this.A.add(this.t);
        this.A.add(this.u);
        this.A.add(this.w);
        this.A.add(this.x);
        this.A.add(this.y);
        this.A.add(this.v);
    }

    public ConstraintWidget j() {
        return this.C;
    }

    public void a(ConstraintWidget constraintWidget) {
        this.C = constraintWidget;
    }

    public void b(boolean z) {
        this.n = z;
    }

    public void c(boolean z) {
        this.o = z;
    }

    public void a(ConstraintWidget constraintWidget, float f, int i) {
        a(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.ad = f;
    }

    public void e(int i) {
        this.am = i;
    }

    public int k() {
        return this.am;
    }

    public String l() {
        return this.an;
    }

    public void a(String str) {
        this.an = str;
    }

    public void b(androidx.constraintlayout.solver.e eVar) {
        eVar.a(this.r);
        eVar.a(this.s);
        eVar.a(this.t);
        eVar.a(this.u);
        if (this.L > 0) {
            eVar.a(this.v);
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.ao != null) {
            str = "type: " + this.ao + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.an != null) {
            str2 = "id: " + this.an + " ";
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.H);
        sb.append(", ");
        sb.append(this.I);
        sb.append(") - (");
        sb.append(this.D);
        sb.append(" x ");
        sb.append(this.E);
        sb.append(") wrap: (");
        sb.append(this.ai);
        sb.append(" x ");
        sb.append(this.aj);
        sb.append(")");
        return sb.toString();
    }

    public int m() {
        return this.H;
    }

    public int n() {
        return this.I;
    }

    public int o() {
        if (this.am == 8) {
            return 0;
        }
        return this.D;
    }

    public int p() {
        return this.ai;
    }

    public int q() {
        if (this.am == 8) {
            return 0;
        }
        return this.E;
    }

    public int r() {
        return this.aj;
    }

    public int s() {
        return this.ae + this.J;
    }

    public int t() {
        return this.af + this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int u() {
        return this.H + this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int v() {
        return this.I + this.K;
    }

    public int w() {
        return m() + this.D;
    }

    public int x() {
        return n() + this.E;
    }

    public float y() {
        return this.P;
    }

    public boolean z() {
        return this.L > 0;
    }

    public int A() {
        return this.L;
    }

    public Object B() {
        return this.ak;
    }

    public ArrayList<ConstraintAnchor> C() {
        return this.A;
    }

    public void f(int i) {
        this.H = i;
    }

    public void g(int i) {
        this.I = i;
    }

    public void a(int i, int i2) {
        this.H = i;
        this.I = i2;
    }

    public void b(int i, int i2) {
        this.J = i;
        this.K = i2;
    }

    public void D() {
        int i = this.H;
        int i2 = this.I;
        int i3 = this.D + i;
        int i4 = this.E + i2;
        this.ae = i;
        this.af = i2;
        this.ag = i3 - i;
        this.ah = i4 - i2;
    }

    public void h(int i) {
        this.D = i;
        int i2 = this.D;
        int i3 = this.M;
        if (i2 < i3) {
            this.D = i3;
        }
    }

    public void i(int i) {
        this.E = i;
        int i2 = this.E;
        int i3 = this.N;
        if (i2 < i3) {
            this.E = i3;
        }
    }

    public void a(int i, int i2, int i3, float f) {
        this.e = i;
        this.h = i2;
        this.i = i3;
        this.j = f;
        if (f >= 1.0f || this.e != 0) {
            return;
        }
        this.e = 2;
    }

    public void b(int i, int i2, int i3, float f) {
        this.f = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        if (f >= 1.0f || this.f != 0) {
            return;
        }
        this.f = 2;
    }

    public void b(String str) {
        float parseFloat;
        if (str == null || str.length() == 0) {
            this.F = 0.0f;
            return;
        }
        int i = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i = 1;
            }
            i2 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 >= 0 && indexOf2 < length - 1) {
            String substring2 = str.substring(i2, indexOf2);
            String substring3 = str.substring(indexOf2 + 1);
            if (substring2.length() > 0 && substring3.length() > 0) {
                try {
                    float parseFloat2 = Float.parseFloat(substring2);
                    float parseFloat3 = Float.parseFloat(substring3);
                    if (parseFloat2 <= 0.0f || parseFloat3 <= 0.0f) {
                        parseFloat = 0.0f;
                    } else if (i == 1) {
                        parseFloat = Math.abs(parseFloat3 / parseFloat2);
                    } else {
                        parseFloat = Math.abs(parseFloat2 / parseFloat3);
                    }
                } catch (NumberFormatException unused) {
                }
            }
            parseFloat = 0.0f;
        } else {
            String substring4 = str.substring(i2);
            if (substring4.length() > 0) {
                try {
                    parseFloat = Float.parseFloat(substring4);
                } catch (NumberFormatException unused2) {
                }
            }
            parseFloat = 0.0f;
        }
        if (parseFloat > 0.0f) {
            this.F = parseFloat;
            this.G = i;
        }
    }

    public void a(float f) {
        this.P = f;
    }

    public void b(float f) {
        this.Q = f;
    }

    public void j(int i) {
        if (i < 0) {
            this.M = 0;
        } else {
            this.M = i;
        }
    }

    public void k(int i) {
        if (i < 0) {
            this.N = 0;
        } else {
            this.N = i;
        }
    }

    public void l(int i) {
        this.ai = i;
    }

    public void m(int i) {
        this.aj = i;
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.H = i;
        this.I = i2;
        if (this.am == 8) {
            this.D = 0;
            this.E = 0;
            return;
        }
        if (this.B[0] != DimensionBehaviour.FIXED || i7 >= (i5 = this.D)) {
            i5 = i7;
        }
        if (this.B[1] != DimensionBehaviour.FIXED || i8 >= (i6 = this.E)) {
            i6 = i8;
        }
        this.D = i5;
        this.E = i6;
        int i9 = this.E;
        int i10 = this.N;
        if (i9 < i10) {
            this.E = i10;
        }
        int i11 = this.D;
        int i12 = this.M;
        if (i11 < i12) {
            this.D = i12;
        }
    }

    public void c(int i, int i2) {
        this.H = i;
        this.D = i2 - i;
        int i3 = this.D;
        int i4 = this.M;
        if (i3 < i4) {
            this.D = i4;
        }
    }

    public void d(int i, int i2) {
        this.I = i;
        this.E = i2 - i;
        int i3 = this.E;
        int i4 = this.N;
        if (i3 < i4) {
            this.E = i4;
        }
    }

    public void n(int i) {
        this.L = i;
    }

    public void a(Object obj) {
        this.ak = obj;
    }

    public void c(float f) {
        this.X[0] = f;
    }

    public void d(float f) {
        this.X[1] = f;
    }

    public void o(int i) {
        this.T = i;
    }

    public void p(int i) {
        this.U = i;
    }

    public boolean a() {
        return this.am != 8;
    }

    public void a(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        a(type).a(constraintWidget.a(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public void E() {
        ConstraintWidget j = j();
        if (j != null && (j instanceof d) && ((d) j()).Q()) {
            return;
        }
        int size = this.A.size();
        for (int i = 0; i < size; i++) {
            this.A.get(i).i();
        }
    }

    public ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
                return this.r;
            case TOP:
                return this.s;
            case RIGHT:
                return this.t;
            case BOTTOM:
                return this.u;
            case BASELINE:
                return this.v;
            case CENTER:
                return this.y;
            case CENTER_X:
                return this.w;
            case CENTER_Y:
                return this.x;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour F() {
        return this.B[0];
    }

    public DimensionBehaviour G() {
        return this.B[1];
    }

    public void a(DimensionBehaviour dimensionBehaviour) {
        this.B[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            h(this.ai);
        }
    }

    public void b(DimensionBehaviour dimensionBehaviour) {
        this.B[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            i(this.aj);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x0233, code lost:
    
        if (r1 == (-1)) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(androidx.constraintlayout.solver.e r39) {
        /*
            Method dump skipped, instructions count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.a(androidx.constraintlayout.solver.e):void");
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.p == -1) {
            if (z3 && !z4) {
                this.p = 0;
            } else if (!z3 && z4) {
                this.p = 1;
                if (this.G == -1) {
                    this.q = 1.0f / this.q;
                }
            }
        }
        if (this.p == 0 && (!this.s.j() || !this.u.j())) {
            this.p = 1;
        } else if (this.p == 1 && (!this.r.j() || !this.t.j())) {
            this.p = 0;
        }
        if (this.p == -1 && (!this.s.j() || !this.u.j() || !this.r.j() || !this.t.j())) {
            if (this.s.j() && this.u.j()) {
                this.p = 0;
            } else if (this.r.j() && this.t.j()) {
                this.q = 1.0f / this.q;
                this.p = 1;
            }
        }
        if (this.p == -1) {
            if (z && !z2) {
                this.p = 0;
            } else if (!z && z2) {
                this.q = 1.0f / this.q;
                this.p = 1;
            }
        }
        if (this.p == -1) {
            if (this.h > 0 && this.k == 0) {
                this.p = 0;
            } else if (this.h == 0 && this.k > 0) {
                this.q = 1.0f / this.q;
                this.p = 1;
            }
        }
        if (this.p == -1 && z && z2) {
            this.q = 1.0f / this.q;
            this.p = 1;
        }
    }

    private void a(androidx.constraintlayout.solver.e eVar, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        SolverVariable solverVariable3;
        boolean z6;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        int i16;
        SolverVariable a2;
        SolverVariable a3;
        boolean z7;
        int i17;
        SolverVariable solverVariable6;
        int i18;
        SolverVariable solverVariable7;
        boolean z8;
        int i19;
        boolean z9;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        int i20;
        int i21;
        int i22;
        boolean z10;
        int i23;
        SolverVariable a4 = eVar.a(constraintAnchor);
        SolverVariable a5 = eVar.a(constraintAnchor2);
        SolverVariable a6 = eVar.a(constraintAnchor.g());
        SolverVariable a7 = eVar.a(constraintAnchor2.g());
        if (eVar.c && constraintAnchor.a().i == 1 && constraintAnchor2.a().i == 1) {
            if (androidx.constraintlayout.solver.e.a() != null) {
                androidx.constraintlayout.solver.e.a().s++;
            }
            constraintAnchor.a().a(eVar);
            constraintAnchor2.a().a(eVar);
            if (z4 || !z) {
                return;
            }
            eVar.a(solverVariable2, a5, 0, 6);
            return;
        }
        if (androidx.constraintlayout.solver.e.a() != null) {
            solverVariable3 = a7;
            androidx.constraintlayout.solver.e.a().B++;
        } else {
            solverVariable3 = a7;
        }
        boolean j = constraintAnchor.j();
        boolean j2 = constraintAnchor2.j();
        boolean j3 = this.y.j();
        int i24 = j ? 1 : 0;
        if (j2) {
            i24++;
        }
        if (j3) {
            i24++;
        }
        int i25 = i24;
        int i26 = z3 ? 3 : i5;
        switch (dimensionBehaviour) {
            case FIXED:
                z6 = false;
                break;
            case WRAP_CONTENT:
                z6 = false;
                break;
            case MATCH_PARENT:
                z6 = false;
                break;
            case MATCH_CONSTRAINT:
                if (i26 != 4) {
                    z6 = true;
                    break;
                } else {
                    z6 = false;
                    break;
                }
            default:
                z6 = false;
                break;
        }
        if (this.am == 8) {
            i8 = 0;
            z6 = false;
        } else {
            i8 = i2;
        }
        if (z5) {
            if (!j && !j2 && !j3) {
                eVar.a(a4, i);
            } else if (j && !j2) {
                eVar.c(a4, a6, constraintAnchor.e(), 6);
            }
        }
        if (z6) {
            if (i6 == -2) {
                i10 = i7;
                i9 = i8;
            } else {
                i9 = i6;
                i10 = i7;
            }
            if (i10 == -2) {
                i10 = i8;
            }
            if (i9 > 0) {
                if (z) {
                    i11 = 6;
                    eVar.a(a5, a4, i9, 6);
                } else {
                    i11 = 6;
                    eVar.a(a5, a4, i9, 6);
                }
                i8 = Math.max(i8, i9);
            } else {
                i11 = 6;
            }
            if (i10 > 0) {
                if (z) {
                    i12 = 1;
                    eVar.b(a5, a4, i10, 1);
                } else {
                    i12 = 1;
                    eVar.b(a5, a4, i10, i11);
                }
                i8 = Math.min(i8, i10);
            } else {
                i12 = 1;
            }
            if (i26 == i12) {
                if (z) {
                    eVar.c(a5, a4, i8, i11);
                    i13 = i26;
                    i14 = i10;
                    i15 = i25;
                    solverVariable4 = a6;
                    solverVariable5 = solverVariable3;
                    i16 = i8;
                } else if (z4) {
                    eVar.c(a5, a4, i8, 4);
                    i13 = i26;
                    i14 = i10;
                    i15 = i25;
                    solverVariable4 = a6;
                    solverVariable5 = solverVariable3;
                    i16 = i8;
                } else {
                    eVar.c(a5, a4, i8, i12);
                    i13 = i26;
                    i14 = i10;
                    i15 = i25;
                    solverVariable4 = a6;
                    solverVariable5 = solverVariable3;
                    i16 = i8;
                }
            } else if (i26 == 2) {
                if (constraintAnchor.d() == ConstraintAnchor.Type.TOP || constraintAnchor.d() == ConstraintAnchor.Type.BOTTOM) {
                    a2 = eVar.a(this.C.a(ConstraintAnchor.Type.TOP));
                    a3 = eVar.a(this.C.a(ConstraintAnchor.Type.BOTTOM));
                } else {
                    a2 = eVar.a(this.C.a(ConstraintAnchor.Type.LEFT));
                    a3 = eVar.a(this.C.a(ConstraintAnchor.Type.RIGHT));
                }
                i14 = i10;
                solverVariable4 = a6;
                i16 = i8;
                i13 = i26;
                i15 = i25;
                solverVariable5 = solverVariable3;
                eVar.a(eVar.c().a(a5, a4, a3, a2, f2));
                z7 = false;
                if (z7 || i15 == 2 || z3) {
                    z6 = z7;
                } else {
                    int max = Math.max(i9, i16);
                    if (i14 > 0) {
                        max = Math.min(i14, max);
                        i17 = 6;
                    } else {
                        i17 = 6;
                    }
                    eVar.c(a5, a4, max, i17);
                    z6 = false;
                }
            } else {
                i13 = i26;
                i14 = i10;
                i15 = i25;
                solverVariable4 = a6;
                solverVariable5 = solverVariable3;
                i16 = i8;
            }
            z7 = z6;
            if (z7) {
            }
            z6 = z7;
        } else {
            if (z2) {
                eVar.c(a5, a4, 0, 3);
                if (i3 > 0) {
                    i23 = 6;
                    eVar.a(a5, a4, i3, 6);
                } else {
                    i23 = 6;
                }
                if (i4 < Integer.MAX_VALUE) {
                    eVar.b(a5, a4, i4, i23);
                }
            } else {
                eVar.c(a5, a4, i8, 6);
            }
            i9 = i6;
            i14 = i7;
            i13 = i26;
            i15 = i25;
            solverVariable4 = a6;
            solverVariable5 = solverVariable3;
        }
        if (!z5 || z4) {
            if (i15 >= 2 || !z) {
                return;
            }
            eVar.a(a4, solverVariable, 0, 6);
            eVar.a(solverVariable2, a5, 0, 6);
            return;
        }
        if (j || j2 || j3) {
            if (!j || j2) {
                if (j || !j2) {
                    SolverVariable solverVariable10 = solverVariable5;
                    if (j && j2) {
                        if (z6) {
                            if (z && i3 == 0) {
                                eVar.a(a5, a4, 0, 6);
                            }
                            if (i13 == 0) {
                                if (i14 > 0 || i9 > 0) {
                                    i22 = 4;
                                    z10 = true;
                                } else {
                                    i22 = 6;
                                    z10 = false;
                                }
                                solverVariable7 = solverVariable4;
                                eVar.c(a4, solverVariable7, constraintAnchor.e(), i22);
                                eVar.c(a5, solverVariable10, -constraintAnchor2.e(), i22);
                                z9 = z10;
                                z8 = i14 > 0 || i9 > 0;
                                i19 = 5;
                            } else {
                                int i27 = i13;
                                solverVariable7 = solverVariable4;
                                z8 = true;
                                if (i27 == 1) {
                                    i19 = 6;
                                    z9 = true;
                                } else if (i27 == 3) {
                                    if (!z3 && this.p != -1 && i14 <= 0) {
                                        i21 = 6;
                                        eVar.c(a4, solverVariable7, constraintAnchor.e(), i21);
                                        eVar.c(a5, solverVariable10, -constraintAnchor2.e(), i21);
                                        i19 = 5;
                                        z9 = true;
                                    }
                                    i21 = 4;
                                    eVar.c(a4, solverVariable7, constraintAnchor.e(), i21);
                                    eVar.c(a5, solverVariable10, -constraintAnchor2.e(), i21);
                                    i19 = 5;
                                    z9 = true;
                                } else {
                                    i19 = 5;
                                    z8 = false;
                                    z9 = false;
                                }
                            }
                        } else {
                            solverVariable7 = solverVariable4;
                            z8 = true;
                            if (z) {
                                eVar.a(a4, solverVariable7, constraintAnchor.e(), 5);
                                eVar.b(a5, solverVariable10, -constraintAnchor2.e(), 5);
                            }
                            i19 = 5;
                            z9 = false;
                        }
                        if (z8) {
                            solverVariable8 = solverVariable7;
                            i20 = 6;
                            solverVariable9 = a5;
                            eVar.a(a4, solverVariable7, constraintAnchor.e(), f, solverVariable10, a5, constraintAnchor2.e(), i19);
                        } else {
                            solverVariable8 = solverVariable7;
                            solverVariable9 = a5;
                            i20 = 6;
                        }
                        if (z9) {
                            eVar.a(a4, solverVariable8, constraintAnchor.e(), i20);
                            solverVariable6 = solverVariable9;
                            eVar.b(solverVariable6, solverVariable10, -constraintAnchor2.e(), i20);
                        } else {
                            solverVariable6 = solverVariable9;
                        }
                        if (z) {
                            i18 = 0;
                            eVar.a(a4, solverVariable, 0, i20);
                        } else {
                            i18 = 0;
                        }
                    } else {
                        solverVariable6 = a5;
                        i18 = 0;
                    }
                } else {
                    eVar.c(a5, solverVariable5, -constraintAnchor2.e(), 6);
                    if (z) {
                        eVar.a(a4, solverVariable, 0, 5);
                        solverVariable6 = a5;
                        i18 = 0;
                    } else {
                        solverVariable6 = a5;
                        i18 = 0;
                    }
                }
            } else if (z) {
                eVar.a(solverVariable2, a5, 0, 5);
                solverVariable6 = a5;
                i18 = 0;
            } else {
                solverVariable6 = a5;
                i18 = 0;
            }
        } else if (z) {
            eVar.a(solverVariable2, a5, 0, 5);
            solverVariable6 = a5;
            i18 = 0;
        } else {
            solverVariable6 = a5;
            i18 = 0;
        }
        if (z) {
            eVar.a(solverVariable2, solverVariable6, i18, 6);
        }
    }

    public void c(androidx.constraintlayout.solver.e eVar) {
        int b = eVar.b(this.r);
        int b2 = eVar.b(this.s);
        int b3 = eVar.b(this.t);
        int b4 = eVar.b(this.u);
        int i = b4 - b2;
        if (b3 - b < 0 || i < 0 || b == Integer.MIN_VALUE || b == Integer.MAX_VALUE || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE) {
            b4 = 0;
            b = 0;
            b2 = 0;
            b3 = 0;
        }
        a(b, b2, b3, b4);
    }
}
