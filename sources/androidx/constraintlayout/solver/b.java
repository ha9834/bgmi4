package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.e;
import com.facebook.appevents.UserDataStore;

/* loaded from: classes.dex */
public class b implements e.a {
    public final a d;

    /* renamed from: a, reason: collision with root package name */
    SolverVariable f420a = null;
    float b = 0.0f;
    boolean c = false;
    boolean e = false;

    public b(c cVar) {
        this.d = new a(this, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        SolverVariable solverVariable = this.f420a;
        return solverVariable != null && (solverVariable.f == SolverVariable.Type.UNRESTRICTED || this.b >= 0.0f);
    }

    public String toString() {
        return b();
    }

    String b() {
        boolean z;
        String str = (this.f420a == null ? "0" : "" + this.f420a) + " = ";
        if (this.b != 0.0f) {
            str = str + this.b;
            z = true;
        } else {
            z = false;
        }
        int i = this.d.f419a;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable a2 = this.d.a(i2);
            if (a2 != null) {
                float b = this.d.b(i2);
                if (b != 0.0f) {
                    String solverVariable = a2.toString();
                    if (z) {
                        if (b > 0.0f) {
                            str = str + " + ";
                        } else {
                            str = str + " - ";
                            b *= -1.0f;
                        }
                    } else if (b < 0.0f) {
                        str = str + "- ";
                        b *= -1.0f;
                    }
                    str = b == 1.0f ? str + solverVariable : str + b + " " + solverVariable;
                    z = true;
                }
            }
        }
        if (z) {
            return str;
        }
        return str + "0.0";
    }

    public void c() {
        this.f420a = null;
        this.d.a();
        this.b = 0.0f;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SolverVariable solverVariable) {
        return this.d.a(solverVariable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(SolverVariable solverVariable, int i) {
        this.f420a = solverVariable;
        float f = i;
        solverVariable.d = f;
        this.b = f;
        this.e = true;
        return this;
    }

    public b b(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.b = i * (-1);
            this.d.a(solverVariable, 1.0f);
        } else {
            this.b = i;
            this.d.a(solverVariable, -1.0f);
        }
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (!z) {
            this.d.a(solverVariable, -1.0f);
            this.d.a(solverVariable2, 1.0f);
        } else {
            this.d.a(solverVariable, 1.0f);
            this.d.a(solverVariable2, -1.0f);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b c(SolverVariable solverVariable, int i) {
        this.d.a(solverVariable, i);
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (!z) {
            this.d.a(solverVariable, -1.0f);
            this.d.a(solverVariable2, 1.0f);
            this.d.a(solverVariable3, 1.0f);
        } else {
            this.d.a(solverVariable, 1.0f);
            this.d.a(solverVariable2, -1.0f);
            this.d.a(solverVariable3, -1.0f);
        }
        return this;
    }

    public b b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (!z) {
            this.d.a(solverVariable, -1.0f);
            this.d.a(solverVariable2, 1.0f);
            this.d.a(solverVariable3, -1.0f);
        } else {
            this.d.a(solverVariable, 1.0f);
            this.d.a(solverVariable2, -1.0f);
            this.d.a(solverVariable3, 1.0f);
        }
        return this;
    }

    public b a(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.d.a(solverVariable, 1.0f);
            this.d.a(solverVariable2, -1.0f);
            this.d.a(solverVariable4, 1.0f);
            this.d.a(solverVariable3, -1.0f);
        } else if (f == 0.0f) {
            this.d.a(solverVariable, 1.0f);
            this.d.a(solverVariable2, -1.0f);
        } else if (f3 == 0.0f) {
            this.d.a(solverVariable3, 1.0f);
            this.d.a(solverVariable4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.d.a(solverVariable, 1.0f);
            this.d.a(solverVariable2, -1.0f);
            this.d.a(solverVariable4, f4);
            this.d.a(solverVariable3, -f4);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.d.a(solverVariable, 1.0f);
            this.d.a(solverVariable4, 1.0f);
            this.d.a(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.d.a(solverVariable, 1.0f);
            this.d.a(solverVariable2, -1.0f);
            this.d.a(solverVariable3, -1.0f);
            this.d.a(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            this.d.a(solverVariable, -1.0f);
            this.d.a(solverVariable2, 1.0f);
            this.b = i;
        } else if (f >= 1.0f) {
            this.d.a(solverVariable3, -1.0f);
            this.d.a(solverVariable4, 1.0f);
            this.b = i2;
        } else {
            float f2 = 1.0f - f;
            this.d.a(solverVariable, f2 * 1.0f);
            this.d.a(solverVariable2, f2 * (-1.0f));
            this.d.a(solverVariable3, (-1.0f) * f);
            this.d.a(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.b = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    public b a(e eVar, int i) {
        this.d.a(eVar.a(i, "ep"), 1.0f);
        this.d.a(eVar.a(i, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f) {
        this.d.a(solverVariable, -1.0f);
        this.d.a(solverVariable2, 1.0f - f);
        this.d.a(solverVariable3, f);
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.d.a(solverVariable, -1.0f);
        this.d.a(solverVariable2, 1.0f);
        this.d.a(solverVariable3, f);
        this.d.a(solverVariable4, -f);
        return this;
    }

    public b b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.d.a(solverVariable3, 0.5f);
        this.d.a(solverVariable4, 0.5f);
        this.d.a(solverVariable, -0.5f);
        this.d.a(solverVariable2, -0.5f);
        this.b = -f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        float f = this.b;
        if (f < 0.0f) {
            this.b = f * (-1.0f);
            this.d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(e eVar) {
        boolean z;
        SolverVariable a2 = this.d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            c(a2);
            z = false;
        }
        if (this.d.f419a == 0) {
            this.e = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolverVariable b(SolverVariable solverVariable) {
        return this.d.a((boolean[]) null, solverVariable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f420a;
        if (solverVariable2 != null) {
            this.d.a(solverVariable2, -1.0f);
            this.f420a = null;
        }
        float a2 = this.d.a(solverVariable, true) * (-1.0f);
        this.f420a = solverVariable;
        if (a2 == 1.0f) {
            return;
        }
        this.b /= a2;
        this.d.a(a2);
    }

    public boolean e() {
        return this.f420a == null && this.b == 0.0f && this.d.f419a == 0;
    }

    @Override // androidx.constraintlayout.solver.e.a
    public SolverVariable a(e eVar, boolean[] zArr) {
        return this.d.a(zArr, (SolverVariable) null);
    }

    @Override // androidx.constraintlayout.solver.e.a
    public void f() {
        this.d.a();
        this.f420a = null;
        this.b = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.e.a
    public void a(e.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f420a = null;
            this.d.a();
            for (int i = 0; i < bVar.d.f419a; i++) {
                this.d.a(bVar.d.a(i), bVar.d.b(i), true);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.e.a
    public void d(SolverVariable solverVariable) {
        float f = 1.0f;
        if (solverVariable.c != 1) {
            if (solverVariable.c == 2) {
                f = 1000.0f;
            } else if (solverVariable.c == 3) {
                f = 1000000.0f;
            } else if (solverVariable.c == 4) {
                f = 1.0E9f;
            } else if (solverVariable.c == 5) {
                f = 1.0E12f;
            }
        }
        this.d.a(solverVariable, f);
    }

    @Override // androidx.constraintlayout.solver.e.a
    public SolverVariable g() {
        return this.f420a;
    }
}
