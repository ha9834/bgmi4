package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a {
    private final b b;
    private final c c;
    private int[] f;
    private int[] g;
    private float[] h;
    private int i;
    private int j;
    private boolean k;

    /* renamed from: a, reason: collision with root package name */
    int f419a = 0;
    private int d = 8;
    private SolverVariable e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        int i = this.d;
        this.f = new int[i];
        this.g = new int[i];
        this.h = new float[i];
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.b = bVar;
        this.c = cVar;
    }

    public final void a(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            a(solverVariable, true);
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            float[] fArr = this.h;
            int i2 = this.i;
            fArr[i2] = f;
            this.f[i2] = solverVariable.f417a;
            this.g[this.i] = -1;
            solverVariable.i++;
            solverVariable.a(this.b);
            this.f419a++;
            if (this.k) {
                return;
            }
            this.j++;
            int i3 = this.j;
            int[] iArr = this.f;
            if (i3 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.f419a; i5++) {
            if (this.f[i] == solverVariable.f417a) {
                this.h[i] = f;
                return;
            }
            if (this.f[i] < solverVariable.f417a) {
                i4 = i;
            }
            i = this.g[i];
        }
        int i6 = this.j;
        int i7 = i6 + 1;
        if (this.k) {
            int[] iArr2 = this.f;
            if (iArr2[i6] != -1) {
                i6 = iArr2.length;
            }
        } else {
            i6 = i7;
        }
        int[] iArr3 = this.f;
        if (i6 >= iArr3.length && this.f419a < iArr3.length) {
            int i8 = 0;
            while (true) {
                int[] iArr4 = this.f;
                if (i8 >= iArr4.length) {
                    break;
                }
                if (iArr4[i8] == -1) {
                    i6 = i8;
                    break;
                }
                i8++;
            }
        }
        int[] iArr5 = this.f;
        if (i6 >= iArr5.length) {
            i6 = iArr5.length;
            this.d *= 2;
            this.k = false;
            this.j = i6 - 1;
            this.h = Arrays.copyOf(this.h, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[i6] = solverVariable.f417a;
        this.h[i6] = f;
        if (i4 != -1) {
            int[] iArr6 = this.g;
            iArr6[i6] = iArr6[i4];
            iArr6[i4] = i6;
        } else {
            this.g[i6] = this.i;
            this.i = i6;
        }
        solverVariable.i++;
        solverVariable.a(this.b);
        this.f419a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f419a >= this.f.length) {
            this.k = true;
        }
        int i9 = this.j;
        int[] iArr7 = this.f;
        if (i9 >= iArr7.length) {
            this.k = true;
            this.j = iArr7.length - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(SolverVariable solverVariable, float f, boolean z) {
        if (f == 0.0f) {
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            float[] fArr = this.h;
            int i2 = this.i;
            fArr[i2] = f;
            this.f[i2] = solverVariable.f417a;
            this.g[this.i] = -1;
            solverVariable.i++;
            solverVariable.a(this.b);
            this.f419a++;
            if (this.k) {
                return;
            }
            this.j++;
            int i3 = this.j;
            int[] iArr = this.f;
            if (i3 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.f419a; i5++) {
            if (this.f[i] == solverVariable.f417a) {
                float[] fArr2 = this.h;
                fArr2[i] = fArr2[i] + f;
                if (fArr2[i] == 0.0f) {
                    if (i == this.i) {
                        this.i = this.g[i];
                    } else {
                        int[] iArr2 = this.g;
                        iArr2[i4] = iArr2[i];
                    }
                    if (z) {
                        solverVariable.b(this.b);
                    }
                    if (this.k) {
                        this.j = i;
                    }
                    solverVariable.i--;
                    this.f419a--;
                    return;
                }
                return;
            }
            if (this.f[i] < solverVariable.f417a) {
                i4 = i;
            }
            i = this.g[i];
        }
        int i6 = this.j;
        int i7 = i6 + 1;
        if (this.k) {
            int[] iArr3 = this.f;
            if (iArr3[i6] != -1) {
                i6 = iArr3.length;
            }
        } else {
            i6 = i7;
        }
        int[] iArr4 = this.f;
        if (i6 >= iArr4.length && this.f419a < iArr4.length) {
            int i8 = 0;
            while (true) {
                int[] iArr5 = this.f;
                if (i8 >= iArr5.length) {
                    break;
                }
                if (iArr5[i8] == -1) {
                    i6 = i8;
                    break;
                }
                i8++;
            }
        }
        int[] iArr6 = this.f;
        if (i6 >= iArr6.length) {
            i6 = iArr6.length;
            this.d *= 2;
            this.k = false;
            this.j = i6 - 1;
            this.h = Arrays.copyOf(this.h, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[i6] = solverVariable.f417a;
        this.h[i6] = f;
        if (i4 != -1) {
            int[] iArr7 = this.g;
            iArr7[i6] = iArr7[i4];
            iArr7[i4] = i6;
        } else {
            this.g[i6] = this.i;
            this.i = i6;
        }
        solverVariable.i++;
        solverVariable.a(this.b);
        this.f419a++;
        if (!this.k) {
            this.j++;
        }
        int i9 = this.j;
        int[] iArr8 = this.f;
        if (i9 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    public final float a(SolverVariable solverVariable, boolean z) {
        if (this.e == solverVariable) {
            this.e = null;
        }
        int i = this.i;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f419a) {
            if (this.f[i] == solverVariable.f417a) {
                if (i == this.i) {
                    this.i = this.g[i];
                } else {
                    int[] iArr = this.g;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    solverVariable.b(this.b);
                }
                solverVariable.i--;
                this.f419a--;
                this.f[i] = -1;
                if (this.k) {
                    this.j = i;
                }
                return this.h[i];
            }
            i2++;
            i3 = i;
            i = this.g[i];
        }
        return 0.0f;
    }

    public final void a() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f419a; i2++) {
            SolverVariable solverVariable = this.c.c[this.f[i]];
            if (solverVariable != null) {
                solverVariable.b(this.b);
            }
            i = this.g[i];
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f419a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(SolverVariable solverVariable) {
        int i = this.i;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f419a; i2++) {
            if (this.f[i] == solverVariable.f417a) {
                return true;
            }
            i = this.g[i];
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f419a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.g[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f419a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] / f;
            i = this.g[i];
        }
    }

    private boolean a(SolverVariable solverVariable, e eVar) {
        return solverVariable.i <= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolverVariable a(e eVar) {
        int i = this.i;
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        boolean z = false;
        float f2 = 0.0f;
        boolean z2 = false;
        for (int i2 = 0; i != -1 && i2 < this.f419a; i2++) {
            float f3 = this.h[i];
            SolverVariable solverVariable3 = this.c.c[this.f[i]];
            if (f3 < 0.0f) {
                if (f3 > -0.001f) {
                    this.h[i] = 0.0f;
                    solverVariable3.b(this.b);
                    f3 = 0.0f;
                }
            } else if (f3 < 0.001f) {
                this.h[i] = 0.0f;
                solverVariable3.b(this.b);
                f3 = 0.0f;
            }
            if (f3 != 0.0f) {
                if (solverVariable3.f == SolverVariable.Type.UNRESTRICTED) {
                    if (solverVariable2 == null) {
                        z = a(solverVariable3, eVar);
                        f = f3;
                        solverVariable2 = solverVariable3;
                    } else if (f > f3) {
                        z = a(solverVariable3, eVar);
                        f = f3;
                        solverVariable2 = solverVariable3;
                    } else if (!z && a(solverVariable3, eVar)) {
                        f = f3;
                        solverVariable2 = solverVariable3;
                        z = true;
                    }
                } else if (solverVariable2 == null && f3 < 0.0f) {
                    if (solverVariable == null) {
                        z2 = a(solverVariable3, eVar);
                        f2 = f3;
                        solverVariable = solverVariable3;
                    } else if (f2 > f3) {
                        z2 = a(solverVariable3, eVar);
                        f2 = f3;
                        solverVariable = solverVariable3;
                    } else if (!z2 && a(solverVariable3, eVar)) {
                        f2 = f3;
                        solverVariable = solverVariable3;
                        z2 = true;
                    }
                }
            }
            i = this.g[i];
        }
        return solverVariable2 != null ? solverVariable2 : solverVariable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(b bVar, b bVar2, boolean z) {
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.f419a) {
            if (this.f[i] == bVar2.f420a.f417a) {
                float f = this.h[i];
                a(bVar2.f420a, z);
                a aVar = bVar2.d;
                int i3 = aVar.i;
                for (int i4 = 0; i3 != -1 && i4 < aVar.f419a; i4++) {
                    a(this.c.c[aVar.f[i3]], aVar.h[i3] * f, z);
                    i3 = aVar.g[i3];
                }
                bVar.b += bVar2.b * f;
                if (z) {
                    bVar2.f420a.b(bVar);
                }
                i = this.i;
                i2 = 0;
            } else {
                i = this.g[i];
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar, b[] bVarArr) {
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.f419a) {
            SolverVariable solverVariable = this.c.c[this.f[i]];
            if (solverVariable.b != -1) {
                float f = this.h[i];
                a(solverVariable, true);
                b bVar2 = bVarArr[solverVariable.b];
                if (!bVar2.e) {
                    a aVar = bVar2.d;
                    int i3 = aVar.i;
                    for (int i4 = 0; i3 != -1 && i4 < aVar.f419a; i4++) {
                        a(this.c.c[aVar.f[i3]], aVar.h[i3] * f, true);
                        i3 = aVar.g[i3];
                    }
                }
                bVar.b += bVar2.b * f;
                bVar2.f420a.b(bVar);
                i = this.i;
                i2 = 0;
            } else {
                i = this.g[i];
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolverVariable a(boolean[] zArr, SolverVariable solverVariable) {
        int i = this.i;
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i2 = 0; i != -1 && i2 < this.f419a; i2++) {
            if (this.h[i] < 0.0f) {
                SolverVariable solverVariable3 = this.c.c[this.f[i]];
                if ((zArr == null || !zArr[solverVariable3.f417a]) && solverVariable3 != solverVariable && (solverVariable3.f == SolverVariable.Type.SLACK || solverVariable3.f == SolverVariable.Type.ERROR)) {
                    float f2 = this.h[i];
                    if (f2 < f) {
                        solverVariable2 = solverVariable3;
                        f = f2;
                    }
                }
            }
            i = this.g[i];
        }
        return solverVariable2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SolverVariable a(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f419a; i3++) {
            if (i3 == i) {
                return this.c.c[this.f[i2]];
            }
            i2 = this.g[i2];
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float b(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f419a; i3++) {
            if (i3 == i) {
                return this.h[i2];
            }
            i2 = this.g[i2];
        }
        return 0.0f;
    }

    public final float b(SolverVariable solverVariable) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f419a; i2++) {
            if (this.f[i] == solverVariable.f417a) {
                return this.h[i];
            }
            i = this.g[i];
        }
        return 0.0f;
    }

    public String toString() {
        String str = "";
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f419a; i2++) {
            str = ((str + " -> ") + this.h[i] + " : ") + this.c.c[this.f[i]];
            i = this.g[i];
        }
        return str;
    }
}
