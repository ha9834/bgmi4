package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import com.facebook.internal.security.CertificateUtil;

/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: a, reason: collision with root package name */
    final ConstraintWidget f425a;
    final Type b;
    ConstraintAnchor c;
    SolverVariable f;
    private i g = new i(this);
    public int d = 0;
    int e = -1;
    private Strength h = Strength.NONE;
    private ConnectionType i = ConnectionType.RELAXED;
    private int j = 0;

    /* loaded from: classes.dex */
    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    /* loaded from: classes.dex */
    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    /* loaded from: classes.dex */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public i a() {
        return this.g;
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f425a = constraintWidget;
        this.b = type;
    }

    public SolverVariable b() {
        return this.f;
    }

    public void a(androidx.constraintlayout.solver.c cVar) {
        SolverVariable solverVariable = this.f;
        if (solverVariable == null) {
            this.f = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.b();
        }
    }

    public ConstraintWidget c() {
        return this.f425a;
    }

    public Type d() {
        return this.b;
    }

    public int e() {
        ConstraintAnchor constraintAnchor;
        if (this.f425a.k() == 8) {
            return 0;
        }
        if (this.e > -1 && (constraintAnchor = this.c) != null && constraintAnchor.f425a.k() == 8) {
            return this.e;
        }
        return this.d;
    }

    public Strength f() {
        return this.h;
    }

    public ConstraintAnchor g() {
        return this.c;
    }

    public int h() {
        return this.j;
    }

    public void i() {
        this.c = null;
        this.d = 0;
        this.e = -1;
        this.h = Strength.STRONG;
        this.j = 0;
        this.i = ConnectionType.RELAXED;
        this.g.b();
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i, Strength strength, int i2) {
        return a(constraintAnchor, i, -1, strength, i2, false);
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i, int i2, Strength strength, int i3, boolean z) {
        if (constraintAnchor == null) {
            this.c = null;
            this.d = 0;
            this.e = -1;
            this.h = Strength.NONE;
            this.j = 2;
            return true;
        }
        if (!z && !a(constraintAnchor)) {
            return false;
        }
        this.c = constraintAnchor;
        if (i > 0) {
            this.d = i;
        } else {
            this.d = 0;
        }
        this.e = i2;
        this.h = strength;
        this.j = i3;
        return true;
    }

    public boolean j() {
        return this.c != null;
    }

    public boolean a(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type d = constraintAnchor.d();
        Type type = this.b;
        if (d == type) {
            return type != Type.BASELINE || (constraintAnchor.c().z() && c().z());
        }
        switch (this.b) {
            case CENTER:
                return (d == Type.BASELINE || d == Type.CENTER_X || d == Type.CENTER_Y) ? false : true;
            case LEFT:
            case RIGHT:
                boolean z = d == Type.LEFT || d == Type.RIGHT;
                return constraintAnchor.c() instanceof e ? z || d == Type.CENTER_X : z;
            case TOP:
            case BOTTOM:
                boolean z2 = d == Type.TOP || d == Type.BOTTOM;
                return constraintAnchor.c() instanceof e ? z2 || d == Type.CENTER_Y : z2;
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return false;
            default:
                throw new AssertionError(this.b.name());
        }
    }

    public String toString() {
        return this.f425a.l() + CertificateUtil.DELIMITER + this.b.toString();
    }
}
