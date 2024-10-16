package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    static boolean[] f435a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(d dVar, androidx.constraintlayout.solver.e eVar, ConstraintWidget constraintWidget) {
        if (dVar.B[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.B[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.r.d;
            int o = dVar.o() - constraintWidget.t.d;
            constraintWidget.r.f = eVar.a(constraintWidget.r);
            constraintWidget.t.f = eVar.a(constraintWidget.t);
            eVar.a(constraintWidget.r.f, i);
            eVar.a(constraintWidget.t.f, o);
            constraintWidget.f430a = 2;
            constraintWidget.c(i, o);
        }
        if (dVar.B[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || constraintWidget.B[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i2 = constraintWidget.s.d;
        int q = dVar.q() - constraintWidget.u.d;
        constraintWidget.s.f = eVar.a(constraintWidget.s);
        constraintWidget.u.f = eVar.a(constraintWidget.u);
        eVar.a(constraintWidget.s.f, i2);
        eVar.a(constraintWidget.u.f, q);
        if (constraintWidget.L > 0 || constraintWidget.k() == 8) {
            constraintWidget.v.f = eVar.a(constraintWidget.v);
            eVar.a(constraintWidget.v.f, constraintWidget.L + i2);
        }
        constraintWidget.b = 2;
        constraintWidget.d(i2, q);
    }

    private static boolean a(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.B[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        if (constraintWidget.F != 0.0f) {
            return constraintWidget.B[i != 0 ? (char) 0 : (char) 1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? false : false;
        }
        if (i == 0) {
            if (constraintWidget.e != 0 || constraintWidget.h != 0 || constraintWidget.i != 0) {
                return false;
            }
        } else if (constraintWidget.f != 0 || constraintWidget.k != 0 || constraintWidget.l != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, ConstraintWidget constraintWidget) {
        constraintWidget.g();
        i a2 = constraintWidget.r.a();
        i a3 = constraintWidget.s.a();
        i a4 = constraintWidget.t.a();
        i a5 = constraintWidget.u.a();
        boolean z = (i & 8) == 8;
        boolean z2 = constraintWidget.B[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && a(constraintWidget, 0);
        if (a2.g != 4 && a4.g != 4) {
            if (constraintWidget.B[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.k() == 8)) {
                if (constraintWidget.r.c == null && constraintWidget.t.c == null) {
                    a2.b(1);
                    a4.b(1);
                    if (z) {
                        a4.a(a2, 1, constraintWidget.h());
                    } else {
                        a4.a(a2, constraintWidget.o());
                    }
                } else if (constraintWidget.r.c != null && constraintWidget.t.c == null) {
                    a2.b(1);
                    a4.b(1);
                    if (z) {
                        a4.a(a2, 1, constraintWidget.h());
                    } else {
                        a4.a(a2, constraintWidget.o());
                    }
                } else if (constraintWidget.r.c == null && constraintWidget.t.c != null) {
                    a2.b(1);
                    a4.b(1);
                    a2.a(a4, -constraintWidget.o());
                    if (z) {
                        a2.a(a4, -1, constraintWidget.h());
                    } else {
                        a2.a(a4, -constraintWidget.o());
                    }
                } else if (constraintWidget.r.c != null && constraintWidget.t.c != null) {
                    a2.b(2);
                    a4.b(2);
                    if (z) {
                        constraintWidget.h().a(a2);
                        constraintWidget.h().a(a4);
                        a2.b(a4, -1, constraintWidget.h());
                        a4.b(a2, 1, constraintWidget.h());
                    } else {
                        a2.b(a4, -constraintWidget.o());
                        a4.b(a2, constraintWidget.o());
                    }
                }
            } else if (z2) {
                int o = constraintWidget.o();
                a2.b(1);
                a4.b(1);
                if (constraintWidget.r.c == null && constraintWidget.t.c == null) {
                    if (z) {
                        a4.a(a2, 1, constraintWidget.h());
                    } else {
                        a4.a(a2, o);
                    }
                } else if (constraintWidget.r.c == null || constraintWidget.t.c != null) {
                    if (constraintWidget.r.c != null || constraintWidget.t.c == null) {
                        if (constraintWidget.r.c != null && constraintWidget.t.c != null) {
                            if (z) {
                                constraintWidget.h().a(a2);
                                constraintWidget.h().a(a4);
                            }
                            if (constraintWidget.F == 0.0f) {
                                a2.b(3);
                                a4.b(3);
                                a2.b(a4, 0.0f);
                                a4.b(a2, 0.0f);
                            } else {
                                a2.b(2);
                                a4.b(2);
                                a2.b(a4, -o);
                                a4.b(a2, o);
                                constraintWidget.h(o);
                            }
                        }
                    } else if (z) {
                        a2.a(a4, -1, constraintWidget.h());
                    } else {
                        a2.a(a4, -o);
                    }
                } else if (z) {
                    a4.a(a2, 1, constraintWidget.h());
                } else {
                    a4.a(a2, o);
                }
            }
        }
        boolean z3 = constraintWidget.B[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && a(constraintWidget, 1);
        if (a3.g == 4 || a5.g == 4) {
            return;
        }
        if (constraintWidget.B[1] != ConstraintWidget.DimensionBehaviour.FIXED && (!z3 || constraintWidget.k() != 8)) {
            if (z3) {
                int q = constraintWidget.q();
                a3.b(1);
                a5.b(1);
                if (constraintWidget.s.c == null && constraintWidget.u.c == null) {
                    if (z) {
                        a5.a(a3, 1, constraintWidget.i());
                        return;
                    } else {
                        a5.a(a3, q);
                        return;
                    }
                }
                if (constraintWidget.s.c != null && constraintWidget.u.c == null) {
                    if (z) {
                        a5.a(a3, 1, constraintWidget.i());
                        return;
                    } else {
                        a5.a(a3, q);
                        return;
                    }
                }
                if (constraintWidget.s.c == null && constraintWidget.u.c != null) {
                    if (z) {
                        a3.a(a5, -1, constraintWidget.i());
                        return;
                    } else {
                        a3.a(a5, -q);
                        return;
                    }
                }
                if (constraintWidget.s.c == null || constraintWidget.u.c == null) {
                    return;
                }
                if (z) {
                    constraintWidget.i().a(a3);
                    constraintWidget.h().a(a5);
                }
                if (constraintWidget.F == 0.0f) {
                    a3.b(3);
                    a5.b(3);
                    a3.b(a5, 0.0f);
                    a5.b(a3, 0.0f);
                    return;
                }
                a3.b(2);
                a5.b(2);
                a3.b(a5, -q);
                a5.b(a3, q);
                constraintWidget.i(q);
                if (constraintWidget.L > 0) {
                    constraintWidget.v.a().a(1, a3, constraintWidget.L);
                    return;
                }
                return;
            }
            return;
        }
        if (constraintWidget.s.c == null && constraintWidget.u.c == null) {
            a3.b(1);
            a5.b(1);
            if (z) {
                a5.a(a3, 1, constraintWidget.i());
            } else {
                a5.a(a3, constraintWidget.q());
            }
            if (constraintWidget.v.c != null) {
                constraintWidget.v.a().b(1);
                a3.a(1, constraintWidget.v.a(), -constraintWidget.L);
                return;
            }
            return;
        }
        if (constraintWidget.s.c != null && constraintWidget.u.c == null) {
            a3.b(1);
            a5.b(1);
            if (z) {
                a5.a(a3, 1, constraintWidget.i());
            } else {
                a5.a(a3, constraintWidget.q());
            }
            if (constraintWidget.L > 0) {
                constraintWidget.v.a().a(1, a3, constraintWidget.L);
                return;
            }
            return;
        }
        if (constraintWidget.s.c == null && constraintWidget.u.c != null) {
            a3.b(1);
            a5.b(1);
            if (z) {
                a3.a(a5, -1, constraintWidget.i());
            } else {
                a3.a(a5, -constraintWidget.q());
            }
            if (constraintWidget.L > 0) {
                constraintWidget.v.a().a(1, a3, constraintWidget.L);
                return;
            }
            return;
        }
        if (constraintWidget.s.c == null || constraintWidget.u.c == null) {
            return;
        }
        a3.b(2);
        a5.b(2);
        if (z) {
            a3.b(a5, -1, constraintWidget.i());
            a5.b(a3, 1, constraintWidget.i());
            constraintWidget.i().a(a3);
            constraintWidget.h().a(a5);
        } else {
            a3.b(a5, -constraintWidget.q());
            a5.b(a3, constraintWidget.q());
        }
        if (constraintWidget.L > 0) {
            constraintWidget.v.a().a(1, a3, constraintWidget.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(d dVar, androidx.constraintlayout.solver.e eVar, int i, int i2, c cVar) {
        boolean z;
        boolean z2;
        boolean z3;
        float e;
        float q;
        float q2;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = cVar.f433a;
        ConstraintWidget constraintWidget3 = cVar.c;
        ConstraintWidget constraintWidget4 = cVar.b;
        ConstraintWidget constraintWidget5 = cVar.d;
        ConstraintWidget constraintWidget6 = cVar.e;
        float f = cVar.k;
        ConstraintWidget constraintWidget7 = cVar.f;
        ConstraintWidget constraintWidget8 = cVar.g;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.B[i];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z = constraintWidget6.T == 0;
            z2 = constraintWidget6.T == 1;
            z3 = constraintWidget6.T == 2;
        } else {
            z = constraintWidget6.U == 0;
            z2 = constraintWidget6.U == 1;
            z3 = constraintWidget6.U == 2;
        }
        ConstraintWidget constraintWidget9 = constraintWidget2;
        int i3 = 0;
        boolean z4 = false;
        int i4 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (!z4) {
            if (constraintWidget9.k() != 8) {
                i4++;
                if (i == 0) {
                    f2 += constraintWidget9.o();
                } else {
                    f2 += constraintWidget9.q();
                }
                if (constraintWidget9 != constraintWidget4) {
                    f2 += constraintWidget9.z[i2].e();
                }
                f3 = f3 + constraintWidget9.z[i2].e() + constraintWidget9.z[i2 + 1].e();
            }
            ConstraintAnchor constraintAnchor = constraintWidget9.z[i2];
            if (constraintWidget9.k() != 8 && constraintWidget9.B[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i3++;
                if (i == 0) {
                    if (constraintWidget9.e != 0 || constraintWidget9.h != 0 || constraintWidget9.i != 0) {
                        return false;
                    }
                } else if (constraintWidget9.f != 0 || constraintWidget9.k != 0 || constraintWidget9.l != 0) {
                    return false;
                }
            }
            ConstraintAnchor constraintAnchor2 = constraintWidget9.z[i2 + 1].c;
            if (constraintAnchor2 != null) {
                ConstraintWidget constraintWidget10 = constraintAnchor2.f425a;
                constraintWidget = (constraintWidget10.z[i2].c == null || constraintWidget10.z[i2].c.f425a != constraintWidget9) ? null : constraintWidget10;
            } else {
                constraintWidget = null;
            }
            if (constraintWidget != null) {
                constraintWidget9 = constraintWidget;
            } else {
                z4 = true;
            }
        }
        i a2 = constraintWidget2.z[i2].a();
        int i5 = i2 + 1;
        i a3 = constraintWidget3.z[i5].a();
        if (a2.c == null || a3.c == null) {
            return false;
        }
        if (a2.c.i != 1 && a3.c.i != 1) {
            return false;
        }
        if (i3 > 0 && i3 != i4) {
            return false;
        }
        if (z3 || z || z2) {
            e = constraintWidget4 != null ? constraintWidget4.z[i2].e() : 0.0f;
            if (constraintWidget5 != null) {
                e += constraintWidget5.z[i5].e();
            }
        } else {
            e = 0.0f;
        }
        float f4 = a2.c.f;
        float f5 = a3.c.f;
        float f6 = f4 < f5 ? (f5 - f4) - f2 : (f4 - f5) - f2;
        if (i3 > 0 && i3 == i4) {
            if (constraintWidget9.j() != null && constraintWidget9.j().B[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                return false;
            }
            float f7 = (f6 + f2) - f3;
            if (z) {
                f7 -= f3 - e;
            }
            if (z) {
                f4 += constraintWidget4.z[i5].e();
                if (constraintWidget4.Z[i] != null) {
                    f4 += r1.z[i2].e();
                }
            }
            while (constraintWidget4 != null) {
                if (androidx.constraintlayout.solver.e.g != null) {
                    androidx.constraintlayout.solver.e.g.B--;
                    androidx.constraintlayout.solver.e.g.s++;
                    androidx.constraintlayout.solver.e.g.y++;
                }
                ConstraintWidget constraintWidget11 = constraintWidget4.Z[i];
                if (constraintWidget11 != null || constraintWidget4 == constraintWidget5) {
                    float f8 = f7 / i3;
                    if (f > 0.0f) {
                        f8 = (constraintWidget4.X[i] * f7) / f;
                    }
                    float e2 = f4 + constraintWidget4.z[i2].e();
                    constraintWidget4.z[i2].a().a(a2.e, e2);
                    float f9 = e2 + f8;
                    constraintWidget4.z[i5].a().a(a2.e, f9);
                    constraintWidget4.z[i2].a().a(eVar);
                    constraintWidget4.z[i5].a().a(eVar);
                    f4 = f9 + constraintWidget4.z[i5].e();
                }
                constraintWidget4 = constraintWidget11;
            }
            return true;
        }
        if (f6 < f2) {
            return false;
        }
        if (z3) {
            float y = f4 + ((f6 - e) * constraintWidget2.y());
            while (constraintWidget4 != null) {
                if (androidx.constraintlayout.solver.e.g != null) {
                    androidx.constraintlayout.solver.e.g.B--;
                    androidx.constraintlayout.solver.e.g.s++;
                    androidx.constraintlayout.solver.e.g.y++;
                }
                ConstraintWidget constraintWidget12 = constraintWidget4.Z[i];
                if (constraintWidget12 != null || constraintWidget4 == constraintWidget5) {
                    if (i == 0) {
                        q2 = constraintWidget4.o();
                    } else {
                        q2 = constraintWidget4.q();
                    }
                    float e3 = y + constraintWidget4.z[i2].e();
                    constraintWidget4.z[i2].a().a(a2.e, e3);
                    float f10 = e3 + q2;
                    constraintWidget4.z[i5].a().a(a2.e, f10);
                    constraintWidget4.z[i2].a().a(eVar);
                    constraintWidget4.z[i5].a().a(eVar);
                    y = f10 + constraintWidget4.z[i5].e();
                }
                constraintWidget4 = constraintWidget12;
            }
            return true;
        }
        if (!z && !z2) {
            return true;
        }
        if (z) {
            f6 -= e;
        } else if (z2) {
            f6 -= e;
        }
        float f11 = f6 / (i4 + 1);
        if (z2) {
            f11 = i4 > 1 ? f6 / (i4 - 1) : f6 / 2.0f;
        }
        float f12 = f4 + f11;
        if (z2 && i4 > 1) {
            f12 = constraintWidget4.z[i2].e() + f4;
        }
        if (z && constraintWidget4 != null) {
            f12 += constraintWidget4.z[i2].e();
        }
        while (constraintWidget4 != null) {
            if (androidx.constraintlayout.solver.e.g != null) {
                androidx.constraintlayout.solver.e.g.B--;
                androidx.constraintlayout.solver.e.g.s++;
                androidx.constraintlayout.solver.e.g.y++;
            }
            ConstraintWidget constraintWidget13 = constraintWidget4.Z[i];
            if (constraintWidget13 != null || constraintWidget4 == constraintWidget5) {
                if (i == 0) {
                    q = constraintWidget4.o();
                } else {
                    q = constraintWidget4.q();
                }
                constraintWidget4.z[i2].a().a(a2.e, f12);
                constraintWidget4.z[i5].a().a(a2.e, f12 + q);
                constraintWidget4.z[i2].a().a(eVar);
                constraintWidget4.z[i5].a().a(eVar);
                f12 += q + f11;
            }
            constraintWidget4 = constraintWidget13;
        }
        return true;
    }
}
