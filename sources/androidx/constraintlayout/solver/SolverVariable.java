package androidx.constraintlayout.solver;

import java.util.Arrays;

/* loaded from: classes.dex */
public class SolverVariable {
    private static int j = 1;
    private static int k = 1;
    private static int l = 1;
    private static int m = 1;
    private static int n = 1;
    public float d;
    Type f;
    private String o;

    /* renamed from: a, reason: collision with root package name */
    public int f417a = -1;
    int b = -1;
    public int c = 0;
    float[] e = new float[7];
    b[] g = new b[8];
    int h = 0;
    public int i = 0;

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        k++;
    }

    public SolverVariable(Type type, String str) {
        this.f = type;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.h;
            if (i < i2) {
                if (this.g[i] == bVar) {
                    return;
                } else {
                    i++;
                }
            } else {
                b[] bVarArr = this.g;
                if (i2 >= bVarArr.length) {
                    this.g = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.g;
                int i3 = this.h;
                bVarArr2[i3] = bVar;
                this.h = i3 + 1;
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.g[i2] == bVar) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    b[] bVarArr = this.g;
                    int i4 = i2 + i3;
                    bVarArr[i4] = bVarArr[i4 + 1];
                }
                this.h--;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            this.g[i2].d.a(this.g[i2], bVar, false);
        }
        this.h = 0;
    }

    public void b() {
        this.o = null;
        this.f = Type.UNKNOWN;
        this.c = 0;
        this.f417a = -1;
        this.b = -1;
        this.d = 0.0f;
        this.h = 0;
        this.i = 0;
    }

    public void a(Type type, String str) {
        this.f = type;
    }

    public String toString() {
        return "" + this.o;
    }
}
