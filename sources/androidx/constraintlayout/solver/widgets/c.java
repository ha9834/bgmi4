package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected ConstraintWidget f433a;
    protected ConstraintWidget b;
    protected ConstraintWidget c;
    protected ConstraintWidget d;
    protected ConstraintWidget e;
    protected ConstraintWidget f;
    protected ConstraintWidget g;
    protected ArrayList<ConstraintWidget> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    private int o;
    private boolean p;
    private boolean q;

    public c(ConstraintWidget constraintWidget, int i, boolean z) {
        this.p = false;
        this.f433a = constraintWidget;
        this.o = i;
        this.p = z;
    }

    private static boolean a(ConstraintWidget constraintWidget, int i) {
        return constraintWidget.k() != 8 && constraintWidget.B[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (constraintWidget.g[i] == 0 || constraintWidget.g[i] == 3);
    }

    private void b() {
        int i = this.o * 2;
        boolean z = false;
        ConstraintWidget constraintWidget = this.f433a;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            ConstraintWidget constraintWidget2 = null;
            constraintWidget.Z[this.o] = null;
            constraintWidget.Y[this.o] = null;
            if (constraintWidget.k() != 8) {
                if (this.b == null) {
                    this.b = constraintWidget;
                }
                ConstraintWidget constraintWidget3 = this.d;
                if (constraintWidget3 != null) {
                    constraintWidget3.Z[this.o] = constraintWidget;
                }
                this.d = constraintWidget;
                if (constraintWidget.B[this.o] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (constraintWidget.g[this.o] == 0 || constraintWidget.g[this.o] == 3 || constraintWidget.g[this.o] == 2)) {
                    this.j++;
                    float f = constraintWidget.X[this.o];
                    if (f > 0.0f) {
                        this.k += constraintWidget.X[this.o];
                    }
                    if (a(constraintWidget, this.o)) {
                        if (f < 0.0f) {
                            this.l = true;
                        } else {
                            this.m = true;
                        }
                        if (this.h == null) {
                            this.h = new ArrayList<>();
                        }
                        this.h.add(constraintWidget);
                    }
                    if (this.f == null) {
                        this.f = constraintWidget;
                    }
                    ConstraintWidget constraintWidget4 = this.g;
                    if (constraintWidget4 != null) {
                        constraintWidget4.Y[this.o] = constraintWidget;
                    }
                    this.g = constraintWidget;
                }
            }
            ConstraintAnchor constraintAnchor = constraintWidget.z[i + 1].c;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f425a;
                if (constraintWidget5.z[i].c != null && constraintWidget5.z[i].c.f425a == constraintWidget) {
                    constraintWidget2 = constraintWidget5;
                }
            }
            if (constraintWidget2 != null) {
                constraintWidget = constraintWidget2;
            } else {
                z2 = true;
            }
        }
        this.c = constraintWidget;
        if (this.o == 0 && this.p) {
            this.e = this.c;
        } else {
            this.e = this.f433a;
        }
        if (this.m && this.l) {
            z = true;
        }
        this.n = z;
    }

    public void a() {
        if (!this.q) {
            b();
        }
        this.q = true;
    }
}
